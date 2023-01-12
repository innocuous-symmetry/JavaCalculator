/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javacalculator;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.mycompany.javacalculator.Operands.Operand;
import java.util.Collection;
import javax.swing.JButton;

/**
 *
 * @author mikayladobson
 */
public class JavaCalculator implements ActionListener {
    private float storedNum = 0;
    private float receivedNum = 0;
    private String receivedData = "";
    private Operand operand = null;
    
    private final JFrame frame;
    private final JPanel mainPanel;
    
    private final JPanel calculatorScreen;
    private final JLabel screenText;
    
    private final NumButton btn1;
    private final NumButton btn2;
    private final NumButton btn3;
    private final NumButton btn4;
    private final NumButton btn5;
    private final NumButton btn6;
    private final NumButton btn7;
    private final NumButton btn8;
    private final NumButton btn9;
    private final NumButton btn0;
    
    private final OpButton btnPlus;
    private final OpButton btnMinus;
    private final OpButton btnMultiply;
    private final OpButton btnDivide;
    private final OpButton btnExponent;
    private final OpButton btnEquals;
    private final OpButton btnDecimal;
    
    public JavaCalculator() {
        frame = new JFrame();
        screenText = new JLabel("Initial value");
        
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        mainPanel.setLayout(new GridLayout(4, 4));
        
        calculatorScreen = new JPanel();
        calculatorScreen.add(screenText);
        calculatorScreen.setBackground(Color.GRAY);
        
        mainPanel.add(calculatorScreen);
        
        btn1 = new NumButton(1, this);
        btn2 = new NumButton(2, this);
        btn3 = new NumButton(3, this);        
        btn4 = new NumButton(4, this);
        btn5 = new NumButton(5, this);
        btn6 = new NumButton(6, this);        
        btn7 = new NumButton(7, this);
        btn8 = new NumButton(8, this);
        btn9 = new NumButton(9, this);
        btn0 = new NumButton(0, this);
        
        btnPlus = new OpButton(Operand.ADD, this);
        btnMinus = new OpButton(Operand.SUBTRACT, this);
        btnMultiply = new OpButton(Operand.MULTIPLY, this);
        btnDivide = new OpButton(Operand.DIVIDE, this);
        btnExponent = new OpButton(Operand.EXPONENT, this);
        btnEquals = new OpButton(Operand.EQUALS, this);
        btnDecimal = new OpButton(Operand.DECIMAL, this);

        NumButton[] numBtns = { btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0 };
        OpButton[] opBtns = { btnPlus, btnMinus, btnMultiply, btnDivide, btnExponent, btnEquals, btnDecimal };

        RowFactory rowFactory = new RowFactory(numBtns);
        Collection<ButtonRow> btnRows = rowFactory.getRows();
                
        for (ButtonRow row : btnRows) {
            mainPanel.add(row);
        }
        
        rowFactory.setRows(opBtns);
        btnRows = rowFactory.getRows();
        
        for (ButtonRow row : btnRows) {
            mainPanel.add(row);
        }
        
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
        JButton source = (JButton)e.getSource();
        screenText.setText(source.getText());
    }
}
