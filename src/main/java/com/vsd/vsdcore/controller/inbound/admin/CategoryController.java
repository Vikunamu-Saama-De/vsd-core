package com.vsd.vsdcore.controller.inbound.admin;

import com.vsd.vsdcore.dto.CategoryOneDto;
import com.vsd.vsdcore.dto.CategoryThreeDto;
import com.vsd.vsdcore.dto.CategoryTwoDto;
import com.vsd.vsdcore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService  categoryService;

    @PostMapping("one")
    public void createCategoryOne(@RequestBody CategoryOneDto dto) {
        categoryService.createCategoryOne(dto);
    }

    @PostMapping("two")
    public void createCategoryTwo(@RequestBody CategoryTwoDto dto) {
        categoryService.createCategoryTwo(dto);
    }

    @PostMapping("three")
    public void createCategoryThree(@RequestBody CategoryThreeDto dto) {
        categoryService.createCategoryThree(dto);
    }







}
