package vantoan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vantoan.model.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User setUserForm(){
      return new User();
    }
    @GetMapping("")
    public ModelAndView showFormLogin(){
        return new ModelAndView("login");
    }
    @PostMapping()
    public ModelAndView login(@ModelAttribute("user") User user){
        ModelAndView modelAndView=new ModelAndView("login");
        if (user.getEmail().equals("admin@gmail.com")&&user.getPassword().equals("123456")||(user.getEmail().equals("toan@gmail.com")&&user.getPassword().equals("123456"))){
            modelAndView.addObject("message", "Login success. Welcome ");
        }else {
            user.setEmail("");
            modelAndView.addObject("message", "Login failed. Try again. ");
        }
        return modelAndView;
    }
}
