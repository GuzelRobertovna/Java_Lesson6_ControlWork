package ru.geekbrains.api.lesson6.hw.control;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

public class Notebook {
    private String manufacturer;
    private String model;
    private int ramValue;
    private int hddValue;
    private String os;
    private String color;
    private double diagonal;
    private int price;

    public Notebook(String manufacturer, String model, int ramValue, int hddValue, String os, String color, double diagonal,int price){
        this.manufacturer = manufacturer;
        this.model = model;
        this.ramValue = ramValue;
        this.hddValue = hddValue;
        this.os = os;
        this.color = color;
        this.diagonal = diagonal;
        this.price = price;
    }


//    public int getRamValue() {
//        return ramValue;
//    }
//
//    public int getHddValue() {
//        return hddValue;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public double getDiagonal() {
//        return diagonal;
//    }

    public String toString() {
          return String.format("\nmanufacturer:%s\nmodel:%s\n ramValue:%s\nhddValue:%s\nos:%s\ncolorт:%s\ndiagonal:%s\nprice:%s",
            manufacturer, model, ramValue, hddValue, os, color, diagonal, price);
    }

    public String getInfo(String filter) {

        if (filter.equals("manufacturer")) {
            return manufacturer.toUpperCase();
        }
        if (filter.equals("model")) {
            return model.toUpperCase();
        }
        if (filter.equals("ramValue")) {
            return Integer.toString(ramValue);
        }
        if (filter.equals("hddValue")) {
            return Integer.toString(hddValue);
        }
        if (filter.equals("os")) {
            return os.toUpperCase();
        }
        if (filter.equals("color")) {
            return color.toUpperCase();
        }
        if (filter.equals("diagonal")) {
            return Double.toString(diagonal);
        }
        if (filter.equals("price")) {
            return Integer.toString(price);
        }
        return "";
    }
}
