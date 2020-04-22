package com.laorencel.hutubill;

import com.laorencel.hutubill.gui.frame.MainFrame;
import com.laorencel.hutubill.gui.panel.SpendPanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){
        MainFrame frame  = new MainFrame();
        SpendPanel spendPanel = SpendPanel.getInstance();
        frame.add(spendPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
