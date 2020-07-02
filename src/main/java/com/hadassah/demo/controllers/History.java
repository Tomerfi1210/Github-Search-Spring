package com.hadassah.demo.controllers;

import com.hadassah.demo.beans.MySession;
import com.hadassah.demo.repo.GitHubUser;
import com.hadassah.demo.repo.GitHubUserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller class History that handle history page.
 */
@Controller
public class History {

    @Autowired
    private GitHubUserDB userDB;

    @Resource(name = "sessionBean")
    private MySession sessios;

    /**
     * function that return the db repo.
     * @return GitHubUserDB object.
     */
    private GitHubUserDB getRepo() {
        return userDB;
    }

    /**
     * function that handle any sort of request to history.
     * @return history page
     */
    @RequestMapping("/history")
    public String main_history(Model model)
    {
        if(!sessios.isSession())
            return "redirect:/";

        model.addAttribute("users",getRepo().findFirst10ByOrderBySearchCounterDesc());
        return "history";
    }

    /**
     * function that delete all the history in the history page.
     * @return history page after deleting history.
     */
    @RequestMapping("/deleteAll")
    public String deleteAll() {
        if(!sessios.isSession()) return "redirect:/";
        getRepo().deleteAll();
        return "redirect:/history";
    }
}
