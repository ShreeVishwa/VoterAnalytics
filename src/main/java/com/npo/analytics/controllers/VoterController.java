package com.npo.analytics.controllers;

import com.npo.analytics.command.VoterCommand;
import com.npo.analytics.service.VoterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VoterController {

    private final VoterService voterService;

    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    @RequestMapping({"/voter/new"})
    public String getIndex(Model model) {
        System.out.println("Voter controller called");
        model.addAttribute("voter", new VoterCommand());
        return "voters";
    }

    @PostMapping
    @RequestMapping("voter")
    public String getVoterData(@ModelAttribute VoterCommand cmd) {
        VoterCommand savedCommand = voterService.saveVoter(cmd);
        return "success";
    }
}
