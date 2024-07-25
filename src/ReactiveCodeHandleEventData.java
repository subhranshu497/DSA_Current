//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//public class ReactiveCodeHandleEventData {
//    import org.json.JSONObject;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.util.function.Tuples;
//
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//    public Mono<Void> handleEventData(GenericRecord record, String requestId, String clientName, JSONObject node, JSONObject dataNode, String txnStatus) {
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
//        // Ensure `cowal` list creation is only done if `urls` and `clientName` are valid
//        Mono<CopyOnWriteArrayList<Webhook>> cowalMono = urlsMono
//                .filter(urls -> urls != null && !urls.isEmpty() && clientName != null && !clientName.isEmpty())
//                .map(urls -> new CopyOnWriteArrayList<>(urls));
//
//        Mono<Void> result = cowalMono
//                .flatMapMany(cowal -> {
//                    // Track if a client is registered
//                    boolean[] isClientRegistered = {false};
//                    return Flux.fromIterable(cowal)
//                            .flatMap(webhook -> {
//                                if (webhook.getSourceSystem() != null
//                                        && webhook.getSourceSystem().equals(clientName)
//                                        && webhook.getStatus().equalsIgnoreCase("enabled")) {
//
//                                    // Set client registered flag
//                                    isClientRegistered[0] = true;
//
//                                    return Mono.defer(() -> {
//                                                Exception exception = webhookNotificationSender.sendNotification(webhook, dataNode.toString(), requestId);
//                                                return Mono.justOrEmpty(exception);
//                                            })
//                                            .flatMap(exception -> {
//                                                if (exception == null) {
//                                                    log.LogInfoMessage(requestId, "Notification Successfully sent");
//                                                    WebhookNotification webhookNotification = buildNotificationObject(webhook, requestId, buildComment(txnStatus), "success");
//                                                    return saveNotificationStatus(webhookNotification)
//                                                            .then(Mono.defer(() -> {
//                                                                if (isLoadTestEnabled) {
//                                                                    prepareTestResult(requestId, System.currentTimeMillis());
//                                                                    log.LogDebugMessage(requestId, "webhook notification saved to DB");
//                                                                }
//                                                                return Mono.empty();
//                                                            }));
//                                                } else {
//                                                    log.LogInfoMessage(requestId, "notification failed to send");
//                                                    WebhookNotification webhookNotification = buildNotificationObject(webhook, requestId, exception.getCause().getMessage(), "fail");
//                                                    return saveNotificationStatus(webhookNotification)
//                                                            .then(Mono.defer(() -> {
//                                                                log.LogDebugMessage(requestId, "webhook notification saved to DB");
//                                                                if (!(exception instanceof HttpClientErrorException))
//                                                                    return Mono.error(exception);
//                                                                return Mono.empty();
//                                                            }));
//                                                }
//                                            });
//                                } else {
//                                    return Mono.empty();
//                                }
//                            })
//                            .collectList()
//                            .flatMap(list -> {
//                                if (!isClientRegistered[0]) {
//                                    WebhookNotification webhookNotification = buildNotificationObject(null, requestId, "No webhook registered", "not tried");
//                                    return saveNotificationStatus(webhookNotification)
//                                            .then(Mono.error(new WebhookNotFoundException("No webhook registered for requestId " + requestId)));
//                                }
//                                return Mono.empty();
//                            });
//                })
//                .switchIfEmpty(Mono.defer(() -> {
//                    log.LogInfoMessage(requestId, "Either there is no webhook");
//                    WebhookNotification webhookNotification = buildNotificationObject(null, requestId, "no webhook event", "not tried");
//                    return saveNotificationStatus(webhookNotification)
//                            .then(Mono.error(new WebhookNotFoundException("No webhook registered for client " + clientName)));
//                }))
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
//    public void handleEventDataWithWebClient(GenericRecord record, String requestId, String clientName, JSONObject node, JSONObject dataNode, String txnStatus){
//        String methodName = "handleEventData";
//        try {
//            Object JsonEventType = webhookUtil.getStringProperty(node, "type");
//            String eventType = JsonEventType == JSONObject.NULL ?null:JsonEventType.toString();
//
//            String source = (String)webhookUtil.getStringProperty(node, "source");
//            log.LogDebugMessage(requestId, className, clientName);
//            List<Webhook> urls = eventWebhookURLMap !=null ? eventWebhookURLMap.get(eventType):null;
//
//            CopyOnWriteArrayList<Webhook> webHookList = new CopyOnWriteArrayList<Webhook>(urls==null?new ArrayList<>():urls);
//            log.LogDebugMessage(requestId, urls);
//            if(webHookList.isEmpty() || clientName.isEmpty()){
//                log.LogInfoMessage(requestId,"No webhook to listen");
//                WebhookNotification webhookNotification = buildNotificationObject(null, requestId, "no webhook event","not tried");
//                saveWebNotifiactionStatus(webhookNotification);
//                log.LogDebugMessage(requestId, "webhook nitofication status saved to DB");
//                throw new WebhookNotFoundException("No webhook registered for client"+clientName);
//            }
//            boolean isClientRegistered = false;
//            for(Webhook webhook :webHookList){
//                if(webhook.getSourceSystem()==null) {
//                    throw new WebhookNotFoundException("webhook.getSourceSystem is null" + requestId);
//                }
//                if(webhook.isEnabled() && webhook.getSourceSystem().equals(clientName)) {
//                    isClientRegistered= true;
//                    webClientMessageSender.sendNotification(webhook,dataNode.toString(),requestId, txnStatus,record,node);
//                }
//            }
//            if(!isClientRegistered){
//                WebhookNotification webhookNotification = buildNotificationObject(webhook, requestId, "No webhook registered","not tried");
//                saveWebNotifiactionStatus(webhookNotification);
//                throw new WebhookNotFoundException("No webhook registered for requestid"+requestId);
//            }
//            log.LogDebugMessage(requestId, "webhook nitofication send and status saved to DB successfully");
//        }//end of try
//        catch(WebhookNotFoundException whex){
//            log.LogErrorMessage(requestId,"Error occurred in webhookNotFound",whex);
//        }
//        catch(Exception ex){
//            log.LogErrorMessage(requestId,"Error occurred in handleEventData",ex);
//            webhookUtils.handleerror(ex,record,requestId,node);
//            log.LogErrorMessage(requestId,"Error when reprocessing message",ex);
//        }
//    }
////reactive coe
//public Mono<Void> handleEventDataWithWebClient(GenericRecord record, String requestId, String clientName, JSONObject node, JSONObject dataNode, String txnStatus) {
//    return Mono.defer(() -> {
//        // Prepare test result if load testing is enabled
//        Mono<Void> prepareTestResultMono = Mono.fromRunnable(() -> {
//            if (isLoadTestEnabled)
//                prepareTestrsult(requestId, System.currentTimeMillis());
//        });
//
//        // Extract event type
//        Mono<String> eventTypeMono = Mono.defer(() -> {
//            Object JsonEventType = webhookUtil.getStringProperty(node, "type");
//            return Mono.justOrEmpty(JsonEventType == JSONObject.NULL ? null : JsonEventType.toString());
//        });
//
//        // Extract source
//        Mono<String> sourceMono = Mono.defer(() -> {
//            return Mono.justOrEmpty((String) webhookUtil.getStringProperty(node, "source"));
//        });
//
//        // Get webhook URLs
//        Mono<List<Webhook>> urlsMono = eventTypeMono.flatMap(eventType -> {
//            List<Webhook> urls = eventWebhookURLMap != null ? eventWebhookURLMap.get(eventType) : null;
//            CopyOnWriteArrayList<Webhook> webHookList = new CopyOnWriteArrayList<>(urls == null ? new ArrayList<>() : urls);
//            return Mono.just(webHookList);
//        });
//
//        return prepareTestResultMono
//                .then(urlsMono)
//                .flatMapMany(webHookList -> {
//                    if (webHookList.isEmpty() || clientName.isEmpty()) {
//                        return Mono.error(new WebhookNotFoundException("No webhook registered for client " + clientName));
//                    }
//
//                    // Processing each webhook
//                    return Flux.fromIterable(webHookList)
//                            .flatMap(webhook -> {
//                                if (webhook.getSourceSystem() == null) {
//                                    return Mono.error(new WebhookNotFoundException("webhook.getSourceSystem is null for requestId " + requestId));
//                                }
//
//                                if (webhook.isEnabled() && webhook.getSourceSystem().equals(clientName)) {
//                                    return webClientMessageSender.sendNotification(webhook, dataNode.toString(), requestId, txnStatus, record, node)
//                                            .then(Mono.just(true));
//                                }
//                                return Mono.just(false);
//                            })
//                            .collectList()
//                            .flatMap(isClientRegisteredList -> {
//                                boolean isClientRegistered = isClientRegisteredList.contains(true);
//
//                                if (!isClientRegistered) {
//                                    WebhookNotification webhookNotification = buildNotificationObject(null, requestId, "No webhook registered", "not tried");
//                                    return saveWebNotifiactionStatus(webhookNotification)
//                                            .then(Mono.error(new WebhookNotFoundException("No webhook registered for requestId " + requestId)));
//                                }
//                                return Mono.empty();
//                            });
//                })
//                .doOnTerminate(() -> log.LogDebugMessage(requestId, "webhook notification sent and status saved to DB successfully"))
//                .onErrorResume(WebhookNotFoundException.class, whex -> {
//                    log.LogErrorMessage(requestId, "Error occurred in webhookNotFound", whex);
//                    return Mono.empty();
//                })
//                .onErrorResume(ex -> {
//                    log.LogErrorMessage(requestId, "Error occurred in handleEventData", ex);
//                    return webhookUtils.handleError(ex, record, requestId, node)
//                            .then(Mono.empty());
//                });
//    });
//}
//
////corrected code to resolve then() compile time error
//
//    public Mono<Void> handleEventDataWithWebClient(GenericRecord record, String requestId, String clientName, JSONObject node, JSONObject dataNode, String txnStatus) {
//        return Mono.defer(() -> {
//            // Prepare test result if load testing is enabled
//            Mono<Void> prepareTestResultMono = Mono.fromRunnable(() -> {
//                if (isLoadTestEnabled)
//                    prepareTestrsult(requestId, System.currentTimeMillis());
//            });
//
//            // Extract event type
//            Mono<String> eventTypeMono = Mono.defer(() -> {
//                Object JsonEventType = webhookUtil.getStringProperty(node, "type");
//                return Mono.justOrEmpty(JsonEventType == JSONObject.NULL ? null : JsonEventType.toString());
//            });
//
//            // Extract source
//            Mono<String> sourceMono = Mono.defer(() -> {
//                return Mono.justOrEmpty((String) webhookUtil.getStringProperty(node, "source"));
//            });
//
//            // Get webhook URLs
//            Mono<List<Webhook>> urlsMono = eventTypeMono.flatMap(eventType -> {
//                List<Webhook> urls = eventWebhookURLMap != null ? eventWebhookURLMap.get(eventType) : null;
//                CopyOnWriteArrayList<Webhook> webHookList = new CopyOnWriteArrayList<>(urls == null ? new ArrayList<>() : urls);
//                return Mono.just(webHookList);
//            });
//
//            return prepareTestResultMono
//                    .then(urlsMono)
//                    .flatMapMany(webHookList -> {
//                        if (webHookList.isEmpty() || clientName.isEmpty()) {
//                            return Mono.error(new WebhookNotFoundException("No webhook registered for client " + clientName));
//                        }
//
//                        // Processing each webhook
//                        return Flux.fromIterable(webHookList)
//                                .flatMap(webhook -> {
//                                    if (webhook.getSourceSystem() == null) {
//                                        return Mono.error(new WebhookNotFoundException("webhook.getSourceSystem is null for requestId " + requestId));
//                                    }
//
//                                    if (webhook.isEnabled() && webhook.getSourceSystem().equals(clientName)) {
//                                        return webClientMessageSender.sendNotification(webhook, dataNode.toString(), requestId, txnStatus, record, node)
//                                                .thenReturn(true);
//                                    }
//                                    return Mono.just(false);
//                                })
//                                .collectList()
//                                .flatMap(isClientRegisteredList -> {
//                                    boolean isClientRegistered = isClientRegisteredList.contains(true);
//
//                                    if (!isClientRegistered) {
//                                        WebhookNotification webhookNotification = buildNotificationObject(null, requestId, "No webhook registered", "not tried");
//                                        return saveWebNotifiactionStatus(webhookNotification)
//                                                .then(Mono.error(new WebhookNotFoundException("No webhook registered for requestId " + requestId)));
//                                    }
//                                    return Mono.empty();
//                                });
//                    })
//                    .doOnTerminate(() -> log.LogDebugMessage(requestId, "webhook notification sent and status saved to DB successfully"))
//                    .onErrorResume(WebhookNotFoundException.class, whex -> {
//                        log.LogErrorMessage(requestId, "Error occurred in webhookNotFound", whex);
//                        return Mono.empty();
//                    })
//                    .onErrorResume(ex -> {
//                        log.LogErrorMessage(requestId, "Error occurred in handleEventData", ex);
//                        // Cast to Exception here to match the signature of handleError
//                        if (ex instanceof Exception) {
//                            return webhookUtils.handleError((Exception) ex, record, requestId, node)
//                                    .then(Mono.empty());
//                        } else {
//                            return Mono.empty();
//                        }
//                    });
//        });
//    }
//
//
//    public Mono<Void> sentToManualTopic(GenericRecord genericRecord, WebHookNotFoundException whex, String requestId, String manualTopic){
//        String methodName = "sentToManualTopic";
//        try {
//            log.LogErrorMessage(requestId, "Msg processing error", whex);
//            kafkaProducer.sendMessageToKafka(requestId, manualTopic, "servicename", genericRecord);
//            log.LogErrorMessage(requestId, "Sent to manual Topic", whex);
//        }
//        catch(Exception e){
//            log.LogErrorMessage(requestId, "Sent to manual Topic failed", whex);
//        }
//}
//public Mono<Void> saveStatus(WebhookNotification wn){
//        try{
//            webhookNotificationDAO.logWebhookNotificationDetails(wn);
//        } catch(Exception ex){
//            log.LogErrorMessage(wn.getEventId(), "Msg processing error", ex);
//        }
//}
////reactive code - 06112024 2:10 pm
//public Mono<Void> handleEventDataWithWebClient(GenericRecord record, String requestId, String clientName, JSONObject node, JSONObject dataNode, String txnStatus) {
//    return Mono.defer(() -> {
//        // Prepare test result if load testing is enabled
//        Mono<Void> prepareTestResultMono = isLoadTestEnabled
//                ? Mono.fromRunnable(() -> prepareTestResult(requestId, System.currentTimeMillis()))
//                : Mono.empty();
//
//        // Extract event type
//        Mono<String> eventTypeMono = Mono.justOrEmpty(webhookUtil.getStringProperty(node, "type"))
//                .map(JsonEventType -> JsonEventType == JSONObject.NULL ? null : JsonEventType.toString());
//
//        // Get webhook URLs
//        Mono<List<Webhook>> urlsMono = eventTypeMono.flatMap(eventType -> {
//            List<Webhook> urls = eventWebhookURLMap != null ? eventWebhookURLMap.get(eventType) : null;
//            return Mono.just(new CopyOnWriteArrayList<>(urls == null ? new ArrayList<>() : urls));
//        });
//
//        return prepareTestResultMono
//                .then(urlsMono)
//                .flatMapMany(webhookList -> {
//                    if (webhookList.isEmpty() || clientName.isEmpty()) {
//                        WebhookNotification webhookNotification = buildNotificationObject(null, requestId, "no webhook event", "not tried");
//                        return saveWebNotifiactionStatus(webhookNotification)
//                                .then(Mono.error(new WebhookNotFoundException("No webhook registered for client " + clientName)));
//                    }
//
//                    // Processing each webhook
//                    return Flux.fromIterable(webhookList)
//                            .flatMap(webhook -> {
//                                if (webhook.getSourceSystem() == null) {
//                                    return Mono.error(new WebhookNotFoundException("webhook.getSourceSystem is null" + requestId));
//                                }
//
//                                if (webhook.isEnabled() && webhook.getSourceSystem().equals(clientName)) {
//                                    return webClientMessageSender.sendNotification(webhook, dataNode.toString(), requestId, txnStatus, record, node)
//                                            .thenReturn(true); // Use thenReturn to signal successful processing
//                                }
//                                return Mono.just(false); // Return false if webhook not processed
//                            })
//                            .collectList()
//                            .flatMap(isClientRegisteredList -> {
//                                boolean isClientRegistered = isClientRegisteredList.stream().anyMatch(Boolean.TRUE::equals);
//
//                                if (!isClientRegistered) {
//                                    WebhookNotification webhookNotification = buildNotificationObject(null, requestId, "No webhook registered", "not tried");
//                                    return saveWebNotifiactionStatus(webhookNotification)
//                                            .then(Mono.error(new WebhookNotFoundException("No webhook registered for request id " + requestId)));
//                                }
//                                return Mono.empty();
//                            });
//                })
//                .doOnSuccess(v -> log.LogDebugMessage(requestId, "webhook notification sent and status saved to DB successfully"))
//                .onErrorResume(WebhookNotFoundException.class, whex -> {
//                    log.LogErrorMessage(requestId, "Error occurred in webhookNotFound", whex);
//                    return Mono.empty();
//                })
//                .onErrorResume(Exception.class, ex -> {
//                    log.LogErrorMessage(requestId, "Error occurred in handleEventData", ex);
//                    return webhookUtils.handleError(ex, record, requestId, node)
//                            .then(Mono.empty());
//                });
//    });
//}
////reactive code 06112024 2:15 pm
//public Mono<Void> handleEventDataWithWebClient(GenericRecord record, String requestId, String clientName, JSONObject node, JSONObject dataNode, String txnStatus) {
//    return Mono.defer(() -> {
//        // Extract event type
//        Mono<String> eventTypeMono = Mono.justOrEmpty(webhookUtil.getStringProperty(node, "type"))
//                .map(JsonEventType -> JsonEventType == JSONObject.NULL ? null : JsonEventType.toString());
//
//        // Get webhook URLs
//        Mono<List<Webhook>> urlsMono = eventTypeMono.flatMap(eventType -> {
//            List<Webhook> urls = eventWebhookURLMap != null ? eventWebhookURLMap.get(eventType) : null;
//            return Mono.just(new CopyOnWriteArrayList<>(urls == null ? new ArrayList<>() : urls));
//        });
//
//        return urlsMono.flatMapMany(webHookList -> {
//                    log.LogDebugMessage(requestId, "Processing webhook list", webHookList);
//                    if (webHookList.isEmpty() || clientName.isEmpty()) {
//                        log.LogInfoMessage(requestId, "No webhook to listen");
//                        WebhookNotification webhookNotification = buildNotificationObject(null, requestId, "no webhook event", "not tried");
//                        return saveWebNotifiactionStatus(webhookNotification)
//                                .then(Mono.error(new WebhookNotFoundException("No webhook registered for client " + clientName)));
//                    }
//
//                    // Processing each webhook
//                    return Flux.fromIterable(webHookList)
//                            .flatMap(webhook -> {
//                                if (webhook.getSourceSystem() == null) {
//                                    return Mono.error(new WebhookNotFoundException("webhook.getSourceSystem is null for requestId " + requestId));
//                                }
//
//                                if (webhook.isEnabled() && webhook.getSourceSystem().equals(clientName)) {
//                                    return webClientMessageSender.sendNotification(webhook, dataNode.toString(), requestId, txnStatus, record, node)
//                                            .thenReturn(true); // Signal successful processing
//                                }
//                                return Mono.just(false); // Webhook not processed
//                            })
//                            .collectList()
//                            .flatMap(isClientRegisteredList -> {
//                                boolean isClientRegistered = isClientRegisteredList.stream().anyMatch(Boolean.TRUE::equals);
//
//                                if (!isClientRegistered) {
//                                    WebhookNotification webhookNotification = buildNotificationObject(null, requestId, "No webhook registered", "not tried");
//                                    return saveWebNotifiactionStatus(webhookNotification)
//                                            .then(Mono.error(new WebhookNotFoundException("No webhook registered for request id " + requestId)));
//                                }
//                                return Mono.empty();
//                            });
//                })
//                .doOnSuccess(v -> log.LogDebugMessage(requestId, "webhook notification sent and status saved to DB successfully"))
//                .doOnError(WebhookNotFoundException.class, whex -> log.LogErrorMessage(requestId, "Error occurred in webhookNotFound", whex))
//                .onErrorResume(Exception.class, ex -> {
//                    log.LogErrorMessage(requestId, "Error occurred in handleEventData", ex);
//                    return webhookUtils.handleError(ex, record, requestId, node)
//                            .then(Mono.empty());
//                });
//    });
//}
//public void onMessage(Message<?> message){
//        GenericRecord record = (GenericRecord) message.getPayload();
//        MessageHeader headers = message.getHeader();
//        String requestId = webhookUtil.getRequestId(record.toString());
//        Long offsetId = headers.get(KafkaHeaders.OFFSET);
//        Long kafksReceivedTimeStamp = headers.get(KafkaHeaders.RECEIVED);
//        Integer kafkaReceivedpartition = (Integer)headers.get(KafkaHeaders.PARTITION);
//        String key = headers.get(KafkaHeaders.KEY);
//    log.LogInfoMessage(requestId, "Response Record received");
//    log.LogDebugMessage(requestId, "Consuming message", String.valueOf(kafkaReceivedpartition),key,
//            String.valueOf(offsetId), String.valueOf(kafksReceivedTimeStamp));
//
//    processMessage(record);
//
//}
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageHeaders;
//import reactor.core.publisher.Mono;
//import org.apache.kafka.common.header.Headers;
//
//    public Mono<Void> onMessage(Message<?> message) {
//        return Mono.just(message)
//                .flatMap(msg -> {
//                    GenericRecord record = (GenericRecord) msg.getPayload();
//                    MessageHeaders headers = msg.getHeaders();
//                    String requestId = webhookUtil.getRequestId(record.toString());
//                    Long offsetId = headers.get(KafkaHeaders.OFFSET, Long.class);
//                    Long kafkaReceivedTimeStamp = headers.get(KafkaHeaders.RECEIVED, Long.class);
//                    Integer kafkaReceivedPartition = headers.get(KafkaHeaders.RECEIVED_PARTITION, Integer.class);
//                    String key = headers.get(KafkaHeaders.RECEIVED_KEY, String.class);
//
//                    log.LogInfoMessage(requestId, "Response Record received");
//                    log.LogDebugMessage(requestId, "Consuming message", String.valueOf(kafkaReceivedPartition), key,
//                            String.valueOf(offsetId), String.valueOf(kafkaReceivedTimeStamp));
//
//                    // Convert processMessage to reactive if it is not already
//                    return processMessage(record);
//                })
//                .then();  // Ensure the method returns Mono<Void>
//    }
////webhookErrorMessageListener.java
//    public void onMessage(GenericRecord record){
//        String message = record.toString();
//        String requestId = webHookUtil.getRequestId(message);
//        String manualTopic = null;
//
//        loggingAggregator.LogInfoMessage(requestId,"OnMessage", "Response record received from kafka error queue");
//        Integer deliveryAttempts = null;
//        String lastdeliveryTime = null;
//        List<RetryTrial> retryList = null;
//        JSONObject node = (JSONObject) WebhookUtil.jsonDeserializer(message, null);
//
//        String source = (String) webhookUtil.getStringProperty(node, "source");
//        if(node.get("retryTrial").toString() != WebhookConstant.NULL){
//            JSONArray retryjson = node.getJSONArray(WebhookConstant.RETRYTRIAL);
//            ObjectMapper mapper = new ObjectMapper();
//            try{
//                retryList = new ArrayList<RetryTrial>(
//                        Arrays.asList(mapper.readValue(retryjson.toString(), RetryTrial[].class)));
//            }
//            catch(JsonProcessingException | JSONException e){
//                loggingAggregator.LogErrorMessage(requestId,"OnMessage", "JsonMappingException");
//            }
//        }
//        RetryTrial lastRetryTrial = WebhookUtil.getLastRetryObject(retryList);
//        RetryRequest retryRequest = new RetryRequest();
//        if(lastRetryTrial !=null){
//            deliveryAttempts = lastRetryTrial.getDeliveryAttempts();
//            lastdeliveryTime = lastRetryTrial.getLastdeliverytime();
//            retryRequest.setRetryCount(deliveryAttempts);
//        }
//        retryRequest.setErrorTopic(errorTopic);
//        retryRequest.setManualErrorTopic(manualTopic);
//        retryRequest.setRetryMessage(record);
//        retryRequest.setRequestId(requestId);
//
//        if(retryService.isRetryEligible(retryRequest, deliveryAttempts, lastdeliveryTime)){
//            processMessage(record);
//        }
//    }
////onmessage method reactive version for errormessagelistener
//    import reactor.core.publisher.Mono;
//import reactor.core.publisher.Flux;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.kafka.common.header.Headers;
//
//    public Mono<Void> onMessage(GenericRecord record) {
//        String message = record.toString();
//        String requestId = webhookUtil.getRequestId(message);
//
//        loggingAggregator.LogInfoMessage(requestId, "OnMessage", "Response record received from kafka error queue");
//
//        // Create reactive sources
//        Mono<JSONObject> nodeMono = Mono.fromCallable(() -> (JSONObject) webhookUtil.jsonDeserializer(message, null));
//        Mono<JSONArray> retryJsonMono = nodeMono
//                .map(node -> node.optJSONArray(WebhookConstant.RETRYTRIAL));
//
//        // Convert JSON to List<RetryTrial> reactively
//        Mono<List<RetryTrial>> retryListMono = retryJsonMono
//                .flatMap(retryJson -> {
//                    if (retryJson != null) {
//                        ObjectMapper mapper = new ObjectMapper();
//                        return Mono.fromCallable(() -> Arrays.asList(mapper.readValue(retryJson.toString(), RetryTrial[].class)))
//                                .onErrorResume(JsonProcessingException.class, ex -> {
//                                    loggingAggregator.LogErrorMessage(requestId, "OnMessage", "JsonProcessingException");
//                                    return Mono.empty();
//                                })
//                                .onErrorResume(JSONException.class, ex -> {
//                                    loggingAggregator.LogErrorMessage(requestId, "OnMessage", "JSONException");
//                                    return Mono.empty();
//                                });
//                    } else {
//                        return Mono.empty();
//                    }
//                });
//
//        // Extract last retry trial
//        Mono<RetryTrial> lastRetryTrialMono = retryListMono
//                .map(WebhookUtil::getLastRetryObject)
//                .switchIfEmpty(Mono.justOrEmpty(null));
//
//        // Create RetryRequest reactively
//        Mono<RetryRequest> retryRequestMono = lastRetryTrialMono.map(lastRetryTrial -> {
//            RetryRequest retryRequest = new RetryRequest();
//            if (lastRetryTrial != null) {
//                retryRequest.setRetryCount(lastRetryTrial.getDeliveryAttempts());
//                retryRequest.setLastDeliveryTime(lastRetryTrial.getLastdeliverytime());
//            }
//            retryRequest.setErrorTopic(errorTopic);
//            retryRequest.setManualErrorTopic(manualTopic);
//            retryRequest.setRetryMessage(record);
//            retryRequest.setRequestId(requestId);
//            return retryRequest;
//        });
//
//        // Check retry eligibility reactively
//        return retryRequestMono
//                .flatMap(retryRequest ->
//                        Mono.just(retryService.isRetryEligible(retryRequest, retryRequest.getRetryCount(), retryRequest.getLastDeliveryTime()))
//                                .flatMap(isEligible -> {
//                                    if (isEligible) {
//                                        return processMessage(record); // Assume this returns Mono<Void>
//                                    } else {
//                                        return Mono.empty();
//                                    }
//                                })
//                );
//    }
//
//    //updated code
//    import reactor.core.publisher.Mono;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.kafka.common.header.Headers;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//    public Mono<Void> onMessage(GenericRecord record) {
//        String message = record.toString();
//        String requestId = webhookUtil.getRequestId(message);
//
//        loggingAggregator.LogInfoMessage(requestId, "OnMessage", "Response record received from kafka error queue");
//
//        // Create reactive sources
//        Mono<JSONObject> nodeMono = Mono.fromCallable(() -> (JSONObject) webhookUtil.jsonDeserializer(message, null));
//        Mono<String> sourceMono = nodeMono.map(node -> (String) webhookUtil.getStringProperty(node, "source"));
//        Mono<JSONArray> retryJsonMono = nodeMono.map(node -> node.optJSONArray(WebhookConstant.RETRYTRIAL));
//
//        // Convert JSON to List<RetryTrial> reactively
//        Mono<List<RetryTrial>> retryListMono = retryJsonMono.flatMap(retryJson -> {
//            if (retryJson != null) {
//                ObjectMapper mapper = new ObjectMapper();
//                return Mono.fromCallable(() -> Arrays.asList(mapper.readValue(retryJson.toString(), RetryTrial[].class)))
//                        .onErrorResume(JsonProcessingException.class, ex -> {
//                            loggingAggregator.LogErrorMessage(requestId, "OnMessage", "JsonProcessingException");
//                            return Mono.just(Collections.emptyList());
//                        })
//                        .onErrorResume(JSONException.class, ex -> {
//                            loggingAggregator.LogErrorMessage(requestId, "OnMessage", "JSONException");
//                            return Mono.just(Collections.emptyList());
//                        });
//            } else {
//                return Mono.just(Collections.emptyList());
//            }
//        });
//
//        // Extract last retry trial and set deliveryAttempts and lastDeliveryTime
//        Mono<Tuple3<List<RetryTrial>, Integer, String>> retryDetailsMono = retryListMono.map(retryList -> {
//            RetryTrial lastRetryTrial = WebhookUtil.getLastRetryObject(retryList);
//            Integer deliveryAttempts = (lastRetryTrial != null) ? lastRetryTrial.getDeliveryAttempts() : 1;
//            String lastDeliveryTime = (lastRetryTrial != null) ? lastRetryTrial.getLastdeliverytime() : null;
//            return Tuples.of(retryList, deliveryAttempts, lastDeliveryTime);
//        });
//
//        // Create RetryRequest reactively
//        Mono<RetryRequest> retryRequestMono = retryDetailsMono.map(tuple -> {
//            RetryRequest retryRequest = new RetryRequest();
//            retryRequest.setRetryCount(tuple.getT2());
//            retryRequest.setLastDeliveryTime(tuple.getT3());
//            retryRequest.setErrorTopic(errorTopic);
//            retryRequest.setManualErrorTopic(manualTopic);
//            retryRequest.setRetryMessage(record);
//            retryRequest.setRequestId(requestId);
//            return retryRequest;
//        });
//
//        // Check retry eligibility reactively
//        return retryRequestMono
//                .flatMap(retryRequest ->
//                        retryDetailsMono.flatMap(tuple -> {
//                            Integer deliveryAttempts = tuple.getT2();
//                            String lastDeliveryTime = tuple.getT3();
//                            if (retryService.isRetryEligible(retryRequest, deliveryAttempts, lastDeliveryTime)) {
//                                return processMessage(record); // Assume this returns Mono<Void>
//                            } else {
//                                return Mono.empty();
//                            }
//                        })
//                );
//    }
//
//    import reactor.core.publisher.Mono;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.kafka.common.header.Headers;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import reactor.util.function.Tuple2;
//import reactor.util.function.Tuple3;
//import reactor.util.function.Tuples;
//import java.util.Collections;
//
//    public Mono<Void> onMessage(GenericRecord record) {
//        String message = record.toString();
//        String requestId = webhookUtil.getRequestId(message);
//
//        loggingAggregator.LogInfoMessage(requestId, "OnMessage", "Response record received from kafka error queue");
//
//        // Reactive node and retryJson
//        Mono<JSONObject> nodeMono = Mono.fromCallable(() -> (JSONObject) webhookUtil.jsonDeserializer(message, null));
//        Mono<String> sourceMono = nodeMono.map(node -> (String) webhookUtil.getStringProperty(node, "source"));
//        Mono<JSONArray> retryJsonMono = nodeMono.map(node -> node.optJSONArray(WebhookConstant.RETRYTRIAL));
//
//        // Reactive List<RetryTrial> with error handling
//        Mono<List<RetryTrial>> retryListMono = retryJsonMono.flatMap(retryJson -> {
//            if (retryJson != null) {
//                ObjectMapper mapper = new ObjectMapper();
//                return Mono.fromCallable(() -> Arrays.asList(mapper.readValue(retryJson.toString(), RetryTrial[].class)))
//                        .onErrorResume(JsonProcessingException.class, ex -> {
//                            loggingAggregator.LogErrorMessage(requestId, "OnMessage", "JsonProcessingException");
//                            return Mono.just(Collections.emptyList());
//                        })
//                        .onErrorResume(JSONException.class, ex -> {
//                            loggingAggregator.LogErrorMessage(requestId, "OnMessage", "JSONException");
//                            return Mono.just(Collections.emptyList());
//                        });
//            } else {
//                return Mono.just(Collections.emptyList());
//            }
//        });
//
//        // Extract last retry trial
//        Mono<RetryTrial> lastRetryTrialMono = retryListMono.map(WebhookUtil::getLastRetryObject);
//
//        // Extract deliveryAttempts and lastDeliveryTime
//        Mono<Tuple2<Integer, String>> deliveryDetailsMono = lastRetryTrialMono.map(lastRetryTrial -> {
//            Integer deliveryAttempts = (lastRetryTrial != null) ? lastRetryTrial.getDeliveryAttempts() : 1;
//            String lastDeliveryTime = (lastRetryTrial != null) ? lastRetryTrial.getLastdeliverytime() : null;
//            return Tuples.of(deliveryAttempts, lastDeliveryTime);
//        });
//
//        // Create RetryRequest
//        Mono<RetryRequest> retryRequestMono = Mono.zip(retryListMono, deliveryDetailsMono)
//                .map(tuple -> {
//                    List<RetryTrial> retryList = tuple.getT1();
//                    Integer deliveryAttempts = tuple.getT2().getT1();
//                    String lastDeliveryTime = tuple.getT2().getT2();
//
//                    RetryRequest retryRequest = new RetryRequest();
//                    retryRequest.setRetryCount(deliveryAttempts);
//                    retryRequest.setLastDeliveryTime(lastDeliveryTime);
//                    retryRequest.setErrorTopic(errorTopic);
//                    retryRequest.setManualErrorTopic(manualTopic);
//                    retryRequest.setRetryMessage(record);
//                    retryRequest.setRequestId(requestId);
//                    return retryRequest;
//                });
//
//        // Check retry eligibility and process message
//        return retryRequestMono
//                .flatMap(retryRequest ->
//                        deliveryDetailsMono.flatMap(details -> {
//                            Integer deliveryAttempts = details.getT1();
//                            String lastDeliveryTime = details.getT2();
//                            if (retryService.isRetryEligible(retryRequest, deliveryAttempts, lastDeliveryTime)) {
//                                return processMessage(record); // Assume this returns Mono<Void>
//                            } else {
//                                return Mono.empty();
//                            }
//                        })
//                );
//    }
//
//    import reactor.core.publisher.Mono;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import java.util.Collections;
//import java.util.List;
//import java.util.Arrays;
//
//    public Mono<Void> onMessage(GenericRecord record) {
//        String message = record.toString();
//        String requestId = webhookUtil.getRequestId(message);
//
//        loggingAggregator.LogInfoMessage(requestId, "OnMessage", "Response record received from kafka error queue");
//
//        // Reactive node and retryJson
//        Mono<JSONObject> nodeMono = Mono.fromCallable(() -> (JSONObject) webhookUtil.jsonDeserializer(message, null));
//        Mono<String> sourceMono = nodeMono.map(node -> (String) webhookUtil.getStringProperty(node, "source"));
//        Mono<JSONArray> retryJsonMono = nodeMono.map(node -> node.optJSONArray(WebhookConstant.RETRYTRIAL));
//
//        // Reactive List<RetryTrial> with error handling
//        Mono<List<RetryTrial>> retryListMono = retryJsonMono.flatMap(retryJson -> {
//            if (retryJson != null) {
//                ObjectMapper mapper = new ObjectMapper();
//                return Mono.fromCallable(() -> Arrays.asList(mapper.readValue(retryJson.toString(), RetryTrial[].class)))
//                        .onErrorResume(JsonProcessingException.class, ex -> {
//                            loggingAggregator.LogErrorMessage(requestId, "OnMessage", "JsonProcessingException");
//                            return Mono.just(Collections.emptyList());
//                        })
//                        .onErrorResume(JSONException.class, ex -> {
//                            loggingAggregator.LogErrorMessage(requestId, "OnMessage", "JSONException");
//                            return Mono.just(Collections.emptyList());
//                        });
//            } else {
//                return Mono.just(Collections.emptyList());
//            }
//        });
//
//        // Extract last retry trial
//        Mono<RetryTrial> lastRetryTrialMono = retryListMono.map(WebhookUtil::getLastRetryObject);
//
//        // Extract deliveryAttempts and lastDeliveryTime separately
//        Mono<Integer> deliveryAttemptsMono = lastRetryTrialMono.map(lastRetryTrial ->
//                (lastRetryTrial != null) ? lastRetryTrial.getDeliveryAttempts() : 1
//        );
//
//        Mono<String> lastDeliveryTimeMono = lastRetryTrialMono.map(lastRetryTrial ->
//                (lastRetryTrial != null) ? lastRetryTrial.getLastdeliverytime() : null
//        );
//
//        // Create RetryRequest
//        Mono<RetryRequest> retryRequestMono = Mono.zip(retryListMono, deliveryAttemptsMono, lastDeliveryTimeMono)
//                .map(tuple -> {
//                    List<RetryTrial> retryList = tuple.getT1();
//                    Integer deliveryAttempts = tuple.getT2();
//                    String lastDeliveryTime = tuple.getT3();
//
//                    RetryRequest retryRequest = new RetryRequest();
//                    retryRequest.setRetryCount(deliveryAttempts);
//                    retryRequest.setLastDeliveryTime(lastDeliveryTime);
//                    retryRequest.setErrorTopic(errorTopic);
//                    retryRequest.setManualErrorTopic(manualTopic);
//                    retryRequest.setRetryMessage(record);
//                    retryRequest.setRequestId(requestId);
//                    return retryRequest;
//                });
//
//        // Check retry eligibility and process message
//        return retryRequestMono
//                .flatMap(retryRequest ->
//                        deliveryAttemptsMono.zipWith(lastDeliveryTimeMono).flatMap(tuple -> {
//                            Integer deliveryAttempts = tuple.getT1();
//                            String lastDeliveryTime = tuple.getT2();
//                            if (retryService.isRetryEligible(retryRequest, deliveryAttempts, lastDeliveryTime)) {
//                                return processMessage(record); // Assume this returns Mono<Void>
//                            } else {
//                                return Mono.empty();
//                            }
//                        })
//                );
//    }
//
//    public Long logWebhookNotificationDetails(WebHookNotification wn){
//        return webhookNotificationRepository.save(wn).getNotificationId();
//    }
//
//    public R2dbcEntityTemplate r2dbcEntityTemplate(ConnectionFactory connectionFactory){
//        return new R2dbcEntityTemplate((ConnectionFactory)DatabaseClient.builder().conectionFactory(connectionFactory).build());
//    }
//}
