package jp.hinagata.web.doc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DocumentController {

    //TODO need to implement access control or only dev profile.
    @RequestMapping("/docs")
    public String getSwaggerUI() {
        return "redirect:swagger-ui.html";
    }
}
