/**
 * AppletRunner.java 1.0 Oct 19, 2015
 * 
 * Copyright (c) 2015 Matthew Bloom. All Rights Reserved
 */
package edu.elon.applet;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Enter summary here
 * 
 * @author Matthew Bloom
 * @version 1.0
 *
 */
public class AppletRunner extends JApplet {

  public double currentValue = 0;
  public String currentCalc = "";
  public String runningValue = "";
  public JTextField field;
  public boolean numberDone = false;
  public boolean decimalWaiting = false;

  @Override
  public void destroy() {

  }

  @Override
  public void init() {
    NumberListener num = new NumberListener();
    CalcListener calc = new CalcListener();
    JPanel buttonPanel = new JPanel();
    JPanel fieldPanel = new JPanel();
    field = new JTextField();
    fieldPanel.setLayout(new GridLayout(0, 1));
    fieldPanel.add(field);
    buttonPanel.setLayout(new GridLayout(4, 3));
    JButton button0 = new JButton("0");
    button0.addActionListener(num);
    JButton button1 = new JButton("1");
    button1.addActionListener(num);
    JButton button2 = new JButton("2");
    button2.addActionListener(num);
    JButton button3 = new JButton("3");
    button3.addActionListener(num);
    JButton button4 = new JButton("4");
    button4.addActionListener(num);
    JButton button5 = new JButton("5");
    button5.addActionListener(num);
    JButton button6 = new JButton("6");
    button6.addActionListener(num);
    JButton button7 = new JButton("7");
    button7.addActionListener(num);
    JButton button8 = new JButton("8");
    button8.addActionListener(num);
    JButton button9 = new JButton("9");
    button9.addActionListener(num);
    JButton buttonDecimal = new JButton(".");
    buttonDecimal.addActionListener(calc);
    JButton buttonEquals = new JButton("=");
    buttonEquals.addActionListener(calc);
    JButton buttonPlus = new JButton("+");
    buttonPlus.addActionListener(calc);
    JButton buttonDivide = new JButton("/");
    buttonDivide.addActionListener(calc);
    JButton buttonMult = new JButton("*");
    buttonMult.addActionListener(calc);
    JButton buttonMin = new JButton("-");
    buttonMin.addActionListener(calc);

    buttonPanel.add(button7);
    buttonPanel.add(button8);
    buttonPanel.add(button9);
    buttonPanel.add(buttonDivide);
    buttonPanel.add(button4);
    buttonPanel.add(button5);
    buttonPanel.add(button6);
    buttonPanel.add(buttonMult);
    buttonPanel.add(button1);
    buttonPanel.add(button2);
    buttonPanel.add(button3);
    buttonPanel.add(buttonMin);
    buttonPanel.add(button0);
    buttonPanel.add(buttonDecimal);
    buttonPanel.add(buttonEquals);
    buttonPanel.add(buttonPlus);
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(fieldPanel, BorderLayout.NORTH);
    panel.add(buttonPanel);
    this.add(panel);
    repaint();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
  }

  public class NumberListener implements ActionListener {

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.
     * ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent aArg0) {
      JButton button = (JButton) aArg0.getSource();
      if (numberDone == false) {
        if (decimalWaiting == true) {
          runningValue = runningValue + ".";
          decimalWaiting = false;
        }
        runningValue = runningValue + button.getText();
        field.setText(runningValue);
      }
    }

  }

  public class CalcListener implements ActionListener {

    /*
     * (non-Javadoc)
     * 
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.
     * ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent aArg0) {
      JButton button = (JButton) aArg0.getSource();
      if (button.getText().equals("=")) {
        if (currentCalc.equals("+")) {
          currentValue = currentValue + Double.valueOf(runningValue);
        } else if (currentCalc.equals("-")) {
          currentValue = currentValue - Double.valueOf(runningValue);
        } else if (currentCalc.equals("*")) {
          currentValue = currentValue * Double.valueOf(runningValue);
        } else if (currentCalc.equals("/")) {
          currentValue = currentValue / Double.valueOf(runningValue);
        }
        field.setText(currentValue + "");
        currentValue = 0;
        runningValue = "0";
      } else if (button.getText().equals(".")) {
        decimalWaiting = true;
      } else {
        currentCalc = button.getText();
        currentValue = Double.valueOf(runningValue);
        runningValue = "";
      }
    }

  }

}
