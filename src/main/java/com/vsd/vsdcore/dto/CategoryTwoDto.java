package com.vsd.vsdcore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryTwoDto {
    private String id;
    private String categoryOneId;
    private String name;
    private int order;

    public CategoryTwoDto() {
    }

    public CategoryTwoDto(
            String name,
            int order
    ) {
        this.name = name;
        this.order = order;
    }

    public CategoryTwoDto(
            String id,
            String name,
            int order
    ) {
        this.id = id;
        this.name = name;
        this.order = order;
    }
}
