package br.com.findesk.findesk.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountDTO {
    private String name;
    private String type;
    private String bankName;
    private BigDecimal initialBalance;
    private Long companyId;
}