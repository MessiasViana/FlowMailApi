package com.example.FlowMailApi.service;

import com.example.FlowMailApi.entity.Email;
import com.example.FlowMailApi.exception.SpamException;
import com.example.FlowMailApi.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repo;
    
    @Autowired
    private SpamControlService spamControlService;

    public Collection<Email> findAll(Example<Email> example) {
        return repo.findAll(example);
    }
    
    public Optional<Email> findOne(Long id) {
    	return repo.findById(id);
    }

    public Email save(Email email) {
        if (spamControlService.isSpam(email.getId())) {
            throw new SpamException("O usuário excedeu o limite de envio de e-mails.");
        }
        return repo.save(email);
    }
}
