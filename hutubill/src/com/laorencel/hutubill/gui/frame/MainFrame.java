package com.laorencel.hutubill.gui.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
//    private JFrame frame;

    public MainFrame() {
        super("一本糊涂账");
        init();
    }

    private void init() {
//        frame = new JFrame("一本糊涂账");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initToolbar();
    }

    private void initToolbar() {
        JToolBar toolBar = new JToolBar();
        JButton bSpend = new JButton("消费一览");
        JButton bRecord = new JButton("记一笔");
        JButton bCategory = new JButton("消费分类");
        JButton bReport = new JButton("月消费报表");
        JButton bConfig = new JButton("设置");
        JButton bBackup = new JButton("备份");
        JButton bRecover = new JButton("恢复");

        bSpend.addActionListener(e -> {
        });
        bRecord.addActionListener(e -> {
        });
        bCategory.addActionListener(e -> {
        });
        bConfig.addActionListener(e -> {
        });
        bBackup.addActionListener(e -> {
        });
        bRecover.addActionListener(e -> {
        });

        toolBar.add(bSpend);
        toolBar.add(bRecord);
        toolBar.add(bCategory);
        toolBar.add(bReport);
        toolBar.add(bConfig);
        toolBar.add(bBackup);
        toolBar.add(bRecover);

        toolBar.setFloatable(false);

        this.setLayout(new BorderLayout());
        this.add(toolBar, BorderLayout.NORTH);
//        this.add(new JPanel(), BorderLayout.CENTER);
    }

}
