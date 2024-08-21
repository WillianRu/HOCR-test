package com.ikno.iknoplus.control.generalUtils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.ikno.iknoplus.dtos.hocrJson.HOCRObject;
import com.ikno.iknoplus.dtos.hocrJson.OCRLineDTO;
import com.ikno.iknoplus.dtos.hocrJson.OCRWordDTO;

public class HOCRVisualizer {
    public static void drawRectanglesFromHOCRObject(HOCRObject hocrObject, String outputPath) {
        // Crear una imagen en blanco con las dimensiones de la imagen original
        BufferedImage image = new BufferedImage((int) hocrObject.getImageWidth(), (int) hocrObject.getImageHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();

        // Color de los rectángulos
        Color rectColor = Color.RED;
        graphics.setColor(rectColor);

        // Dibujar los rectángulos basados en las coordenadas de OCRLines y OCRWords
        for (OCRLineDTO line : hocrObject.getOcrLines()) {
            for (OCRWordDTO word : line.getOCRWords()) {
                int x0 = (int) word.getX0coordinate();
                int y0 = (int) word.getY0coordinate();
                int x1 = (int) word.getX1coordinate();
                int y1 = (int) word.getY1coordinate();
        
                // Asegurar que x0 sea menor que x1 y y0 menor que y1
                int x = Math.min(x0, x1);
                int y = Math.min(y0, y1);
                int width = Math.abs(x1 - x0);
                int height = Math.abs(y1 - y0);
        
                // *Depuración
                //System.out.println("Dibujando rectángulo: x=" + x + ", y=" + y + ", width=" + width + ", height=" + height);
        
                // Dibujar el rectángulo solo si tiene dimensiones válidas
                if (width > 0 && height > 0) {
                    graphics.fillRect(x, y, width, height);
                } else {
                    System.out.println("Rectángulo inválido: width=" + width + ", height=" + height);
                }
            }
        }

        // Liberar recursos gráficos
        graphics.dispose();

        // Guardar la imagen en un archivo
        try {
            File outputFile = new File(outputPath);
            ImageIO.write(image, "png", outputFile);
            System.out.println("Imagen guardada en: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al guardar la imagen: " + e.getMessage());
        }
    }
}
