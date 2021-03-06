/**
 * @name        Simple Java Calculator
 * @file        UI.java
 * @author      SORIA Pierre-Henry
 * @copyright   Copyright Pierre-Henry SORIA, All Rights Reserved.
 * @license     Apache (http://www.apache.org/licenses/LICENSE-2.0)
 */

package com.simplejavacalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;


import java.io.*;

public class UI implements ActionListener {
   /*make fields of class UI*/
   // make frame
   private final JFrame frame;

   // make panel
   private final JPanel panel;
   private final JPanel panelSub1;
   private final JPanel panelSub2;
   private final JPanel panelSub3;
   private final JPanel panelSub4;
   private final JPanel panelSub5;
   private final JPanel panelSub6;
   private final JPanel panelSub7;
   private final JPanel panelSub8;

   // make text and buttons
   private final JTextArea text;
   private final JButton[] but;
   private final JButton butAdd;
   private final JButton butMinus;
   private final JButton butMultiply;
   private final JButton butDivide;
   private final JButton butEqual;
   private final JButton butCancel;
   private final JButton butSquareRoot;
   private final JButton butSquare;
   private final JButton butOneDevidedBy;
   private final JButton butCos;
   private final JButton butSin;
   private final JButton butTan;
   private final JButton butxpowerofy;
   private final JButton butlog;
   private final JButton butrate;
   private final JButton butabs;
   private final JButton butBinary;
   private final Calculator calc;
   
