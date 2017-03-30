package jp.hinagata.web.api;

import jp.hinagata.model.rest.SessionSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/api/sample/session")
public class SessionSampleController {

    private static final Logger logger = LoggerFactory.getLogger(SessionSampleController.class);

    private final static String HTTP_SESSION_ATTR_NAME_SAMPLE = "SESSION_SAMPLE";


    @GetMapping("/get")
    public ResponseEntity<SessionSample> getSession(HttpSession session) {
        SessionSample sessionSample = (SessionSample) session.getAttribute(HTTP_SESSION_ATTR_NAME_SAMPLE);
        return sessionSample == null ? createSession(session) : ResponseEntity.ok().body(sessionSample);
    }

    @GetMapping("/invalidate")
    public ResponseEntity<?> invalidateSession(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().build();
    }

    private ResponseEntity<SessionSample> createSession(HttpSession session) {
        logger.info("Create session object.");
        SessionSample sessionSample = new SessionSample();
        sessionSample.setUuid(UUID.randomUUID().toString());
        session.setAttribute(HTTP_SESSION_ATTR_NAME_SAMPLE, sessionSample);
        return ResponseEntity.ok().body(sessionSample);
    }

}
