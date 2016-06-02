/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationControllerPattern;

import java.util.HashMap;

/**
 *
 * @author co075oh
 */
public class ApplicationController {
    
    private static final HashMap<String, HandleMath> hashMapOfCommands = new HashMap<>();

    public ApplicationController() {
    }
    
    static {
        hashMapOfCommands.put("+", new Add());
        hashMapOfCommands.put("/", new Divide());
        hashMapOfCommands.put("*", new Multiply());
        hashMapOfCommands.put("^", new PowerOf());
        hashMapOfCommands.put("-", new Subtract());
    }
    
    public static void handleCommand(String command, Integer num1, Integer num2) {
        
        HandleMath handler = hashMapOfCommands.get(command);
        
        handler.execute(num1, num2);
        
    }
}
