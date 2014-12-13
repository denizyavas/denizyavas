package hello

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * author: TRYavasU
 * date: 12/12/2014
 */
//@RestController
class HelloController {

    @RequestMapping("/")
    String index() {
        "Greetings dear visitor!"
    }

}