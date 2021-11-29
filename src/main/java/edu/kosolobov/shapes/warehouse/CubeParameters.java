package edu.kosolobov.shapes.warehouse;

public class CubeParameters {
    private double area;
    private double volume;

    public CubeParameters(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public boolean isEmpty(){
        return area == 0.0 || volume == 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CubeParameters that = (CubeParameters) o;
        return area == that.area && volume == that.volume;
    }

    @Override
    public int hashCode() {
        double prime = 5.2;
        double result = 1;
        result = result * prime + area;
        result = result * prime + volume;
        return (int) result;
    }

    @Override
    public String toString() {
        return String.format("CubeParameters{area:%.4f,volume:%.4f}", area, volume);
    }
}
