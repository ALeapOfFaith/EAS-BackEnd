package com.example.springHomework.controller;

import com.example.springHomework.service.RegisterService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        String identity = request.getParameter("role");
        if(identity.equals("student")) {
            return registerService.stuRegister(request);
        }else{
            return registerService.profRegister(request);
        }
    }
}
