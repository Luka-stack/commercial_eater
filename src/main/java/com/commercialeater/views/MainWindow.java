package com.commercialeater.views;

import com.commercialeater.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class MainWindow extends JFrame {

    private JLabel bottomInfLabel;

    private JPanel background;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel main;
    private JPanel sidebar;

    public MainWindow() {
        initComponents();
    }

    private void initComponents() {

        background = new JPanel();
        sidebar = new JPanel();
        jPanel2 = new JPanel();
        jLabel3 = new JLabel();
        jLabel8 = new JLabel();
        jPanel3 = new JPanel();
        jLabel4 = new JLabel();
        jLabel9 = new JLabel();
        jPanel4 = new JPanel();
        jLabel5 = new JLabel();
        jLabel10 = new JLabel();
        jPanel5 = new JPanel();
        jLabel6 = new JLabel();
        jLabel11 = new JLabel();
        jPanel6 = new JPanel();
        jLabel7 = new JLabel();
        jLabel12 = new JLabel();
        jLabel2 = new JLabel();
        bottomInfLabel = new JLabel();
        main = new JPanel();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1070, 664));
        setMinimumSize(new Dimension(1070, 664));
        setPreferredSize(new Dimension(1070, 664));
        setResizable(true);

        background.setBackground(new Color(238, 233, 212));

        sidebar.setBackground(new Color(153, 194, 93));

        jPanel2.setBackground(new Color(153, 194, 93));
        jPanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                menuEntryHover(jPanel2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuEntryStdBackground(jPanel2);
            }
        });

        jLabel3.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/restauratns.png"))));

        jLabel8.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new Color(255, 255, 255));
        jLabel8.setText("Restaurants");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)
                                .addContainerGap())
        );

        jPanel3.setBackground(new Color(153, 194, 93));
        jPanel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                menuEntryHover(jPanel3);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuEntryStdBackground(jPanel3);
            }
        });

        jLabel4.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/users.png"))));

        jLabel9.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new Color(255, 255, 255));
        jLabel9.setText("Users");

        javax.swing.GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)
                                .addContainerGap())
        );

        jPanel4.setBackground(new Color(153, 194, 93));
        jPanel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                menuEntryHover(jPanel4);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuEntryStdBackground(jPanel4);
            }
        });

        jLabel5.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/payments.png"))));

        jLabel10.setFont(new Font("Segoe UI", 1, 18));
        jLabel10.setForeground(new Color(255, 255, 255));
        jLabel10.setText("Transactions");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addContainerGap())
        );

        jPanel5.setBackground(new Color(153, 194, 93));
        jPanel5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                menuEntryHover(jPanel5);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuEntryStdBackground(jPanel5);
            }
        });

        jLabel6.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/settings.png"))));

        jLabel11.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new Color(255, 255, 255));
        jLabel11.setText("Settings");

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addContainerGap())
        );

        jPanel6.setBackground(new Color(153, 194, 93));
        jPanel6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logOutButtonClicked();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                menuEntryHover(jPanel6);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuEntryStdBackground(jPanel6);
            }
        });

        jLabel7.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/logout.png"))));

        jLabel12.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new Color(255, 255, 255));
        jLabel12.setText("Log Out");

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addContainerGap())
        );

        jLabel2.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/name2.png"))));

        GroupLayout sidebarLayout = new GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
                sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidebarLayout.setVerticalGroup(
                sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2)
                                .addGap(55, 55, 55)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bottomInfLabel.setFont(new Font("Segoe UI", 0, 12));
        bottomInfLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        bottomInfLabel.setText("Bottom Information");

        main.setBackground(new Color(255, 255, 255));
        main.setMaximumSize(new Dimension(800, 580));
        main.setMinimumSize(new Dimension(800, 580));
        main.setName("");

        GroupLayout mainLayout = new GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 580, Short.MAX_VALUE)
        );

        GroupLayout backgroundLayout = new GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(sidebar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(main, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bottomInfLabel, GroupLayout.PREFERRED_SIZE, 782, GroupLayout.PREFERRED_SIZE)))
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(main, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(bottomInfLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(background, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(background, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void menuEntryStdBackground(JPanel panel) {
        panel.setBackground(new Color(153, 194, 93));
    }

    private void menuEntryHover(JPanel panel) {
        panel.setBackground(new Color(125, 166, 63));
    }

    private void logOutButtonClicked() {

        this.dispose();
        Main.openLoginWindow();
    }

    public void setBottomInformation(String information) {
        bottomInfLabel.setText(information);
    }
}
