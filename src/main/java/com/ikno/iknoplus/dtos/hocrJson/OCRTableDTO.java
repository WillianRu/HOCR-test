package com.ikno.iknoplus.dtos.hocrJson;

import java.util.ArrayList;

public class OCRTableDTO extends OCRNode {
    private ArrayList<OCRLineDTO> ocrRows;

    public OCRTableDTO() {
        ocrRows = new ArrayList<OCRLineDTO>();
    }

    public ArrayList<OCRLineDTO> getOcrRows() {
        return ocrRows;
    }

    public void setOcrRows(ArrayList<OCRLineDTO> ocrRows) {
        this.ocrRows = ocrRows;
    }

    @Override
    public void rotateCoordinates() {
        super.rotateCoordinates(); // Rotar las coordenadas de la tabla

        // Rotar cada fila dentro de la tabla
        for (OCRLineDTO row : ocrRows) {
            row.rotateCoordinates();
        }
    }
}
    