/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSONSerialization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author co075oh
 */
public class VehicleServer {
    
    public static void main(String[] args) throws IOException {
        boolean complete = false;
        try (ServerSocket listener = new ServerSocket(8888)) {
            while (!complete) {
                try (Socket socket = listener.accept()) {
                    BufferedReader input = 
                            new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("savedfile.json"))) {
                        bw.write(input.readLine());
                        bw.newLine();
                        bw.write(input.readLine());
                        bw.close();
                        complete = true;
                    } catch (Throwable te) {
                        System.out.println("\nException: " + te.toString());
                    }
                }
            
                try (Socket socket = listener.accept()) {
                    try (BufferedReader br = new BufferedReader(new FileReader("savedfile.json"))) {
                        PrintWriter out = 
                                new PrintWriter(socket.getOutputStream(), true);
                        out.println(br.readLine());
                        out.println(br.readLine());
                    } catch (Throwable te) {
                        System.out.println("\nException: " + te.toString());
                    }
                }
            }
        }
    }
    
}
