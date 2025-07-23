package br.com.findesk.findesk.repository;

import br.com.findesk.findesk.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepository extends JpaRepository<br.com.findesk.findesk.model.AppUser, Long> {
    List<AppUser> findByCompanyId(Long companyID);
    br.com.findesk.findesk.model.AppUser findByEmail(String email);
}
