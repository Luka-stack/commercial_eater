package com.commercialeater.views;

import com.commercialeater.Main;
import com.commercialeater.models.City;

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

public class CitiesPage extends JPanel {

    private JPanel background;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel7;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JTable jTable1;
    private JTextField nameField;
    private JPanel addNewButton;
    private DefaultTableModel tableModel;

    private JPopupMenu popupMenu;
    private JMenuItem popupItemRemove;

    public CitiesPage() {
        initComponents();
        getCitiesData();
    }

    private void initComponents() {

        background = new JPanel();
        jPanel3 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        nameField = new JTextField();
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        addNewButton = new JPanel();
        jLabel7 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        tableModel = new DefaultTableModel();

        background.setBackground(Main.colorUtilities.getBackground());

        jPanel3.setBackground(Main.colorUtilities.getBackground());

        jLabel2.setFont(new Font("Segoe UI", 0, 18));
        jLabel2.setText("Filters");

        jLabel3.setFont(new Font("Segoe UI", 0, 14));
        jLabel3.setText("Name:");

        nameField.setFont(new Font("Segoe UI", 0, 14));
        nameField.setBackground(Main.colorUtilities.getBackground());
        nameField.setBorder(null);

        jSeparator1.setBackground(Main.colorUtilities.getMainColor());
        jSeparator1.setForeground(Main.colorUtilities.getMainColor());

        addNewButton.setBackground(Main.colorUtilities.getButtonsColor());
        addNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        addNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createNewCity();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.colorUtilities.buttonHoverEntered(addNewButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.colorUtilities.buttonHoverExited(addNewButton);
            }
        });

        jLabel7.setFont(new Font("Segoe UI", 1, 12));
        jLabel7.setForeground(Main.colorUtilities.getButtonsTextColor());
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setText("ADD");

        GroupLayout searchButton1Layout = new GroupLayout(addNewButton);
        addNewButton.setLayout(searchButton1Layout);
        searchButton1Layout.setHorizontalGroup(
                searchButton1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        searchButton1Layout.setVerticalGroup(
                searchButton1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12));
        jLabel1.setForeground(new Color(153, 0, 0));
        jLabel1.setText("");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGap(183, 183, 183)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                                        .addComponent(jSeparator1))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                                .addComponent(addNewButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(addNewButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addGap(16, 16, 16))
        );

        jScrollPane1.setBackground(Main.colorUtilities.getBackground());
        jScrollPane1.setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));

        popupItemRemove = new JMenuItem("Remove Selected Row");
        popupItemRemove.addActionListener(event -> removeSelectedRow());

        popupMenu = new JPopupMenu();
        popupMenu.add(popupItemRemove);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));
        jTable1.setFont(new Font("Segoe UI", 0, 14));

        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable1.getTableHeader().setBackground(Main.colorUtilities.getBackground());
        jTable1.getTableHeader().setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setOpaque(false);
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setBorder(BorderFactory.createEtchedBorder());

        tableModel.setColumnIdentifiers(new String [] { "Name" });

        jTable1.setModel(tableModel);
        jTable1.setDefaultEditor(Object.class, null);

        jTable1.setFocusable(false);
        jTable1.setGridColor(Main.colorUtilities.getMainColor());
        jTable1.setBackground(Main.colorUtilities.getBackground());
        jTable1.setIntercellSpacing(new Dimension(0, 0));
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(Main.colorUtilities.getMainColor());
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
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
                                .addComponent(jScrollPane1)
                                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
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

    private void getCitiesData() {

        ResultSet cities = City.getAll();
        String[] rows = new String[1];
        int rowsCount = 0;

        try {
            while (cities.next()) {
                rows[0] = cities.getString(City.NAME);

                tableModel.addRow(rows);
                ++rowsCount;
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

        Main.mainWindow.setBottomInformation("Found " + rowsCount + " cities");
    }

    private void createNewCity() {

        if (validateField()) {

            int result = City.create(nameField.getText());

            if (result != 1) {
                jLabel1.setText("Name has to bo unique");
            }
            else {
                tableModel.addRow(new String[] {nameField.getText()});
            }
        }
    }

    private void removeSelectedRow() {

        int selectedRow = jTable1.getSelectedRow();
        String cityName = tableModel.getValueAt(selectedRow, 1).toString();

        int result = City.delete(cityName);

        if (result > 0) {
            tableModel.removeRow(selectedRow);
            Main.mainWindow.setBottomInformation("City '"+ cityName +"' was deleted");
        }
        else {
            Main.mainWindow.setBottomInformation("Couldn't delete City on row #"+ (selectedRow+1));
        }
    }

    private boolean validateField() {

        boolean valid = false;

        if (nameField.getText().length() == 0) {
            jSeparator1.setBackground(new Color(153, 0, 0));
            jSeparator1.setBackground(new Color(153, 0, 0));

            valid = true;
        }
        else {
            jSeparator1.setBackground(Main.colorUtilities.getMainColor());
            jSeparator1.setBackground(Main.colorUtilities.getMainColor());

            jLabel1.setText("");
        }

        return valid;
    }
}
