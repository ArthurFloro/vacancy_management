package br.com.arthurfloro.gestao_vagas.module.candidate.useCases;

import br.com.arthurfloro.gestao_vagas.exceptions.UserFoundException;
import br.com.arthurfloro.gestao_vagas.module.candidate.entities.CandidateEntity;
import br.com.arthurfloro.gestao_vagas.module.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(),
                candidateEntity.getEmail()).ifPresent(user -> {
                    throw new UserFoundException();
        });

        var password = passwordEncoder.encode(candidateEntity.getPassword());

        return this.candidateRepository.save(candidateEntity);


    }
}
