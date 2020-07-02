package com.hadassah.demo.controllers;

import com.hadassah.demo.beans.MySession;
import com.hadassah.demo.repo.GitHubUser;
import com.hadassah.demo.repo.GitHubUserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Controller
public class Search {

    @Resource(name = "sessionBean")
    private MySession session;

    @Autowired
    private GitHubUserDB userRepo;

    private GitHubUserDB getRepo() {
        return userRepo;
    }


    @GetMapping("/search")
    public String main_search(Model model){
        if(!session.isSession())
            return "redirect:/";

        model.addAttribute("error_input", false);
        model.addAttribute("exist", true);
        model.addAttribute("hasUser", false);
        model.addAttribute("isEmpty", false);
        return "search";
    }

    @PostMapping("/search")
    public String post_search(@RequestParam(name="username", required = false, defaultValue = "") String user, Model model) {
        if(!session.isSession())
            return "redirect:/";

        user = user.trim();
        model.addAttribute("isEmpty", false);
        model.addAttribute("exist", true);
        model.addAttribute("hasUser", true);


        try {
            setAtt(user, model);
        } catch (Exception e) {
            if (user.equals(""))
                model.addAttribute("isEmpty", true);
            else
                model.addAttribute("exist", false);
        }
        return "search";
    }


    public void setAtt(String user, Model model) throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        GitHubUser user1 = restTemplate.getForObject("https://api.github.com/users/" + user, GitHubUser.class);
        if (user1 != null) {
            model.addAttribute("username", user);
            if(user1.getFollowers() == 0)
                model.addAttribute("followers", "No followers exists!!");
            else
                model.addAttribute("followers", user1.getFollowers());
            user1.inc_search_counter();
            if(getRepo().existsByLogin(user1.getLogin()))
                getRepo().findByLogin(user1.getLogin()).inc_search_counter();
            else
                getRepo().save(user1);
            model.addAttribute("exist", true);
        }
    }
}
