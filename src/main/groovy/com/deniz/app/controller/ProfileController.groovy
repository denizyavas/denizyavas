package com.deniz.app.controller

import org.springframework.beans.factory.annotation.Value
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

    @Value('${profile.url.facebook}')
    def facebookUrl

    @Value('${profile.url.cv}')
    def cvUrl

    @Value('${profile.url.twitter}')
    def twitterUrl

    @Value('${profile.url.linkedin}')
    def linkedinUrl

    @RequestMapping("/greet")
    String index() {
        "greetings from denizyavas.com"
    }
    
    @RequestMapping("/")
    ModelAndView excel() {
        new ModelAndView("redirect:https://docs.google.com/spreadsheets/d/1IznjA3KgnmO7mz1rJe6SJzgGRJuKdbn6AJbeYgZ-Ht8/edit#gid=0")
    } 

    @RequestMapping("/profile/{profile}")
    ModelAndView profile(@PathVariable("profile") String profile) {
        if (profile == "facebook") {
            new ModelAndView("redirect:${facebookUrl}")
        } else if (profile == "twitter") {
            new ModelAndView("redirect:${twitterUrl}")
        } else if (profile == "linkedin") {
            new ModelAndView("redirect:${linkedinUrl}")
            http://goo.gl/CsFh4Rhttp://goo.gl/CsFh4R        } else if (profile == "cv") {
            new ModelAndView("redirect:${cvUrl}")
        } else {
            new ModelAndView("/")
        }
    }
}
