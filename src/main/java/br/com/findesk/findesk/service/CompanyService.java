package br.com.findesk.findesk.service;

import br.com.findesk.findesk.model.Company;
import br.com.findesk.findesk.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company createCompany(Company company) {
        // Exemplo: validar CNPJ único
        if (companyRepository.findByCnpj(company.getCnpj()).isPresent()) {
            throw new IllegalArgumentException("CNPJ já cadastrado.");
        }
        return companyRepository.save(company);
    }

    public Optional<Company> getById(Long id) {
        return companyRepository.findById(id);
    }
}