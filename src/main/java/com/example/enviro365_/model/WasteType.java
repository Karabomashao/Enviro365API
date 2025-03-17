package com.example.enviro365_.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Waste Types")
public class WasteType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wasteTypeId;

    private String wasteType;

    private String example;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public int getWasteTypeId() {
        return wasteTypeId;
    }

    public void setWasteTypeId(int wasteTypeId) {
        this.wasteTypeId = wasteTypeId;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
