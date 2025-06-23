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
public class Product {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String description;
    private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryThreeId")
    private CategoryThree categoryThree;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Product() {
    }

    public Product(String name, String description, double price, CategoryThree categoryThree) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryThree = categoryThree;
    }

}
