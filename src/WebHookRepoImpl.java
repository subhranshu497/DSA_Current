//import java.util.List;
//
//@Repository
//@Transactional(readOnly = true)
//public class WebHookRepoImpl implements WebHookRepositoryCustom{
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Override
//    public List<WebHook> getAllWebHook(){
//        Query q = entityManager.cerateQuery(WebhookConstant.FIND_ALL_WEBHOOK, WebHook.class);
//        return q.getResultList();
//    }
//    @Override
//    public List<Webhook> getAllActiveWebhook(){
//        Query q = entityManager.cerateQuery(WebhookConstant.FIND_ALL_ACTIVE_WEBHOOK, WebHook.class);
//        return q.getResultList();
//    }
//    @Override
//    public List<WebHook> fetchLatestWebHookDetails(String Date){
//        Query q = entityManager.cerateNativeQuery(WebhookConstant.WH_REF_QUERY, WebHook.class);
//        q.setParameter(1, date);
//        q.setParameter(2,date);
//        return q.getResultList();
//    }
//}
