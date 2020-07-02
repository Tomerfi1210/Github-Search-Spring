package com.hadassah.demo.controllers;

import com.hadassah.demo.beans.MySession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


/**
 * Controller that handle logout from the server.
 */
@Controller
public class Logout {

    @Resource(name = "sessionBean")
    private MySession session;

    /**
     * log out user(and delete session)
     * @return login page.
     */
    @RequestMapping("/logout")
    public String main_logout()
    {
        if(session.isSession()) {
            session.setSession(false);
        }
        return "redirect:/";
    }
}
