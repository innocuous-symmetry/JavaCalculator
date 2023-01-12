/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacalculator.ui;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author mikayladobson
 */
public class ButtonRow extends JPanel {
    public ButtonRow() {}
    
    public ButtonRow(JButton btn) {
        addToRow(btn);
    }
    
    public ButtonRow(JButton[] buttons) {
        addToRow(buttons);
    }
    
    public void addToRow(JButton btn) {
        this.add(btn);
    }
    
    public void addToRow(JButton[] buttons) {
        for (JButton btn : buttons) {
            this.add(btn);
        }
    }
}
