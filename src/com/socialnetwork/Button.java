package com.socialnetwork;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton implements ActionListener {
    public IButtonClickEvent btnClickEvent;
    public Button(String label, IButtonClickEvent e) {
        this.setText(label);
        this.setBounds(0,0, 230, 48);
        this.setBackground(new Color(0x31313A));
        this.setForeground(Color.WHITE);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.addActionListener(this);

        this.btnClickEvent = e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       this.btnClickEvent.onClick();
    }
}
