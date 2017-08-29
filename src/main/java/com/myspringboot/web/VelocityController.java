package com.myspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/velocity")
public class VelocityController {
    
    @RequestMapping("/test")
    public String velocityTest(String keyword, ModelMap map){
        map.addAttribute("name", "小明");
        map.addAttribute("age", "15");
        return "velocity_test";
    }
}
