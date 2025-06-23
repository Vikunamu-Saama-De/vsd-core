package com.vsd.vsdcore.service;

import com.vsd.vsdcore.dto.CategoryOneDto;
import com.vsd.vsdcore.dto.CategoryThreeDto;
import com.vsd.vsdcore.dto.CategoryTwoDto;
import com.vsd.vsdcore.model.CategoryOne;
import com.vsd.vsdcore.model.CategoryThree;
import com.vsd.vsdcore.model.CategoryTwo;
import com.vsd.vsdcore.repository.CategoryOneRepository;
import com.vsd.vsdcore.repository.CategoryThreeRepository;
import com.vsd.vsdcore.repository.CategoryTwoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryOneRepository categoryOneRepository;
    private final CategoryTwoRepository categoryTwoRepository;
    private final CategoryThreeRepository categoryThreeRepository;

    public void createCategoryOne(CategoryOneDto dto) {
        validateCategoryOneCreateRequest(dto);
        categoryOneRepository.save(
                new CategoryOne(
                        dto.getName(),
                        dto.getOrder()
                )
        );
    }

    public void createCategoryTwo(CategoryTwoDto dto) {
        validateCategoryTwoCreateRequest(dto);

        categoryOneRepository.findById(dto.getId())
                .ifPresentOrElse(
                        categoryOne -> {
                            categoryTwoRepository.save(new CategoryTwo(dto.getName(), dto.getOrder(), categoryOne));
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category one not found");
                        }
                );
    }

    public void createCategoryThree(CategoryThreeDto dto) {
        validateCategoryOneCreateRequest(dto);

        categoryTwoRepository.findById(dto.getCategoryTwoId())
                .ifPresentOrElse(
                        categoryTwo -> {
                            categoryThreeRepository.save(new CategoryThree(dto.getName(), dto.getOrder(), categoryTwo));
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category two not found");
                        }
                );
    }

    private void validateCategoryOneCreateRequest(CategoryOneDto dto) {
        if (dto.getName() == null || dto.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category name is required");
        }
    }

    private void validateCategoryTwoCreateRequest(CategoryTwoDto dto) {
        if (dto.getName() == null || dto.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category name is required");
        }
        if (dto.getCategoryOneId() == null || dto.getCategoryOneId().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category one ID is required");
        }
    }

    private void validateCategoryOneCreateRequest(CategoryThreeDto dto) {
        if (dto.getName() == null || dto.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category name is required");
        }
        if (dto.getCategoryTwoId() == null || dto.getCategoryTwoId().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category two ID is required");
        }
    }
}
