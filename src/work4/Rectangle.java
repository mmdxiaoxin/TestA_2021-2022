package work4;

import java.io.Serializable;

public class Rectangle implements Serializable {
    private double length;
    private double width;

    public Rectangle(double _length, double _width) {
        this.length = _length;
        this.width = _width;
    }

    public double getArea() {
        return length * width;
    }
}
