package com.myweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Liu on 2017-04-26.
 */
@Controller
@RequestMapping("/home")
public class testController {
    private static final Logger logger = LoggerFactory.getLogger(testController.class);

    public static void main(String[] args) {
        logger.warn("RunTimeExceptio: {}", "ClassNotFoundException");
        logger.error("RunTimeException: {}", "NullPointerException");
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("index...");
        return "index";
    }
}
