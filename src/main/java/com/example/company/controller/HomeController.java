package com.example.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
        @RequestMapping(value = "/")
        public String index() {
            return "index.html";
        }
}
