package jp.hinagata.config;

import jp.hinagata.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HinagataConfigTest extends BaseTest {

    @Autowired
    private HinagataConfig hinagataConfig;

    @Test
    public void shouldGetTwitterProperties() {
        assertThat("You should export TWITTER_CONSUMER_KEY", is(hinagataConfig.getTwitter4j().consumerKey));
        assertThat("You should export TWITTER_CONSUMER_SECRET", is(hinagataConfig.getTwitter4j().consumerSecret));
        assertThat("You should export TWITTER_ACCESS_TOKEN", is(hinagataConfig.getTwitter4j().accessToken));
        assertThat("You should export TWITTER_ACCESS_TOKEN_SECRET", is(hinagataConfig.getTwitter4j().accessTokenSecret));
    }

}
