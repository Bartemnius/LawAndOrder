package com.project.LawAndOrder.controllers;

import com.project.LawAndOrder.entities.Case;
import com.project.LawAndOrder.entities.Judge;
import com.project.LawAndOrder.repositories.CaseRepository;
import com.project.LawAndOrder.repositories.JudgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 This is a judge controller page.
 This page will be used to make CRUD operations on Judges.
 */

 @Controller
public class JudgeController {
     @Autowired
     JudgeRepository judgeRepository;

     @GetMapping({"/judges"})
     public ModelAndView getMainPage() {
         List<Judge> judgeList = judgeRepository.findAll();
         ModelAndView mav = new ModelAndView("judges");
         mav.addObject(judgeList);
         return mav;
     }

     @GetMapping("/addJudge")
    public ModelAndView getAddJudgePage() {
         ModelAndView mav = new ModelAndView("addJudge");
         Judge newJudge = new Judge();
         mav.addObject("newJudge", newJudge);
         return mav;
     }

     @PostMapping("/addJudge")
    public String addJudge(@ModelAttribute Judge newJudge) {
         judgeRepository.save(newJudge);
         return "redirect:/judges";
     }



}
