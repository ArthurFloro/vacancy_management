package br.com.arthurfloro.gestao_vagas.module.candidate.useCases;


import br.com.arthurfloro.gestao_vagas.module.company.entities.JobEntity;
import br.com.arthurfloro.gestao_vagas.module.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilterUseCase {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter) {
        return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
    }

}
