package com.msx.thymyeleafpt.controllers;

import java.util.List;

import javax.validation.Valid;

import com.msx.thymyeleafpt.models.Dojo;
import com.msx.thymyeleafpt.models.Ninja;
import com.msx.thymyeleafpt.services.DojoService;
import com.msx.thymyeleafpt.services.NinjaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NinjaController {
    private NinjaService ninjaService;
    private DojoService dojoService;
    
    public NinjaController(NinjaService ninjaService, DojoService dojoService){
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }
    @GetMapping("/ninjahome")
    public String showAllNinjas(Model model){
        List<Ninja> ninjaList = ninjaService.showAllNinja();
        model.addAttribute("ninjaList", ninjaList);
        return "showNinja";
    }
    
    // @GetMapping("/ninja/new")
    // public String ninjaCreatePage(@ModelAttribute("ninjaObj") Ninja ninja){
    //     return "newNinja";
    // }

    // @PostMapping("/ninja/new")
    // public String createNinja(@Valid @ModelAttribute("ninjaObj") Ninja ninja, BindingResult result){
    //     if(result.hasErrors()){
    //         return "newNinja";
    //     }else{
    //         ninjaService.addNinja(ninja);
    //         return "redirect:/ninjahome";
    //     }
    // }

    @DeleteMapping("/delete/{id}")
    public String deleteNinja(@PathVariable("id") Long id){
        ninjaService.deleteByIdNinja(id);
        return "redirect:/ninjahome";
    }


    @GetMapping("/addninja")
    public String addPage(@ModelAttribute("ninjaObj") Ninja ninja, Model model){
        List<Ninja> allNinja = ninjaService.showAllNinja();
        model.addAttribute("ninjaList", allNinja);
        List<Dojo> allDojos = dojoService.findAllDojos();
        model.addAttribute("dojoList", allDojos);
        return "addNinja";
    }

    @PostMapping("/addninja")
    public String addNinja(@Valid @ModelAttribute("ninjaObj") Ninja ninja, BindingResult result){
        if(result.hasErrors()){
            return "newNinja";
        }else{
            ninjaService.addNinja(ninja);
            return "redirect:/addninja";
        }
    }


    
}
