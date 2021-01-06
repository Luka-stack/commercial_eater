package com.commercialeater.views;

import com.commercialeater.Main;
import com.commercialeater.models.Transaction;
import com.commercialeater.utilities.CustomComboBoxUI;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

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
import java.time.DayOfWeek;

public class TransactionsPage extends JPanel {

    private JPanel background;

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;

    private JPanel clearButton;
    private JPanel searchButton;

    private JComboBox<String> transactionFilter;
    private DatePicker endDateFilter;
    private DatePicker startDateFilter;
    private JTextField userFilter;

    private JTable jTable1;
    private DefaultTableModel tableModel;

    public TransactionsPage() {
        initComponents();
        getTransactionsData(false);
    }

    private void initComponents() {

        background = new JPanel();
        jPanel3 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();

        jLabel4 = new JLabel();
        searchButton = new JPanel();
        jLabel5 = new JLabel();
        clearButton = new JPanel();
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jLabel6 = new JLabel();
        userFilter = new JTextField();
        jSeparator3 = new JSeparator();
        jLabel7 = new JLabel();
        jSeparator4 = new JSeparator();
        transactionFilter = new JComboBox<>();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        tableModel = new DefaultTableModel();

        background.setBackground(Main.colorUtilities.getBackground());

        jPanel3.setBackground(Main.colorUtilities.getBackground());

        jLabel2.setFont(new Font("Segoe UI", 0, 18));
        jLabel2.setText("Filters");

        jLabel3.setFont(new Font("Segoe UI", 0, 14));
        jLabel3.setText("Start Date");

        DatePickerSettings startDateSettings = new DatePickerSettings();
        startDateSettings.setFirstDayOfWeek(DayOfWeek.MONDAY);
        startDateSettings.setColor(DatePickerSettings.DateArea.CalendarBackgroundSelectedDate, Main.colorUtilities.getMainColor());
        startDateSettings.setColor(DatePickerSettings.DateArea.TextFieldBackgroundInvalidDate, Main.colorUtilities.getBackground());
        startDateSettings.setColor(DatePickerSettings.DateArea.TextFieldBackgroundValidDate, Main.colorUtilities.getBackground());

        startDateFilter = new DatePicker(startDateSettings);
        startDateFilter.setBackground(Main.colorUtilities.getBackground());
        startDateFilter.getComponentDateTextField().setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));
        startDateFilter.getComponentDateTextField().setBackground(Main.colorUtilities.getBackground());
        startDateFilter.getComponentDateTextField().setFont(new Font("Segoe UI", 0, 14));
        startDateFilter.getComponentToggleCalendarButton().setBackground(Main.colorUtilities.getMainColor());
        startDateFilter.getComponentToggleCalendarButton().setBorderPainted(false);
        startDateFilter.getComponentToggleCalendarButton().setOpaque(true);

        DatePickerSettings endDateSettings = new DatePickerSettings();
        endDateSettings.setFirstDayOfWeek(DayOfWeek.MONDAY);
        endDateSettings.setColor(DatePickerSettings.DateArea.CalendarBackgroundSelectedDate, Main.colorUtilities.getMainColor());
        endDateSettings.setColor(DatePickerSettings.DateArea.TextFieldBackgroundInvalidDate, Main.colorUtilities.getBackground());
        endDateSettings.setColor(DatePickerSettings.DateArea.TextFieldBackgroundValidDate, Main.colorUtilities.getBackground());

        endDateFilter = new DatePicker(endDateSettings);
        endDateFilter.getComponentDateTextField().setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));
        endDateFilter.getComponentDateTextField().setBackground(Main.colorUtilities.getBackground());
        endDateFilter.getComponentDateTextField().setFont(new Font("Segoe UI", 0, 14));
        endDateFilter.getComponentToggleCalendarButton().setBackground(Main.colorUtilities.getMainColor());
        endDateFilter.getComponentToggleCalendarButton().setBorderPainted(false);
        endDateFilter.getComponentToggleCalendarButton().setOpaque(true);

        jLabel4.setFont(new Font("Segoe UI", 0, 14));
        jLabel4.setText("End Date");

        searchButton.setBackground(Main.colorUtilities.getButtonsColor());
        searchButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filterTransactions();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.colorUtilities.buttonHoverEntered(searchButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.colorUtilities.buttonHoverExited(searchButton);
            }
        });

        jLabel5.setFont(new Font("Segoe UI", 1, 12));
        jLabel5.setForeground(Main.colorUtilities.getButtonsTextColor());
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("SEARCH");

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

        clearButton.setBackground(Main.colorUtilities.getButtonsColor());
        clearButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearButtonClicked();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.colorUtilities.buttonHoverEntered(clearButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.colorUtilities.buttonHoverExited(clearButton);
            }
        });

        jLabel1.setFont(new Font("Segoe UI", 1, 12));
        jLabel1.setForeground(Main.colorUtilities.getButtonsTextColor());
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("CLEAR");

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

        jSeparator1.setBackground(Main.colorUtilities.getMainColor());
        jSeparator1.setForeground(Main.colorUtilities.getMainColor());

        jSeparator2.setBackground(Main.colorUtilities.getMainColor());
        jSeparator2.setForeground(Main.colorUtilities.getMainColor());

        jLabel6.setFont(new Font("Segoe UI", 0, 14));
        jLabel6.setText("User");

        userFilter.setFont(new Font("Segoe UI", 0, 14));
        userFilter.setBackground(Main.colorUtilities.getBackground());
        userFilter.setOpaque(false);
        userFilter.setText("All");
        userFilter.setBorder(null);

        jSeparator3.setBackground(Main.colorUtilities.getMainColor());
        jSeparator3.setForeground(Main.colorUtilities.getMainColor());

        jLabel7.setFont(new Font("Segoe UI", 0, 14));
        jLabel7.setText("Transaction");

        jSeparator4.setBackground(Main.colorUtilities.getMainColor());
        jSeparator4.setForeground(Main.colorUtilities.getMainColor());

        transactionFilter.setEditable(false);
        transactionFilter.setFont(new Font("Segoe UI", 0, 14));
        transactionFilter.setBackground(Main.colorUtilities.getBackground());
        transactionFilter.setMaximumRowCount(3);
        transactionFilter.setModel(new DefaultComboBoxModel<>(new String[] { "All", "Top_Up", "Order" }));
        transactionFilter.setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));
        transactionFilter.setMinimumSize(new Dimension(72, 25));

        transactionFilter.setUI(new CustomComboBoxUI());

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel3))
                                        .addComponent(jLabel6))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startDateFilter, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(userFilter, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(transactionFilter, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(endDateFilter, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(startDateFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(userFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel7))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(endDateFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                                                                .addComponent(transactionFilter, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())
        );

        jScrollPane1.setBackground(Main.colorUtilities.getBackground());
        jScrollPane1.setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new Font("Segoe UI", 0, 14));

        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable1.getTableHeader().setBackground(Main.colorUtilities.getBackground());
        jTable1.getTableHeader().setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setOpaque(false);
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        ((DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer()).setBorder(BorderFactory.createEtchedBorder());

        tableModel.setColumnIdentifiers(new String [] {
                "Timestamp", "Transaction", "User"
        });

        jTable1.setModel(tableModel);
        jTable1.setDefaultEditor(Object.class, null);

        jTable1.setFocusable(false);
        jTable1.setBackground(Main.colorUtilities.getBackground());
        jTable1.setGridColor(Main.colorUtilities.getMainColor());
        jTable1.setIntercellSpacing(new Dimension(0,0));
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(Main.colorUtilities.getMainColor());
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
        }

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
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE))
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

    public void getTransactionsData(boolean changeInformation) {

        tableModel.setRowCount(0);

        ResultSet transactions = Transaction.getAll();
        String[] rows = new String[3]; // Timestamp, Transaction, User
        int rowsCount = 0;

        try {
            while (transactions.next()) {

                rows[0] = transactions.getString(Transaction.TRANSACTION_DATE);
                rows[1] = transactions.getString(Transaction.TRANSACTION_TYPE);
                rows[2] = transactions.getString(Transaction.USER_CONCAT);

                tableModel.addRow(rows);
                ++rowsCount;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        if (changeInformation) {
            Main.mainWindow.setBottomInformation("Found " + rowsCount + " transactions");
        }
    }

    private void clearButtonClicked() {

        startDateFilter.getComponentDateTextField().setText("");
        endDateFilter.getComponentDateTextField().setText("");
        userFilter.setText("All");
        transactionFilter.setSelectedIndex(0);

        getTransactionsData(true);
    }

    private void filterTransactions() {

        String startDate = startDateFilter.getDate() == null ? null : startDateFilter.getDate().toString();
        String endDate = endDateFilter.getDate() == null ? null : endDateFilter.getDate().toString();

        ResultSet transactions = Transaction.getQueryData(startDate, endDate, userFilter.getText(),
                transactionFilter.getSelectedItem().toString());
        String[] rows = new String[4];
        int rowsCount = 0;

        tableModel.setRowCount(0);

        try {
            while (transactions.next()) {

                rows[0] = transactions.getString(Transaction.TRANSACTION_DATE);
                rows[1] = transactions.getString(Transaction.TRANSACTION_TYPE);
                rows[2] = transactions.getString(Transaction.USER_CONCAT);
                ++rowsCount;

                tableModel.addRow(rows);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        Main.mainWindow.setBottomInformation("Found " + rowsCount + " transactions");
    }
}
