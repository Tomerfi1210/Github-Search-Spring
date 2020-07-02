package com.hadassah.demo.controllers;

import com.hadassah.demo.beans.MySession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class Login {

    @Resource(name = "sessionBean")
    private MySession session;

    @RequestMapping(value = "/")
    public String main_login() {
        if(session.isSession())
            return "redirect:/search";
        return "login";
    }

}
