/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javacalculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mikayladobson
 */
public class JavaCalculator implements ActionListener {
    private final JFrame frame;
    private final JLabel label;
    private final JPanel mainPanel;
    
    private final NumButton btn1;
    private final NumButton btn2;
    private final NumButton btn3;
    
    public JavaCalculator() {
        frame = new JFrame();
        label = new JLabel("Initial value");
        
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        mainPanel.setLayout(new GridLayout(4, 4));        
        mainPanel.add(label);
        
        btn1 = new NumButton(1, this);
        btn2 = new NumButton(2, this);
        btn3 = new NumButton(3, this);
        
        mainPanel.add(btn1);
        mainPanel.add(btn2);
        mainPanel.add(btn3);
        
        frame.add(mainPanel);
        frame.setTitle("Calculator");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JavaCalculator();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        NumButton source = (NumButton)e.getSource();
        label.setText(source.getText());
    }
}
