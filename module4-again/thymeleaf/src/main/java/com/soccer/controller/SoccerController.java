package com.soccer.controller;

import com.soccer.model.SoccerPlayer;
import com.soccer.service.ISoccerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SoccerController {
    @Autowired
private ISoccerService iSoccerService;
    @GetMapping("/soccer")
    public String showList(Model model) {
        List<SoccerPlayer> soccerPlayers = iSoccerService.findAll();
        model.addAttribute("soccers", soccerPlayers);
        return "/list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("soccer", new SoccerPlayer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(SoccerPlayer soccerPlayers, RedirectAttributes redirectAttributes) {
        iSoccerService.save(soccerPlayers);
        redirectAttributes.addFlashAttribute("mess", "Add new soccers successful!");
        return "redirect:/soccer";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("soccer", iSoccerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute SoccerPlayer soccerPlayer, RedirectAttributes redirectAttributes) {
        iSoccerService.update(soccerPlayer);
        redirectAttributes.addFlashAttribute("mess", "Update product successful!");
        return "redirect:/soccer";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("soccer", iSoccerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(SoccerPlayer soccerPlayer, RedirectAttributes redirectAttributes) {
        iSoccerService.remove(soccerPlayer.getId());
        redirectAttributes.addFlashAttribute("mess", "Remove soccerPlayer successful!");
        return "redirect:/soccer";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("soccer", iSoccerService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String showListSearch(@RequestParam String name, Model model) {
        model.addAttribute("soccers", iSoccerService.findByName(name));
        return "/list";
    }
}
