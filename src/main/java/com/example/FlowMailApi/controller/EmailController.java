package com.example.FlowMailApi.controller;

import com.example.FlowMailApi.dto.DadosListagemEmail;
import com.example.FlowMailApi.entity.Email;
import com.example.FlowMailApi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Endpoint para buscar todos os e-mails com um exemplo de filtro
    @GetMapping
    public ResponseEntity<List<DadosListagemEmail>> getAllEmails(Email emailFilter) {
        Example<Email> example = Example.of(emailFilter);
        
        Collection<Email> emails = emailService.findAll(example);
        
        List<DadosListagemEmail> emailList = emails.stream().map(DadosListagemEmail::new).toList();
        
        return ResponseEntity.ok(emailList);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Email>> getOneEmail(@PathVariable Long id) {
        
        // Supondo que `findAll` retorna uma Collection<Email>
        Optional<Email> email = emailService.findOne(id);
        
        return ResponseEntity.ok(email);
    }

    // Endpoint para salvar um novo e-mail
    @PostMapping
    public ResponseEntity<Email> saveEmail(@RequestBody Email email) {
        Email savedEmail = emailService.save(email);
        return ResponseEntity.ok(savedEmail);
    }
}
