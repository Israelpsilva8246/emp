package com.ms.email.service;

import com.ms.email.models.Email;

import java.util.List;

public interface EmailService {

    Email create(Email email);

    List<Email> findAll();

    void deleteAll();
}
