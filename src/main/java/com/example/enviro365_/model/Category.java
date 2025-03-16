package com.example.enviro365_.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, unique = true)
    private String typeOfCategory;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfCategory() {
        return typeOfCategory;
    }

    public void setTypeOfCategory(String typeOfCategory) {
        this.typeOfCategory = typeOfCategory;
    }
}
