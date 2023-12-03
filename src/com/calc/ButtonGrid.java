package com.calc;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ButtonGrid extends Panel{
    private HashMap<String, CalcButton> buttonList = new HashMap<String, CalcButton>();

    public ButtonGrid (String[] arr, int rows){
        super(new GridLayout(rows, (arr.length/rows), 5, 5));

        for(String x : arr){
            CalcButton btn = new CalcButton(x);
            btn.setFocusable(false);
            btn.setFont(new Font("Jetbrains Mono", Font.BOLD, 15));
            btn.setBackground(new Color(49, 47, 46));
            btn.setForeground(new Color(136, 183, 119));
            btn.setName(x);

            buttonList.put(x, btn);
            getPanel().add(buttonList.get(x));
        }
    }

    public void eventsPoll(ActionListener listener){
        for(Map.Entry<String, CalcButton> entry : buttonList.entrySet()){
            entry.getValue().addActionListener(listener);
        }
    }

}
