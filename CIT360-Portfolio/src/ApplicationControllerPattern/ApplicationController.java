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
    
    private static final HashMap<String, HandleMath> HASHMAPOFCOMMANDS = new HashMap<>();

    public ApplicationController() {
    }
    
    static {
        HASHMAPOFCOMMANDS.put("+", new Add());
        HASHMAPOFCOMMANDS.put("/", new Divide());
        HASHMAPOFCOMMANDS.put("*", new Multiply());
        HASHMAPOFCOMMANDS.put("^", new PowerOf());
        HASHMAPOFCOMMANDS.put("-", new Subtract());
    }
    
    public void handleCommand(String command, Integer num1, Integer num2) {
        
        HandleMath handler = HASHMAPOFCOMMANDS.get(command);
        
        handler.execute(num1, num2);
        
    }
}
