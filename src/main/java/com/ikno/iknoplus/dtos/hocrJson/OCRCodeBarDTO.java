package com.ikno.iknoplus.dtos.hocrJson;

public class OCRCodeBarDTO extends OCRNode {
    private double confidence;
    private String type;
    private String value;

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}