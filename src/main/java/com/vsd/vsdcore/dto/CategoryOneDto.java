package com.vsd.vsdcore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryOneDto {
    private String id;
    private String name;
    private int order;

    public CategoryOneDto() {
    }

    public CategoryOneDto(
            String name,
            int order
    ) {
        this.name = name;
        this.order = order;
    }

    public CategoryOneDto(
            String id,
            String name,
            int order
    ) {
        this.id = id;
        this.name = name;
        this.order = order;
    }
}
