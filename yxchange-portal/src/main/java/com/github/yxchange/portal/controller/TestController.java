package com.github.yxchange.portal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("test")
public class TestController {

    @RequestMapping(value="exception", method=RequestMethod.GET)
    public Object exception(){
        throw new RuntimeException("test exception");
    }
}
