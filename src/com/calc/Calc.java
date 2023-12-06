package com.calc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    class _actionListener implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e) {
            CalcButton btn = (CalcButton) e.getSource();
            Pattern p = Pattern.compile("\\G(-?.?\\d+(\\.\\d+)?)(\\s+)?([\\+\\-\\*/%])?(\\s+)?(-?.?\\d+(\\.\\d+)?)?");
            Matcher m = p.matcher(outputField.getText());
            StringBuffer s = new StringBuffer();
            System.out.println(outputField.getText());
            String g1 = "", g2="", g3="";
            if (m.find()) {
                g1 = m.group(1);
                g2 = m.group(4);
                g3 = m.group(6);
            }
            System.out.println(outputField);
            System.out.println(g1 + " " + g2 + " " + g3);
            switch (btn.getInteger()){
                case 42: // *
                    outputField.setText(outputField.getText() + "*");
                    break;
                case 47: // /
                    outputField.setText(outputField.getText() + "/");
                    break;
                case 43: // +
                    outputField.setText(outputField.getText() + "+");
                    break;
                case 45: // -
                    outputField.setText(outputField.getText() + "-");
                    break;
                case 61: // =
                    if(!g3.isEmpty() && !g1.isEmpty()) {
                        Double left = Double.parseDouble(g1);
                        Double rigth = Double.parseDouble(g3);
                        switch (g2) {
                            case "*":
                                outputField.setText((left * rigth) + " ");
                                break;
                            case "/":
                                outputField.setText((left / rigth) + " ");
                                break;
                            case "+":
                                outputField.setText((left + rigth) + " ");
                                break;
                            case "-":
                                outputField.setText((left - rigth) + " ");
                                break;
                            case "%":
                                outputField.setText((left % rigth) + " ");
                                break;
                        }
                    }
                    break;
                case 37: // %
                    outputField.setText(outputField.getText() + "-");
                    break;
                case 66: // B
                    outputField.setText(outputField.getText().substring(0, outputField.getText().length()-1));
                    break;
                case 69: // E
                    if(g3 == null){
                        outputField.setText("");
                    }else{
                        m.appendReplacement(s, "$1$2");
                        outputField.setText(s.toString());
                    }
                    break;
                case 67: // C
                    outputField.setText("");
                    break;
                case 46: // .
                    outputField.setText(outputField.getText().concat("."));
                    break;
                default:
                    String out = outputField.getText();
                    if(!out.isEmpty() && out.charAt(out.length()-1) == ' ')out = out.substring(0, out.length()-1);
                    outputField.setText(out + btn.getName());
                    break;
            }
        }
    }
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
