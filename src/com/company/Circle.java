package com.company;

public class Circle implements IFigure {

    private double Radius;

    public Circle(double radius){
        Radius = radius;
    }

    public double GetRadius() {
        return Radius;
    }

    public double GetCircleLength(){
        return 2 * Math.PI * Radius;
    }

    @Override
    public String getInfo() {
        return "\nCircle radius: " + Radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(Radius, 2);
    }
}