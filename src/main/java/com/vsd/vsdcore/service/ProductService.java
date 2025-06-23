package com.vsd.vsdcore.service;

import com.vsd.vsdcore.dto.ProductDto;
import com.vsd.vsdcore.model.Product;
import com.vsd.vsdcore.repository.CategoryThreeRepository;
import com.vsd.vsdcore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryThreeRepository categoryThreeRepository;
    private final ProductRepository productRepository;

    public void createProduct(ProductDto dto) {
        validateCreateProductRequest(dto);

        productRepository.findByName(dto.getName())
                        .ifPresent(product -> {
                            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with this name already exists");
                        });


        categoryThreeRepository.findById(dto.getCategoryThreeId())
                        .ifPresentOrElse(
                                categoryThree -> {
                                    productRepository.save(
                                            new Product(
                                                    dto.getName(),
                                                    dto.getDescription(),
                                                    dto.getPrice(),
                                                    categoryThree
                                            )
                                    );
                                },
                                () -> {
                                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category three not found");
                                }
                        );
    }

    private void validateCreateProductRequest(ProductDto dto) {
        if (dto.getName() == null || dto.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product name cannot be empty");
        }
        if (dto.getPrice() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product price must be greater than zero");
        }
        if (dto.getCategoryThreeId() == null || dto.getCategoryThreeId().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product must belong to a category");
        }

    }

}
