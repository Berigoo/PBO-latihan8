package com.calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Calc {
    class _actionListener implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e) {
            CalcButton btn = (CalcButton) e.getSource();
            switch (btn.getInteger()){
                case 42: // *
                    opr = 42;
                    if (right != 0)outputField.setText(left + " " + (char)opr + " " + right);
                    else outputField.setText(left + " " + (char)opr);
                    isLeft = false;
                    isDec = false;
                    break;
                case 47: // /
                    opr = 47;
                    if (right != 0)outputField.setText(left + " " + (char)opr + " " + right);
                    else outputField.setText(left + " " + (char)opr);
                    isLeft = false;
                    isDec = false;
                    break;
                case 43: // +
                    opr = 43;
                    if (right != 0)outputField.setText(left + " " + (char)opr + " " + right);
                    else outputField.setText(left + " " + (char)opr);
                    isLeft = false;
                    isDec = false;
                    break;
                case 45: // -
                    opr = 45;
                    if (right != 0)outputField.setText(left + " " + (char)opr + " " + right);
                    else outputField.setText(left + " " + (char)opr);
                    isLeft = false;
                    isDec = false;
                    break;
                case 61: // =
                    if(opr == 42){
                        left = left * right;
                    } else if (opr == 47) {
                        if(right == 0){
                            outputField.setText("buh.");
                            isLeft = true;
                            left = 0;
                            break;
                        }else {
                            left = left / right;
                        }
                    } else if (opr == 43) {
                        left = left + right;
                    } else if (opr == 45) {
                        left = left - right;
                    } else if (opr == 37) {
                        left = left % right;
                    }
                    outputField.setText(Double.toString(left));
                    right = 0;
                    decrCount = 1;
                    isDec = false;
                    break;
                case 37: // %
                    opr = 37;
                    if (right != 0)outputField.setText(left + " " + (char)opr + " " + right);
                    else outputField.setText(left + " " + (char)opr);
                    isLeft = false;
                    isDec = false;
                    break;
                case 66: // B
                    if(isLeft) {
                        String last = Double.toString(left);
                        if(last.charAt(last.length()-1) == '0') {
                            last = last.substring(0, last.indexOf(".")-1);
                            left = Double.parseDouble(last);
                            outputField.setText(Double.toString(left));
                        }else {
                            declCount--;
                            double num = Double.parseDouble(last);
                            last = last.substring(0, last.length()-1);
                            System.out.println(last);
                            left = Double.parseDouble(last);
                            System.out.println(num + " " + -left);
                            left = -left + num;
                            outputField.setText(Double.toString(left));
                        }
                    }
                    break;
                case 69: // E
                    break;
                case 67: // C
                    outputField.setText("");
                    left = 0;
                    right = 0;
                    isLeft = true;
                    isDec = false;
                    declCount = 1;
                    decrCount = 1;
                    break;
                case 46: // .
                    isDec = true;
                    break;
                default:
                    if(isLeft){
                        if(isDec){
                            left = left + (btn.getInteger()/Math.pow(10, declCount));
                            declCount++;
                        }
                        else if(left <= 0)left = btn.getInteger();
                        else left = left * Math.pow(10, 1) + btn.getInteger();
                        outputField.setText(Double.toString(left));
                    }else {
                        if(isDec) {
                            right = right + (btn.getInteger() / Math.pow(10, decrCount));
                            decrCount++;
                        }
                        else if(right <= 0)right = btn.getInteger();
                        else right = right * Math.pow(10, 1) + btn.getInteger();
                        outputField.setText((left + " " + (char)opr + " " + right));
                    }
                    break;
            }
        }
    }
    private double left=0, right=0;
    private int declCount = 1;
    private int decrCount = 1;
    private boolean isLeft = true;
    private int opr = 43;
    private boolean isDec = false;

    private JTextField outputField = null;
    private _actionListener actionListener;
    public Calc(JTextField out){
        outputField = out;
        actionListener = new _actionListener();
    }

    public _actionListener getActionListener () {
        return actionListener;
    }
}
