/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONSerialization;

import java.io.Serializable;

/**
 *
 * @author co075oh
 */
public class Vehicle implements Serializable {
    private String make;
    private String model;
    private int year;
    private String vin;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
    
    public void displayVehicle() {
        System.out.printf("%-10s%-25s%n", "Make:", this.make);
        System.out.printf("%-10s%-25s%n", "Model:", this.model);
        System.out.printf("%-10s%-25s%n", "Year:", this.year);
        System.out.printf("%-10s%-25s%n", "VIN:", this.vin);
    }
}
