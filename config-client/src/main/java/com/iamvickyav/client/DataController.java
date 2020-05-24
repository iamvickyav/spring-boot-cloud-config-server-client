package com.iamvickyav.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DataController {

    @Value("${user.username}")
    String name;

    @Value("${user.password}")
    String password;

    @Autowired
    AdminConfig adminConfig;

    @GetMapping(value = "/admin")
    public AdminData getAdminData() {
        return new AdminData(adminConfig.getUsername(), adminConfig.getPassword());
    }

    @GetMapping(value = "/user")
    public UserConfigData getUserData() {
        return new UserConfigData(name, password);
    }
}
