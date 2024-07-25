//import javax.sql.DataSource;
//
//@Configuration
//public class WebhookDBConfiguration {
//    @Value("${webhook.db.password}")
//    privateString password;
//
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix="webhook.datasource")
//    public DataSource dataSource(AESUtility aesUtility){
//        return DataSourceBuilder.create().password(password).build();
//    }
//}
