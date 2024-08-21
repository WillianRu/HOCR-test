package com.ikno.iknoplus.dtos.hocrJson;

public class OCRKeyValuePair {
    private OCRWordDTO key;
    private OCRWordDTO value;

    public OCRKeyValuePair() {
        key = new OCRWordDTO();
        key.setKind("key");
        value = new OCRWordDTO();
        value.setKind("value");
    }

    public void rotateCoordinates() {
        key.rotateCoordinates();
        value.rotateCoordinates();
    }

    public OCRWordDTO getKey() {
        return key;
    }

    public void setKey(OCRWordDTO key) {
        this.key = key;
    }

    public OCRWordDTO getValue() {
        return value;
    }

    public void setValue(OCRWordDTO value) {
        this.value = value;
    }

}