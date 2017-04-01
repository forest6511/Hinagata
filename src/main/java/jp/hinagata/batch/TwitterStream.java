package jp.hinagata.batch;


import jp.hinagata.config.HinagataConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TwitterStream implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(TwitterStream.class);

    @Autowired
    private HinagataConfig hinagataConfig;

    @Override
    public void run(String... strings) throws Exception {
        logger.debug("Access Token -> [{}]", hinagataConfig.getTwitter4j().accessToken);
        logger.debug("Consumer Key -> [{}]", hinagataConfig.getTwitter4j().consumerKey);
    }
}
