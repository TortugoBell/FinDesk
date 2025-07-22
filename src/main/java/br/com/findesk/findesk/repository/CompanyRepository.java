package br.com.findesk.findesk.repository;

import br.com.findesk.findesk.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByCnpj(String cnpj)
}