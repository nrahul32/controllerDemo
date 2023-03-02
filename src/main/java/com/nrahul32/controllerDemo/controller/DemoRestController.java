package com.nrahul32.controllerDemo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * localhost:8080/demo
 *
 */
@RestController
@RequestMapping("demo2")
public class DemoRestController {

    /**
     * localhost:8080/demo/hello
     * GET
     *
     * @ResponseBody is not needed since this uses @RestController
     */
    @GetMapping("/hello")
    public String sayHello(){
        return "hello World! - from demo rest controller";
    }
}
