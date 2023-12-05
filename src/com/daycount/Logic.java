package com.daycount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class Logic {

    class _actionListener implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e) {
            System.out.println("Button pressed");
            JButton btn = (JButton) e.getSource();
            if(btn.getName().compareTo("Hapus") == 0){
                reset();
            } else if (btn.getName().compareTo("Hitung") == 0) {
                calc();
            }else if (btn.getName().compareTo("Simpan") == 0){
                writeIntoFile();
            } else if (btn.getName().compareTo("Keluar") == 0) {
                System.exit(0);
            }
        }
    }
    private JTextField inputYear;
    private JComboBox<String> inputMonth;
    private JLabel output;
    private  _actionListener listener;

    public Logic(JTextField year, JComboBox<String> month, JLabel output){
        inputMonth = month;
        inputYear = year;
        this.output = output;
        listener = new _actionListener();
    }
    public void reset(){
        inputYear.setText("");
        inputMonth.setSelectedIndex(0);
        output.setText("-");
    }
    private int isLeapYear(int year){
        if((year % 4 > 0) || year % 100 == 0){
            return 0;
        }else {
            return 1;
        }
    }
    private void setOutput(int dayCount){
        output.setText("Jumlah hari pada bulan " + inputMonth.getSelectedItem() + " tahun " + inputYear.getText() + " adalah " + dayCount);
    }
    public void calc(){
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(inputMonth.getSelectedIndex() == 1){
            setOutput(days[1] + isLeapYear(Integer.parseInt(inputYear.getText())));
        }else {
            setOutput(days[inputMonth.getSelectedIndex()]);
        }
    }
    private void writeIntoFile(){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("out.txt", true));
            calc();
            out.write(output.getText() + "\n");
        }catch (Exception exception){
            System.err.println(exception.getMessage());
        }
    }

    public _actionListener getListener () {
        return listener;
    }
}
