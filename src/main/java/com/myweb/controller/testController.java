package com.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Liu on 2017-04-26.
 */
@Controller
@RequestMapping("/home")
public class testController {


    @RequestMapping("/index")
    public String index() {
        System.out.println("index...");
        return "index";
    }
}
