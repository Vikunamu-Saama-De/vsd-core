package com.vsd.vsdcore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryThreeDto {
    private String id;
    private String categoryTwoId;
    private String name;
    private int order;

    public CategoryThreeDto() {
    }

    public CategoryThreeDto(
            String name,
            int order
    ) {
        this.name = name;
        this.order = order;
    }

    public CategoryThreeDto(
            String id,
            String name,
            int order
    ) {
        this.id = id;
        this.name = name;
        this.order = order;
    }
}
