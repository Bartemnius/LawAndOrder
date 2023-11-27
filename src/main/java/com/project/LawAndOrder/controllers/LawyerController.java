package com.project.LawAndOrder.controllers;

import com.project.LawAndOrder.entities.Lawyer;
import com.project.LawAndOrder.repositories.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 This is a lawyer controller page.
 This page will be used to make CRUD operations on Lawyers.
 */

 @Controller
public class LawyerController {
     @Autowired
     LawyerRepository lawyerRepository;

     @GetMapping({"/lawyers"})
     public ModelAndView getMainPage() {
         List<Lawyer> lawyerList = lawyerRepository.findAll();
         ModelAndView mav = new ModelAndView("lawyers");
         mav.addObject(lawyerList);
         return mav;
     }

     @GetMapping("addLawyer")
    public ModelAndView getAddLawyerPage() {
         ModelAndView mav = new ModelAndView("addLawyer");
         Lawyer newLawyer = new Lawyer();
         mav.addObject("newLawyer", newLawyer);
         return mav;
     }

     @PostMapping("/addLawyer")
    public String saveLawyer(@ModelAttribute Lawyer newLawyer) {
         lawyerRepository.save(newLawyer);
         return "redirect:/lawyers";
     }
}
