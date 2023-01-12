/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacalculator.logic;

import com.mycompany.javacalculator.logic.Operands.Operand;

/**
 *
 * @author mikayladobson
 */
public class Calculation {
    private double result;
    
    public Calculation(double first, double second, Operand operand) {
        switch (operand) {
            case ADD -> {
                this.result = first + second;
                break;
            }
            case SUBTRACT -> {
                result = first - second;
                break;
            }
            case MULTIPLY -> {
                result = first * second;
                break;
            }
            case DIVIDE -> {
                result = first / second;
                break;
            }
            case EXPONENT -> {
                result = Math.pow(first, second);
                break;
            }
        }
    }

    public double getResult() {
        return this.result;
    }
}
