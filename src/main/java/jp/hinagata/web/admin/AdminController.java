package jp.hinagata.web.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/login")
    public String home(){
        return "Hello :: This is admin home";
    }

    @RequestMapping("/execute/twitter/stream")
    public String executeTwitterStream() throws Exception {
        return "Twitter Batch Executed.";
    }

}
