package com.example.springHomework.controller;

import com.example.springHomework.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@RestController=@Controller+@ResponseBody
@CrossOrigin //解决跨域问题
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        // identity只有student和professor两个值
        String identity = request.getParameter("role");
        if(identity.equals("student")) {
            return loginService.stuLogin(request);
        }else{
            return loginService.profLogin(request);
        }
    }
}
