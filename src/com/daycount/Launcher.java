package com.daycount;
import com.calc.Panel;

import javax.swing.*;
import java.awt.*;

public class Launcher {
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run () {
                String[] btnName = {"Hitung", "Hapus", "Simpan", "Keluar"};

                JFrame window = new JFrame();
                Panel main = new Panel(new GridBagLayout());
                Panel top = new Panel(new GridLayout(2, 2, 10, 5));
                Panel mid = new Panel(new FlowLayout());
                BtnGrid bot = new BtnGrid(btnName, 1);

                Label lTahun = new Label("Tahun");
                TextField tTahun = new TextField();
                Label lBulan = new Label("Bulan");
                ComboBox<String> cBulan = new ComboBox<>(new String[] {"Januari", "Februari", "Maret", "April", "Mei",
                "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"});

                top.getPanel().add(lTahun);
                top.getPanel().add(tTahun);
                top.getPanel().add(lBulan);
                top.getPanel().add(cBulan);

                Label output = new Label("-");
                mid.getPanel().add(output);

                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridy = 0;
                main.getPanel().add(top.getPanel(), constraints);
                constraints.gridy = 1;
                main.getPanel().add(mid.getPanel(), constraints);
                constraints.gridy = 2;
                main.getPanel().add(bot, constraints);

                Logic logic = new Logic(tTahun, cBulan, output);
                bot.eventsPoll(logic.getListener());

                window.add(main.getPanel());
                window.pack();
                window.setVisible(true);

            }
        });
    }
}
