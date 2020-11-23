package com.commercialeater.views;

import com.commercialeater.Main;
import com.commercialeater.models.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class LoginWindow extends JFrame {

    private JPanel cancelButton;
    private JTextField emailTextField;
    private JLabel errorMessageLabel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JPasswordField passwdPasswordField;
    private JPanel signInButton;

    public LoginWindow() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        passwdPasswordField = new JPasswordField();
        emailTextField = new JTextField();
        cancelButton = new JPanel();
        jLabel7 = new JLabel();
        signInButton = new JPanel();
        jLabel6 = new JLabel();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        errorMessageLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(243, 243, 244));
        setMaximumSize(new Dimension(700, 450));
        setMinimumSize(new Dimension(700, 450));
        ///setUndecorated(true);
        setPreferredSize(new Dimension(700, 450));
        setResizable(false);

        jPanel1.setBackground(new Color(153, 194, 93));
        jLabel1.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/new_logo.png"))));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50))
        );

        jPanel2.setBackground(new Color(238, 233, 212));
        jPanel2.setPreferredSize(new Dimension(400, 262));

        jLabel2.setIcon(new ImageIcon(Objects.requireNonNull(
                getClass().getClassLoader().getResource("imgs/padlock.png"))));

        jLabel3.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new Color(102, 83, 51));
        jLabel3.setText("Email:");

        jLabel4.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new Color(102, 83, 51));
        jLabel4.setText("Password:");

        passwdPasswordField.setBackground(new Color(238, 233, 212));
        passwdPasswordField.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        passwdPasswordField.setBorder(null);

        emailTextField.setBackground(new Color(238, 233, 212));
        emailTextField.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        emailTextField.setBorder(null);

        cancelButton.setBackground(new Color(153, 194, 93));
        cancelButton.setBorder(new LineBorder(new java.awt.Color(153, 194, 93), 1, true));
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        jLabel7.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new Color(249, 246, 241));
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setText("Cancel");

        GroupLayout cancelButtonLayout = new GroupLayout(cancelButton);
        cancelButton.setLayout(cancelButtonLayout);
        cancelButtonLayout.setHorizontalGroup(
                cancelButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cancelButtonLayout.setVerticalGroup(
                cancelButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        signInButton.setBackground(new Color(153, 194, 93));
        signInButton.setBorder(new LineBorder(new Color(153, 194, 93), 1, true));
        signInButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                singInButtonOnAction();
            }
        });

        jLabel6.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new Color(249, 246, 241));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("Sign In");

        GroupLayout signInButtonLayout = new GroupLayout(signInButton);
        signInButton.setLayout(signInButtonLayout);
        signInButtonLayout.setHorizontalGroup(
                signInButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        signInButtonLayout.setVerticalGroup(
                signInButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jSeparator1.setBackground(new Color(153, 194, 93));
        jSeparator1.setForeground(new Color(153, 194, 93));

        jSeparator2.setBackground(new Color(153, 194, 93));
        jSeparator2.setForeground(new Color(153, 194, 93));

        errorMessageLabel.setFont(new Font("Segoe UI", 0, 12));
        errorMessageLabel.setForeground(new Color(153, 0, 0));
        errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(signInButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(errorMessageLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(emailTextField, GroupLayout.Alignment.LEADING)
                                                                .addComponent(jSeparator1, GroupLayout.Alignment.LEADING)
                                                                .addComponent(passwdPasswordField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                                                .addComponent(jSeparator2, GroupLayout.Alignment.LEADING)))))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(passwdPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(errorMessageLabel)
                                .addGap(27, 27, 27)
                                .addComponent(signInButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );

        pack();
    }

    private void singInButtonOnAction() {

        if (!emailTextField.getText().isBlank() && passwdPasswordField.getPassword().length > 0) {
            validateLogin();
        }
        else {
            errorMessageLabel.setText("Please enter login and password");
        }
    }

    private void validateLogin() {

        boolean correctCredential = User.checkUserExistence(
                emailTextField.getText(), new String(passwdPasswordField.getPassword()));

        if (correctCredential) {
            //errorMessageLabel.setText("Successfully logged :D");

            this.dispose();
            Main.openMainApplication(emailTextField.getText());
        }
        else {
            errorMessageLabel.setText("Incorrect login or password");
        }
    }
}
