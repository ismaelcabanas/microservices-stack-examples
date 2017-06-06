package cabanas.garcia.ismael.configclient.framework.controller;

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

    @RequestMapping("/")
    public String home() {
        return String.format(template, name);
    }
}
