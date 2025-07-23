package br.com.findesk.findesk.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransferDTO {
    private BigDecimal amount;
    private LocalDate transferDate;
    private String description;
    private String status;
    private Long originAccountId;
    private Long destinationAccountId;
    private Long userId;
    private Long companyId;
}