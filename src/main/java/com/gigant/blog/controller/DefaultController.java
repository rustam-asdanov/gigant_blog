package com.gigant.blog.controller;

import com.gigant.blog.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;


@Slf4j
@Controller
@SessionAttributes("user")
public class DefaultController {

    private String folder = "help/";

    @ModelAttribute(name = "user")
    public Account getAccount(){
        return new Account();
    }

    @GetMapping
    public String getPage() {
        return folder + "welcome";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return folder + "login";
    }

    @GetMapping("/signup")
    public String getSignUpPage() {
        return folder + "signup";
    }

    @GetMapping("/building")
    public String getBuildingPage() {
        return folder + "building";
    }

    @GetMapping("/perform-logout")
    public String logout(
            @SessionAttribute("user") Account account,
            SessionStatus sessionStatus
    ){
        log.info("current user {}",account);
        sessionStatus.setComplete();
        return "redirect:/logout";
    }
}
