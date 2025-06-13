package com.my.awsapp.controller

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping



@Controller
class CustomErrorController : ErrorController {

    @RequestMapping("/error")
    fun error(): String {
        return "index.html"
    }

    fun getErrorPath(): String {
        return "/error"
    }

}