package com.commercialeater.views;

import com.commercialeater.Main;
import com.commercialeater.models.Restaurant;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantPage extends JPanel {

    private JPanel background;
    private JPanel clearButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JPanel searchButton;

    private DefaultTableModel tableModel;
    private JTable jTable1;

    private JTextField nameFilter;
    private JTextField addressFilter;

    public RestaurantPage() {
        initComponents();
        getRestaurantsData(true);
    }

    private void initComponents() {

        background = new JPanel();
        jPanel3 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        nameFilter = new JTextField();
        jLabel4 = new JLabel();
        addressFilter = new JTextField();
        searchButton = new JPanel();
        jLabel5 = new JLabel();
        clearButton = new JPanel();
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jLabel6 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        tableModel = new DefaultTableModel();

//        setMaximumSize(new Dimension(800, 100));
//        setMinimumSize(new Dimension(800, 100));

        background.setBackground(new Color(255, 255, 255));
        background.setForeground(new Color(255, 255, 255));

        jPanel3.setBackground(new Color(255, 255, 255));

        jLabel2.setFont(new Font("Segoe UI", 0, 18));
        jLabel2.setText("Filters");

        jLabel3.setFont(new Font("Segoe UI", 0, 14));
        jLabel3.setText("Name:");

        nameFilter.setFont(new Font("Segoe UI", 0, 14));
        nameFilter.setText("All");
        nameFilter.setBorder(null);

        jLabel4.setFont(new Font("Segoe UI", 0, 14));
        jLabel4.setText("Address:");

        addressFilter.setFont(new Font("Segoe UI", 0, 14));
        addressFilter.setText("All");
        addressFilter.setBorder(null);

        searchButton.setBackground(new Color(153, 194, 93));
        searchButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filterRestaurants();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonHoverEntered(searchButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonHoverExited(searchButton);
            }
        });

        jLabel5.setBackground(new Color(255, 255, 255));
        jLabel5.setFont(new Font("Segoe UI", 1, 12));
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Search");

        GroupLayout searchButtonLayout = new GroupLayout(searchButton);
        searchButton.setLayout(searchButtonLayout);
        searchButtonLayout.setHorizontalGroup(
                searchButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        searchButtonLayout.setVerticalGroup(
                searchButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        clearButton.setBackground(new Color(153, 194, 93));
        clearButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getRestaurantsData(false);
                nameFilter.setText("All");
                addressFilter.setText("All");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonHoverEntered(clearButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonHoverExited(clearButton);
            }
        });

        jLabel1.setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Segoe UI", 1, 12));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Clear");

        GroupLayout clearButtonLayout = new GroupLayout(clearButton);
        clearButton.setLayout(clearButtonLayout);
        clearButtonLayout.setHorizontalGroup(
                clearButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        clearButtonLayout.setVerticalGroup(
                clearButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jSeparator1.setBackground(new Color(153, 194, 93));
        jSeparator1.setForeground(new Color(153, 194, 93));

        jSeparator2.setBackground(new Color(153, 194, 93));
        jSeparator2.setForeground(new Color(153, 194, 93));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nameFilter, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                .addGap(191, 191, 191)))
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(addressFilter, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(9, 9, 9)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(nameFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(addressFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addGap(41, 41, 41))
        );

        jScrollPane1.setBackground(new Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new Font("Segoe UI", 0, 14));

        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setOpaque(false);

        tableModel.setColumnIdentifiers(new String [] {
                "Name", "Address", "Description"
        });
        jTable1.setModel(tableModel);

        jTable1.setFocusable(false);
        jTable1.setGridColor(new Color(255, 255, 255));
        jTable1.setIntercellSpacing(new Dimension(0, 0));
        jTable1.setRowHeight(30);
        jTable1.setSelectionBackground(new Color(153, 194, 93));
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
        }

        GroupLayout backgroundLayout = new GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(background, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(background, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void getRestaurantsData(boolean onLoad) {

        ResultSet restaurants = Restaurant.getAll();
        String[] rows = new String[3]; // Name, Address, Description
        int rowsCount = 0;

        try {
            while (restaurants.next()) {

                rows[0] = restaurants.getString(Restaurant.NAME);
                rows[1] = restaurants.getString(Restaurant.ADDRESS);
                rows[2] = restaurants.getString(Restaurant.DESCRIPTION);

                tableModel.addRow(rows);
                ++rowsCount;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        if (!onLoad) {
            Main.mainWindow.setBottomInformation("Found " + rowsCount + " restaurants");
        }
    }

    private void filterRestaurants() {

        ResultSet restaurants = Restaurant.getQueryData(nameFilter.getText(), addressFilter.getText());
        String[] rows = new String[3];
        int rowsCount = 0;

        tableModel.setRowCount(0);

        try {
            while (restaurants.next()) {

                rows[0] = restaurants.getString(Restaurant.NAME);
                rows[1] = restaurants.getString(Restaurant.ADDRESS);
                rows[2] = restaurants.getString(Restaurant.DESCRIPTION);
                ++rowsCount;

                tableModel.addRow(rows);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        Main.mainWindow.setBottomInformation("Found " + rowsCount + " restaurants for name: " +
                nameFilter.getText() + ", address: " + addressFilter.getText());
    }

    private void buttonHoverExited(JPanel panel) {
        panel.setBackground(new Color(153, 194, 93));
    }

    private void buttonHoverEntered(JPanel panel) {
        panel.setBackground(new Color(125, 166, 63));
    }
}
