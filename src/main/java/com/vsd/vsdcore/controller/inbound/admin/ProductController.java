package com.vsd.vsdcore.controller.inbound.admin;

import com.vsd.vsdcore.dto.ProductDto;
import com.vsd.vsdcore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void createProduct(@RequestBody ProductDto dto) {
        productService.createProduct(dto);
    }

}
