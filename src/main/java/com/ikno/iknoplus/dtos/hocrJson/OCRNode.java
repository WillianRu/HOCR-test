package com.ikno.iknoplus.dtos.hocrJson;

public class OCRNode {
    private String id;
    private double x0coordinate;
    private double y0coordinate;
    private double x1coordinate;
    private double y1coordinate;
    private int textAngle;
    private double imageWidth;
    private double imageHeight;

    public void rotateCoordinates() {
        // *Depuracion
        //System.out.println("Antes de la rotación: x0=" + x0coordinate + ", y0=" + y0coordinate + "--- W:" + imageWidth + "--- H:" + imageHeight);
        //System.out.println("Antes de la rotación: x1=" + x1coordinate + ", y1=" + y1coordinate);    

        double currentWidth = imageWidth;
        double currentHeight = imageHeight;

        // Rotar el primer punto (x0, y0)
        double[] rotatedPoint1 = rotatePoint(x0coordinate, y0coordinate, currentWidth, currentHeight);
        this.x0coordinate = rotatedPoint1[0];
        this.y0coordinate = rotatedPoint1[1];

        // Rotar el segundo punto (x1, y1)
        double[] rotatedPoint2 = rotatePoint(x1coordinate, y1coordinate, currentWidth, currentHeight);
        this.x1coordinate = rotatedPoint2[0];
        this.y1coordinate = rotatedPoint2[1];

        // *Depuracion
        //System.out.println("Después de la rotación: x0=" + x0coordinate + ", y0=" + y0coordinate);
        //System.out.println("Después de la rotación: x1=" + x1coordinate + ", y1=" + y1coordinate);


        //!Alternar dimensiones
        //double temp = imageWidth;
        //imageWidth = imageHeight;
        //imageHeight = temp;
    }

    private double[] rotatePoint(double x, double y, double width, double height) {
        double xNew = height - y;
        double yNew = x;
        return new double[]{xNew, yNew};
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getX0coordinate() {
        return this.x0coordinate;
    }

    public void setX0coordinate(double x0coordinate) {
        this.x0coordinate = x0coordinate;
    }

    public double getY0coordinate() {
        return this.y0coordinate;
    }

    public void setY0coordinate(double y0coordinate) {
        this.y0coordinate = y0coordinate;
    }

    public double getX1coordinate() {
        return this.x1coordinate;
    }

    public void setX1coordinate(double x1coordinate) {
        this.x1coordinate = x1coordinate;
    }

    public double getY1coordinate() {
        return this.y1coordinate;
    }

    public void setY1coordinate(double y1coordinate) {
        this.y1coordinate = y1coordinate;
    }

    public void setAllCoordinates(double[] allCoordinates) {
        x0coordinate = allCoordinates[0];
        y0coordinate = allCoordinates[1];
        x1coordinate = allCoordinates[2];
        y1coordinate = allCoordinates[3];
    }

    public int getTextAngle() {
        return textAngle;
    }

    public void setTextAngle(int textAngle) {
        this.textAngle = textAngle;
    }

    // new get and set
    public void setImageWidth(double imageWidth) {
        this.imageWidth = imageWidth;
    }

    public double getImageWidth() {
        return this.imageWidth;
    }

    public void setImageHeight(double imageHeight) {
        this.imageHeight = imageHeight;
    }

    public double getImageHeight() {
        return this.imageHeight;
    }
}