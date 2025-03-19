package com.enviro.assessment.grad001.KaraboMashao.model;


import jakarta.persistence.*;

@Entity
@Table(name = "RECYCLING TIPS")
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tipId;

    @Column(nullable = false)
    private String tipDescription;

    @Column(nullable = false)
    private String material;

    @Column(nullable = false)
    private String additionalInfo;

    @ManyToOne
    @JoinColumn(name = "waste_id", nullable = false)
    private WasteType wasteType;

    public RecyclingTip(WasteType wasteType, String tipDescription, String additionalInfo, String material) {
        this.additionalInfo = additionalInfo;
        this.material = material;
        this.tipDescription = tipDescription;
        this.wasteType = wasteType;
    }

    public RecyclingTip() {

    }

    public int getTipId() {
        return tipId;
    }

    public void setTipId(int tipId) {
        this.tipId = tipId;
    }

    public String getTipDescription() {
        return tipDescription.toLowerCase();
    }

    public void setTipDescription(String tipDescription) {
        this.tipDescription = tipDescription.toLowerCase();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material.toLowerCase();
    }

    public String getAdditionalInfo() {
        return additionalInfo.toLowerCase();
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo.toLowerCase();
    }

    public WasteType getWasteType() {
        return wasteType;
    }

    public void setWasteType(WasteType wasteType) {
        this.wasteType = wasteType;
    }

    public void setId(int tipId) {
    }

}
