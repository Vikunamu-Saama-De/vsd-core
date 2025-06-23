package com.vsd.vsdcore.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class CategoryTwo {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private int order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryOneId")
    private CategoryOne categoryOne;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public CategoryTwo() {
    }

    public CategoryTwo(String name, int order, CategoryOne categoryOne) {
        this.name = name;
        this.order = order;
        this.categoryOne = categoryOne;
    }

}
