package com.hadassah.demo;

import com.hadassah.demo.beans.MySession;
import com.hadassah.demo.repo.GitHubUserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

@SpringBootApplication
public class Application {

    @Autowired
    public GitHubUserDB gitDB;

    @Resource(name = "sessionBean")
    private MySession session;

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public MySession sessionBean()
    {
        return new MySession();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
