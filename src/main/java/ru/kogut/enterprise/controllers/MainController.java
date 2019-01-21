package ru.kogut.enterprise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kogut.enterprise.models.User;
import ru.kogut.enterprise.repository.UserRepository;
import ru.kogut.enterprise.services.UserService;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model, Principal principal){
        User user = userService.findByLogin(principal.getName());
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("login",user.getLogin());
        model.addAttribute("isActive", user.isActive());
        model.addAttribute("isAdmin", user.isAdmin());
        if (user.isAdmin()){
            model.addAttribute("users", userService.findAllUsers());
        }
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal){
        User user = userService.findByLogin(principal.getName());
        model.addAttribute("login", user.getLogin());
        model.addAttribute("userName", user.getUserName());
        return "profile";
    }

    @PostMapping("/saveProfile")
    public String saveProfile(@RequestParam(value = "login") String login,
                              @RequestParam(value = "userName") String userName,
                              @RequestParam(value = "oldPassword") String oldPassword,
                              @RequestParam(value = "newPassword") String newPassword,
                              @RequestParam(value = "rePassword") String rePassword){


        return "profile";
    }

}
