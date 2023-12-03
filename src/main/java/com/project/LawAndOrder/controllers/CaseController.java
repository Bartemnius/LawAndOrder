package com.project.LawAndOrder.controllers;

import com.project.LawAndOrder.entities.*;
import com.project.LawAndOrder.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * This is main page controller.
 * This page will be default/homepage for this app.
 */
@Controller
public class CaseController {
    @Autowired
    CaseRepository caseRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CourtRepository courtRepository;
    @Autowired
    JudgeRepository judgeRepository;
    @Autowired
    LawyerRepository lawyerRepository;

    @GetMapping({"/", "/home", "cases"})
    public ModelAndView getMainPage() {
        List<Case> caseList = caseRepository.findAll();
        ModelAndView mav = new ModelAndView("home");
        mav.addObject(caseList);
        return mav;
    }

    @GetMapping("/addCase")
    public ModelAndView getAddCasePage() {
        ModelAndView mav = new ModelAndView("addCase");

        Case newCase = new Case();
        mav.addObject("newCase", newCase);

        List<Client> clients = clientRepository.findAll();
        List<Court> courts = courtRepository.findAll();
        List<Judge> judges = judgeRepository.findAll();
        List<Lawyer> lawyers = lawyerRepository.findAll();

        mav.addObject("clients", clients);
        mav.addObject("courts", courts);
        mav.addObject("judges", judges);
        mav.addObject("lawyers", lawyers);
        return mav;
    }

    @PostMapping("/addCase")
    public String saveCase(@ModelAttribute Case newCase) {
        caseRepository.save(newCase);
        return "redirect:/cases";
    }

    @GetMapping("/deleteCase")
    public String deleteClient(@RequestParam Long caseId) {
        caseRepository.deleteById(caseId);
        return "redirect:/cases";
    }

    @GetMapping("/updateCase")
    public ModelAndView updateCase(@RequestParam Long caseId) {
        Case newCase = caseRepository.findById(caseId).get();
        ModelAndView mav = new ModelAndView("addCase");
        mav.addObject("newCase", newCase);

        List<Client> clients = clientRepository.findAll();
        List<Court> courts = courtRepository.findAll();
        List<Judge> judges = judgeRepository.findAll();
        List<Lawyer> lawyers = lawyerRepository.findAll();

        mav.addObject("clients", clients);
        mav.addObject("courts", courts);
        mav.addObject("judges", judges);
        mav.addObject("lawyers", lawyers);

        return mav;
    }
}
