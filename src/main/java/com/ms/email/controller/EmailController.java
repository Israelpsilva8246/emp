package com.ms.email.controller;

import com.ms.email.models.Email;
import com.ms.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        List<Email> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
