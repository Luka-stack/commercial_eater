package com.commercialeater.views;

import com.commercialeater.models.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

    private JLabel cancelButton;
    private JLabel signInButton;
    private JLabel errorLabel;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTextField loginTextField;
    private JPasswordField passwordPasswordField;

    public Login() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel5 = new JLabel();
        jPanel2 = new JPanel();
        passwordPasswordField = new JPasswordField();
        loginTextField = new JTextField();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jPanel3 = new JPanel();
        signInButton = new JLabel();
        jPanel4 = new JPanel();
        cancelButton = new JLabel();
        jLabel1 = new JLabel();
        errorLabel = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setResizable(false);
        setBackground(new Color(243, 243, 244));
        setMinimumSize(new Dimension(620, 400));
        //setUndecorated(true);
        setPreferredSize(new Dimension(620, 400));

        jPanel1.setBackground(new Color(240, 171, 141));

        //jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Takacchi\\Downloads\\person-black-18dp\\2x\\"));
        jLabel5.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/pinterest_profile_image.png")));


        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new Color(243, 243, 244));

        passwordPasswordField.setBackground(new Color(243, 243, 244));
        passwordPasswordField.setFont(new Font("Tahoma", 0, 14));
        passwordPasswordField.setHorizontalAlignment(JTextField.LEFT);
        passwordPasswordField.setBorder(null);

        loginTextField.setBackground(new Color(243, 243, 244));
        loginTextField.setFont(new Font("Tahoma", 0, 14));
        loginTextField.setHorizontalAlignment(JTextField.LEFT);
        loginTextField.setBorder(null);

        jSeparator1.setBackground(new Color(240, 171, 141));
        jSeparator1.setForeground(new Color(240, 171, 141));

        jSeparator2.setBackground(new Color(240, 171, 141));
        jSeparator2.setForeground(new Color(240, 171, 141));

        jPanel3.setBackground(new Color(240, 171, 141));
        jPanel3.setBorder(new LineBorder(new Color(240, 171, 141), 1, true));

        signInButton.setFont(new Font("Tahoma", 1, 12));
        signInButton.setForeground(new Color(255, 255, 255));
        signInButton.setHorizontalAlignment(SwingConstants.CENTER);
        signInButton.setText("Sign In");
        signInButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginButtonOnAction();
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(signInButton, GroupLayout.Alignment.TRAILING,  GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(signInButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new Color(240, 171, 141));
        jPanel4.setBorder(new LineBorder(new Color(240, 171, 141), 1, true));

        cancelButton.setFont(new Font("Tahoma", 1, 12));
        cancelButton.setForeground(new Color(255, 255, 255));
        cancelButton.setHorizontalAlignment(SwingConstants.CENTER);
        cancelButton.setText("Cancel");
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cancelButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        //jLabel1.setIcon(new ImageIcon("C:\\Users\\Takacchi\\Downloads\\lock-black-36dp\\2x\\padlock.png"));
        jLabel1.setIcon(new ImageIcon(getClass().getClassLoader().getResource("imgs/padlock.png")));


        errorLabel.setBackground(new Color(158, 42, 43));
        errorLabel.setFont(new Font("Tahoma", 0, 12));
        errorLabel.setForeground(new Color(198, 42, 43));
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        jLabel2.setFont(new Font("Tahoma", 0, 14));
        jLabel2.setText("Email:");

        jLabel3.setFont(new Font("Tahoma", 0, 14));
        jLabel3.setText("Password:");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(errorLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 15, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(77, 77, 77))
                                                                //.addGap(50, 50, 50))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                        .addComponent(jLabel2)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                                                        .addComponent(loginTextField, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                        .addComponent(jLabel3)
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(jSeparator2)
                                                                                .addComponent(passwordPasswordField, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                                                .addComponent(jSeparator1))))
                                                        .addComponent(jPanel3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(jLabel1)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(loginTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel2))
                                                                .addGap(23, 23, 23))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(42, 42, 42)
                                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addGap(44, 44, 44)
                                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(178, 178, 178)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(passwordPasswordField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
                                .addGap(28, 28, 28)
                                .addComponent(errorLabel)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                //.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }


    private void loginButtonOnAction() {

        if (!loginTextField.getText().isBlank() && passwordPasswordField.getPassword().length > 0) {
            validateLogin();
        }
        else {
            errorLabel.setText("Please enter login and password");
        }
    }

    private void validateLogin() {

        boolean correctCredential = User.checkUserExistence(
                loginTextField.getText(), new String(passwordPasswordField.getPassword()));

        if (correctCredential) {
            errorLabel.setText("Successfully logged :D");
        }
        else {
            errorLabel.setText("Incorrect login or password");
        }
    }
}
