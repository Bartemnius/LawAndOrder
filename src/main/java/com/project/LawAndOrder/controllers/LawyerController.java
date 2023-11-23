package com.project.LawAndOrder.controllers;

import com.project.LawAndOrder.entities.Case;
import com.project.LawAndOrder.entities.Lawyer;
import com.project.LawAndOrder.repositories.CaseRepository;
import com.project.LawAndOrder.repositories.LawyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
