package com.itheima.controllor;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")

public class UserControllor {
    @RequestMapping("/sayHello")
    public String sayHello(String name){
        System.out.println("aaa");
        //int i = 1/0;
        return "success";
    }
    @RequestMapping("/getParam")
    public String getParam(User user,Model model){
        System.out.println(user);
        model.addAttribute("user",user);
        return "success";
    }
    @RequestMapping("/getModelAndView")
    public ModelAndView getModelAndView(User user){
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }
    @RequestMapping("/getRedirect")
    public String getRedirect(User user,Model model){
        System.out.println(user);
        model.addAttribute("user",user);
        
        return "redirect:/user/getModelAndView";
    }

}
