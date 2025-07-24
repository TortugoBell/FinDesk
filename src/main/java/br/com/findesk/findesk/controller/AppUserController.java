package br.com.findesk.findesk.controller;

import br.com.findesk.findesk.dto.AppUserDTO;
import br.com.findesk.findesk.model.AppUser;
import br.com.findesk.findesk.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping
    public AppUser create(@RequestBody AppUserDTO dto) {
        AppUser user = new AppUser();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPasswordHash(dto.getPassword()); // no futuro hash
        user.setProfile(dto.getProfile());
        // associar empresa por id, ajuste conforme necessário
        return appUserService.createUser(user);
    }

    @GetMapping("/company/{companyId}")
    public List<AppUser> listByCompany(@PathVariable Long companyId) {
        return appUserService.listByCompany(companyId);
    }
}