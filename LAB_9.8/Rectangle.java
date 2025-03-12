/*
 * Author:       Nicolaas tenBroek
 *
 * Student Name:
 *
 */


 class Rectangle {
    private double length;
    private double width;

    Rectangle() {
        length = 0;
        width = 0;
    }

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * length + 2 * width;
    }
}