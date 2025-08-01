package br.com.findesk.findesk.dto;

import lombok.Data;

@Data
public class AppUserDTO {
    private String name;
    private String email;
    private String password; //Implementar criptografia
    private String profile;
    private Long companyId;
}