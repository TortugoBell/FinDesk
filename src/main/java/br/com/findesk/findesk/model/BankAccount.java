package br.com.findesk.findesk.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FD_T_BANKACCOUNT")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String type; // CHECKING, SAVINGS, CASH, INVESTMENT

    private String bankName;

    @Column(nullable = false)
    private BigDecimal initialBalance;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
