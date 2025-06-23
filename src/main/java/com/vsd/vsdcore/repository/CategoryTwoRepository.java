package com.vsd.vsdcore.repository;

import com.vsd.vsdcore.model.CategoryOne;
import com.vsd.vsdcore.model.CategoryTwo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryTwoRepository extends JpaRepository<CategoryTwo, String> {
}
