package ua.com.kisit.lab3;

import javax.swing.*;
import java.awt.*;

public class ClockFrame2 {

    JFrame frame;
    JPanel panel;
    JLabel label;

    public ClockFrame2() {
        frame = new JFrame("My Clock");
        panel = new JPanel();
        label = new JLabel();

        frame.setSize(600, 120);
        frame.setLocationRelativeTo(null); // Центрує вікно на екрані
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label.setFont(new Font("Consolas", Font.BOLD, 32));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panel.setBackground(new Color(25, 25, 112)); // темно-синій фон
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.CENTER);

        java.util.Calendar now = java.util.Calendar.getInstance();
        int hour = now.get(java.util.Calendar.HOUR_OF_DAY);
        int minute = now.get(java.util.Calendar.MINUTE);
        int second = now.get(java.util.Calendar.SECOND);
        int millis = now.get(java.util.Calendar.MILLISECOND);

        ClockExt2 clockExt = new ClockExt2(hour, minute, second, millis);

        Timer timer = new Timer(100, e -> {
            clockExt.nextMillisecond();

            // Форматований вивід:  HH : MM : SS : mmm
            String timeText = String.format(
                    "%02d : %02d : %02d : %03d",
                    clockExt.getHour(),
                    clockExt.getMinute(),
                    clockExt.getSeconds(),
                    clockExt.getMilliseconds()
            );

            label.setText(timeText);
        });

        timer.start();
        frame.setVisible(true);
    }


}