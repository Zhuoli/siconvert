package com.example.restservice;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SIUnitSingleton {
    private static SIUnitSingleton instance =null;
    private  HashMap<String, String> convertMap = null;
    private SIUnitSingleton(){
        // this.convertMap = Map.ofEntries(
        //     new AbstractMap.SimpleEntry<String, SIUnit>("minute", new SIUnit("s",60)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("min", new SIUnit("s",60)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("hour", new SIUnit("s",3600)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("h", new SIUnit("s",3600)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("day", new SIUnit("s",86400)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("d", new SIUnit("s",86400)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("degree", new SIUnit("rad",Math.PI/180)),
        //     new AbstractMap.SimpleEntry<String, SIUnit>("°", new SIUnit("rad",Math.PI/180))
        // );
    }

    // public SIUnit convert2SIUnit(String unitName){
    //     return this.convertMap.get(unitName);
    // }

    public static SIUnitSingleton getInstance(){
        if (instance==null){
            instance = new SIUnitSingleton();
        }
        return instance;
    }

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0; // For the on-going result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {

                // Forming operand, since it could be more than one digit
                operand = 10 * operand + (int) (ch - '0');

            } else if (ch == '+') {

                // Evaluate the expression to the left,
                // with result, sign, operand
                result += sign * operand;

                // Save the recently encountered '+' sign
                sign = 1;

                // Reset operand
                operand = 0;

            } else if (ch == '-') {

                result += sign * operand;
                sign = -1;
                operand = 0;

            } else if (ch == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1;
                result = 0;

            } else if (ch == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * operand;

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();

                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();

                // Reset the operand
                operand = 0;
            }
        }
        return result + (sign * operand);
    }


    public int calculate2(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 1; // For the on-going result
        int sign = 1; //  1 means * -1 means /  

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {

                // Forming operand, since it could be more than one digit
                operand = 10 * operand + (int) (ch - '0');

            } else if (ch == '*') {

                sign=1;
                // Evaluate the expression to the left,
                // with result, sign, operand
                if (operand!=0){
                    if (sign==1){
                        result = result * operand;
                    }else{
                        result = result / operand;
                    }
                    // Reset operand
                    operand = 0;
                }

            } else if (ch == '/') {
                sign=-1;
                if (operand!=0){
                    if (sign==1){
                        result = result * operand;
                    }else{
                        result = result / operand;
                    }
                    operand = 0;
                }

            } else if (ch == '(') {

                // Push the result and sign on to the stack, for later
                // We push the result first, then sign
                stack.push(result);
                stack.push(sign);

                // Reset operand and result, as if new evaluation begins for the new sub-expression
                result = 1;

            } else if (ch == ')') {

                // Evaluate the expression to the left
                // with result, sign and operand
                if (sign==1){
                    result = result * operand;
                }else{
                    result = result / operand;
                }

                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                sign = stack.pop();
                if (sign==1){
                    result = stack.pop() * result ;
                }else{
                    result = stack.pop() / result;
                }
                // Reset the operand
                operand = 0;
            }
        }
        if (operand==0){
            operand=1;
        }
        if (sign==1){
            result = result * operand;
        }else{
            result = result / operand;
        }
        return result;
    }
}