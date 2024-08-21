package com.ikno.iknoplus.dtos.hocrJson;

import java.util.ArrayList;

public class HOCRObject {

    private ArrayList<OCRLineDTO> ocrLines;
    private String fullContent;
    private String sourceImageName;
    private double imageWidth;
    private double imageHeight;
    private String language;
    private int segmentation;
    private String charsWhitelist;
    private String unit;
    private String engine;
    private ArrayList<OCRTableDTO> ocrTables;
    private ArrayList<OCRCodeBarDTO> ocrCodebars;
    private ArrayList<OCRKeyValuePair> ocrKeyValuePairs;
    

    public HOCRObject() {
        setOcrLines(new ArrayList<OCRLineDTO>());
        setOcrTables(new ArrayList<OCRTableDTO>());
        setOcrCodebars(new ArrayList<OCRCodeBarDTO>());
        setOcrKeyValuePairs(new ArrayList<OCRKeyValuePair>());
        fullContent = "";
        unit = "PIXEL";
        engine = "TESSERACT";
    }

    public void rotateAllCoordinates() {
        // Rotar todas las líneas
        for (OCRLineDTO line : ocrLines) {
            line.rotateCoordinates();
        }

        // Rotar todas las tablas
        for (OCRTableDTO table : ocrTables) {
            table.rotateCoordinates();
        }

        // Rotar todos los códigos de barras
        for (OCRCodeBarDTO codeBar : ocrCodebars) {
            codeBar.rotateCoordinates();
        }

        // Rotar todas las claves y valores
        for (OCRKeyValuePair pair : ocrKeyValuePairs) {
            pair.getKey().rotateCoordinates();
            pair.getValue().rotateCoordinates();
        }

        //Alternar dimensiones del objeto HOCR
        double tempWidth = this.imageWidth;
        this.imageWidth = this.imageHeight;
        this.imageHeight = tempWidth;
    }

    public String getCharsWhitelist() {
        return charsWhitelist;
    }

    public void setCharsWhitelist(String charsWhitelist) {
        this.charsWhitelist = charsWhitelist;
    }

    public ArrayList<OCRLineDTO> getOcrLines() {
        return ocrLines;
    }

    public void setOcrLines(ArrayList<OCRLineDTO> ocrLines) {
        this.ocrLines = ocrLines;
    }

    public String getFullContent() {
        return this.fullContent;
    }

    public void setFullContent(String fullContent) {
        this.fullContent = fullContent;
    }

    public void addToFullContent(String fullContent) {
        this.fullContent += fullContent;
    }

    public String getSourceImageName() {
        return sourceImageName;
    }

    public void setSourceImageName(String sourceImageName) {
        this.sourceImageName = sourceImageName;
    }

    public double getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(double imageWidth) {
        this.imageWidth = imageWidth;
        propagateImageDimensions();
    }

    public double getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(double imageHeight) {
        this.imageHeight = imageHeight;
        propagateImageDimensions();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSegmentation() {
        return segmentation;
    }

    public void setSegmentation(int segmentation) {
        this.segmentation = segmentation;
    }

    public ArrayList<OCRTableDTO> getOcrTables() {
        return ocrTables;
    }

    public void setOcrTables(ArrayList<OCRTableDTO> ocrTables) {
        this.ocrTables = ocrTables;
    }

    public ArrayList<OCRCodeBarDTO> getOcrCodebars() {
        return ocrCodebars;
    }

    public void setOcrCodebars(ArrayList<OCRCodeBarDTO> codebars) {
        this.ocrCodebars = codebars;
    }

    public ArrayList<OCRKeyValuePair> getOcrKeyValuePairs() {
        return ocrKeyValuePairs;
    }

    public void setOcrKeyValuePairs(ArrayList<OCRKeyValuePair> ocrKeyValuePairs) {
        this.ocrKeyValuePairs = ocrKeyValuePairs;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    private void propagateImageDimensions() {
        for (OCRLineDTO line : ocrLines) {
            line.setImageWidth(imageWidth);
            line.setImageHeight(imageHeight);
            for (OCRWordDTO word : line.getOCRWords()) {
                word.setImageWidth(imageWidth);
                word.setImageHeight(imageHeight);
            }
        }

        for (OCRTableDTO table : ocrTables) {
            table.setImageWidth(imageWidth);
            table.setImageHeight(imageHeight);
            for (OCRLineDTO row : table.getOcrRows()) {
                row.setImageWidth(imageWidth);
                row.setImageHeight(imageHeight);
                for (OCRWordDTO word : row.getOCRWords()) {
                    word.setImageWidth(imageWidth);
                    word.setImageHeight(imageHeight);
                }
            }
        }

        for (OCRCodeBarDTO codeBar : ocrCodebars) {
            codeBar.setImageWidth(imageWidth);
            codeBar.setImageHeight(imageHeight);
        }

        for (OCRKeyValuePair pair : ocrKeyValuePairs) {
            pair.getKey().setImageWidth(imageWidth);
            pair.getKey().setImageHeight(imageHeight);
            pair.getValue().setImageWidth(imageWidth);
            pair.getValue().setImageHeight(imageHeight);
        }
    }
}