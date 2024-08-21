package com.ikno.iknoplus.dtos.hocrJson;

public class OCRWordDTO extends OCRNode {

    private double confidence;
    private String value;
    private String originalLineId;
    private String kind;

    public OCRWordDTO() {
        value = "";
        kind = "content";
    }

    public OCRWordDTO(String id, String value, double confidence, double x0, double y0, double x1, double y1) {

        this.value = value;
        this.confidence = confidence;

        super.setId(id);
        double[] allCoordinates = { x0, y0, x1, y1 };
        super.setAllCoordinates(allCoordinates);

    }

    public double getConfidence() {
        return this.confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOriginalLineId() {
        return originalLineId;
    }

    public void setOriginalLineId(String originalLineId) {
        this.originalLineId = originalLineId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}