package com.project.LawAndOrder.controllers;

import com.project.LawAndOrder.entities.Case;
import com.project.LawAndOrder.entities.Court;
import com.project.LawAndOrder.repositories.CaseRepository;
import com.project.LawAndOrder.repositories.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 This is a court controller page.
 This page will be used to make CRUD operations on Courts.
 */

 @Controller
public class CourtController {
     @Autowired
     CourtRepository courtRepository;

     @GetMapping({"/courts"})
     public ModelAndView getCourtPage() {
         List<Court> courtList = courtRepository.findAll();
         ModelAndView mav = new ModelAndView("courts");
         mav.addObject(courtList);
         return mav;
     }



}
