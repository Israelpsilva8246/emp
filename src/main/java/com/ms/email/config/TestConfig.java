package com.ms.email.config;

import com.ms.email.models.Email;
import com.ms.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public void run(String... args) throws Exception {

        Email em1 = new Email(null, "lucas@gmail.com", LocalDate.now());

        emailRepository.saveAll(Arrays.asList(em1));

    }
}
