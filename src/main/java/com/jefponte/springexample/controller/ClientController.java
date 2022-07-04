package com.jefponte.springexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jefponte.springexample.model.Client;
import com.jefponte.springexample.repository.ClientRepository;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ModelAndView list() {
        List<Client> clients = clientRepository.findAll();
        ModelAndView modelAndView =new ModelAndView("client/list.html");
        modelAndView.addObject("clients", clients);
        return modelAndView;
    }

}
