package br.com.findesk.findesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<br.com.findesk.findesk.model.AppUser, Long> {
    br.com.findesk.findesk.model.AppUser findByEmail(String email);
}
