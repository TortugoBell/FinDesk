package br.com.findesk.findesk.service;

import br.com.findesk.findesk.model.Transaction;
import br.com.findesk.findesk.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        if (transaction.getAmount().doubleValue() <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
        return transactionRepository.save(transaction);
    }

    public List<Transaction> listByCompanyId(Long companyId) {
        return transactionRepository.findByCompanyId(companyId);
    }

    public double calculateForecast(Long companyId) {
        List<Transaction> transactions = transactionRepository.findByCompanyId(companyId);
        return transactions.stream()
                .mapToDouble(t -> {
                    if ("INCOME".equals(t.getTransaction_type())) return t.getAmount().doubleValue();
                    else if ("EXPENSE".equals(t.getTransaction_type())) return -t.getAmount().doubleValue();
                    else return 0.0;
                })
                .sum();
    }
}