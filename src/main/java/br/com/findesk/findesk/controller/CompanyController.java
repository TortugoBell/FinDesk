package br.com.findesk.findesk.controller;

import br.com.findesk.findesk.dto.CompanyDTO;
import br.com.findesk.findesk.model.Company;
import br.com.findesk.findesk.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public Company create(@RequestBody CompanyDTO dto) {
        Company company = new Company();
        company.setName(dto.getName());
        company.setCnpj(dto.getCnpj());
        return companyService.createCompany(company);
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable Long id) {
        return companyService.getById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));
    }
}