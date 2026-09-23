package br.com.arthurfloro.gestao_vagas.module.candidate.useCases;

import br.com.arthurfloro.gestao_vagas.exceptions.UserFoundException;
import br.com.arthurfloro.gestao_vagas.module.candidate.CandidateEntity;
import br.com.arthurfloro.gestao_vagas.module.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(),
                candidateEntity.getEmail()).ifPresent(user -> {
                    throw new UserFoundException();
        });

        return this.candidateRepository.save(candidateEntity);
    }
}
