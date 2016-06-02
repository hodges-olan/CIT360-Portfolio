/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationControllerPattern;

import java.util.Scanner;

/**
 *
 * @author co075oh
 */
public class ApplicationControllerPattern {
    
    public static void main(String[] args) {
        
        // Define Variables
        ApplicationController deligate = new ApplicationController();
        Integer num1, num2;
        String command;
        Scanner in = new Scanner(System.in);
        
        // Gather input
        System.out.println("Enter first number: ");
        num1 = Integer.parseInt(in.nextLine());
        System.out.println("Enter a command (+, -, *, /, ^): ");
        command = in.nextLine();
        System.out.println("Enter second number: ");
        num2 = Integer.parseInt(in.nextLine());
        
        // Perform calculation
        System.out.print(num1 + " " + command + " " + num2 + " = ");
        deligate.handleCommand(command,num1,num2);
        
    }
    
}
