/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApplicationControllerPattern;

/**
 *
 * @author co075oh
 */
public class Multiply implements HandleMath {
    
    @Override
    public void execute(Integer num1, Integer num2) {
        Integer sum = num1 * num2;
        System.out.println(sum);
    }
    
}
