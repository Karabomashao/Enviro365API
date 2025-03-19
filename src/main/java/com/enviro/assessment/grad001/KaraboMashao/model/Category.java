package com.enviro.assessment.grad001.KaraboMashao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;


@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;

    @NotBlank(message = "Description cannot be blank")
    @Column(nullable = false)
    private String description;

    @Column(unique=true, nullable = false)
    @NotBlank(message = "Waste category cannot be blank")
    private String typeOfCategory;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<WasteType> wasteTypes;

    public Category(String typeOfCategory, String description) {
        this.description = description;
        this.typeOfCategory = typeOfCategory;
    }

    public Category() {

    }

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
