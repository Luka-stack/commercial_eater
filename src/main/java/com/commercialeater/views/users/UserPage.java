package com.commercialeater.views.users;

import com.commercialeater.Main;
import com.commercialeater.models.Restaurant;
import com.commercialeater.models.User;
import com.commercialeater.utilities.UIUtilities;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPage extends JPanel {

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JSeparator jSeparator5;

    private JPanel background;

    private JTextField cityFilter;
    private JTextField emailFilter;
    private JTextField firstNameFilter;
    private JTextField lastNameFilter;
    private JComboBox<String> roleFilter;

    private JPanel searchButton;
    private JPanel clearButton;

    private JTable jTable1;
    private DefaultTableModel tableModel;

    private JPopupMenu popupMenu;
    private JMenuItem popupItemEdit;
    private JMenuItem popupItemRemove;

    public UserPage() {
        initComponents();
        getUsersData(false);
    }

    private void initComponents() {

        background = new JPanel();
        jPanel3 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        firstNameFilter = new JTextField();
        jSeparator1 = new JSeparator();
        emailFilter = new JTextField();
        jLabel6 = new JLabel();
        jSeparator3 = new JSeparator();
        jLabel7 = new JLabel();
        cityFilter = new JTextField();
        jSeparator4 = new JSeparator();
        jLabel4 = new JLabel();
        roleFilter = new JComboBox<>();
        jSeparator2 = new JSeparator();
        jLabel8 = new JLabel();
        lastNameFilter = new JTextField();
        jSeparator5 = new JSeparator();
        clearButton = new JPanel();
        jLabel1 = new JLabel();
        searchButton = new JPanel();
        jLabel5 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        tableModel = new DefaultTableModel();

        background.setBackground(new Color(255, 255, 255));
        background.setForeground(new Color(255, 255, 255));

        jPanel3.setBackground(new Color(255, 255, 255));

        jLabel2.setFont(new Font("Segoe UI", 0, 18));
        jLabel2.setText("Filters");

        jLabel3.setFont(new Font("Segoe UI", 0, 14));
        jLabel3.setText("First Name");

        firstNameFilter.setFont(new Font("Segoe UI", 0, 14));
        firstNameFilter.setText("All");
        firstNameFilter.setBorder(null);

        jSeparator1.setBackground(new Color(153, 194, 93));
        jSeparator1.setForeground(new Color(153, 194, 93));

        emailFilter.setFont(new Font("Segoe UI", 0, 14));
        emailFilter.setText("All");
        emailFilter.setBorder(null);

        jLabel6.setFont(new Font("Segoe UI", 0, 14));
        jLabel6.setText("Email");

        jSeparator3.setBackground(new Color(153, 194, 93));
        jSeparator3.setForeground(new Color(153, 194, 93));

        jLabel7.setFont(new Font("Segoe UI", 0, 14));
        jLabel7.setText("City");

        cityFilter.setFont(new Font("Segoe UI", 0, 14));
        cityFilter.setText("All");
        cityFilter.setBorder(null);

        jSeparator4.setBackground(new Color(153, 194, 93));
        jSeparator4.setForeground(new Color(153, 194, 93));

        jLabel4.setFont(new Font("Segoe UI", 0, 14));
        jLabel4.setText("Role:");

        roleFilter.setEditable(true);
        roleFilter.setFont(new Font("Segoe UI", 0, 14));
        roleFilter.setMaximumRowCount(3);
        roleFilter.setModel(new DefaultComboBoxModel<>(new String[] { "All", "Admin", "User" }));
        roleFilter.setToolTipText("");
        roleFilter.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));

        jSeparator2.setBackground(new Color(153, 194, 93));
        jSeparator2.setForeground(new Color(153, 194, 93));

        jLabel8.setFont(new Font("Segoe UI", 0, 14));
        jLabel8.setText("Last Name");

        lastNameFilter.setFont(new Font("Segoe UI", 0, 14));
        lastNameFilter.setText("All");
        lastNameFilter.setBorder(null);

        jSeparator5.setBackground(new Color(153, 194, 93));
        jSeparator5.setForeground(new Color(153, 194, 93));

        clearButton.setBackground(new Color(153, 194, 93));
        clearButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearAndSearch();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverEntered(clearButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UIUtilities.buttonHoverExited(clearButton);
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

        searchButton.setBackground(new Color(153, 194, 93));
        searchButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filterUsers();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverEntered(searchButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UIUtilities.buttonHoverExited(searchButton);
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
                        .addComponent(jLabel5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        searchButtonLayout.setVerticalGroup(
                searchButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(firstNameFilter, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lastNameFilter, GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cityFilter, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addGap(83, 83, 83)
                                                        .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(roleFilter, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(emailFilter, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(13, 13, 13)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(emailFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(roleFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(firstNameFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lastNameFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel7))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cityFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        popupItemEdit = new JMenuItem("Edit Current Row");
        popupItemEdit.addActionListener(event -> editSelectedRow());

        popupItemRemove = new JMenuItem("Remove Current Row");
        popupItemRemove.addActionListener(event -> removeSelectedRow());

        popupMenu = new JPopupMenu();
        popupMenu.add(popupItemEdit);
        popupMenu.add(popupItemRemove);

        jScrollPane1.setBackground(new Color(255, 255, 255));
        jScrollPane1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        jTable1.setFont(new Font("Segoe UI", 0, 14));

        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable1.getTableHeader().setBackground(new Color(255, 255, 255));
        jTable1.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setOpaque(false);
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setBorder(BorderFactory.createEtchedBorder());

        tableModel.setColumnIdentifiers(new String [] {
                "Id", "First Name", "Last Name", "City", "Email", "Role"
        });

        jTable1.setModel(tableModel);
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);

        jTable1.setFocusable(false);
        jTable1.setGridColor(new Color(153, 194, 93));
        jTable1.setIntercellSpacing(new Dimension(0, 0));
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(new Color(153, 194, 93));
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jTable1.setComponentPopupMenu(popupMenu);
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int selectedRow = jTable1.getSelectedRow();
                Main.mainWindow.setBottomInformation("Selected Row #"+ (selectedRow+1));
            }
        });

        GroupLayout backgroundLayout = new GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
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

    public void getUsersData(boolean changeInformation) {

        tableModel.setRowCount(0);

        ResultSet users = User.getAll();
        String[] rows = new String[6]; // Id, First Name, Last Name, City, Email, Role
        int rowsCount = 0;

        try {
            while (users.next()) {

                rows[0] = users.getString(User.ID);
                rows[1] = users.getString(User.FIRST_NAME);
                rows[2] = users.getString(User.LAST_NAME);
                rows[3] = users.getString(User.CITY);
                rows[4] = users.getString(User.EMAIL);
                rows[5] = users.getString(User.ROLE);

                tableModel.addRow(rows);
                ++rowsCount;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        if (changeInformation) {
            Main.mainWindow.setBottomInformation("Found " + rowsCount + " users");
        }
    }

    private void editSelectedRow() {

        int selectedRow = jTable1.getSelectedRow();
        Long rowID = Long.parseLong(tableModel.getValueAt(selectedRow, 0).toString());

        Main.mainWindow.setBottomInformation("Editing Row #"+ (selectedRow+1));
        Main.mainWindow.loadUsersCreationPage(rowID);
    }

    private void removeSelectedRow() {

        int selectedRow = jTable1.getSelectedRow();
        Long rowID = Long.parseLong(tableModel.getValueAt(selectedRow, 0).toString());

        String user = tableModel.getValueAt(selectedRow, 1).toString();
        int deleteResult = User.delete(rowID);

        if (deleteResult > 0) {
            tableModel.removeRow(selectedRow);
            Main.mainWindow.setBottomInformation("User '"+ user +"'  was deleted");
        }
        else {
            Main.mainWindow.setBottomInformation("Couldn't delete User on row #"+ rowID);
        }
    }

    private void filterUsers() {

        ResultSet users = User.getQueryData(emailFilter.getText(), firstNameFilter.getText(), lastNameFilter.getText(),
                cityFilter.getText(), roleFilter.getSelectedItem().toString());
        String[] rows = new String[6];
        int rowsCount = 0;

        tableModel.setRowCount(0);

        try {
            while (users.next()) {

                rows[0] = users.getString(User.ID);
                rows[1] = users.getString(User.FIRST_NAME);
                rows[2] = users.getString(User.LAST_NAME);
                rows[3] = users.getString(User.CITY);
                rows[4] = users.getString(User.EMAIL);
                rows[5] = users.getString(User.ROLE);

                tableModel.addRow(rows);
                ++rowsCount;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        Main.mainWindow.setBottomInformation("Found " + rowsCount + " users for email: '" +
                emailFilter.getText() + "', role: '" + roleFilter.getSelectedItem().toString() +
                "', first name: '" + firstNameFilter.getText() +"', last name: '" + lastNameFilter.getText() +
                "', city: '"+ cityFilter.getText() +"'");
    }

    private void clearAndSearch() {

        emailFilter.setText("All");
        cityFilter.setText("All");
        firstNameFilter.setText("All");
        lastNameFilter.setText("All");
        roleFilter.setSelectedIndex(0);

        getUsersData(true);
    }
}
