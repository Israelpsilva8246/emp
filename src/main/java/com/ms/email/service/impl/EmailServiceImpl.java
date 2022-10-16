package com.ms.email.service.impl;

import com.ms.email.models.Email;
import com.ms.email.repository.EmailRepository;
import com.ms.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository repository;

    @Override
    public Email create(Email email) {
        return repository.save(email);
    }

    @Override
    public List<Email> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

}
