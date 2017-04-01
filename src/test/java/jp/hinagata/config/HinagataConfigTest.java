package jp.hinagata.config;

import jp.hinagata.ApplicationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
@ActiveProfiles("test")
public class HinagataConfigTest {

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
