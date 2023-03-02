package com.nrahul32.controllerDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * localhost:8080/demo1
 *
 */
@Controller
@RequestMapping("demo1")
public class DemoController {

    /**
     * localhost:8080/demo1/hello
     * GET
     */
    @GetMapping("/hello")
    public @ResponseBody String sayHello(){
        return "hello World! - from demo controller";
    }
}
