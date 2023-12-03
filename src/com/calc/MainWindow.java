package com.calc;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class MainWindow{

    private JFrame window;
    public MainWindow(){
        window = new JFrame();
        init();
    };

    private void init(){
        window.setTitle("Calculator");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
    }

    public JFrame getWindow () {
        return window;
    }
}
