package br.com.findesk.findesk.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransactionDTO {
    private String description;
    private BigDecimal amount;
    private LocalDate dueDate;
    private String transaction_type;
    private String transaction_status;
    private Long categoryId;
    private Long bankAccountId;
    private Long userId;
    private Long companyId;
}