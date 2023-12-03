package com.calc;
import javax.swing.JTextField;
import java.awt.*;

public class Monitor {
    private JTextField textField;

    public Monitor(int width){
        textField = new JTextField(width);
        textField.enableInputMethods(false);
        textField.setFont(new Font("Jetbrains Mono", Font.BOLD, 15));
        textField.setBackground(new Color(69, 133, 136));
        textField.setForeground(new Color(222, 205, 158));
        textField.setEditable(false);
    }

    public JTextField getTextField () {
        return textField;
    }
}
