package com.example.cisc3140;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Controller
@RequestMapping("/student")
public class IndexController {

    @Autowired
    EntityManager entityManager;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Student> index(){
        Query query =entityManager.createNativeQuery("select * from student",Student.class);
        return query.getResultList();
    }


    @RequestMapping("/index")
    public ModelAndView toIndex(){
        ModelAndView modelAndView=new ModelAndView("index");
        Query query =entityManager.createNativeQuery("select * from student",Student.class);
        modelAndView.addObject("students",query.getResultList());
        return modelAndView;
    }


}
