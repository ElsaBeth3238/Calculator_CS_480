/*
CS 480 Calculator by Elisabeth Jenkins

Credit: I got help with the Java Swing aspects from geeksforgeeks.org
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener
{

    static JFrame frame;

    static JTextField entry;

    String string0, string1, string2;

    Calculator ()
    {
        string0 = string1 = string2 = "";
    }

    public static void main(String[] args)
    {
        frame = new JFrame("calculator");

        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

        Calculator calc = new Calculator();

        entry = new JTextField(16);

        entry.setEditable(false);

        JButton bnum0, bnum1, bnum2, bnum3, bnum4, bnum5, bnum6, bnum7, bnum8, bnum9, badd, bsub, bdiv, bmult, bdec, bequals, bclear;

        //create buttons for numbers
        bnum0 = new JButton("0");
        bnum1 = new JButton("1");
        bnum2 = new JButton("2");
        bnum3 = new JButton("3");
        bnum4 = new JButton("4");
        bnum5 = new JButton("5");
        bnum6 = new JButton("6");
        bnum7 = new JButton("7");
        bnum8 = new JButton("8");
        bnum9 = new JButton("9");

        //create buttons for operations
        badd = new JButton("+");
        bsub = new JButton("-");
        bdiv = new JButton("/");
        bmult = new JButton("*");
        bclear = new JButton("C");

        //create other buttons (equals, decimal)
        bequals = new JButton("=");
        bdec = new JButton(".");

        JPanel panel = new JPanel();

        //add all of the action listeners
        bnum0.addActionListener(calc);
        bnum1.addActionListener(calc);
        bnum2.addActionListener(calc);
        bnum3.addActionListener(calc);
        bnum4.addActionListener(calc);
        bnum5.addActionListener(calc);
        bnum6.addActionListener(calc);
        bnum7.addActionListener(calc);
        bnum8.addActionListener(calc);
        bnum9.addActionListener(calc);

        badd.addActionListener(calc);
        bsub.addActionListener(calc);
        bdiv.addActionListener(calc);
        bmult.addActionListener(calc);
        bclear.addActionListener(calc);
        bequals.addActionListener(calc);
        bdec.addActionListener(calc);

        //add all elements to panel
        panel.add(entry);
        panel.add(bnum0);
        panel.add(bnum1);
        panel.add(bnum2);
        panel.add(bnum3);
        panel.add(bnum4);
        panel.add(bnum5);
        panel.add(bnum6);
        panel.add(bnum7);
        panel.add(bnum8);
        panel.add(bnum9);

        panel.add(badd);
        panel.add(bsub);
        panel.add(bdiv);
        panel.add(bmult);
        panel.add(bclear);
        panel.add(bdec);
        panel.add(bequals);

        //set background of panel
        panel.setBackground(Color.cyan);

        //add panel to frame
        frame.add(panel);

        frame.setSize(200,220);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent event)
    {
        String expression = event.getActionCommand();

        // if the value is a number
        if ((expression.charAt(0) >= '0' && expression.charAt(0) <= '9') || expression.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!string1.equals(""))
                string2 = string2 + expression;
            else
                string0 = string0 + expression;

            // set the value of text
            entry.setText(string0 + string1 + string2);
        }
        else if (expression.charAt(0) == 'C') {
            // clear the one letter
            string0 = string1 = string2 = "";

            // set the value of text
            entry.setText(string0 + string1 + string2);
        }
        else if (expression.charAt(0) == '=') {

            double solution = switch (string1) {
                case "+" -> (Double.parseDouble(string0) + Double.parseDouble(string2));
                case "-" -> (Double.parseDouble(string0) - Double.parseDouble(string2));
                case "/" -> (Double.parseDouble(string0) / Double.parseDouble(string2));
                default -> (Double.parseDouble(string0) * Double.parseDouble(string2));
            };

            // store the value in 1st

            // set the value of text
            entry.setText(string0 + string1 + string2 + "=" + solution);

            // convert it to string
            string0 = Double.toString(solution);

            string1 = string2 = "";
        }
        else {
            // if there was no operand
            if (string1.equals("") || string2.equals(""))
                string1 = expression;
                // else evaluate
            else {
                double solution = switch (string1) {
                    case "+" -> (Double.parseDouble(string0) + Double.parseDouble(string2));
                    case "-" -> (Double.parseDouble(string0) - Double.parseDouble(string2));
                    case "/" -> (Double.parseDouble(string0) / Double.parseDouble(string2));
                    default -> (Double.parseDouble(string0) * Double.parseDouble(string2));
                };

                // store the value in 1st

                // convert it to string
                string0 = Double.toString(solution);

                // place the operator
                string1 = expression;

                // make the operand blank
                string2 = "";
            }

            entry.setText(string0 + string1 + string2);
        }
    }
}