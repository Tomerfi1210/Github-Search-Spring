package com.hadassah.demo.controllers;

import com.hadassah.demo.beans.MySession;
import com.hadassah.demo.utils.JSONResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Rest controller that behave like listener to JS.
 * this RestController checking for validation if user can enter.
 */
@RestController
public class Authenticate {

    @Resource(name = "sessionBean")
    private MySession session;

    @Value("${spring.security.user.name}")
    private String security_username;
    @Value("${spring.security.user.password}")
    private String security_password;

    /**
     * function that send a response in JSON format to JS fetch.
     * @param requestParams Map<String, String> of two  parameters username and password to check
     * for validation.
     * @return JSONResponse object.
     */
    @ResponseBody
    @RequestMapping("/authenticate")
    public JSONResponse authenticate(@RequestBody Map<String, String> requestParams) {

        String username = requestParams.get("username");
        String password = requestParams.get("password");
        if (username.equals(security_username) && (password.equals(security_password))) {
            session.setSession(true);
            return new JSONResponse(200, "success");
        }
        return new JSONResponse(404, "session timeout");
    }
}
