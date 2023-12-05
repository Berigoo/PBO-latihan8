package com.daycount;

import javax.swing.*;
import java.awt.*;

public class Panel {
    private JPanel panel;

    public Panel(LayoutManager layout){
        init(layout);
    }

    private void init(LayoutManager layout){
        panel = new JPanel(layout);
        panel.setLayout(layout);
        panel.setBackground(new Color(29, 32, 33));
    }

    public JPanel getPanel () {
        return panel;
    }
}
