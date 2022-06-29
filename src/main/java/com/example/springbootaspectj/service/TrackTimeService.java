package com.example.springbootaspectj.service;

import org.aspectj.lang.ProceedingJoinPoint;

public interface TrackTimeService {

    void audit(ProceedingJoinPoint joinPoint) throws Throwable;
}
