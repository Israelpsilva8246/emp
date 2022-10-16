package com.ms.email.controller;

import com.ms.email.models.Email;
import com.ms.email.repository.EmailRepository;
import com.ms.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Email create(@RequestBody Email email) {
        return service.create(email);
    }

    @GetMapping
    public ResponseEntity<List<Email>> findAll() {
        List<Email> completeList = service.findAll();
        List<Email> filteredList = new ArrayList<>();

        completeList.forEach(item -> {
            if (!hasItem(filteredList, item.getEmail())) {
                filteredList.add(item);
            }
        });

        return ResponseEntity.ok().body(filteredList);

    }

    public static Boolean hasItem(List<Email> list, String emailToFind) {
        List<Email> result = list.stream()
                .filter(item -> item.getEmail().equals(emailToFind))
                .collect(Collectors.toList());

        return !result.isEmpty();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete() {
        service.deleteAll();
    }
}
