//package com.prep;
//
//import javax.swing.text.html.Option;
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class  {
//    import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
//import java.util.Optional;
//
//    @RestController
//    @RequestMapping("/api/webhook")
//    public class WebhookController {
//
//        private final WebhookDAO webhookDAO;
//
//        public WebhookController(WebhookDAO webhookDAO) {
//            this.webhookDAO = webhookDAO;
//        }
//
//        @GetMapping("/{webhookId}")
//        public Mono<ResponseEntity<WebhookResponse>> getWebhook(@PathVariable Long webhookId) {
//            return Mono.defer(() -> {
//                try {
//                    // Set processing ID to thread
//                    setProcessingIdToThread();
//
//                    // Fetch webhook by ID asynchronously
//                    return webhookDAO.getWebhookById(webhookId)
//                            .map(this::createLink)
//                            .map(webhookResponse -> ResponseEntity.ok(webhookResponse))
//                            .switchIfEmpty(Mono.error(new WebhookNotFoundException("Webhook not found")));
//                } catch (Exception ex) {
//                    // If an error occurs, throw a WebhookException
//                    return Mono.error(new WebhookException("Error retrieving webhook"));
//                } finally {
//                    // Remove processing ID from thread
//                    threadLocal.remove();
//                }
//            });
//        }
//
//        private WebhookResponse createLink(Webhook webhook) {
//            // Implement logic to create link for the webhook
//        }
//    }
//
//    public void getWebHookById() throws Exception {
//        WebHook webhook = new WebHook(1001, "acc.act","testUrl",WebhookStatus.Enabled.name(),"econnect","secret");
//        Optional<WebHook> optional = Optional.of(webhook);
//        RequestBuilder requestBuilder = MockMVCRequestBuilders.get("/v1/risk").accept(
//                MediaType.Application_json
//        );
//        () -> mockMvc.perform(requestBuilder).andExcept(status().isOk()).andExcept(content().contenttype(MediaType.Application_json));
//
//    }
//
//    public void getAllWebhooks() throws Exception{
//        WebHook w1 = new WebHook(1,2,"3");
//        List<WebHook> webhooks = new ArrayList<>();
//        webhooks.add(w1);
//        when(webHookDAO.getAllWebhook()).thenreturn(webhooks);
//        RequestBuilder rb = MockMvcRequestBuilders.get("/v1/risk").accept(MediaType.Application.json);
//
//        MvcResult result = mockMvc.perform(rb).andExcept(status().isOk()).andReturn();
//        assertNotNull(result.getResponse().getContentAsString());
//    }
//
//    //subh - yet to modify for 404 response
//    public void webHookNotFoundException() throws Exception{
//        when(webhookDao.getWebhookById(Mockito.anyLong())).thenThrow(WebhookNotFoundException.class);
//        RequestBuilder requestBuilder = MockMVCRequestBuilders.get("/v1/risk/webhooks/1002").accept(
//                MediaType.Application_json
//        );
//        MvcResult result = mockMvc.perform(requestBuilder).andExcept(status().is4xxClientError()).andReturn();
//        assertEquals(result.getResponse().getStaus(),404);
//    }
//
//    //Subh - yet to update to get 404 status
//    public void getWebHookById404() throws Exception {
//       when(webhookDAO.getWebhookById(Mockito.anyLong())).thenReturn(null);
//        RequestBuilder requestBuilder = MockMVCRequestBuilders.get("/v1/risk/webhooks/1002").accept(
//                MediaType.Application_json);
//        mockMvc.perform(requestBuilder).andExcept(status().isNotFound());
//
//    }
//    private WebHookResponse createLinks(Webhook webhook){
//        String[] eventtypes = webhook.getEventType().split(",");
//        WebhookResponse whr = new WebhookResponse(webhook.getWebhookId(), eventtypes);
//        whr.add(linkTo(methodOn(WebhookController.class).getById(webhook.getWebhookId))).withSelfRel());
//
//    return whr;
//    }
//
//    public ResponseEntity<WebhookResponse> createWebhook(@RequestBody WebhookRequest webhookRequest){
//        try{
//            Webhook webhook = setWebhookDetails(webhookRequest);
//            boolean isdup = webhookDAO.isWebhookAlreadyExists(webhook.getEventType(),
//                    webhook.getWebhookUrl(), webhook.getSourceSystem());
//            if(!isdup){
//                webhookDAO.registerWebhook(webhook);
//            }
//            else throw DuplicateWebhookException("message");
//            WebhookResponse webhookResponse = createLinks(webhook);
//            return ResponseEntity<WebhookRsponse>(webhookResponse, HttpStatus.OK);
//        }
//        catch(DuplicateWebhookException ex){
//            throw ex;
//        }
//        catch(Exception ex){
//            throw WebhookException("message");
//        }
//    }
//
//    public boolean isWebhookExist(String eventType){
//        Webhook wbhook = webhookRepo.findByEventType(eventType);
//        return wbhook==null?false :true;
//    }
//
//    public void updateWebhook(Long id, Webhook hook){
//        Optional<Webhook> webhook = webhookRepo.findById(id);
//        if(webhook.isPresent()){
//            Webhook wh = webhook.get();
//            if(hook.getEventType().equalIgnoreCase(wh.getEventType())){
//                if(isWebhookAlreadyExists(hook.getEventType())){
//                    throw new DuplicateWebhookException("messagw");
//                }
//            }
//            wh.setEventType(hook.getEventType()?hook.getEventType():wh.getEventtype());
//            Map<String, String> newMetaData = hook.getMetadata();
//            wh.setIsDeleted("N");
//            if(newMetaData != null){
//                wh.setMetaData(newMetaData);
//            }
//            webhookrepo.save(wh);
//        }
//        else{
//            throw new WebhookNotFoundException("message");
//        }
//    }
//
//}
