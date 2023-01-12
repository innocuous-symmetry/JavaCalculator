/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacalculator.ui;
import com.mycompany.javacalculator.JavaCalculator;
import javax.swing.JButton;

/**
 *
 * @author mikayladobson
 */
public class NumButton extends JButton {
    private static int btnValue;
    
    public NumButton(int btnValue, JavaCalculator calculator) {
        this.btnValue = btnValue;
        this.addActionListener(calculator);
        this.setText(String.valueOf(btnValue));
    }
    
    public int getValue() {
        return this.btnValue;
    }
}
