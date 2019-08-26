package cn.ypf88.springcloud.config.client.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${config.env}")
    private String env;

    @GetMapping("/profile")
    public String getEnv() {
        return this.env;
    }
}
