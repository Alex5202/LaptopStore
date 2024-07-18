import java.util.Objects;

public class Laptop {
    private String brand;
    private int ram;
    private int hddCapacity;
    private String os;
    private String color;

    public Laptop(String brand, int ram, int hddCapacity, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.hddCapacity = hddCapacity;
        this.os = os;
        this.color = color;
    }

    // Геттеры
    public String getBrand() { return brand; }
    public int getRam() { return ram; }
    public int getHddCapacity() { return hddCapacity; }
    public String getOs() { return os; }
    public String getColor() { return color; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram &&
                hddCapacity == laptop.hddCapacity &&
                Objects.equals(brand, laptop.brand) &&
                Objects.equals(os, laptop.os) &&
                Objects.equals(color, laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, ram, hddCapacity, os, color);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", hddCapacity=" + hddCapacity +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
