package br.com.findesk.findesk.controller;

import br.com.findesk.findesk.dto.CategoryDTO;
import br.com.findesk.findesk.model.Category;
import br.com.findesk.findesk.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public Category create(@RequestBody CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setType(dto.getType());
        return categoryService.createCategory(category);
    }

    @GetMapping("/company/{companyId}")
    public List<Category> listByCompany(@PathVariable Long companyId) {
        return categoryService.listByCompany(companyId);
    }
}