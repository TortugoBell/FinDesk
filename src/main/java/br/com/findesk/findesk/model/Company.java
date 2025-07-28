package br.com.findesk.findesk.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FD_T_COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, length = 20)
    private String cnpj;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "company")
    private List<AppUser> users;

    @OneToMany(mappedBy = "company")
    private List<BankAccount> bankAccounts;

    @OneToMany(mappedBy = "company")
    private List<Category> categories;
}