package ca.sheridancollege.yuezhang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;

import ca.sheridancollege.yuezhang.beans.PersonalDetails;
import ca.sheridancollege.yuezhang.repositories.PersonalDetailsRepository;

@Controller
public class AdminController {

    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;

    @GetMapping("/")
    public String index(Model model) {
        PersonalDetails current = personalDetailsRepository.findById(1L)
                .orElse(new PersonalDetails());
        
        model.addAttribute("personalDetails", current);
        model.addAttribute("currDetails", current);
        
        return "index";
    }

    @PostMapping("/updatePersonalDetails")
    public String updatePersonalDetails(Model model,
            @Valid @ModelAttribute("personalDetails") PersonalDetails personalDetails, 
            BindingResult result, 
            RedirectAttributes ra) {
    	
        if (result.hasErrors()) {
            model.addAttribute("currDetails", personalDetailsRepository.findById(1L).orElse(new PersonalDetails()));
            return "index"; 
        }
        
        personalDetails.setId(1L);
        personalDetailsRepository.save(personalDetails);
        
        ra.addFlashAttribute("message", "Update Successful!");
        
        return "redirect:/";
    }
}