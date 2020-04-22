package com.laorencel.learn.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUITest {

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3(null);
//        test4();
        test5();
    }

    private static void test1() {
        JFrame jFrame = new JFrame("LOL");
        jFrame.setSize(400, 300);
        jFrame.setLocation(200, 200);
        jFrame.setLayout(null);
        JButton jButton = new JButton("对方秒挂");
        jButton.setBounds(50, 50, 100, 50);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击 = " + e);
                jButton.setBounds(100, 100, 100, 50);
            }
        });
        jFrame.add(jButton);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    private static void test2() {
        JFrame jFrame = new JFrame("LOL");
        jFrame.setSize(400, 300);
        jFrame.setLocation(200, 200);
        jFrame.setLayout(null);

        JLabel jLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("/Users/laorencel/Pictures/壁纸/5d85cb123c076.jpg");
        jLabel.setIcon(imageIcon);
//        jLabel.setBounds(50,50,imageIcon.getIconWidth(),imageIcon.getIconHeight());
        jLabel.setBounds(50, 50, 100, 100);
        JButton jButton = new JButton("对方秒挂");
        jButton.setBounds(50, 150, 100, 50);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击 = " + e);
//                jButton.setBounds(100, 100, 100, 50);
//                jLabel.setVisible(!jLabel.isVisible());
                test3(jFrame);
            }
        });
        // 增加键盘监听
        jFrame.addKeyListener(new KeyListener() {

            // 键被弹起
            public void keyReleased(KeyEvent e) {

                // 39代表按下了 “右键”
                if (e.getKeyCode() == 39) {
                    // 图片向右移动 （y坐标不变，x坐标增加）
                    jLabel.setLocation(jLabel.getX() + 10, jLabel.getY());
                }
            }

            //键被按下
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                System.out.println("keyPressed e = " + e);
            }

            // 一个按下弹起的组合动作
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped e = " + e);
            }
        });

        jFrame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked e = " + e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed e = " + e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased e = " + e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered e = " + e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited e = " + e);
            }
        });
        jFrame.add(jLabel);
        jFrame.add(jButton);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    private static void test3(Frame owner) {
        JDialog d = new JDialog(owner);
        d.setTitle("LOL");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(50, 50, 280, 30);

        d.add(b);

        d.setVisible(true);
    }

    private static void test4() {
        JFrame f = new JFrame("外部窗体");
        f.setSize(800, 600);
        f.setLocation(100, 100);
        f.setLayout(null);
        // 根据外部窗体实例化JDialog
        JDialog d = new JDialog(f);
        // 设置为模态(true则frame不能操作，false反之）
        d.setModal(true);

        d.setTitle("模态的对话框");
        d.setSize(400, 300);
        d.setLocation(200, 200);
        d.setLayout(null);
        JButton b = new JButton("一键秒对方基地挂");
        b.setBounds(50, 50, 280, 30);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setVisible(!d.isVisible());
            }
        });
        f.add(b);
        f.setVisible(true);
    }

    private static void test5() {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        addMenu(f);

        JToolBar tb = new JToolBar();
        ImageIcon imageIcon1 = new ImageIcon("/Users/laorencel/Pictures/壁纸/5b1f5aa5e96ea.jpg");
        imageIcon1.setImage(imageIcon1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton b1 = new JButton(imageIcon1);
        ImageIcon imageIcon2 = new ImageIcon("/Users/laorencel/Pictures/壁纸/5b1f5aa5e96ea.jpg");
        imageIcon2.setImage(imageIcon2.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton b2 = new JButton(imageIcon2);
        ImageIcon imageIcon3 = new ImageIcon("/Users/laorencel/Pictures/壁纸/5b1f5aa264d1c.jpg");
        imageIcon3.setImage(imageIcon3.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton b3 = new JButton(imageIcon3);
        ImageIcon imageIcon4 = new ImageIcon("/Users/laorencel/Pictures/壁纸/5d85cb123c076.jpg");
        imageIcon4.setImage(imageIcon4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton b4 = new JButton(imageIcon4);
        ImageIcon imageIcon5 = new ImageIcon("/Users/laorencel/Pictures/壁纸/5e43b4b851f7f.jpg");
        imageIcon5.setImage(imageIcon5.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton b5 = new JButton(imageIcon5);
        ImageIcon imageIcon6 = new ImageIcon("/Users/laorencel/Pictures/壁纸/5e43b4b851f7f.jpg");
        imageIcon6.setImage(imageIcon6.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        JButton b6 = new JButton(imageIcon6);
        tb.add(b1);
        tb.add(b2);
        tb.add(b3);
        tb.add(b4);
        tb.add(b5);
        tb.add(b6);

        // 禁止工具栏拖动
        tb.setFloatable(false);
        // 给按钮设置提示信息
        b1.setToolTipText("坑爹英雄");

        // 把工具栏放在north的位置
        f.setLayout(new BorderLayout());
        f.add(tb, BorderLayout.NORTH);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }

    private static void addMenu(JFrame f) {
        JMenuBar mb = new JMenuBar();

        JMenu mHero = new JMenu("英雄");
        JMenu mItem = new JMenu("道具");
        JMenu mWord = new JMenu("符文");
        JMenu mSummon = new JMenu("召唤师");
        JMenu mTalent = new JMenu("天赋树");

        // 菜单项
        mHero.add(new JMenuItem("近战-Warriar"));
        mHero.add(new JMenuItem("远程-Range"));
        mHero.add(new JMenuItem("物理-physical"));
        mHero.add(new JMenuItem("坦克-Tank"));
        mHero.add(new JMenuItem("法系-Mage"));
        mHero.add(new JMenuItem("辅助-Support"));
        mHero.add(new JMenuItem("打野-Jungle"));
        mHero.add(new JMenuItem("突进-Charge"));
        mHero.add(new JMenuItem("男性-Boy"));
        mHero.add(new JMenuItem("女性-Girl"));

        mb.add(mHero);
        mb.add(mItem);
        mb.add(mWord);
        mb.add(mSummon);
        mb.add(mTalent);

        f.setJMenuBar(mb);
    }
}
