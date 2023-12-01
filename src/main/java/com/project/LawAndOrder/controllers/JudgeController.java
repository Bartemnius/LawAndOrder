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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 This is a judge controller page.
 This page will be used to make CRUD operations on Judges.
 */

 @Controller
public class JudgeController {
     @Autowired
     JudgeRepository judgeRepository;
     @Autowired
     CaseRepository caseRepository;

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

    @GetMapping("/deleteJudge")
    public String deleteJudge(@RequestParam Long judgeId) {
        Optional<Judge> judge = judgeRepository.findById(judgeId);
        List<Case> cases = caseRepository.findAll();
        cases.forEach(aCase -> {
            if(aCase.getJudge() == judge.get()) aCase.setJudge(null);
        });
        judgeRepository.deleteById(judgeId);
        return "redirect:/judges";
    }

    @GetMapping("/updateJudge")
    public ModelAndView updateJudge(@RequestParam Long judgeId) {
        Judge newJudge = judgeRepository.findById(judgeId).get();
        ModelAndView mav = new ModelAndView("addJudge");
        mav.addObject("newJudge", newJudge);
        return mav;
    }
}
