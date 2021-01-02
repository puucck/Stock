package com.example.Stock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class Homepage implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        try{            Runtime.getRuntime().exec("cmd /c   start  http://localhost:8080/index.html");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
//@Configuration
//public class Homepage implements WebMvcConfigurer {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//    }
//}
