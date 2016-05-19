/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONSerialization;

import com.google.gson.Gson;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author co075oh
 */
public class JSONSerialization {
    public static void main (String[] args) {
        
        // Object Declaration
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        
        // Declare Vehicle 1 Values
        vehicle1.setMake("Chevrolet");
        vehicle1.setModel("Silverado");
        vehicle1.setYear(2008);
        vehicle1.setVin("2GCEC19J881138304");
        
        // Declare Vehicle 2 Values
        vehicle2.setMake("Honda");
        vehicle2.setModel("Odyssey");
        vehicle2.setYear(2012);
        vehicle2.setVin("5FNRL5H66CB108942");
        
        // Display Vehicle Values
        vehicle1.displayVehicle();
        System.out.println("\n");
        vehicle2.displayVehicle();
        
        // Create Google GSON Object
        Gson vehiclesJSON = new Gson();
        String data1, data2;
        
        // Serialize Vehicles to JSON
        data1 = vehiclesJSON.toJson(vehicle1);
        data2 = vehiclesJSON.toJson(vehicle2);
        
        // Display JSON
        System.out.println(data1);
        System.out.println(data2);
        
        // Save Serialized Data to File
        try (FileOutputStream fops = new FileOutputStream("savedfile.json")) {
            try (ObjectOutputStream output = new ObjectOutputStream(fops)) {
                output.writeObject(data1);
                output.writeObject(data2);
                output.close();
            }
            fops.close();
        } catch (Throwable te) {
            System.out.println("\nException: " + te.toString());
        }
    }
}