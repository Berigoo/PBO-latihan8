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
            String val = outputField.getText();
            switch (btn.getInteger()){
                case 42: // *
                    val += " *";
                    opr = 42;
                    outputField.setText(Double.toString(left) + " " + (char)opr);
                    isLeft = false;
                    break;
                case 47: // /
                    val += " /";
                    opr = 47;
                    outputField.setText(Double.toString(left) + " " + (char)opr);
                    isLeft = false;
                    break;
                case 43: // +
                    val += " +";
                    opr = 43;
                    outputField.setText(Double.toString(left) + " " + (char)opr);
                    isLeft = false;
                    break;
                case 45: // -
                    val += " -";
                    opr = 45;
                    outputField.setText(Double.toString(left) + " " + (char)opr);
                    isLeft = false;
                    break;
                case 61: // =
                    if(opr == 42){
                        left = left * right;
                    } else if (opr == 47) {
                        left = left / right;
                        if(right == 0){
                            outputField.setText("buh.");
                            isLeft = true;
                        }
                    } else if (opr == 43) {
                        left = left + right;
                    } else if (opr == 45) {
                        left = left - right;
                    } else if (opr == 37) {
                        left = left % right;
                    }
                    outputField.setText(Double.toString(left));
                    break;
                case 37: // %
                    opr = 37;
                    outputField.setText(Double.toString(left) + " " + (char)opr);
                    isLeft = false;
                    break;
                case 66: // B
                    break;
                case 69: // E
                    break;
                case 67: // C
                    break;
                case 46: // .
                    break;
                default:
                    if(isLeft){
                        if(left == 0)left = btn.getInteger();
                        else left = left * Math.pow(10, 1) + btn.getInteger();
                        outputField.setText(Double.toString(left));
                    }else {
                        if(right == 0)right = btn.getInteger();
                        else right = right * Math.pow(10, 1) + btn.getInteger();
                        outputField.setText((Double.toString(left) + " " + (char)opr + " " + right));
                    }
                    break;
            }
        }
    }
    private double left=0, right=0, res=0;
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
