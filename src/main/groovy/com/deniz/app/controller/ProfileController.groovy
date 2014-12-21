package com.deniz.app.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

/**
 * author: TRYavasU
 * date: 21/12/2014
 */
@RestController
class ProfileController {

    @RequestMapping("/")
    ModelAndView index() {
        new ModelAndView("redirect:http://goo.gl/CsFh4R");
    }

    @RequestMapping("/profile/{profile}")
    ModelAndView profile(@PathVariable("profile") String profile) {
        if(profile){
            new ModelAndView("redirect:https://www.facebook.com/denizyavas");
        }else{
            new ModelAndView("redirect:http://goo.gl/CsFh4R");
        }
    }
}
