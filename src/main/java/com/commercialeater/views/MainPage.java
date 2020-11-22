package com.commercialeater.views;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {

    private JPanel displayPanel;
    private JLabel informationLabel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel logoutButton;
    private JPanel restaurantButton;
    private JPanel settingsButton;
    private JPanel transactionsButton;
    private JPanel usersButton;
    private JMenuBar windowMenu;

    public MainPage() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        restaurantButton = new JPanel();
        jLabel1 = new JLabel();
        usersButton = new JPanel();
        jLabel2 = new JLabel();
        transactionsButton = new JPanel();
        jLabel3 = new JLabel();
        settingsButton = new JPanel();
        jLabel4 = new JLabel();
        logoutButton = new JPanel();
        jLabel5 = new JLabel();
        jPanel2 = new JPanel();
        informationLabel = new JLabel();
        displayPanel = new JPanel();
        windowMenu = new JMenuBar();
        jMenu1 = new JMenu();
        jMenu2 = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(620, 400));
        setMinimumSize(new Dimension(620, 400));
        setPreferredSize(new Dimension(620, 400));

        jPanel1.setBackground(new Color(240, 171, 141));
        jPanel1.setMaximumSize(new Dimension(200, 170));
        jPanel1.setMinimumSize(new Dimension(200, 40));
        jPanel1.setPreferredSize(new Dimension(200, 170));

        restaurantButton.setBackground(new Color(240, 171, 141));
        restaurantButton.setMaximumSize(new Dimension(200, 45));
        restaurantButton.setMinimumSize(new Dimension(200, 45));
        restaurantButton.setPreferredSize(new Dimension(200, 45));

        //jLabel1.setIcon(new ImageIcon(getClass().getResource("/com/mycompany/imgs/restaurant.png")));
        jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/restaurant.png")));

        GroupLayout restaurantButtonLayout = new GroupLayout(restaurantButton);
        restaurantButton.setLayout(restaurantButtonLayout);
        restaurantButtonLayout.setHorizontalGroup(
                restaurantButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(restaurantButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        restaurantButtonLayout.setVerticalGroup(
                restaurantButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(restaurantButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        usersButton.setBackground(new Color(240, 171, 141));
        usersButton.setMaximumSize(new Dimension(200, 45));
        usersButton.setMinimumSize(new Dimension(200, 45));
        usersButton.setPreferredSize(new Dimension(200, 45));

        //jLabel2.setIcon(new ImageIcon(getClass().getResource("/com/mycompany/imgs/group.png")));
        jLabel2.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/group.png")));

        GroupLayout usersButtonLayout = new GroupLayout(usersButton);
        usersButton.setLayout(usersButtonLayout);
        usersButtonLayout.setHorizontalGroup(
                usersButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(usersButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        usersButtonLayout.setVerticalGroup(
                usersButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(usersButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        transactionsButton.setBackground(new Color(240, 171, 141));
        transactionsButton.setMaximumSize(new Dimension(200, 45));
        transactionsButton.setMinimumSize(new Dimension(200, 45));
        transactionsButton.setPreferredSize(new Dimension(200, 45));

        //jLabel3.setIcon(new ImageIcon(getClass().getResource("/com/mycompany/imgs/payments.png")));
        jLabel3.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/payments.png")));

        GroupLayout transactionsButtonLayout = new GroupLayout(transactionsButton);
        transactionsButton.setLayout(transactionsButtonLayout);
        transactionsButtonLayout.setHorizontalGroup(
                transactionsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(transactionsButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        transactionsButtonLayout.setVerticalGroup(
                transactionsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(transactionsButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        settingsButton.setBackground(new Color(240, 171, 141));
        settingsButton.setMaximumSize(new Dimension(200, 45));
        settingsButton.setMinimumSize(new Dimension(200, 45));
        settingsButton.setPreferredSize(new Dimension(200, 45));

        //jLabel4.setIcon(new ImageIcon(getClass().getResource("/com/mycompany/imgs/settings.png")));
        jLabel4.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/settings.png")));

        GroupLayout settingsButtonLayout = new GroupLayout(settingsButton);
        settingsButton.setLayout(settingsButtonLayout);
        settingsButtonLayout.setHorizontalGroup(
                settingsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(settingsButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        settingsButtonLayout.setVerticalGroup(
                settingsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(settingsButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logoutButton.setBackground(new Color(240, 171, 141));
        logoutButton.setMaximumSize(new Dimension(200, 45));
        logoutButton.setMinimumSize(new Dimension(200, 45));
        logoutButton.setPreferredSize(new Dimension(200, 45));

        //jLabel5.setIcon(new ImageIcon(getClass().getResource("/com/mycompany/imgs/logout.png"))); // NOI18N
        jLabel5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/logout.png")));

        GroupLayout logoutButtonLayout = new GroupLayout(logoutButton);
        logoutButton.setLayout(logoutButtonLayout);
        logoutButtonLayout.setHorizontalGroup(
                logoutButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(logoutButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logoutButtonLayout.setVerticalGroup(
                logoutButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(logoutButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(settingsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(usersButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(transactionsButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                        .addComponent(restaurantButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(restaurantButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(usersButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(transactionsButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(settingsButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new Color(243, 243, 244));

        informationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        informationLabel.setText("Bottom Information");

        displayPanel.setBackground(new Color(243, 243, 244));

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
                displayPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        displayPanelLayout.setVerticalGroup(
                displayPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(informationLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(displayPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(informationLabel))
        );

        jMenu1.setText("File");
        windowMenu.add(jMenu1);

        jMenu2.setText("Edit");
        windowMenu.add(jMenu2);

        setJMenuBar(windowMenu);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
}
