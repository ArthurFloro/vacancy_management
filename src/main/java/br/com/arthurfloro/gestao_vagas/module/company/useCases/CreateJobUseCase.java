package br.com.arthurfloro.gestao_vagas.module.company.useCases;

import br.com.arthurfloro.gestao_vagas.module.company.entities.JobEntity;
import br.com.arthurfloro.gestao_vagas.module.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }

}
