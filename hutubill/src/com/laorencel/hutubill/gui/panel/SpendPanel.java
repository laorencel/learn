package com.laorencel.hutubill.gui.panel;

import javax.swing.*;
import java.awt.*;

public class SpendPanel extends JPanel{
    private static SpendPanel instance;

    public static SpendPanel getInstance() {
        if (null == instance) {
            synchronized (SpendPanel.class) {
                if (null == instance) {
                    instance = new SpendPanel();
                }
            }
        }
        return instance;
    }

    private SpendPanel() {
        init();
    }

    JLabel lMonthSpend = new JLabel("本月消费");
    JLabel lTodaySpend = new JLabel("今日消费");
    JLabel lAvgSpendPerDay = new JLabel("日均消费");
    JLabel lMonthLeft = new JLabel("本月剩余");
    JLabel lDayAvgAvailable = new JLabel("日均可用");
    JLabel lMonthLeftDay = new JLabel("距离月末");

    JLabel vMonthSpend = new JLabel("￥2300");
    JLabel vTodaySpend = new JLabel("￥25");
    JLabel vAvgSpendPerDay = new JLabel("￥120");
    JLabel vMonthAvailable = new JLabel("￥2084");
    JLabel vDayAvgAvailable = new JLabel("￥389");
    JLabel vMonthLeftDay = new JLabel("15天");

    private void init(){
        this.setLayout(new BorderLayout());
        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
    }
    private JPanel center() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
//        p.add(west(), BorderLayout.WEST);
//        p.add(center2(),BorderLayout.CENTER);
        return p;
    }
    private JPanel south() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 4));
        p.add(lAvgSpendPerDay);
        p.add(lMonthLeft);
        p.add(lDayAvgAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgSpendPerDay);
        p.add(vMonthAvailable);
        p.add(vDayAvgAvailable);
        p.add(vMonthLeftDay);
        return p;
    }
}
