/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacalculator;

/**
 *
 * @author mikayladobson
 */
public class Operands {
    public enum Operand {
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EXPONENT,
        EQUALS, DECIMAL
    }
    
    public static String toLabel(Operand input) {
        switch (input) {
            case ADD -> {
                return "+";
            }
            case SUBTRACT -> {
                return "-";
            }
            case MULTIPLY -> {
                return "*";
            }
            case DIVIDE -> {
                return "/";
            }
            case EXPONENT -> {
                return "^";
            }
            case DECIMAL -> {
                return ".";
            }
            case EQUALS -> {
                return "=";
            }
            default -> {
                throw new Error("Invalid operand input");
            }
        }
    }
}
