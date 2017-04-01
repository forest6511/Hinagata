package jp.hinagata.web.admin;

import jp.hinagata.batch.TwitterStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    TwitterStream twitterStream;

    @RequestMapping("/login")
    public String home(){
        return "Hello :: This is admin home";
    }

    @RequestMapping("/execute/twitter/stream")
    public String executeTwitterStream() throws Exception {
        twitterStream.run();
        return "Twitter Batch Executed.";
    }

}
