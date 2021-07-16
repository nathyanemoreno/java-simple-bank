package com.socialnetwork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainFrame extends JFrame {
    public MainFrame(JComponent... component){
        GridLayout gridLayout = new GridLayout(1,2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(gridLayout);
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(0xF3F3F3));
        this.setVisible(true);


        for (JComponent jComponent : component) {
            this.add(jComponent);
        }
//        this.pack();
    }

}
