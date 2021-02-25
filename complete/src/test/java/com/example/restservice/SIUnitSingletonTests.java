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
        assertEquals(40, siUnitSingleton.calculate("5*8"), "5*8 should be 40");       
        assertEquals(40, siUnitSingleton.calculate("(5*8)"), "(5*8) should be 40"); 
        assertEquals(240, siUnitSingleton.calculate("(5*8)*(2*3)"), "(5*8)*(2*3) should be 240");   
        assertEquals(10, siUnitSingleton.calculate("(5*8)/(2*2)"),"(5*8)/(2*2) should be 10");     
        assertEquals(24, siUnitSingleton.calculate("(2*8/(1*4))/(1*2)*(3*4)"), "(2*8/(1*4))/(1*2)*(3*4) should be 24");    
        assertEquals(0.66666666666667, siUnitSingleton.calculate("(2/3)"), "(2/3) should be 0.66666666666667");  
        assertEquals(0.33333333333334, siUnitSingleton.calculate("(2/3)/2"), "(2/3)/2 should be 0.33333333333334");  
        assertEquals(0.22222222222223, siUnitSingleton.calculate("(2*4/3)/(2*3)/2"), "(2*4/3)/(2*3)/2 should be 0.22222222222223"); 
        assertEquals(0.00029088820866572, siUnitSingleton.calculate("PI/180/60"),"PI/180/60 should be 0.00029088820866572");           
    }

    @Test
    @DisplayName("Extract mathematical expression from UI string")
    public void testParseCalculateExpression() {
        SIExpressionTuple siExpression = siUnitSingleton.parseSIExpression("(degree/minute)");
        assertEquals("(PI/180/60)", siExpression.getCalculateExpression(), "(degree/minute) shoud be (PI/180/60)");  
        
        
        siExpression = siUnitSingleton.parseSIExpression("(degree/(minute*hectare))");
        assertEquals("(PI/180/(60*10000))", siExpression.getCalculateExpression(), "(degree/(minute*hectare)) shoud be (PI/180/(60*10000))"); 
    }


    @Test
    @DisplayName("Extract si UNIT symbol expression from UI string")
    public void testParseSIUnitSymbolExpression() {
        SIExpressionTuple siExpression = siUnitSingleton.parseSIExpression("(degree/minute)");
        assertEquals("(rad/s)", siExpression.getSIUnitExpression(), "(degree/minute) shoud be (rad/s)");   
        siExpression = siUnitSingleton.parseSIExpression("(degree/(minute*hectare))");
        assertEquals("(rad/(s*m2))", siExpression.getSIUnitExpression(), "(degree/(minute*hectare)) shoud be (rad/(s*m2))");        
    }

}
