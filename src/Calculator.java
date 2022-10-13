/*
CS 480 Calculator by Elisabeth Jenkins

Credit: I got help with the Java Swing aspects and with the parsing method from geeksforgeeks.org
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

        Calculator calc = new Calculator();

        entry = new JTextField(20);
        entry.setEditable(false);

        Font entryFont = new Font("Arial", Font.PLAIN, 25);
        entry.setFont(entryFont);

        JButton bnum0, bnum1, bnum2, bnum3, bnum4, bnum5, bnum6, bnum7, bnum8, bnum9, badd, bsub, bdiv, bmult,
                bdec, bequals, bclear, bpower, bsin, bcos, btan, bcot, bln, blog10, bopparen, bendparen, bopcurbr, bendcurbr;

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
        bpower = new JButton("^");
        bsin = new JButton("sin");
        bcos = new JButton("cos");
        btan = new JButton("tan");
        bcot = new JButton("cot");
        bln = new JButton("ln");
        blog10 = new JButton("log_10");

        bclear = new JButton("C");

        //create other buttons (equals, decimal, parentheses, curly braces)
        bequals = new JButton("=");
        bdec = new JButton(".");
        bopparen = new JButton("(");
        bendparen = new JButton(")");
        bopcurbr = new JButton("{");
        bendcurbr = new JButton("}");


        //create panel
        JPanel panel = new JPanel();

        //set preferred sizes and fonts for buttons
        Dimension buttonSize = new Dimension(70, 70);
        Font buttonFont = new Font("Arial", Font.PLAIN, 18);
        bnum0.setPreferredSize(buttonSize);
        bnum0.setFont(buttonFont);
        bnum1.setPreferredSize(buttonSize);
        bnum1.setFont(buttonFont);
        bnum2.setPreferredSize(buttonSize);
        bnum2.setFont(buttonFont);
        bnum3.setPreferredSize(buttonSize);
        bnum3.setFont(buttonFont);
        bnum4.setPreferredSize(buttonSize);
        bnum4.setFont(buttonFont);
        bnum5.setPreferredSize(buttonSize);
        bnum5.setFont(buttonFont);
        bnum6.setPreferredSize(buttonSize);
        bnum6.setFont(buttonFont);
        bnum7.setPreferredSize(buttonSize);
        bnum7.setFont(buttonFont);
        bnum8.setPreferredSize(buttonSize);
        bnum8.setFont(buttonFont);
        bnum9.setPreferredSize(buttonSize);
        bnum9.setFont(buttonFont);

        badd.setPreferredSize(buttonSize);
        badd.setFont(buttonFont);
        bsub.setPreferredSize(buttonSize);
        bsub.setFont(buttonFont);
        bdiv.setPreferredSize(buttonSize);
        bdiv.setFont(buttonFont);
        bmult.setPreferredSize(buttonSize);
        bmult.setFont(buttonFont);
        bpower.setPreferredSize(buttonSize);
        bpower.setFont(buttonFont);
        bsin.setPreferredSize(buttonSize);
        bsin.setFont(buttonFont);
        bcos.setPreferredSize(buttonSize);
        bcos.setFont(buttonFont);
        btan.setPreferredSize(buttonSize);
        btan.setFont(buttonFont);
        bcot.setPreferredSize(buttonSize);
        bcot.setFont(buttonFont);
        bln.setPreferredSize(buttonSize);
        bln.setFont(buttonFont);
        blog10.setPreferredSize(buttonSize);
        blog10.setFont(buttonFont);
        bopparen.setPreferredSize(buttonSize);
        bopparen.setFont(buttonFont);
        bendparen.setPreferredSize(buttonSize);
        bendparen.setFont(buttonFont);
        bopcurbr.setPreferredSize(buttonSize);
        bopcurbr.setFont(buttonFont);
        bendcurbr.setPreferredSize(buttonSize);
        bendcurbr.setFont(buttonFont);
        bclear.setPreferredSize(buttonSize);
        bclear.setFont(buttonFont);
        bdec.setPreferredSize(buttonSize);
        bdec.setFont(buttonFont);
        bequals.setPreferredSize(buttonSize);
        bequals.setFont(buttonFont);


        //add all action listeners
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
        bpower.addActionListener(calc);
        bsin.addActionListener(calc);
        bcos.addActionListener(calc);
        btan.addActionListener(calc);
        bcot.addActionListener(calc);
        bln.addActionListener(calc);
        blog10.addActionListener(calc);
        bopparen.addActionListener(calc);
        bendparen.addActionListener(calc);
        bopcurbr.addActionListener(calc);
        bendcurbr.addActionListener(calc);
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
        panel.add(bpower);
        panel.add(bsin);
        panel.add(bcos);
        panel.add(btan);
        panel.add(bcot);
        panel.add(bln);
        panel.add(blog10);
        //panel.add(bopparen);
       // panel.add(bendparen);
       // panel.add(bopcurbr);
       // panel.add(bendcurbr);
        panel.add(bclear);
        panel.add(bdec);
        panel.add(bequals);

        //set background of panel
        panel.setBackground(Color.cyan);

        //add panel to frame
        frame.add(panel);

        frame.setSize(500,500);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent event)
    {
        String expression = event.getActionCommand();

        int parenCount = 0;
        int curlyBraceCount = 0;

        // if the value is a number
        if ((expression.charAt(0) >= '0' && expression.charAt(0) <= '9') || expression.charAt(0) == '.')
        {
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
                case "^" -> (Math.pow(Double.parseDouble(string0), Double.parseDouble(string2)));
                case "sin" -> (Math.sin(Double.parseDouble(string2)));
                case "cos" -> (Math.cos(Double.parseDouble(string2)));
                case "tan" -> (Math.tan(Double.parseDouble(string2)));
                case "cot" -> (Math.cos(Double.parseDouble(string2)) / Math.sin(Double.parseDouble(string2)));
                case "ln" -> (Math.log(Double.parseDouble(string2)));
                case "log_10" -> (Math.log10(Double.parseDouble(string2)));
                default -> (Double.parseDouble(string0) * Double.parseDouble(string2));
            };

            // store the value in 1st

            // set the value of text
            entry.setText(string0 + string1 + string2 + "=" + solution);

            // convert it to string
            string0 = Double.toString(solution);

            string1 = string2 = "";
        }
        else if (expression.charAt(0) == '-') {

            double solution = (0 - Double.parseDouble(string2));
            string0 = expression;
            string1 = Double.toString(solution);
            string2 = "";

            entry.setText(string0 + string1 + string2);

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
                    case "^" -> (Math.pow(Double.parseDouble(string0), Double.parseDouble(string2)));
                    case "sin" -> (Math.sin(Double.parseDouble(string2)));
                    case "cos" -> (Math.cos(Double.parseDouble(string2)));
                    case "tan" -> (Math.tan(Double.parseDouble(string2)));
                    case "cot" -> (Math.cos(Double.parseDouble(string2)) / Math.sin(Double.parseDouble(string2)));
                    case "ln" -> (Math.log(Double.parseDouble(string2)));
                    case "log_10" -> (Math.log10(Double.parseDouble(string2)));
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