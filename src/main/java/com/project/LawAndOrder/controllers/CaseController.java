package com.project.LawAndOrder.controllers;

import com.project.LawAndOrder.entities.Case;
import com.project.LawAndOrder.repositories.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
This is main page controller.
This page will be default/homepage for this app.
*/
 @Controller
public class CaseController {
     @Autowired
     CaseRepository caseRepository;

     @GetMapping({"/", "/home"})
     public ModelAndView getMainPage() {
         List<Case> caseList = caseRepository.findAll();
         ModelAndView mav = new ModelAndView("home");
         mav.addObject(caseList);
         return mav;
     }



}
