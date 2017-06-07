package cabanas.garcia.ismael.configclient.framework.controller;

import cabanas.garcia.ismael.configclient.framework.service.HotMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ismaelcabanas on 6/6/17.
 */
@RestController
public class HomeController {

    private static final String template = "Hello, %s!";

    @Value("${message:World}")
    private String name;

    @Autowired
    private HotMessage hotMessage;

    @RequestMapping("/")
    public String home() {
        return String.format(template, name);
    }

    @RequestMapping(value = "/hot")
    public String hot(){
        return String.format(template, hotMessage.message());
    }
}
