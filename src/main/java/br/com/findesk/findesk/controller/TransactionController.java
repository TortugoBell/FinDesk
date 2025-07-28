package br.com.findesk.findesk.controller;

import br.com.findesk.findesk.dto.TransactionDTO;
import br.com.findesk.findesk.model.Transaction;
import br.com.findesk.findesk.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public Transaction create(@RequestBody TransactionDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setDueDate(dto.getDueDate());
        transaction.setTransaction_type(dto.getTransaction_type());
        transaction.setTransaction_status(dto.getTransaction_status());
        return transactionService.createTransaction(transaction);
    }

    @GetMapping("/company/{companyId}")
    public List<Transaction> listByCompany(@PathVariable Long companyId) {
        return transactionService.listByCompanyId(companyId);
    }

    @GetMapping("/company/{companyId}/forecast")
    public double forecast(@PathVariable Long companyId) {
        return transactionService.calculateForecast(companyId);
    }
}