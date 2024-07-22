package com.study.ssr.controller;

import com.study.ssr.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NameController {

    @GetMapping("/name")
    public ModelAndView namePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/name");
        mav.addObject(Student.builder().name("김해민").age(22).build());
        return mav;
    }
}
