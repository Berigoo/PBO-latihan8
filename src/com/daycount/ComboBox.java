package com.daycount;

import javax.swing.*;
import java.awt.*;

public class ComboBox<E> extends JComboBox<E> {
    public ComboBox(E[] data){
        super(data);
        setFont(new Font("Jetbrains Mono", Font.BOLD, 15));
        setBackground(new Color(49, 47, 46));
        setForeground(new Color(136, 183, 119));
        setRequestFocusEnabled(true);
    }
}
