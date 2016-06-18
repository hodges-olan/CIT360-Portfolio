/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadsExecutorsRunnablesHandlers;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author co075oh
 */
public class ThreadsExecutorsRunnablesHandlers {
    public static int threadCount = 4;
    public static int stop = 800000;
    
    public static void main(String[] args) {
        
        // Declare attributes
        ArrayList<Integer> primes = new ArrayList<>();
        int incrementAmount = stop/threadCount;
        int starting = 1;
        
        // Output starting message
        System.out.println("Spawning threads...");
        
        // Create and Start Threads
        for (int i = 0; i < threadCount; i++) {
            (new Thread(new PrimeThread(starting, starting+incrementAmount, i + ".txt"))).start();
        }
        
        // Combine results from each thread into a single ArrayList
        for (int i = 0; i < threadCount; i++) {
            File f = new File(i+".txt");
            try (Scanner scan = new Scanner(new File(i+".txt"))) {
                while (scan.hasNextInt()) {
                    primes.add(scan.nextInt());
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ThreadsExecutorsRunnablesHandlers.class.getName()).log(Level.SEVERE, null, ex);
            }
            f.delete();
        }
        
        // Output the results from the ArrayList to a file
        try (PrintWriter print = new PrintWriter(new File("primes.txt"))) {
            for (Integer prime : primes) {
                print.println(prime);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
