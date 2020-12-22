package com.commercialeater.views.users;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BalancePopup extends JDialog {

    private double balance;
    private JTextField balanceField;

    public BalancePopup(Frame parent) {

        super(parent);
        initComponents();
    }

    private void initComponents() {

        JLabel textLabel = new JLabel("Balance");
        textLabel.setFont(new Font("Segoe UI", 1, 14));

        NumberFormat format = DecimalFormat.getInstance();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(0.0);
        balanceField = new JFormattedTextField(formatter);

        JButton addButton = new JButton(" ADD ");
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        addButton.setBackground(new Color(153, 194, 93));
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setOpaque(true);
        addButton.repaint();
        addButton.setBorderPainted(false);
        addButton.addActionListener(event -> addBalance());

        JButton cancelButton = new JButton(" CANCEL ");
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        cancelButton.setBackground(new Color(153, 194, 93));
        cancelButton.setForeground(new Color(255, 255, 255));
        cancelButton.setOpaque(true);
        cancelButton.repaint();
        cancelButton.setBorderPainted(false);
        cancelButton.addActionListener(event -> dispose());

        createLayout(textLabel, balanceField, addButton, cancelButton);

        setModalityType(ModalityType.APPLICATION_MODAL);
        setTitle("Add Balance");
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getParent());
        setVisible(true);
    }

    private void addBalance() {

        balance = Double.parseDouble(balanceField.getText());
        dispose();
    }

    public double getBalance() {
        return balance;
    }

    private void createLayout(JComponent... args) {

        Container pane = getContentPane();
        GroupLayout groupLayout = new GroupLayout(pane);
        pane.setLayout(groupLayout);

        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.setAutoCreateGaps(true);

        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(args[2])
                                                .addComponent(args[3]))
                                        .addComponent(args[1])
                                        .addComponent(args[0])))
        );

        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(args[0])
                                .addComponent(args[1])
                                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(args[2])
                                        .addComponent(args[3])))
        );

        pack();
    }
}
