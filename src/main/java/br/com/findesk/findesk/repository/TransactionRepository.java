package br.com.findesk.findesk.repository;

import br.com.findesk.findesk.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Category, Long> {
}
