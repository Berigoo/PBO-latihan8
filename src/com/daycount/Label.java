package com.daycount;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel{
    public Label(String name){
        super(name);
        setBackground(new Color(29, 32, 33));
        setForeground(new Color(222, 205, 158));
        setFont(new Font("JetBrains Mono", Font.BOLD, 15));
    }
}
