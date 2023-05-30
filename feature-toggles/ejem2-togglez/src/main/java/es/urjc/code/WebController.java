package es.urjc.code;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class WebController {
    
    @GetMapping
    public String getHome() {
        return "{'message' = 'Home'}";
    }

}
