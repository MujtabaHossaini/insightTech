package com.mujtaba.poc.config;

import com.mujtaba.poc.controller.HomeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com")
public class WebMvcConfig {

    @Bean
    public HomeController homeController()
    {
        return new HomeController();
    }

}
