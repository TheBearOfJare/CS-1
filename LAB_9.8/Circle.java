/*
 * Author:       Nicolaas tenBroek
 *
 * Student Name:
 *
 */


 class Circle {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getArea(double radius) {
        return (Math.pow(radius, 2) * Math.PI);
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    
}