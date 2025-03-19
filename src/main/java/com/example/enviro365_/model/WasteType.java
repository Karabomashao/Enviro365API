package com.example.enviro365_.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "Waste Types")
public class WasteType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wasteTypeId;

    @NotBlank(message = "Type of waste cannot be blank")
    @Column(nullable = false, unique = true)
    private String wasteType;

    @NotBlank(message = "Waste example of waste cannot be blank")
    @Column(nullable = false)
    private String example;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "wasteType", cascade = CascadeType.ALL)
    private List<DisposalGuideline> disposalGuidelineList;

    @OneToMany(mappedBy = "wasteType", cascade = CascadeType.ALL)
    private List<RecyclingTip> recyclingTipList;

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
