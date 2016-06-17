/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreadsExecutorsRunnablesHandlers;

import java.util.*;
import java.io.*;

/**
 *
 * @author co075oh
 */
public class PrimeThread implements Runnable {
    
    // Declare attributes
    int start;
    int stop;
    String file;
    
    
   // Constructor Method
    public PrimeThread(int startValue, int stopValue, String filename) {
        start = startValue;
        stop = stopValue;
        file = filename;
    }
    
    // Run method override
    @Override
    public void run() {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = start; i <= stop; i+=2) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        try (PrintWriter print = new PrintWriter(new File(file))) {
            for (Integer prime : primes) {
                print.println(prime);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    // Method to determine if the number is prime
    public static boolean isPrime(int toTest) {
        if (toTest == 2) {
            return true;
        }
        for (int n = 3; n < toTest; n+=2) {
            if (toTest%n==0) {
                return false;
            }
        }
        return true;
    }
}
