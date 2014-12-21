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
    String index() {
        "Greetings from denizyavas.com"
    }

    @RequestMapping("/google")
    String google() {
        "redirect:http://www.google.com"
    }

    @RequestMapping("/redirect")
    ModelAndView method() {
        new ModelAndView("redirect:http://www.google.com");

    }
}
