package br.com.findesk.findesk.service;

import br.com.findesk.findesk.model.AppUser;
import br.com.findesk.findesk.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUser createUser(AppUser user) {
        // Regra de exemplo: email único já garantido pelo banco, mas podemos validar antes
        if (appUserRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }
        return appUserRepository.save(user);
    }

    public List<AppUser> listByCompany(Long companyId) {
        return appUserRepository.findByCompanyId(companyId);
    }
}