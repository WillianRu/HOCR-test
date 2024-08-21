package com.ikno.iknoplus;

import java.io.IOException;

import com.ikno.iknoplus.dtos.hocrJson.HOCRObject;
import com.ikno.iknoplus.control.generalUtils.HOCRVisualizer;
import com.ikno.iknoplus.control.generalUtils.JsonUtils;


public class Main {
     public static void main(String[] args) {
        try {
            // Leer el archivo JSON y convertirlo a un objeto HOCRObject
            //HOCRObject hocrObject = JsonUtils.readObjectFromJsonFile("/Users/willianrueda/Documents/IKDATA_FILES/B12/B12-000.json", HOCRObject.class);
            //HOCRObject hocrObject = JsonUtils.readObjectFromJsonFile("/Users/willianrueda/Documents/Rotated_data/rotated-B12-000.json", HOCRObject.class);
            HOCRObject hocrObject = JsonUtils.readObjectFromJsonFile("/Users/willianrueda/Documents/IKDATA_FILES/B13/B13-000.json", HOCRObject.class);

            // Mostrar las dimensiones del objeto
            System.out.println("imageWidth: " + hocrObject.getImageWidth());
            System.out.println("imageHeight: " + hocrObject.getImageHeight());

            // Propagar dimensiones manualmente después de leer el JSON
            hocrObject.setImageWidth(hocrObject.getImageWidth());
            hocrObject.setImageHeight(hocrObject.getImageHeight());

            // Ejemplo: Rotar todas las coordenadas
            hocrObject.rotateAllCoordinates();

            // Escribir el objeto HOCRObject de nuevo a un archivo JSON después de la rotación
            //JsonUtils.writeObjectToJsonFile(hocrObject, "/Users/willianrueda/Documents/Rotated_data/rotated-B12-000.json");
            //JsonUtils.writeObjectToJsonFile(hocrObject, "/Users/willianrueda/Documents/Rotated_data/rotated-again-B12-000.json");
            JsonUtils.writeObjectToJsonFile(hocrObject, "/Users/willianrueda/Documents/Rotated_data/rotated-B13-000.json");

            
            // Dibujar los rectángulos basados en el objeto HOCRObject rotado
            HOCRVisualizer.drawRectanglesFromHOCRObject(hocrObject, "/Users/willianrueda/Documents/Rotated_data/rotated-B13-000.png");


            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

