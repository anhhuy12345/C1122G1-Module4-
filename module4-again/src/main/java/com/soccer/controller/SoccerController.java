package com.soccer.controller;

import com.soccer.model.Soccer;
import com.soccer.service.ISoccerService;
import com.soccer.service.impl.SoccerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/soccer")
public class SoccerController {
    private final ISoccerService iSoccerService = new SoccerService();
@GetMapping("/list")
public String toIndex(Model model) {
    List<Soccer> soccerList = iSoccerService.getSoccerList();
    model.addAttribute("soccerList", soccerList);
    return "soccer/list";
}

    @GetMapping("/showAddNewForm")
    public String showAddNewForm(Model model) {
        model.addAttribute("newSoccer", new Soccer());
        return "/soccer/create";
    }
    @PostMapping("/addNewSoccer")
    public String addNewSoccer(@ModelAttribute Soccer newSoccer, RedirectAttributes redirectAttributes) {
        String mess = "Add new soccer failed!";

        if (iSoccerService.add(newSoccer)) {
            mess = "Adding new soccer Succesfully!";
        }

        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/soccer/list";
    }
    @GetMapping( "/showUpdateForm")
    public String showUpdateForm(Model model, @RequestParam int idFind) {
        Soccer soccerUpdate = iSoccerService.findById(idFind);

        model.addAttribute("soccerUpdate", soccerUpdate);

        return "/soccer/edit";
    }
    @PostMapping("/editSoccer")
    public String editSoccer(@ModelAttribute Soccer soccerUpdate, RedirectAttributes redirectAttributes) {
        String mess = null;

        if (iSoccerService.update(soccerUpdate)) {
            mess = "Soccer updated successfully!";
        }

        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/soccer/list";
    }
    @PostMapping("/deleteSoccer")
    public String deleteSoccer(@RequestParam int idDelete, RedirectAttributes redirectAttributes) {

        iSoccerService.delete(idDelete);

        redirectAttributes.addFlashAttribute("mess", "Delete soccer successfully!");
        return "redirect:/soccer/list";
    }
    @GetMapping( "/viewSoccer")
    public String viewSoccer(@RequestParam int idView, Model model) {
        Soccer soccerView = iSoccerService.findById(idView);

        List<Soccer> soccerToView = new ArrayList<>();

        soccerToView.add(soccerView);

        model.addAttribute("soccerList", soccerToView);

        return "/soccer/list";
    }
    @GetMapping("/searchByName")
    public String searchByName(@RequestParam String soccerNameSearch, Model model) {
        String mess = "Found!";

        List<Soccer> soccerFound = iSoccerService.searchByName(soccerNameSearch);

        if (soccerFound.size() == 0) {
            mess = "No soccer found!";
        }

        model.addAttribute("soccerList", soccerFound);
        model.addAttribute("mess", mess);

        return "/soccer/list";
    }

}
