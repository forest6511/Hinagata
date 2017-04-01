package jp.hinagata.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "hinagata", ignoreUnknownFields = false)
public class HinagataConfig {

    private final Twitter4j twitter4j = new Twitter4j();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Twitter4j{
        public String consumerKey;
        public String consumerSecret;
        public String accessToken;
        public String accessTokenSecret;
    }


}
