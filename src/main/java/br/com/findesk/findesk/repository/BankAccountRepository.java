package br.com.findesk.findesk.repository;

import br.com.findesk.findesk.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    List<BankAccount> findByCompanyId(Long companyId);

}