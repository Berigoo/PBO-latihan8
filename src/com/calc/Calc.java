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
                    outputField.setText(left + " " + (char)opr + " " + right);
                    isLeft = false;
                    break;
                case 47: // /
                    opr = 47;
                    outputField.setText(left + " " + (char)opr + " " + right);
                    isLeft = false;
                    break;
                case 43: // +
                    opr = 43;
                    outputField.setText(left + " " + (char)opr + " " + right);
                    isLeft = false;
                    break;
                case 45: // -
                    if(isLeft){
                        if(left.charAt(0) != '-')left = "-" + left;
                        else{
                            opr = 45;
                            isLeft = false;
                        }
                    }else {
                        if(right.charAt(0) != '-')right = "-" + right;
                        else{
                            opr = 45;
                        }
                    }

                    outputField.setText(left + " " + (char)opr + " " + right);
                    break;
                case 61: // =
                    if(left.isEmpty()) left = "0";
                    if(right.isEmpty()) right = "0";
                    double _left = Double.parseDouble(left);
                    double _right = Double.parseDouble(right);
                    if(opr == 42){
                        left = Double.toString( _left * _right);
                    } else if (opr == 47) {
                        if(right.isEmpty() || right.equals("0")){
                            outputField.setText("buh.");
                            isLeft = true;
                            left = "";
                            break;
                        }else {
                            left = Double.toString( _left / _right);
                        }
                    } else if (opr == 43) {
                        left = Double.toString( _left + _right);
                    } else if (opr == 45) {
                        left = Double.toString( _left - _right);
                    } else if (opr == 37) {
                        left = Double.toString( _left % _right);
                    }
                    outputField.setText(left);
                    right = "";
                    isLeft = false;
                    break;
                case 37: // %
                    opr = 37;
                    outputField.setText(left + " " + (char)opr + " " + right);
                    isLeft = false;
                    break;
                case 66: // B
                    if(isLeft){
                        if(left.length()>1)left = left.substring(0, left.length()-1);
                        else left = "0";
                        outputField.setText(left);
                    }else {
                        if(right.length()>1)right = right.substring(0, right.length() - 1);
                        else right = "0";
                        outputField.setText(left + " " + (char)opr + " " + right);
                    }
                    break;
                case 69: // E
                    if(isLeft){
                        left = "0";
                        outputField.setText(left);
                    } else{
                        right = "0";
                        outputField.setText(left + " " + (char)opr + " " + right);
                    }
                    break;
                case 67: // C
                    outputField.setText("");
                    left = "";
                    right = "";
                    isLeft = true;
                    break;
                case 46: // .
                    if(isLeft)left = left.concat(".");
                    else right = right.concat(".");
                    break;
                default:
                    if(isLeft){
                        if(left.length() == 1 && left.compareTo("0") == 0) left = btn.getName();
                        else left = left.concat(btn.getName());
                        outputField.setText(left);
                    }else {
                        if(right.length() == 1 && right.compareTo("0") == 0) right = btn.getName();
                        else right = right.concat(btn.getName());
                        outputField.setText(left + " " + (char)opr + " " + right);
                    }
                    break;
            }
        }
    }
    private String left="", right="", res="";
    int lloop = 0;
    private boolean isLeft = true;
    int opr = 43;

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
