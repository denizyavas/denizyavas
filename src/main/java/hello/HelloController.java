package hello;

/**
 * author: TRYavasU
 * date: 20/12/2014
 */

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Hi from denizyavas!";
    }

}