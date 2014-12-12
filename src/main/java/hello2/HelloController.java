package hello2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: TRYavasU
 * date: 12/12/2014
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings dear visitor!";
    }

}