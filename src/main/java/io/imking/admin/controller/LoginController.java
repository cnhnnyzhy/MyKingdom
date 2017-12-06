package io.imking.admin.controller;

<<<<<<< HEAD
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
=======
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
>>>>>>> 2bc437572f115ada5298529313654f94f24d35f3
import org.springframework.web.bind.annotation.RequestMapping;

import io.imking.core.domain.Result;
import io.imking.core.domain.ResultEnum;

/**
 * Desc: 登陆相关的入口
 *
 * @date: 09/11/2017
 * @author: gaul
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
	@RequestMapping("/login")
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
    
    @RequestMapping("/loginSuccess")
	public Result<Authentication> loginSuccess(){
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication() ;
		 
		 return new Result<>(ResultEnum.SUCCESS , authentication) ;
	}
}
