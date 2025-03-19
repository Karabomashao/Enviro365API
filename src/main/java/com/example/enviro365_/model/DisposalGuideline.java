package com.example.enviro365_.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "DISPOSAL GUIDELINES")
public class DisposalGuideline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int guidelineId;

    @Column(nullable = false)
    @NotBlank(message = "Disposal method cannot be blank")
    private String disposalMethod;

    @Column(nullable = false)
    @NotBlank(message = "Location cannot be blank")
    private String location;

    @ManyToOne
    @JoinColumn(name = "waste_id", nullable = false)
    private WasteType wasteType;

    public int getGuidelineId() {
        return guidelineId;
    }

    public void setGuidelineId(int guidelineId) {
        this.guidelineId = guidelineId;
    }

    public String getDisposalMethod() {
        return disposalMethod;
    }

    public void setDisposalMethod(String disposalMethod) {
        this.disposalMethod = disposalMethod;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public WasteType getWasteType() {
        return wasteType;
    }

    public void setWasteType(WasteType wasteType) {
        this.wasteType = wasteType;
    }
}
