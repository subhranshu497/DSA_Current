//package com.prep;
//import reactor.core.publisher.Mono;
//import org.json.JSONObject;
//import org.apache.avro.generic.GenericRecord;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//public class ReactiveCodeDemo {
//
//    public Mono<Void> processMessage(GenericRecord record) {
//        String message = record.toString();
//        String reqId = webhookUtil.getRequestId(message);
//        String manualTopic = null;
//
//        loggingAggregator.LogInfoMessage(reqId, className, "OnMessage");
//
//        Mono<JSONObject> nodeMono = Mono.fromCallable(() -> webhookUtil.jsonDeserializer(message, null));
//        Mono<String> sourceMono = nodeMono.map(node -> (String) webhookUtil.getStringProperty(node, webhookConstant.SOURCE));
//        Mono<JSONObject> dataNodeMono = nodeMono.map(node -> (JSONObject) webhookUtil.getStringProperty(node, webhookConstant.DATA));
//        Mono<String> clientNameMono = dataNodeMono.map(dataNode -> {
//            String jsonClientName = (String) webhookUtil.getStringProperty(dataNode, webhookConstant.CLIENT_NAME);
//            return jsonClientName == JSONObject.NULL ? null : jsonClientName.toString();
//        });
//        Mono<JSONObject> screeningStatusMono = dataNodeMono.map(dataNode -> (JSONObject) webhookUtil.getStringProperty(dataNode, webhookConstant.SCR));
//        Mono<String> txnStatusMono = screeningStatusMono.map(screeningStatus -> {
//            Object jsonTxnStatus = webhookUtil.getStringProperty(screeningStatus, webhookConstant.txn);
//            return jsonTxnStatus == JSONObject.NULL ? null : jsonTxnStatus.toString();
//        });
//
//        return nodeMono
//                .flatMap(node -> sourceMono.zipWith(clientNameMono)
//                        .flatMap(tuple -> {
//                            String source = tuple.getT1();
//                            String clientName = tuple.getT2();
//                            return txnStatusMono
//                                    .flatMap(txnStatus -> webhookMessageHandler.handleMessage(record, reqId, clientName, message, txnStatus, node)
//                                            .thenReturn(Tuples.of(node, source, clientName, txnStatus)));
//                        }))
//                .flatMap(tuple -> {
//                    JSONObject node = tuple.getT1();
//                    String source = tuple.getT2();
//                    String clientName = tuple.getT3();
//                    String txnStatus = tuple.getT4();
//                    Mono<Void> notificationMono;
//                    if (flag) {
//                        notificationMono = notificationService.handleEventDataUsingWebClient(record, reqId, node, clientName, node, txnStatus);
//                    } else {
//                        notificationMono = notificationService.handleEventData(record, reqId, node, clientName, node, txnStatus);
//                    }
//                    return notificationMono;
//                })
//                .doOnSuccess(aVoid -> loggingAggregator.LogInfoMessage(reqId, className, "OnMessage"))
//                .onErrorResume(NullPointerException.class, npe -> {
//                    loggingAggregator.LogInfoMessage(reqId, className, "npe");
//                    kafkaProducer.sendMessageToKafka(record, reqId, manualTopic);
//                    return Mono.empty();
//                })
//                .onErrorResume(ex -> {
//                    loggingAggregator.LogInfoMessage(reqId, className, "error");
//                    return nodeMono.flatMap(node -> webhookUtil.handleError(ex, record, reqId, node));
//                })
//                .doFinally(signalType -> loggingAggregator.LogInfoMessage(reqId, className, "success"))
//                .then();
//    }
//
//
//    public Mono<String> getRequestId(String jsonData) {
//        return Mono.defer(() -> {
//            return Mono.justOrEmpty(webhookUtil.jsonDeserializer(jsonData, null))
//                    .cast(JSONObject.class)
//                    .flatMap(node -> {
//                        Object jsonValue = getStringProperty(node, WebhookConstant.REQUESTID);
//                        String requestId = jsonValue == JSONObject.NULL ? null : jsonValue.toString();
//                        return Mono.justOrEmpty(requestId);
//                    })
//                    .onErrorResume(e -> {
//                        loggingAggregator.LogErrorMessage(null, className, "OnMessage", e);
//                        return Mono.empty();
//                    });
//        });
//    }
//
//    public void handleMessage(GenericRecord record, String requestId, String applicationName, String message, String txnStatus, JSNObject node){
//        String methodname = "handleMessage";
//        loggingAggregator.LogDebugMessage("debug");
//        EventData eventData = new EventData();
//        try{
//            eventData.setSvbRequestId(requestId);
//            eventData.setEventMessage(message);
//            eventDataDao.saveEvent(eventData);
//        }
//        catch(Exception e){
//            loggingAggregator.LogErrorMessage(requestId, className, methodName, "message", e);
//            webhookUtil.handleError(e,record,requestId, node);
//        }
//        loggingAggregator.LogDebugMessage("persisted");
//    }
//
//    public void handleError(Exception ex, GenericRecord event, String requestId, JSONObject node){
//        String manualTopic =null;
//        try {
//            RetryRequest retryRequest = new RetryRequest();
//            List<RetryTrial> retryList = null;
//            RetryTrial lastRetryTrail = null;
//            if(node.get(WebhookConstant.RETRY).toString() !=null){
//                JSONArray retryJson = node.getJSONArray(WebhookConstant.RETRY);
//                ObjectMapper mapper = new ObjectMapper();
//
//                retryList = new ArrayList<RetryTrial>(
//                        Arrays.asList(mapper.readValue(retryJson.toString(), RetryTrial[].class)));
//            }
//            loggingAggregator.LogInfoMessage(requestId,"message", retryList);
//            Integer deliveryAttemps=null;
//            String lastDeliveryTime =null;
//            lastRetryTrail = webhookUtil.getLastRetryObject(retryList);
//            loggingAggregator.LogInfoMessage(requestId,"message", lastRetryTrail);
//            if(lastRetryTrail !=null){
//                deliveryAttemps = lastRetryTrail.getDeliveryAttempts();
//                lastDeliveryTime = lastRetryTrail.getLastDeliveryTime();
//                retryRequest.setRetryCount(deliveryAttemps);
//            }
//            else{
//                retryRequest.setRetryCount(1);
//            }
//            String source = (String) getStringProperty(node,"Source");
//            event = ExceptionHandler.mapErrorRetryDetails(event,exception,node, retryList,requestId, retryRequest);
//            retryRequest.setRetryMessage(event);
//            loggingAggregator.LogInfoMessage(requestId,"message", deliveryAttemps);
//            loggingAggregator.LogInfoMessage(requestId,"message", retryRequest.toString());
//            retryService.retryRequest(retryRequest);
//        }
//        catch(JsonProcessingException | JSONException e){
//            loggingAggregator.LogErrorMessage(requestId,"message", e);
//        }
//    }
//
//    public Mono<Void> handleError(Exception ex, GenericRecord event, String requestId, JSONObject node) {
//        String manualTopic = null;
//
//        Mono<RetryRequest> retryRequestMono = Mono.fromSupplier(RetryRequest::new);
//        Mono<List<RetryTrial>> retryListMono = Mono.defer(() -> {
//            if (node.optString(WebhookConstant.RETRY) != null) {
//                JSONArray retryJson = node.getJSONArray(WebhookConstant.RETRY);
//                ObjectMapper mapper = new ObjectMapper();
//                List<RetryTrial> retryList = Arrays.asList(mapper.readValue(retryJson.toString(), RetryTrial[].class));
//                return Mono.just(retryList);
//            }
//            return Mono.just(new ArrayList<>());
//        });
//
//        return retryListMono.flatMap(retryList -> {
//                    loggingAggregator.LogInfoMessage(requestId, "message", retryList);
//
//                    RetryTrial lastRetryTrial = webhookUtil.getLastRetryObject(retryList);
//                    loggingAggregator.LogInfoMessage(requestId, "message", lastRetryTrial);
//
//                    Mono<Integer> deliveryAttemptsMono = Mono.justOrEmpty(lastRetryTrial).map(RetryTrial::getDeliveryAttempts);
//                    Mono<String> lastDeliveryTimeMono = Mono.justOrEmpty(lastRetryTrial).map(RetryTrial::getLastDeliveryTime);
//
//                    return Mono.zip(retryRequestMono, deliveryAttemptsMono.defaultIfEmpty(1), lastDeliveryTimeMono)
//                            .flatMap(tuple -> {
//                                RetryRequest retryRequest = tuple.getT1();
//                                int deliveryAttempts = tuple.getT2();
//                                retryRequest.setRetryCount(deliveryAttempts);
//
//                                return Mono.justOrEmpty((String) getStringProperty(node, "Source"))
//                                        .flatMap(source -> Mono.defer(() -> {
//                                            event = ExceptionHandler.mapErrorRetryDetails(event, ex, node, retryList, requestId, retryRequest);
//                                            retryRequest.setRetryMessage(event);
//                                            loggingAggregator.LogInfoMessage(requestId, "message", deliveryAttempts);
//                                            loggingAggregator.LogInfoMessage(requestId, "message", retryRequest.toString());
//                                            return retryService.retryRequest(retryRequest);
//                                        }));
//                            });
//                }).doOnError(e -> loggingAggregator.LogErrorMessage(requestId, "message", e))
//                .then();
//    }
//
//public Mono<Void> handleEventData(GenericRecord record, String requestId, String clientName, JSONObject node, JSONObject dataNode, String txnStatus){
//        String methodName="handleEventDat";
//        String manualTopic=null;
//        try{
//                prepareTestrsult(requestId,System.currentTimeMillis());
//                Object JsonEventType = webhookUtil.getStringProperty(node, "type");
//                String eventType = JsonEventType == JSONObject.NULL ?null:JsonEventType.toString();
//
//                String source = (String)webhookUtil.getStringProperty(node, "source");
//                log.LogDebugMessage(requestId, className, clientName);
//                List<Webhook> urls = eventWebhookURLMap !=null ? eventWebhookURLMap.get(eventType):null;
//
//                CopyOnWriteArrayList<Webhook> cowal = new CopyOnWriteArrayList<Webhook>(urls==null?new ArrayList<>():urls);
//                log.LogDebugMessage(requestId, urls);
//
//                if(cowal !=null && !cowal.isEmpty() && (clientName !=null && !clientName.isEmpty())){
//                    boolean isClientRegistered = false;
//                    for(Webhook webhook :cowal){
//                        WebhookNotification webhookNotification = null;
//                        if(webhook.getSourceSystem()!=null
//                        && (clientName !=null && webhook.getSourceSystem().equals(clientName))
//                        && webhook.getStatus().equalsIgnoreCase("enabled")){
//                            Exception exception =null;
//                            isClientRegistered = true;
//                            exception = webhookNotificationSender.sendNotification(webhook,dataNode.toString(), requestId);
//                            if(exception == null){
//                                log.LogInfoMessage(requestId,"Notification Successfully sent");
//                                webhookNotification = buildNotificationObject(webhook, requestId, buildComment(txnStatus),"success");
//                                saveNotificationStatus(webhookNotification);
//                                if(isLoadTestEnabled){
//                                    prepareTestResult(requestId,System.currentTimeMillis());
//                                    log.LogDebugMessage(requestId, "webhook nitofication saved to DB");
//                                }
//                                else {
//                                    log.LogInfoMessage(requestId, "notification failed to send");
//                                    webhookNotification= buildNotificationObject(webhook, requestId, exception.getCause().getMessage(),"fail");
//                                    saveNotifiactionStatus(webhookNotification);
//                                    log.LogDebugMessage(requestId, "webhook nitofication saved to DB");
//                                    if(!(exception instanceof HttpClientErrorException))
//                                        throw exception;
//                                }
//                            }
//                        }
//                    }
//                    if(!isClientRegistered){
//                        WebhookNotification webhookNotification = buildNotificationObject(webhook, requestId, "No webhook registered","not tried");
//                        saveWebNotifiactionStatus(webhookNotification);
//                        throw new WebhookNotFoundException("No webhook registered for requestid"+requestId);
//                    }
//                }
//                else {
//                    log.LogInfoMessage(requestId, "Either there is no webhook");
//                    WebhookNotification webhookNotification = buildNotificationObject(null, requestId, "no webhook event","not tried");
//                    saveWebNotifiactionStatus(webhookNotification);
//                    log.LogDebugMessage(requestId, "webhook nitofication status saved to DB");
//                    throw new WebhookNotFoundException("No webhook registered for client"+clientName);
//                }
//                log.LogDebugMessage(requestId, "webhook nitofication send and status saved to DB successfully");
//        }
//        catch(WebhookNotFoundException whex){
//            if(record !=null){
//                sentToManualTopic(record,whex,requestId,manualTopic);
//            }
//            else{
//                log.LogErrorMessage(requestId,whex);
//            }
//        }
//        catch(Exception ex){
//            log.LogErrorMessage(requestId,"Error occurred in handleEventData",ex);
//            if(record !=null){
//                webhookUtils.handleerror(ex,record,requestId,node);
//            }
//            else{
//                log.LogErrorMessage(requestId,"Error when reprocessing message",ex);
//            }
//        }
//
// }
// //Reactive code
//    import org.json.JSONObject;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.util.function.Tuples;
//
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//    public Mono<Void> handleEventData(GenericRecord record, String requestId, String clientName, JSONObject node, JSONObject dataNode, String txnStatus) {
//
//        String methodName = "handleEventData";
//        String manualTopic = null;
//
//        Mono<String> eventTypeMono = Mono.defer(() -> {
//            Object JsonEventType = webhookUtil.getStringProperty(node, "type");
//            return Mono.justOrEmpty(JsonEventType == JSONObject.NULL ? null : JsonEventType.toString());
//        });
//
//        Mono<String> sourceMono = Mono.defer(() -> {
//            return Mono.justOrEmpty((String) webhookUtil.getStringProperty(node, "source"));
//        });
//
//        Mono<List<Webhook>> urlsMono = eventTypeMono.map(eventType ->
//                eventWebhookURLMap != null ? eventWebhookURLMap.get(eventType) : null
//        );
//
//        Flux<Webhook> cowalFlux = urlsMono.flatMapMany(urls ->
//                Flux.fromIterable(urls != null ? new CopyOnWriteArrayList<>(urls) : new CopyOnWriteArrayList<>())
//        );
//
//        Mono<Void> result = cowalFlux
//                .filter(webhook -> webhook.getSourceSystem() != null
//                        && clientName != null && webhook.getSourceSystem().equals(clientName)
//                        && webhook.getStatus().equalsIgnoreCase("enabled")
//                )
//                .flatMap(webhook -> {
//                    Mono<Exception> exceptionMono = Mono.defer(() -> {
//                        Exception exception = webhookNotificationSender.sendNotification(webhook, dataNode.toString(), requestId);
//                        return Mono.justOrEmpty(exception);
//                    });
//
//                    return exceptionMono
//                            .flatMap(exception -> {
//                                if (exception == null) {
//                                    log.LogInfoMessage(requestId, "Notification Successfully sent");
//                                    WebhookNotification webhookNotification = buildNotificationObject(webhook, requestId, buildComment(txnStatus), "success");
//                                    return saveNotificationStatus(webhookNotification)
//                                            .then(Mono.defer(() -> {
//                                                if (isLoadTestEnabled) {
//                                                    prepareTestResult(requestId, System.currentTimeMillis());
//                                                    log.LogDebugMessage(requestId, "webhook notification saved to DB");
//                                                }
//                                                return Mono.empty();
//                                            }));
//                                } else {
//                                    log.LogInfoMessage(requestId, "notification failed to send");
//                                    WebhookNotification webhookNotification = buildNotificationObject(webhook, requestId, exception.getCause().getMessage(), "fail");
//                                    return saveNotificationStatus(webhookNotification)
//                                            .then(Mono.defer(() -> {
//                                                log.LogDebugMessage(requestId, "webhook notification saved to DB");
//                                                if (!(exception instanceof HttpClientErrorException))
//                                                    return Mono.error(exception);
//                                                return Mono.empty();
//                                            }));
//                                }
//                            });
//                })
//                .collectList()
//                .flatMap(list -> {
//                    if (list.isEmpty()) {
//                        WebhookNotification webhookNotification = buildNotificationObject(null, requestId, "No webhook registered", "not tried");
//                        return saveNotificationStatus(webhookNotification)
//                                .then(Mono.error(new WebhookNotFoundException("No webhook registered for requestId " + requestId)));
//                    }
//                    return Mono.empty();
//                })
//                .onErrorResume(WebhookNotFoundException.class, whex -> {
//                    if (record != null) {
//                        return sentToManualTopic(record, whex, requestId, manualTopic).then();
//                    } else {
//                        log.LogErrorMessage(requestId, whex);
//                        return Mono.empty();
//                    }
//                })
//                .onErrorResume(ex -> {
//                    log.LogErrorMessage(requestId, "Error occurred in handleEventData", ex);
//                    if (record != null) {
//                        return webhookUtils.handleError(ex, record, requestId, node).then();
//                    } else {
//                        log.LogErrorMessage(requestId, "Error when reprocessing message", ex);
//                        return Mono.empty();
//                    }
//                });
//
//        return result.then();
//    }
//
//
//
//}
