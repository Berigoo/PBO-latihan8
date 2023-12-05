package com.daycount;

import com.calc.ButtonGrid;
import com.calc.CalcButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class BtnGrid extends JPanel {
    public HashMap<String, JButton> buttonList = new HashMap<String, JButton>();

    public BtnGrid (String[] arr, int rows){
        super(new GridLayout(rows, (arr.length/rows), 5, 5));

        for(String x : arr){
            CalcButton btn = new CalcButton(x);
            btn.setFocusable(false);
            btn.setFont(new Font("Jetbrains Mono", Font.BOLD, 15));
            btn.setBackground(new Color(49, 47, 46));
            btn.setForeground(new Color(136, 183, 119));
            btn.setName(x);

            buttonList.put(x, btn);
            add(buttonList.get(x));
        }
        setBackground(new Color(29, 32, 33));
    }

    public void eventsPoll(ActionListener listener){
        for(Map.Entry<String, JButton> entry : buttonList.entrySet()){
            entry.getValue().addActionListener(listener);
        }
    }
}
