/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacalculator;

import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JButton;

/**
 *
 * @author mikayladobson
 */
public class RowFactory {
    private Collection<ButtonRow> allRows;
    
    public RowFactory() {
        allRows = new ArrayList<ButtonRow>();
    }
    
    public RowFactory(JButton[] btns) {
        setRows(btns);
    }
    
    public void setRows(JButton[] btns) {
        allRows = new ArrayList<ButtonRow>();
        int remaining = 0;
        
        while (remaining < btns.length) {
            ButtonRow product = new ButtonRow();
            
            int i = 0;
            while (remaining < btns.length && i < 3) {
                product.add(btns[remaining]);
                remaining++;
                i++;
            }
            
            allRows.add(product);
        }
    }
    
    public Collection<ButtonRow> getRows() {
        return this.allRows;
    }
}
