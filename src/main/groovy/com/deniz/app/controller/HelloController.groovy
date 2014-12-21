package com.deniz.app.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

/**
 * author: TRYavasU
 * date: 21/12/2014
 */
@RestController
class HelloController {

    @RequestMapping("/")
    ModelAndView index() {
        new ModelAndView("redirect:http://goo.gl/CsFh4R");
    }
}