   private final static String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6",
      "7", "8", "9"};

   //font
   private final Font font;
   private final Font textFont;

   //constructor for class UI
   public UI() throws IOException {
      //set frame and panel
      frame = new JFrame("Calculator PH");

      
      panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
      panelSub1 = new JPanel(new FlowLayout());
      panelSub2 = new JPanel(new FlowLayout());
      panelSub3 = new JPanel(new FlowLayout());
      panelSub4 = new JPanel(new FlowLayout());
      panelSub5 = new JPanel(new FlowLayout());
      panelSub6 = new JPanel(new FlowLayout());
      panelSub7 = new JPanel(new FlowLayout());
      panelSub8 = new JPanel(new FlowLayout());

      //set font
      font = new Font("Consolas",Font.PLAIN, 18);
      
      text = new JTextArea(1, 10);
      
      textFont = new Font("Consolas",Font.BOLD, 24);

      //set button
      but = new JButton[10];      
      for (int i = 0; i < 10; i++) {
         but[i] = new JButton(String.valueOf(i));
      }      
      butAdd = new JButton("+");      
      butMinus = new JButton("-");      
      butMultiply = new JButton("*");      
      butDivide = new JButton("/");      
      butEqual = new JButton("=");      
      butSquareRoot = new JButton("sqrt");      
      butSquare = new JButton("x*x");      
      butOneDevidedBy = new JButton("1/x");      
      butCos = new JButton("Cos");      
      butSin = new JButton("Sin");      
      butTan = new JButton("Tan");      
      butxpowerofy = new JButton("x^y");      
      butlog = new JButton("log10(x)");      
      butrate = new JButton("x%");      
      butabs = new JButton("abs(x)");      
      butCancel = new JButton("C");      
      butBinary = new JButton("Bin");      

      //initialize calculator
      calc = new Calculator();
      
   }

   //initialize UI
   public void init() {
      // set frame
      frame.setSize(450, 450);
      frame.setVisible(true);
      frame.setLocationRelativeTo(null); 
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

      // set font
      text.setFont(textFont);
      text.setEditable(false);

      // apply font on buttons
      for (int i = 0; i < 10; i++) {
         but[i].setFont(font);
      }      
      butAdd.setFont(font);
      butMinus.setFont(font);
      butMultiply.setFont(font);
      butDivide.setFont(font);
      butEqual.setFont(font);
      butSquareRoot.setFont(font);
      butSquare.setFont(font);
      butOneDevidedBy.setFont(font);
      butCos.setFont(font);
      butSin.setFont(font);
      butTan.setFont(font);
      butxpowerofy.setFont(font);
      butlog.setFont(font);
      butrate.setFont(font);
      butabs.setFont(font);
      butCancel.setFont(font);
      butBinary.setFont(font); 

      // set panel and locate buttons
      panel.add(Box.createHorizontalStrut(100));
      panelSub1.add(text);
      panel.add(panelSub1);
      
      panelSub2.add(but[1]);
      panelSub2.add(but[2]);
      panelSub2.add(but[3]);
      panelSub2.add(Box.createHorizontalStrut(15));
      panelSub2.add(butAdd);
      panelSub2.add(butMinus);
      panel.add(panelSub2);
      
      panelSub3.add(but[4]);
      panelSub3.add(but[5]);
      panelSub3.add(but[6]);
      panelSub3.add(Box.createHorizontalStrut(15));
      panelSub3.add(butMultiply);
      panelSub3.add(butDivide);      
      panel.add(panelSub3);
      
      panelSub4.add(but[7]);
      panelSub4.add(but[8]);
      panelSub4.add(but[9]);
      panelSub4.add(Box.createHorizontalStrut(15));
      panelSub4.add(butEqual);
      panelSub4.add(butCancel);
      panel.add(panelSub4);
      
      panelSub5.add(but[0]);
      panelSub5.add(Box.createHorizontalStrut(210));
      panel.add(panelSub5);
      
      panelSub6.add(butSquare);
      panelSub6.add(butSquareRoot);
      panelSub6.add(butOneDevidedBy);
      panelSub6.add(butxpowerofy);
      panel.add(panelSub6);
      
      panelSub7.add(butCos);
      panelSub7.add(butSin);
      panelSub7.add(butTan);
      panel.add(panelSub7);
      
      panelSub8.add(butlog);
      panelSub8.add(butrate);
      panelSub8.add(butabs);
      panelSub8.add(butBinary);
      panel.add(panelSub8);

      //add action to the buttons
      for (int i = 0; i < 10; i++) {
         but[i].addActionListener(this);
      }      
      butAdd.addActionListener(this);
      butMinus.addActionListener(this);
      butMultiply.addActionListener(this);
      butDivide.addActionListener(this);
      butSquare.addActionListener(this);
      butSquareRoot.addActionListener(this);
      butOneDevidedBy.addActionListener(this);
      butCos.addActionListener(this);
      butSin.addActionListener(this);
      butTan.addActionListener(this);
      butxpowerofy.addActionListener(this);
      butlog.addActionListener(this);
      butrate.addActionListener(this);
      butabs.addActionListener(this);
      butBinary.addActionListener(this);
      
      butEqual.addActionListener(this);
      butCancel.addActionListener(this);

      //add panel to frame
      frame.add(panel);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      //determine which action should occur
      final Object source = e.getSource();
      
      for (int i = 0; i < 10; i++) {
         if (source == but[i]) {
            text.replaceSelection(buttonValue[i]);
            return;
         }
      }
      
      if (source == butAdd) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.ADD, reader()));
      }
      
      if (source == butMinus) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.MINUS, reader()));
      }
      
      if (source == butMultiply) {
         writer(calc.calculateBi(Calculator.BiOperatorModes.MULTIPLY,
                                 reader()));
      }
      
      if (source == butDivide) {
         writer(calc
                   .calculateBi(Calculator.BiOperatorModes.DIVIDE, reader()));
      }
      if (source == butxpowerofy) {
         writer(calc
                   .calculateBi(Calculator.BiOperatorModes.XPOWEROFY, reader()));
      }
      
      if (source == butSquare) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.SQUARE,
                                   reader()));
      }
      
      if (source == butSquareRoot) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.SQUAREROOT,
                                   reader()));
      }
      
      if (source == butOneDevidedBy) {
         writer(calc.calculateMono(
                                   Calculator.MonoOperatorModes.ONEDEVIDEBY, reader()));
      }
      
      if (source == butCos) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.COS,
                                   reader()));
      }
      
      if (source == butSin) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.SIN,
                                   reader()));
      }
      
      if (source == butTan) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.TAN,
                                   reader()));
      }
      if (source == butlog) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.LOG,
                                   reader()));
      }
      if (source == butrate) {
         writer(calc.calculateMono(Calculator.MonoOperatorModes.RATE,
                                   reader()));
      }
      if(source == butabs){
         writer(calc.calculateMono(Calculator.MonoOperatorModes.ABS, reader()));
      }
      
      if (source == butEqual) {
         writer(calc.calculateEqual(reader()));
      }
      
      if (source == butCancel) {
         writer(calc.reset());
      }
      
      if (source == butBinary) {
         parsetoBinary();
      }
      
      text.selectAll();
   }
   
   private void parsetoBinary() {
      try {
         text.setText("" + Long.toBinaryString(Long.parseLong(text.getText())));
      } catch (NumberFormatException ex) {
         System.err.println("Error while parse to binary." + ex.toString());
      }
   }
   
   public Double reader() {
      //read data in display and parse to Double
      Double num;
      String str;
      str = text.getText();
//      if the string is empty, then it will raise exception but now it is not handled yet
      num = Double.valueOf(str);

      return num;
   }
   
   public void writer(final Double num) {
      //write text on display of calculator
      if (Double.isNaN(num)) {
         text.setText("");
      } else {
         text.setText(Double.toString(num));
      }
   }
}
