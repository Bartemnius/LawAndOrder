package com.project.LawAndOrder.controllers;

import com.project.LawAndOrder.entities.Case;
import com.project.LawAndOrder.entities.Client;
import com.project.LawAndOrder.repositories.CaseRepository;
import com.project.LawAndOrder.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * This is a client controller page.
 * This page will be used to make CRUD operations on Clients.
 */
@Controller
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping({"/clients"})
    public ModelAndView getClientPage() {
        List<Client> clientList = clientRepository.findAll();
        ModelAndView mav = new ModelAndView("clients");
        mav.addObject(clientList);
        return mav;
    }

    @GetMapping("addClient")
    public ModelAndView addClientPage() {
        ModelAndView mav = new ModelAndView("addClient");
        Client newClient = new Client();
        mav.addObject("newClient", newClient);
        return mav;
    }

    @PostMapping("addClient")
    public String saveClient(@ModelAttribute Client newClient) {
        clientRepository.save(newClient);
        return "redirect:/clients";
    }
}
