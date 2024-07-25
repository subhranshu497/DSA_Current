//package com.prep;
//
//public class demo1 {
//    import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import reactor.core.publisher.Mono;
//
//private static final boolean flag = true;
//
//    public Mono<ResponseEntity<WebHookResponse>> createWebhook(@RequestBody WebhookRequest webhookRequest) {
//        return Mono.defer(() -> {
//            try {
//                Mono<Webhook> webhookMono = setWebhookDetails(webhookRequest);
//
//                return webhookMono.flatMap(webhook ->
//                        webhookDAO.isWebhookAlreadyExists(webhook.getEventType(), webhook.getWebhookUrl(), webhook.getSourceSystem())
//                                .flatMap(isDup -> {
//                                    if (!isDup) {
//                                        return Mono.error(new DuplicateWebhookException("message"));
//                                    }
//                                    return webhookDAO.registerWebhook(webhook)
//                                            .then(createLinks(Mono.just(webhook)));
//                                })
//                                .map(webhookResponse -> new ResponseEntity<>(webhookResponse, HttpStatus.OK))
//                ).onErrorMap(ex -> {
//                    if (ex instanceof DuplicateWebhookException) {
//                        return ex;
//                    }
//                    return new WebhookException("message", ex);
//                });
//            } catch (Exception ex) {
//                return Mono.error(new WebhookException("message", ex));
//            }
//        });
//    }
//
//    public void processMessage(GenericRecord record){
//        String message = record.toString();
//        String reqId= webhookUtil.getRequestId(message);
//        String manualTopic = null;
//
//        loggingAggregator.LogInfoMessage(reqId, className, "OnMessage");
//        JSONObject node = null;
//        try {
//            JSONObject screeningStatus = null;
//            Object jsonTxnStatus = null;
//            String jsonClientName = null;
//            String clientName = null;
//            String txnStatus = null;
//            String source = null;
//            node = (JSONObject) webhookUtil.jsonDeserializer(message, null);
//            Object JsonEventType = webhookUtil.getStringProperty(node, webhookConstnt.TYPE);
//            source = (String) webhookUtil.getStringProperty(node, webhookConstant.SOURCE);
//            JSONObject dataNode = webhookUtil.getStringProperty(node, webhookConstant.DATA);
//            screeningStatus = webhookUtil.getStringProperty(dataNode, webhookConstant.SCR);
//            jsonClientName = (String) webhookUtil.getStringProperty(dataNode, webhookConstant.CLIENT_NAME);
//            clientName = jsonClientName == JSONObject.NULL ? null : jsonClientName.toString();
//            jsonTxnStatus = webhookUtil.getStringProperty(screeningStatus, webhookConstant.txn);
//            txnStatus = jsonTxnStatus == JSONObject.NULL ? null : jsonTxnStatus.toString();
//            webhookMessageHandler.handleMessage(record,reqId, clientName, message, txnStatus,node);
//            if(flag){
//                notificationService.handleEventDataUsingWebClient(record, reqId, node, clientName,dataNode, txnStatus);
//            }else{
//                notificationService.handleEventData(record, reqId, node, clientName, dataNode, txnStatus);
//            }
//            loggingAggregator.LogInfoMessage(reqId, className, "OnMessage");
//        }
//        catch (NullPointerException npe){
//            loggingAggregator.LogInfoMessage(reqId, className, "npe");
//            kafkaProducer.sendMessageToKafka(record, reqId, manualTopic);
//        }
//        catch (Exception ex){
//            loggingAggregator.LogInfoMessage(reqId, className, "npe");
//            webhookUtil.handleError(ex, record, reqId, node);
//        }
//        loggingAggregator.LogInfoMessage(reqId, className, "success");
//    }
//
//    public static Object jsonSerializer(String jsonData, Class<?> cls){
//        Object node = null;
//        if(cls == null) node = new JSONObject(jsonData);
//        else{
//            Gson gson = new Gson();
//            node = gson.fromJson(jsonData, cls);
//        }
//        return node;
//    }
//    public String getRequestId(String jsonData){
//        String requestId =null;
//        try{
//            JSONObject node = (JSONObject) webhookUtil.jsonDeserializer(jsonData, null);
//            Object jsonValue = getStringProperty(node, WebhookConstant.REQUESTID);
//            requestId = jsonValue == JSONObject.NULL ? null : jsonValue.toString();
//        }
//        catch(JSONException e){
//            loggingAggregator.LogErrorMessage(null, className, "OnMessage", e);
//        }
//    }

//import java.lang.management.ManagementFactory;
//import java.lang.management.RuntimeMXBean;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//static Map<String, List<WebHook>> eventWebHookUrlMap = new ConcurrentHashMap<>();
//
//@postConstruct
//public void initialize(){
//    String methodName = "initialize";
//    log.LogInfoMessage(uuid, className, "method", "Initializing webhookurlmap");
//    try{
//        Set<WebHook> activeWebhooks = new HashSet<>(webhookDao.getAllActiveWebhook());
//        populateWebhook(activeWebhooks);
//        setUpTimer();
//        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
//        jvm_startup_time = bean.getStartTime();
//        log.LogDebugMessage(uuid, className, "method", "Initialize event");
//        log.LogDebugMessage(uuid, className, "method", "webhookurlmap", eventWebHookUrlMap.toString());
//    }
//    catch(Exception ex){
//        log.LogErrorMessage(uuid, className, "error occured", ex);
//    }
//}
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import javax.annotation.PostConstruct;
//import java.lang.management.ManagementFactory;
//import java.lang.management.RuntimeMXBean;
//import java.util.Set;
//import java.util.HashSet;
//import java.util.UUID;
//
//@Component
//public class WebHookInitializer {
//
//    private final WebHookRepoImpl webhookRepo;
//    private final LogService log;  // Assuming there's a logging service
//    private final UUID uuid = UUID.randomUUID();
//    private final String className = this.getClass().getSimpleName();
//
//    private long jvm_startup_time;
//    private Set<WebHook> eventWebHookUrlMap = new HashSet<>();  // Example set for webhook URLs
//
//    @Autowired
//    public WebHookInitializer(WebHookRepoImpl webhookRepo, LogService log) {
//        this.webhookRepo = webhookRepo;
//        this.log = log;
//    }
//
//    @PostConstruct
//    public void initialize() {
//        String methodName = "initialize";
//        log.LogInfoMessage(uuid, className, methodName, "Initializing webhookurlmap");
//
//        webhookRepo.getAllActiveWebHook()
//                .collectList()  // Collecting the Flux into a List to mimic synchronous behavior
//                .doOnNext(this::populateWebhook)  // Populating webhook
//                .doOnNext(activeWebhooks -> setUpTimer())  // Setting up the timer
//                .doOnNext(activeWebhooks -> {
//                    RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
//                    jvm_startup_time = bean.getStartTime();
//                    log.LogDebugMessage(uuid, className, methodName, "Initialize event");
//                    log.LogDebugMessage(uuid, className, methodName, "webhookurlmap", eventWebHookUrlMap.toString());
//                })
//                .doOnError(ex -> log.LogErrorMessage(uuid, className, "error occurred", ex))
//                .subscribe();
//    }
//
//    private void populateWebhook(Set<WebHook> activeWebhooks) {
//        // Example logic for populating webhook map
//        eventWebHookUrlMap.addAll(activeWebhooks);
//    }
//
//    private void setUpTimer() {
//        // Example logic for setting up a timer
//        // Timer setup code here
//    }
//}


//}
