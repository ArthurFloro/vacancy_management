package br.com.arthurfloro.gestao_vagas.module.company.useCases;

import br.com.arthurfloro.gestao_vagas.exceptions.UserFoundException;
import br.com.arthurfloro.gestao_vagas.module.company.entities.CompanyEntity;
import br.com.arthurfloro.gestao_vagas.module.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);
    }
}
