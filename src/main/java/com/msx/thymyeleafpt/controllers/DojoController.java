package com.msx.thymyeleafpt.controllers;

import com.msx.thymyeleafpt.models.Dojo;
import com.msx.thymyeleafpt.models.Ninja;
import com.msx.thymyeleafpt.repositories.DojoRepository;
import com.msx.thymyeleafpt.repositories.NinjaRepository;
import com.msx.thymyeleafpt.services.DojoService;
import com.msx.thymyeleafpt.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class DojoController {
    private DojoService dojoService;
    private NinjaService ninjaService;

    public DojoController(DojoService dojoService, NinjaService ninjaService){
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    @GetMapping("/dojohome")
    public String showHome(Model model){
        List<Dojo> dojoList = dojoService.findAllDojos();
        model.addAttribute("dojoList", dojoList);
        // model.addAttribute("name", dojoList.get(0).getName());
        return "showDojos";
    }

    //display the form
    // @GetMapping("/dojo/new")
    // public String createDojoPage(@ModelAttribute("dojoObj") Dojo dojo){
    //     // model.addAttribute("dojo", new Dojo());
    //     return "newDojo";
    // }

    //display the form
    @GetMapping("/dojo/new")
    public String createDojoPage(Model model){
        model.addAttribute("dojoObj", new Dojo());
        return "newDojo";
    }



    @PostMapping("/dojo/new")
    public String addDojo(@Valid @ModelAttribute("dojoObj") Dojo dojo, BindingResult result){
        if(result.hasErrors()){
            return "newDojo";
        }else {
            dojoService.addDojo(dojo);
            return "redirect:/dojohome";
        }
    }

    @DeleteMapping("/deletedojo/{id}")
    // public String deleteDojo(@Valid @ModelAttribute("dojoObj") Dojo dojo, BindingResult result){
        public String deleteDojo(@PathVariable("id") Long id){
    //         Optional<Dojo> dojoById = dojoService.findDojoById(id);
    //         if(dojoById != null){
    //             dojoService.deleteDojo(id);
    //             return "redirect:/dojoHome";
    //         }else {
    //             model.addAttribute("error", "The entered ID doesn't exist");
    //             return "redirect:/dojoHome";
    //         }
            dojoService.deleteDojo(id);
            return "redirect:/dojohome";
    
}


}
