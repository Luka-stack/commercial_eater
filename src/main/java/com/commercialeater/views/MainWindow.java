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
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel logOutButton;
    private JPanel main;
    private JPanel restaurantsButton;
    private JPanel restaurantsCard;
    private JPanel settingsButton;
    private JPanel settingsCard;
    private JPanel sidebar;
    private JLabel sidebarLogo;
    private JPanel transactionsButton;
    private JPanel transactionsCard;
    private JPanel usersButton;
    private JPanel usersCard;

    private JMenu addMenu;
    private JMenuBar jMenuBar1;

    public MainWindow() {
        initComponents();
    }

    private void initComponents() {

        background = new JPanel();
        sidebar = new JPanel();
        restaurantsButton = new JPanel();
        jLabel3 = new JLabel();
        jLabel8 = new JLabel();
        usersButton = new JPanel();
        jLabel4 = new JLabel();
        jLabel9 = new JLabel();
        transactionsButton = new JPanel();
        jLabel5 = new JLabel();
        jLabel10 = new JLabel();
        settingsButton = new JPanel();
        jLabel6 = new JLabel();
        jLabel11 = new JLabel();
        logOutButton = new JPanel();
        jLabel7 = new JLabel();
        jLabel12 = new JLabel();
        sidebarLogo = new JLabel();

        main = new JPanel();
        restaurantsCard = new RestaurantPage();
        usersCard = new JPanel();
        transactionsCard = new JPanel();
        settingsCard = new JPanel();

        bottomInfLabel = new JLabel();

        jMenuBar1 = new JMenuBar();
        addMenu = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(1150, 620));
        setMinimumSize(new Dimension(1150, 620));
        setPreferredSize(new Dimension(1150, 620));
        setResizable(true);

        background.setBackground(new Color(238, 233, 212));

        sidebar.setBackground(new Color(153, 194, 93));

        restaurantsButton.setBackground(new Color(153, 194, 93));
        restaurantsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                menuEntryHover(restaurantsButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuEntryStdBackground(restaurantsButton);
            }
        });

        jLabel3.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/restauratns.png"))));

        jLabel8.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new Color(255, 255, 255));
        jLabel8.setText("Restaurants");

        GroupLayout restaurantsButtonLayout = new GroupLayout(restaurantsButton);
        restaurantsButton.setLayout(restaurantsButtonLayout);
        restaurantsButtonLayout.setHorizontalGroup(
                restaurantsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(restaurantsButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        restaurantsButtonLayout.setVerticalGroup(
                restaurantsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(GroupLayout.Alignment.TRAILING, restaurantsButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)
                                .addContainerGap())
        );

        usersButton.setBackground(new Color(153, 194, 93));
        usersButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                menuEntryHover(usersButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuEntryStdBackground(usersButton);
            }
        });

        jLabel4.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/users.png"))));

        jLabel9.setFont(new Font("Segoe UI", 1, 18));
        jLabel9.setForeground(new Color(255, 255, 255));
        jLabel9.setText("Users");

        GroupLayout usersButtonLayout = new GroupLayout(usersButton);
        usersButton.setLayout(usersButtonLayout);
        usersButtonLayout.setHorizontalGroup(
                usersButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(usersButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        usersButtonLayout.setVerticalGroup(
                usersButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(GroupLayout.Alignment.TRAILING, usersButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)
                                .addContainerGap())
        );

        transactionsButton.setBackground(new Color(153, 194, 93));
        transactionsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                menuEntryHover(transactionsButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuEntryStdBackground(transactionsButton);
            }
        });

        jLabel5.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/payments.png"))));

        jLabel10.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new Color(255, 255, 255));
        jLabel10.setText("Transactions");

        GroupLayout transactionsButtonLayout = new GroupLayout(transactionsButton);
        transactionsButton.setLayout(transactionsButtonLayout);
        transactionsButtonLayout.setHorizontalGroup(
                transactionsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(transactionsButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        transactionsButtonLayout.setVerticalGroup(
                transactionsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addGroup(GroupLayout.Alignment.TRAILING, transactionsButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)
                                .addContainerGap())
        );

        settingsButton.setBackground(new Color(153, 194, 93));
        settingsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                menuEntryHover(settingsButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuEntryStdBackground(settingsButton);
            }
        });

        jLabel6.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/settings.png"))));

        jLabel11.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new Color(255, 255, 255));
        jLabel11.setText("Settings");

        GroupLayout settingsButtonLayout = new GroupLayout(settingsButton);
        settingsButton.setLayout(settingsButtonLayout);
        settingsButtonLayout.setHorizontalGroup(
                settingsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(settingsButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        settingsButtonLayout.setVerticalGroup(
                settingsButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addGroup(GroupLayout.Alignment.TRAILING, settingsButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addContainerGap())
        );

        logOutButton.setBackground(new Color(153, 194, 93));
        logOutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                menuEntryHover(logOutButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                menuEntryStdBackground(logOutButton);
            }
        });

        jLabel7.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/logout.png"))));

        jLabel12.setFont(new Font("Segoe UI", 1, 18));
        jLabel12.setForeground(new Color(255, 255, 255));
        jLabel12.setText("Log Out");

        GroupLayout logOutButtonLayout = new GroupLayout(logOutButton);
        logOutButton.setLayout(logOutButtonLayout);
        logOutButtonLayout.setHorizontalGroup(
                logOutButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(logOutButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        logOutButtonLayout.setVerticalGroup(
                logOutButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(GroupLayout.Alignment.TRAILING, logOutButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12)
                                .addContainerGap())
        );

        sidebarLogo.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/name2.png"))));

        GroupLayout sidebarLayout = new GroupLayout(sidebar);
        sidebar.setLayout(sidebarLayout);
        sidebarLayout.setHorizontalGroup(
                sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(restaurantsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usersButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(transactionsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(settingsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logOutButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(sidebarLogo)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidebarLayout.setVerticalGroup(
                sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(sidebarLogo)
                                .addGap(55, 55, 55)
                                .addComponent(restaurantsButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(usersButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(transactionsButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(settingsButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(logOutButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main.setLayout(new CardLayout());

        main.add(restaurantsCard, "card2");

        usersCard.setBackground(new Color(204, 255, 204));

        GroupLayout usersCardLayout = new GroupLayout(usersCard);
        usersCard.setLayout(usersCardLayout);
        usersCardLayout.setHorizontalGroup(
                usersCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        usersCardLayout.setVerticalGroup(
                usersCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 573, Short.MAX_VALUE)
        );

        main.add(usersCard, "card3");

        transactionsCard.setBackground(new Color(0, 51, 204));

        GroupLayout transactionsCardLayout = new GroupLayout(transactionsCard);
        transactionsCard.setLayout(transactionsCardLayout);
        transactionsCardLayout.setHorizontalGroup(
                transactionsCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        transactionsCardLayout.setVerticalGroup(
                transactionsCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 573, Short.MAX_VALUE)
        );

        main.add(transactionsCard, "card4");

        settingsCard.setBackground(new Color(0, 51, 51));

        GroupLayout settingsCardLayout = new GroupLayout(settingsCard);
        settingsCard.setLayout(settingsCardLayout);
        settingsCardLayout.setHorizontalGroup(
                settingsCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        settingsCardLayout.setVerticalGroup(
                settingsCardLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 573, Short.MAX_VALUE)
        );

        main.add(settingsCard, "card5");

        bottomInfLabel.setFont(new Font("Segoe UI", 0, 12));
        bottomInfLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        bottomInfLabel.setText("Bottom Information");

        GroupLayout backgroundLayout = new GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(sidebar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(main, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(bottomInfLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())))
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(main, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bottomInfLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        addMenu.setText("New Entity");
        addMenu.add("Restaurant");
        addMenu.add("User");

        jMenuBar1.add(addMenu);
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
