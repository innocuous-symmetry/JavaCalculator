/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javacalculator;

import com.mycompany.javacalculator.logic.Calculation;
import com.mycompany.javacalculator.ui.RowFactory;
import com.mycompany.javacalculator.logic.Operands;
import com.mycompany.javacalculator.ui.OpButton;
import com.mycompany.javacalculator.ui.NumButton;
import com.mycompany.javacalculator.ui.ButtonRow;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.mycompany.javacalculator.logic.Operands.Operand;
import java.util.Collection;
import javax.swing.JButton;

/**
 *
 * @author mikayladobson
 */
public class JavaCalculator implements ActionListener {
    private double storedNum = 0;
    private double receivedNum = 0;
    private String receivedData = "";
    private Operand operand = Operand.READ_NEXT;
    private Operand storedOperand = null;
    
    private int wholeNums;
    private int decimalNums;
    
    private final JFrame frame;
    private final JPanel mainPanel;
    
    private final JPanel calculatorScreen;
    private final JLabel numScreenText;
    private final JLabel operandScreenText;
    
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
    private final OpButton btnClear;
    
    public JavaCalculator() {
        frame = new JFrame();
        numScreenText = new JLabel(String.valueOf(storedNum));
        operandScreenText = new JLabel();
        
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        mainPanel.setLayout(new GridLayout(4, 4));
        
        calculatorScreen = new JPanel();
        calculatorScreen.add(numScreenText);
        calculatorScreen.add(operandScreenText);
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
        btnClear = new OpButton(Operand.CLEAR, this);

        NumButton[] numBtns = { btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0 };
        OpButton[] opBtns = { btnPlus, btnMinus, btnMultiply, btnDivide, btnExponent, btnEquals, btnDecimal, btnClear };

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
        // get the object declaration and label of the event source
        JButton source = (JButton)e.getSource();
        String targetValue = source.getText();
        String concatenatedNums = "";
        
        if (source instanceof NumButton) {
            // while decimal mode is active, only add digits after decimal place
            // to do: limit to x number of decimal places?
            if (this.operand == Operand.DECIMAL) {
                if (decimalNums == 0) {
                    concatenatedNums = String.valueOf(targetValue);
                } else {
                    concatenatedNums = String.valueOf(decimalNums) + String.valueOf(targetValue);
                }
                
                decimalNums = Integer.parseInt(concatenatedNums);
            } else {
                if (wholeNums == 0) {
                    concatenatedNums = String.valueOf(targetValue);
                } else {
                    concatenatedNums = String.valueOf(wholeNums) + String.valueOf(targetValue);
                }
                
                wholeNums = Integer.parseInt(concatenatedNums);
            }
            
            storedNum = (float)wholeNums + (float)(decimalNums / 100);
        } else if (source instanceof OpButton) {
            OpButton opButton = (OpButton)source;
            this.operand = opButton.getOperand();
            
            switch (this.operand) {
                case CLEAR -> {
                    storedNum = 0;
                    wholeNums = 0;
                    decimalNums = 0;
                    this.operand = null;
                    operandScreenText.setText("");
                    break;
                }
                case EQUALS -> {
                    String resultAsString = String.valueOf(storedNum) + " " + String.valueOf(receivedNum) + " " + String.valueOf(storedNum + receivedNum);
                    operandScreenText.setText(resultAsString);
                    
                    double result = new Calculation(receivedNum, storedNum, this.storedOperand).getResult();
                    storedNum = result;
                    receivedNum = 0;
                    
                    int idxOfDecimal = resultAsString.indexOf('.');
                    wholeNums = Integer.parseInt(resultAsString.substring(0, idxOfDecimal));
                    decimalNums = Integer.parseInt(resultAsString.substring(idxOfDecimal + 1));
                    this.operand = Operand.READ_NEXT;
                    break;
                }
                case DECIMAL, READ_NEXT -> {
                    break;
                }
                default -> {
                    receivedNum = storedNum;
                    storedNum = 0;
                    wholeNums = 0;
                    decimalNums = 0;
                    this.storedOperand = this.operand;
                    this.operand = Operand.READ_NEXT;
                    break;
                }
            }
        }
        
        
        // numScreenText.setText(String.valueOf(storedNum));
        numScreenText.setText(String.format("%s.%s", wholeNums, decimalNums));
        
        if (this.operand == null) {
            storedNum = 0;
            wholeNums = 0;
            decimalNums = 0;
            this.storedOperand = null;
        }
    }
}
