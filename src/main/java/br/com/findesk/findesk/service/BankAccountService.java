package br.com.findesk.findesk.service;

import br.com.findesk.findesk.model.BankAccount;
import br.com.findesk.findesk.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccount createAccount(BankAccount account) {
        return bankAccountRepository.save(account);
    }

    public List<BankAccount> listByCompany(Long companyId) {
        return bankAccountRepository.findByCompanyId(companyId);
    }
}