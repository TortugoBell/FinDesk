package br.com.findesk.findesk.controller;

import br.com.findesk.findesk.dto.BankAccountDTO;
import br.com.findesk.findesk.model.BankAccount;
import br.com.findesk.findesk.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping
    public BankAccount create(@RequestBody BankAccountDTO dto) {
        BankAccount account = new BankAccount();
        account.setName(dto.getName());
        account.setType(dto.getType());
        account.setBankName(dto.getBankName());
        account.setInitialBalance(dto.getInitialBalance());
        return bankAccountService.createAccount(account);
    }

    @GetMapping("/company/{companyId}")
    public List<BankAccount> listByCompany(@PathVariable Long companyId) {
        return bankAccountService.listByCompany(companyId);
    }
}