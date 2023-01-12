/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacalculator.ui;

import com.mycompany.javacalculator.JavaCalculator;
import com.mycompany.javacalculator.logic.Operands;
import javax.swing.JButton;
import com.mycompany.javacalculator.logic.Operands.Operand;

/**
 *
 * @author mikayladobson
 */
public class OpButton extends JButton {
    private final Operand operand;
    
    public OpButton(Operand operand, JavaCalculator calculator) {
        this.operand = operand;
        this.addActionListener(calculator);
        this.setText(Operands.toLabel(operand));
    }
    
    public Operand getOperand() {
        return operand;
    }
}
