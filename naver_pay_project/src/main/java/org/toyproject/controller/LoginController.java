package org.toyproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.toyproject.DB.CookieMgr;
import org.toyproject.DB.SessionMgr;

@Controller
public class LoginController {
    private SessionMgr sessionMgr; // = SessionMgr.getInstance();
    private CookieMgr cookieMgr; // = CookieMgr.getInstance();


    @Autowired
    public LoginController(SessionMgr sessionMgr, CookieMgr cookieMgr, MemberService memberService) {
        this.sessionMgr = sessionMgr;
        this.cookieMgr = cookieMgr;
        this.userService = memberService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(){
        return "Login";
    }
}
