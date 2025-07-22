package br.com.findesk.findesk.repository;

import br.com.findesk.findesk.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
