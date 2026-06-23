package ca.sheridancollege.yuezhang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.yuezhang.beans.PersonalDetails;
import ca.sheridancollege.yuezhang.repositories.PersonalDetailsRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class WebController {

    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;

    @GetMapping("/profile")
    public ResponseEntity<PersonalDetails> getProfile() {
        return personalDetailsRepository.findById(1L)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
