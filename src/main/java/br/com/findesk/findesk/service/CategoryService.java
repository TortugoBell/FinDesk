package br.com.findesk.findesk.service;

import br.com.findesk.findesk.model.Category;
import br.com.findesk.findesk.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> listByCompany(Long companyId) {
        return categoryRepository.findByCompanyId(companyId);
    }
}