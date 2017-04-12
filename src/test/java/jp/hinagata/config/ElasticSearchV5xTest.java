package jp.hinagata.config;

import jp.hinagata.BaseTest;
import jp.hinagata.model.rest.ElasticSearchInfoDO;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ElasticSearchV5xTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchV5xTest.class);

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void shouldGetElasticSearchVersion() {
        String elasticSearchServerUrl = "http://localhost:9200";
        ResponseEntity<ElasticSearchInfoDO> response
                = restTemplate.getForEntity(elasticSearchServerUrl, ElasticSearchInfoDO.class);

        ElasticSearchInfoDO dto = response.getBody();
        assertThat("elasticsearch", is(dto.getClusterName()));
        assertThat("5.2.2", is(dto.getVersion().getVersionNumber()));
    }
}
