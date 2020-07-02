package com.hadassah.demo.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Error controller to handle error pages and error actions.
 */
@Controller
public class Error implements ErrorController {

    /**
     * function that handle error and send it to error page.
     * @return String error page
     */
    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }

    /**
     * function that handle error and send it to error page.
     * @return String path to function that handle error.
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
