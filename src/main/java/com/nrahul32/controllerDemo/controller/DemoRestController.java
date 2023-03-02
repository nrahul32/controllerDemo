package com.nrahul32.controllerDemo.controller;

import org.springframework.web.bind.annotation.*;

/**
 * localhost:8080/demo2
 * localhost:8080/demo3
 */
@RestController
@RequestMapping(value = {"demo2", "demo3"})
public class DemoRestController {

    /**
     * localhost:8080/demo2/hello
     * localhost:8080/demo2/greet
     * localhost:8080/demo3/hello
     * localhost:8080/demo3/greet
     *
     * GET
     *
     * @ResponseBody is not needed since this uses @RestController
     */
    @GetMapping(value = {"/hello", "/greet"})
    public String sayHello(){
        return "hello World! - from demo rest controller";
    }
}
