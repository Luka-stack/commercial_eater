package com.commercialeater.views;

import com.commercialeater.utilities.UIUtilities;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserDetailPage extends JPanel {

    private JPanel background;

    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JSeparator jSeparator1;
    private JSeparator jSeparator4;
    private JSeparator jSeparator5;
    private JSeparator jSeparator6;
    private JSeparator jSeparator7;
    private JSeparator jSeparator8;
    private JLabel titleLabel;

    private JPanel cancelButton;
    private JPanel saveButton;
    private JPanel topUpButton;

    private JTextField cityField;
    private JTextField emailField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JComboBox<String> roleField;
    private JLabel balanceLabel;

    private Long entityId;

    public UserDetailPage() {
        initComponents();
        titleLabel.setText("Creating New User");

        this.entityId = -1L;
    }

    public UserDetailPage(Long entityID) {
        initComponents();

        this.entityId = entityID;
        getUserFields();
    }

    private void initComponents() {

        background = new JPanel();
        jPanel1 = new JPanel();
        titleLabel = new JLabel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        emailField = new JTextField();
        jLabel3 = new JLabel();
        jSeparator1 = new JSeparator();
        roleField = new JComboBox<>();
        jSeparator4 = new JSeparator();
        jLabel5 = new JLabel();
        firstNameField = new JTextField();
        jSeparator5 = new JSeparator();
        jLabel8 = new JLabel();
        cityField = new JTextField();
        jSeparator6 = new JSeparator();
        jLabel9 = new JLabel();
        lastNameField = new JTextField();
        jSeparator7 = new JSeparator();
        jLabel10 = new JLabel();
        jSeparator8 = new JSeparator();
        jPanel4 = new JPanel();
        jLabel1 = new JLabel();
        jLabel4 = new JLabel();
        balanceLabel = new JLabel();
        topUpButton = new JPanel();
        jLabel12 = new JLabel();
        jPanel3 = new JPanel();
        cancelButton = new JPanel();
        jLabel7 = new JLabel();
        saveButton = new JPanel();
        jLabel6 = new JLabel();

        background.setBackground(new Color(255, 255, 255));
        background.setForeground(new Color(255, 255, 255));

        jPanel1.setBackground(new Color(255, 255, 255));

        titleLabel.setFont(new Font("Segoe UI", 1, 24));
        titleLabel.setText("Editing Restaurant");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(titleLabel)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(titleLabel)
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new Color(255, 255, 255));

        jLabel2.setFont(new Font("Segoe UI", 0, 14));
        jLabel2.setText("Email");

        emailField.setFont(new Font("Segoe UI", 0, 14));
        emailField.setText("qweqweqweqweqwe");
        emailField.setBorder(null);

        jLabel3.setFont(new Font("Segoe UI", 0, 14));
        jLabel3.setText("Password");

        jSeparator1.setBackground(new Color(153, 194, 93));
        jSeparator1.setForeground(new Color(153, 194, 93));

        roleField.setEditable(true);
        roleField.setFont(new Font("Segoe UI", 0, 14));
        roleField.setMaximumRowCount(3);
        roleField.setModel(new DefaultComboBoxModel<>(new String[] { "All", "Admin", "User" }));
        roleField.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255)));

        jSeparator4.setBackground(new Color(153, 194, 93));
        jSeparator4.setForeground(new Color(153, 194, 93));
        jSeparator4.setOrientation(SwingConstants.VERTICAL);

        jLabel5.setFont(new Font("Segoe UI", 0, 14));
        jLabel5.setText("First Name");

        firstNameField.setFont(new Font("Segoe UI", 0, 14));
        firstNameField.setText("qweqweqweqweqwe");
        firstNameField.setBorder(null);

        jSeparator5.setBackground(new Color(153, 194, 93));
        jSeparator5.setForeground(new Color(153, 194, 93));

        jLabel8.setFont(new Font("Segoe UI", 0, 14));
        jLabel8.setText("City");

        cityField.setFont(new Font("Segoe UI", 0, 14));
        cityField.setText("qweqweqweqweqwe");
        cityField.setBorder(null);

        jSeparator6.setBackground(new Color(153, 194, 93));
        jSeparator6.setForeground(new Color(153, 194, 93));

        jLabel9.setFont(new Font("Segoe UI", 0, 14));
        jLabel9.setText("Last Name");

        lastNameField.setFont(new Font("Segoe UI", 0, 14));
        lastNameField.setText("qweqweqweqweqwe");
        lastNameField.setBorder(null);

        jSeparator7.setBackground(new Color(153, 194, 93));
        jSeparator7.setForeground(new Color(153, 194, 93));

        jLabel10.setFont(new Font("Segoe UI", 0, 14));
        jLabel10.setText("Role");

        jSeparator8.setBackground(new Color(153, 194, 93));
        jSeparator8.setForeground(new Color(153, 194, 93));

        jPanel4.setBackground(new Color(153, 194, 93));

        jLabel1.setFont(new Font("Segoe UI", 1, 14));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Reset Password");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jLabel4.setFont(new Font("Segoe UI", 0, 14));
        jLabel4.setText("Balance:");

        balanceLabel.setFont(new Font("Segoe UI", 0, 14));
        balanceLabel.setText("0 zl");

        topUpButton.setBackground(new Color(153, 194, 93));
        topUpButton.setPreferredSize(new Dimension(172, 25));
        topUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverEntered(topUpButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UIUtilities.buttonHoverExited(topUpButton);
            }
        });

        jLabel12.setFont(new Font("Segoe UI", 1, 14));
        jLabel12.setForeground(new Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel12.setText("Top Up");

        GroupLayout topUpButtonLayout = new GroupLayout(topUpButton);
        topUpButton.setLayout(topUpButtonLayout);
        topUpButtonLayout.setHorizontalGroup(
                topUpButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        topUpButtonLayout.setVerticalGroup(
                topUpButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(emailField, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(jSeparator1)
                                                        .addComponent(jPanel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(89, 89, 89)
                                                .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel5)
                                                                .addComponent(firstNameField)
                                                                .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel8)
                                                                .addComponent(cityField)
                                                                .addComponent(jSeparator6, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addComponent(balanceLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel9)
                                                .addComponent(lastNameField)
                                                .addComponent(jSeparator7, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel10)
                                        .addComponent(jSeparator8, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(roleField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(topUpButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                                .addGap(76, 76, 76))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(55, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(15, 15, 15)
                                                                .addComponent(jSeparator5, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel9)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(15, 15, 15)
                                                                .addComponent(jSeparator7, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(15, 15, 15)
                                                                .addComponent(jSeparator6, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(7, 7, 7)
                                                                .addComponent(roleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jSeparator8, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(topUpButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel4)
                                                                .addComponent(balanceLabel)))))
                                .addGap(34, 34, 34))
        );

        jPanel3.setBackground(new Color(244, 244, 244));

        cancelButton.setBackground(new Color(153, 194, 93));
        cancelButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverEntered(cancelButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UIUtilities.buttonHoverExited(cancelButton);
            }
        });

        jLabel7.setFont(new Font("Segoe UI", 1, 14));
        jLabel7.setForeground(new Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setText("Cancel");

        GroupLayout cancelButtonLayout = new GroupLayout(cancelButton);
        cancelButton.setLayout(cancelButtonLayout);
        cancelButtonLayout.setHorizontalGroup(
                cancelButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );
        cancelButtonLayout.setVerticalGroup(
                cancelButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        saveButton.setBackground(new Color(153, 194, 93));
        saveButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverEntered(saveButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                UIUtilities.buttonHoverExited(saveButton);
            }
        });

        jLabel6.setFont(new Font("Segoe UI", 1, 14));
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("Save");

        GroupLayout saveButtonLayout = new GroupLayout(saveButton);
        saveButton.setLayout(saveButtonLayout);
        saveButtonLayout.setHorizontalGroup(
                saveButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );
        saveButtonLayout.setVerticalGroup(
                saveButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(438, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(59, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))
        );

        GroupLayout backgroundLayout = new GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void getUserFields() {
    }

}
