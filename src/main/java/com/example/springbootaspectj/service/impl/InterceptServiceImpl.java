package com.example.springbootaspectj.service.impl;

import com.example.springbootaspectj.service.InterceptService;
import com.example.springbootaspectj.utility.TrackTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InterceptServiceImpl implements InterceptService {

    @Override
    @TrackTime
    public void interceptNestedMethod() throws InterruptedException {
        log.info("Inside interceptNestedMethod()");
        Thread.sleep(2000);
        nestedMethod();
        privateMethod();
    }

    @TrackTime
    public void nestedMethod() throws InterruptedException {
        log.info("Inside nestedMethod()");
        Thread.sleep(3000);
    }

    @TrackTime
    private void privateMethod() throws InterruptedException {
        log.info("Inside privateMethod()");
        Thread.sleep(1000);
    }

}
