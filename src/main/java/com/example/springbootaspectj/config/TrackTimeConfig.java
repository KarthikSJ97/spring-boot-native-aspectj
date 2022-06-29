package com.example.springbootaspectj.config;

import com.example.springbootaspectj.service.impl.TrackTimeServiceImpl;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TrackTimeConfig {

    @Bean
    public TrackTimeServiceImpl trackTimeAspect() {
        return Aspects.aspectOf(TrackTimeServiceImpl.class);
    }

}