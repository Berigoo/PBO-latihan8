package com.calc;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcButton extends JButton {
    public CalcButton(String x){
        super(x);
    }

    public int getInteger(){
        if(getName().matches("\\d")){
            return Integer.parseInt(getName());
        }else {
            return getName().charAt(0);
        }
    }
}
