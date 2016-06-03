/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONSerialization;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author co075oh
 */
public class VehicleClient {
    public static void main (String[] args) throws IOException, InterruptedException {
        
        // Object Declaration
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        
        // Declare Vehicle 1 Values
        vehicle1.setMake("Chevrolet");
        vehicle1.setModel("Silverado");
        vehicle1.setYear(2008);
        vehicle1.setVin("2GCEC19J881138304");
        vehicle1.setColor("Grey");
        
        // Declare Vehicle 2 Values
        vehicle2.setMake("Honda");
        vehicle2.setModel("Odyssey");
        vehicle2.setYear(2012);
        vehicle2.setVin("5FNRL5H66CB108942");
        vehicle2.setColor("White");
        
        // Display Vehicle Values
        System.out.println("Vehicle Data Before JSON Serialization");
        System.out.println("======================================");
        System.out.println("Vehicle 1");
        vehicle1.displayVehicle();
        System.out.print("\n");
        System.out.println("Vehicle 2");
        vehicle2.displayVehicle();
        
        // Create Google GSON Object
        Gson vehiclesJSON = new Gson();
        String data1, data2;
        
        // Serialize Vehicles to JSON
        data1 = vehiclesJSON.toJson(vehicle1);
        data2 = vehiclesJSON.toJson(vehicle2);
        
        // Display JSON
        System.out.println("\n\nJSON Serialization of Vehicle Data");
        System.out.println("==================================");
        System.out.println(data1);
        System.out.println(data2);
        
        // Save Serialized Data to Server
        String server = "127.0.0.1";
        int port = 8888;
        try (Socket socket = new Socket(server, port);
                BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            output.write(data1);
            output.newLine();
            output.write(data2);
        }
        
        // Delay read execution
        TimeUnit.SECONDS.sleep(1);
        
        // Retrieve Serialized Data from Server
        String newData1;
        String newData2;
        try (Socket socket = new Socket(server, port);
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            newData1 = input.readLine();
            newData2 = input.readLine();
        }
        
        // Display JSON
        System.out.println("\n\nJSON Serialized data retrieve from file");
        System.out.println("=======================================");
        System.out.println(newData1);
        System.out.println(newData2);
        
        // Deserialize Vehicles
        Vehicle newVehicle1 = vehiclesJSON.fromJson(newData1, Vehicle.class);
        Vehicle newVehicle2 = vehiclesJSON.fromJson(newData2, Vehicle.class);
        
        // Display Vehicle Values
        System.out.println("\n");
        System.out.println("Vehicle Data after JSON Serialization Retrieval");
        System.out.println("===============================================");
        System.out.println("New Vehicle 1");
        newVehicle1.displayVehicle();
        System.out.print("\n");
        System.out.println("New Vehicle 2");
        newVehicle2.displayVehicle();
    }
}