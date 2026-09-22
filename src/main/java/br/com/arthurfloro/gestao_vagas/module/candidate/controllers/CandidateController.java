package br.com.arthurfloro.gestao_vagas.module.candidate.controllers;

import br.com.arthurfloro.gestao_vagas.module.candidate.CandidateEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public void create(@RequestBody CandidateEntity candidateEntity) {
        System.out.println("candidato");
        System.out.println(candidateEntity.getEmail());
    }
}
