package jp.hinagata.web.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jp.hinagata.BaseTest;
import jp.hinagata.model.rest.SessionSample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class SessionSampleControllerTest extends BaseTest {

    private MockMvc mockMvc;
    private MockHttpSession session;

    /*
     * TODO
     * Im not sure that those session tests make sense??
     */

    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new SessionSampleController()).build();
        session = new MockHttpSession();
    }

    @Test
    public void shouldGetSession() throws Exception {
        String getUrl = "/api/sample/session/get";
        MvcResult mvcResult = mockMvc
                .perform(get(getUrl).session(session))
                .andExpect(status().isOk()).andReturn();

        String uuid1 = getUUID(mvcResult);
        log.info("First time UUID =[{}]", uuid1);

        mvcResult = mockMvc
                .perform(get(getUrl).session(session))
                .andExpect(status().isOk()).andReturn();

        String uuid2 = getUUID(mvcResult);
        log.info("Second time UUID =[{}]", uuid2);
        assertThat(uuid1, is(uuid2));
    }

    @Test
    public void shouldInvalidateSession() throws Exception {
        String getUrl = "/api/sample/session/get";
        String invalidateUrl = "/api/sample/session/invalidate";
        MvcResult mvcResult = mockMvc
                .perform(get(getUrl).session(session))
                .andExpect(status().isOk()).andReturn();

        String uuid3 = getUUID(mvcResult);
        log.info("Third time UUID =[{}]", uuid3);

        mockMvc.perform(get(invalidateUrl).session(session));

        mvcResult = mockMvc
                .perform(get(getUrl).session(session))
                .andExpect(status().isOk()).andReturn();

        String uuid4 = getUUID(mvcResult);
        log.info("Fourth time UUID =[{}]", uuid4);
        assertThat(uuid3, not(uuid4));
    }


    private String getUUID(MvcResult mvcResult) throws IOException {
        String json = mvcResult.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        SessionSample sessionSample = mapper.readValue(json, SessionSample.class);
        return sessionSample.getUuid();
    }
}



