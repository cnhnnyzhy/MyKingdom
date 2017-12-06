package io.imking.admin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Desc: 登陆相关的入口
 *
 * @date: 09/11/2017
 * @author: gaul
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "/admin/login";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        return "/admin/index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/index")
    public String index() {
        return "/admin/index";
    }
}
