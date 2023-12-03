package com.calc;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Launcher {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run () {
                MainWindow window = new MainWindow();
                Panel WrapPanel = new Panel(new GridBagLayout());
                Panel InputPanel = new Panel(new FlowLayout(FlowLayout.CENTER));

                ButtonGrid num = new ButtonGrid(new String[]
                        {"7", "8", "9",
                                "4", "5", "6",
                                "1", "2", "3",
                                ".", "0", "C"}, 4);
                ButtonGrid opr = new ButtonGrid(new String[]
                        {"+", "-",
                        "*", "/",
                        "=", "%",
                        "B", "E"}, 4);

                Monitor output = new Monitor(25);

                GridBagConstraints constraints = new GridBagConstraints();
                InputPanel.getPanel().add(num.getPanel());
                InputPanel.getPanel().add(opr.getPanel());

                constraints.anchor=GridBagConstraints.CENTER;
                constraints.fill=GridBagConstraints.HORIZONTAL;
                constraints.insets = new Insets(10, 10, 10, 10);
                constraints.gridx=0;
                constraints.gridy=1;
                WrapPanel.getPanel().add(num.getPanel(), constraints);
                constraints.gridx=1;
                WrapPanel.getPanel().add(opr.getPanel(), constraints);
                constraints.gridx=0;
                constraints.gridy=0;
                constraints.gridwidth=2;
                WrapPanel.getPanel().add(output.getTextField(), constraints);

                Calc calc = new Calc(output.getTextField());

                num.eventsPoll(calc.getActionListener());
                opr.eventsPoll(calc.getActionListener());

                window.getWindow().add(WrapPanel.getPanel(), BorderLayout.CENTER);
                window.getWindow().pack();
                window.getWindow().setVisible(true);
            }
        });
    }
}
