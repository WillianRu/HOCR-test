package com.ikno.iknoplus.dtos.hocrJson;

import java.util.ArrayList;

public class OCRLineDTO extends OCRNode implements Cloneable {

    private ArrayList<OCRWordDTO> OCRWords;

    public OCRLineDTO() {
        OCRWords = new ArrayList<OCRWordDTO>();
    }

    public ArrayList<OCRWordDTO> getOCRWords() {
        return this.OCRWords;
    }

    public void setOCRWords(ArrayList<OCRWordDTO> OCRWords) {
        this.OCRWords = OCRWords;
    }

    @Override
    public OCRLineDTO clone() throws CloneNotSupportedException {
        return (OCRLineDTO) super.clone();
    }

    @Override
    public void rotateCoordinates() {
        super.rotateCoordinates(); // Rotar las coordenadas de la línea

        // Rotar cada palabra dentro de la línea
        for (OCRWordDTO word : OCRWords) {
            word.rotateCoordinates();
        }
    }
}