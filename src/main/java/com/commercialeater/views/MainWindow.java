package com.commercialeater.views;

import com.commercialeater.Main;
import com.commercialeater.utilities.UIUtilities;

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

    private JPanel mainCardPanel;
    private RestaurantPage restaurantsCard;
    private UserPage usersCard;
    private TransactionsPage transactionsCard;
    private JPanel settingsCard;

    private JPanel logOutButton;
    private JPanel restaurantsButton;
    private JPanel settingsButton;
    private JPanel sidebar;
    private JLabel sidebarLogo;
    private JPanel transactionsButton;
    private JPanel usersButton;

    private JMenu newEntityMenu;
    private JMenuBar jMenuBar1;

    public MainWindow() {
        initComponents();
    }

    private void initComponents() {

        background = new JPanel();
        sidebar = new JPanel();

        jLabel3 = new JLabel();
        jLabel8 = new JLabel();
        jLabel4 = new JLabel();
        jLabel9 = new JLabel();
        jLabel5 = new JLabel();
        jLabel10 = new JLabel();
        jLabel6 = new JLabel();
        jLabel11 = new JLabel();
        jLabel7 = new JLabel();
        jLabel12 = new JLabel();
        sidebarLogo = new JLabel();

        restaurantsButton = new JPanel();
        usersButton = new JPanel();
        transactionsButton = new JPanel();
        settingsButton = new JPanel();
        logOutButton = new JPanel();

        mainCardPanel = new JPanel();
        restaurantsCard = new RestaurantPage();
        usersCard = new UserPage();
        transactionsCard = new TransactionsPage();
        settingsCard = new JPanel();

        bottomInfLabel = new JLabel();

        jMenuBar1 = new JMenuBar();
        newEntityMenu = new JMenu();

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
                loadRestaurantsView(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverEntered(restaurantsButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UIUtilities.buttonHoverExited(restaurantsButton);
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
                loadUsersView(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverEntered(usersButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UIUtilities.buttonHoverExited(usersButton);
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
                loadTransactionsView(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverEntered(transactionsButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UIUtilities.buttonHoverExited(transactionsButton);
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
                UIUtilities.buttonHoverEntered(settingsButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UIUtilities.buttonHoverExited(settingsButton);
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
                logOutButtonClicked();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverEntered(logOutButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UIUtilities.buttonHoverExited(logOutButton);
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

        mainCardPanel.setLayout(new CardLayout());

        mainCardPanel.add(restaurantsCard, "Restaurants");
        mainCardPanel.add(usersCard, "Users");
        mainCardPanel.add(transactionsCard, "Transactions");

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
                                        .addComponent(mainCardPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(bottomInfLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addContainerGap())))
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sidebar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(mainCardPanel, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bottomInfLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        newEntityMenu.setText("New Entity");

        JMenuItem newRestaurantMenuItem = new JMenuItem("Restaurant");
        newRestaurantMenuItem.addActionListener(e -> loadRestaurantCreationPage(-1L) );
        newEntityMenu.add(newRestaurantMenuItem);

        JMenuItem newUserMenuItem = new JMenuItem("User");
        newUserMenuItem.addActionListener(e -> loadUsersCreationPage(-1L) );
        newEntityMenu.add(newUserMenuItem);

        jMenuBar1.add(newEntityMenu);
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

    public void loadTransactionsView(boolean changeInformation) {

        CardLayout cardLayout = (CardLayout) mainCardPanel.getLayout();
        cardLayout.show(mainCardPanel, "Transactions");

        //transactionsCard.getTransactionsData(changeInformation);
    }

    public void loadUsersView(boolean changeInformation) {

        CardLayout cardLayout = (CardLayout) mainCardPanel.getLayout();
        cardLayout.show(mainCardPanel, "Users");

        usersCard.getUsersData(changeInformation);
    }

    public void loadRestaurantsView(boolean changeInformation) {

        CardLayout cardLayout = (CardLayout) mainCardPanel.getLayout();
        cardLayout.show(mainCardPanel, "Restaurants");

        restaurantsCard.getRestaurantsData(changeInformation);

//        try { mainCardPanel.remove(1); }
//        catch (Exception exc) {}
    }

    public void loadRestaurantCreationPage(Long entityID) {

        if (entityID < 0) {
            mainCardPanel.add(new RestaurantDetailPage(), "RestaurantDetail");
            Main.mainWindow.setBottomInformation("");
        }
        else {
            mainCardPanel.add(new RestaurantDetailPage(entityID), "RestaurantDetail");
        }

        CardLayout cardLayout = (CardLayout) mainCardPanel.getLayout();
        cardLayout.show(mainCardPanel, "RestaurantDetail");
    }

    public void loadUsersCreationPage(Long entityId) {

        if (entityId < 0) {
            mainCardPanel.add(new UserDetailPage(), "UserDetails");
            Main.mainWindow.setBottomInformation("");
        }
        else {
            mainCardPanel.add(new UserDetailPage(entityId), "UserDetails");
        }

        CardLayout cardLayout = (CardLayout) mainCardPanel.getLayout();
        cardLayout.show(mainCardPanel, "UserDetails");
    }

    public void setBottomInformation(String information) {
        bottomInfLabel.setText(information);
    }

    public String getBottomInformation() { return bottomInfLabel.getText(); }

    private void logOutButtonClicked() {

        this.dispose();
        Main.openLoginWindow();
    }
}
