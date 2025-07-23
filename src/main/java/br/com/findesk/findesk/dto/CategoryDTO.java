package br.com.findesk.findesk.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private String name;
    private String type;
    private Long companyId;
    private Long parentCategoryId;
}