package com.example.restservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class SIUnitSingletonTests {

    private SIUnitSingleton siUnitSingleton;
    @BeforeEach                                         
    public void setUp() throws Exception {
        siUnitSingleton = SIUnitSingleton.getInstance();
    }

    @Test                                               
    @DisplayName("Simple multiplication should work")   
    public void testMultiply() {
        assertEquals(40, siUnitSingleton.calculate("5*8"),      
        "5*8 should be 40");          
    }


    @Test                                               
    @DisplayName("Simple multiplication with parenthesis should work")   
    public void testMultiplyParenthesis() {
        assertEquals(40, siUnitSingleton.calculate("(5*8)"),      
        "(5*8) should be 40");          
    }

    @Test                                               
    @DisplayName("Simple multiplication with 2 parenthesis should work")   
    public void testMultiplyParenthesis2() {
        assertEquals(240, siUnitSingleton.calculate("(5*8)*(2*3)"),      
        "(5*8)*(2*3) should be 240");          
    }

    @Test                                               
    @DisplayName("multiplication and division with 2 parenthesis should work")   
    public void testMultiplyAndDivision() {
        assertEquals(10, siUnitSingleton.calculate("(5*8)/(2*2)"),      
        "(5*8)/(2*2) should be 10");          
    }

    @Test                                               
    @DisplayName("multiplication and division with nested parenthesis should work")   
    public void testMultiplyAndDivision2() {
        assertEquals(24, siUnitSingleton.calculate("(2*8/(1*4))/(1*2)*(3*4)"),      
        "(2*8/(1*4))/(1*2)*(3*4) should be 24");          
    }
}
