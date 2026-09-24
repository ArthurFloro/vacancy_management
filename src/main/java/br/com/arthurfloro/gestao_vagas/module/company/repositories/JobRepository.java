package br.com.arthurfloro.gestao_vagas.module.company.repositories;

import br.com.arthurfloro.gestao_vagas.module.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
