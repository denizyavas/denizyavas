package com.deniz.app.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.stereotype.Controller
import org.springframework.web.servlet.ModelAndView
import org.springframework.ui.Model

/**
 * author: TRYavasU
 * date: 21/12/2014
 */
@Controller
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
    String greet() {
        "greetings from denizyavas.com"
    }
    
    @RequestMapping("/excel")
    ModelAndView excel() {
        new ModelAndView("redirect:https://docs.google.com/spreadsheets/d/1IznjA3KgnmO7mz1rJe6SJzgGRJuKdbn6AJbeYgZ-Ht8/edit#gid=0")
    } 
    
    @RequestMapping("/odev")
    ModelAndView odev() {
        new ModelAndView("redirect:https://docs.google.com/presentation/d/1SLXbyKN62ngkB0DAJLWdrE8ZNzVlcjWCa1kC7JL_Q1g/edit#slide=id.p")
    } 
    
    @RequestMapping("/")
    ModelAndView index() {
        new ModelAndView("redirect:https://docs.google.com/document/d/12E5PP1uZXriz5snedKMrdc1IrRqNtVMwVm2x-mpjhNg/edit")
    } 
    
    @RequestMapping("/company")
    String company(Model model) {
        "company-home"
    } 

    @RequestMapping("/info")
    String info() {
        "denizyavas.com"
    } 
    
    @RequestMapping("/profile/{profile}")
    ModelAndView profile(@PathVariable("profile") String profile) {
        if (profile == "facebook") {
            new ModelAndView("redirect:${facebookUrl}")
        } else if (profile == "twitter") {
            new ModelAndView("redirect:${twitterUrl}")
        } else if (profile == "linkedin") {
            new ModelAndView("redirect:${linkedinUrl}")
            http://goo.gl/CsFh4Rhttp://goo.gl/CsFh4R        
        } else if (profile == "cv") {
            new ModelAndView("redirect:${cvUrl}")
        } else {
            new ModelAndView("/")
        }
    }
}
