package com.example.springbootaspectj.controller;

import com.example.springbootaspectj.service.InterceptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/intercept")
public class InterceptController {

    @Autowired
    private InterceptService interceptService;

    @GetMapping
    public void interceptNestedMethod() throws InterruptedException {
        interceptService.interceptNestedMethod();
    }
}
