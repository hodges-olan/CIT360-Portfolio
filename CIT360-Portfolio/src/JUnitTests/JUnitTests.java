package JUnitTests;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author co075oh
 */
public class JUnitTests {
    
    public JUnitTests() {
    }
    
    public static void main(String[] args) {
        testReduceHealthNormal();
    }
    
    /**
     * Test of reduceHealthNormal method, of class BattleControl.
     */
    @Test
    public static void testReduceHealthNormal() {
        System.out.println("\nreduceHealthNormal");
        
        // Declare variables
        double result, weapon, strength, armor, expResult;
        BattleControl instance = new BattleControl();
        
        /********************************
         * Test Case #1
         */
            // Declare test input and expected output
            weapon = 8.0;
            strength = 4.0;
            armor = 20.0;
            expResult = 12.0;
            
            // Execute and Verify function
            System.out.println("\tTest case #1");
            result = instance.reduceHealthNormal(weapon, strength, armor);
            assertEquals(expResult, result, 0.0);
            
        /********************************
         * Test Case #2
         */
            // Declare test input and expected output
            weapon = -1.0;
            strength = 10.0;
            armor = 10.0;
            expResult = -1.0;
            
            // Execute and Verify function
            System.out.println("\tTest case #2");
            result = instance.reduceHealthNormal(weapon, strength, armor);
            assertEquals(expResult, result, 0.0);
            
        /********************************
         * Test Case #3
         */
            // Declare test input and expected output
            weapon = 10.0;
            strength = -1.0;
            armor = 5.0;
            expResult = -1.0;
            
            // Execute and Verify function
            System.out.println("\tTest case #3");
            result = instance.reduceHealthNormal(weapon, strength, armor);
            assertEquals(expResult, result, 0.0);
            
        /********************************
         * Test Case #4
         */
            // Declare test input and expected output
            weapon = 4.0;
            strength = 6.0;
            armor = -1.0;
            expResult = -1.0;
            
            // Execute and Verify function
            System.out.println("\tTest case #4");
            result = instance.reduceHealthNormal(weapon, strength, armor);
            assertEquals(expResult, result, 0.0);
            
        /********************************
         * Test Case #5
         */
            // Declare test input and expected output
            weapon = 0.0;
            strength = 12.0;
            armor = 7.0;
            expResult = -1.0;
            
            // Execute and Verify function
            System.out.println("\tTest case #5");
            result = instance.reduceHealthNormal(weapon, strength, armor);
            assertEquals(expResult, result, 0.0);
            
        /********************************
         * Test Case #6
         */
            // Declare test input and expected output
            weapon = 9.0;
            strength = 0.0;
            armor = 3.0;
            expResult = -1.0;
            
            // Execute and Verify function
            System.out.println("\tTest case #6");
            result = instance.reduceHealthNormal(weapon, strength, armor);
            assertEquals(expResult, result, 0.0);
            
        /********************************
         * Test Case #7
         */
            // Declare test input and expected output
            weapon = 3.0;
            strength = 2.0;
            armor = 0.0;
            expResult = -1.0;
            
            // Execute and Verify function
            System.out.println("\tTest case #7");
            result = instance.reduceHealthNormal(weapon, strength, armor);
            assertEquals(expResult, result, 0.0);
            
        /********************************
         * Test Case #8
         */
            // Declare test input and expected output
            weapon = 1.0;
            strength = 8.0;
            armor = 2.0;
            expResult = 6.0;
            
            // Execute and Verify function
            System.out.println("\tTest case #8");
            result = instance.reduceHealthNormal(weapon, strength, armor);
            assertEquals(expResult, result, 0.0);
            
        /********************************
         * Test Case #9
         */
            // Declare test input and expected output
            weapon = 11.0;
            strength = 1.0;
            armor = 7.0;
            expResult = 4.0;
            
            // Execute and Verify function
            System.out.println("\tTest case #9");
            result = instance.reduceHealthNormal(weapon, strength, armor);
            assertEquals(expResult, result, 0.0);
            
        /********************************
         * Test Case #10
         */
            // Declare test input and expected output
            weapon = 10.0;
            strength = 8.0;
            armor = 1.0;
            expResult = 79.0;
            
            // Execute and Verify function
            System.out.println("\tTest case #10");
            result = instance.reduceHealthNormal(weapon, strength, armor);
            assertEquals(expResult, result, 0.0);
        
    }

    private static class BattleControl {

        public BattleControl() {
        }

        private double reduceHealthNormal(double weapon, double strength, double armor) {
            // Declare variables
            double damage;

            // Validation Checks
            if(weapon <= 0 || strength <= 0 || armor <= 0) {
                return -1.0;
            }

            // Calculate damage
            damage = (weapon * strength) - armor;

            // Return values
            return Math.round(damage);
        }
    }

}
