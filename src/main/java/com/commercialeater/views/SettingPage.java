package com.commercialeater.views;

import com.commercialeater.utilities.UIUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingPage extends JPanel {

    private JPanel background;
    private JTextField buttonsColor;
    private JTextField buttonsTextColor;
    private JPanel cancelButton1;
    private JPasswordField dbPassword;
    private JTextField dbUrl;
    private JTextField dbUsername;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel buttonDBClear;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel buttonDBSave;
    private JPanel jPanel7;
    private JPanel buttonColorSave;
    private JPanel buttonColorClear;
    private JSeparator jSeparator1;
    private JSeparator jSeparator10;
    private JSeparator jSeparator2;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JSeparator jSeparator7;
    private JSeparator jSeparator8;
    private JSeparator jSeparator9;
    private JTextField mainColor;
    private JTextField mainTextColor;

    public SettingPage() {
        initComponents();
    }

    private void initComponents() {

        background = new JPanel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        dbUrl = new JTextField();
        jSeparator1 = new JSeparator();
        jSeparator4 = new JSeparator();
        jLabel9 = new JLabel();
        mainColor = new JTextField();
        jSeparator7 = new JSeparator();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        dbUsername = new JTextField();
        jSeparator2 = new JSeparator();
        jLabel5 = new JLabel();
        jSeparator3 = new JSeparator();
        dbPassword = new JPasswordField();
        jLabel10 = new JLabel();
        mainTextColor = new JTextField();
        jSeparator8 = new JSeparator();
        jLabel11 = new JLabel();
        buttonsColor = new JTextField();
        jSeparator9 = new JSeparator();
        jLabel12 = new JLabel();
        buttonsTextColor = new JTextField();
        jSeparator10 = new JSeparator();
        buttonDBClear = new JPanel();
        jLabel6 = new JLabel();
        buttonDBSave = new JPanel();
        jLabel15 = new JLabel();
        buttonColorSave = new JPanel();
        jLabel17 = new JLabel();
        buttonColorClear = new JPanel();
        jLabel16 = new JLabel();


        background.setBackground(new Color(255, 255, 255));
        background.setForeground(new Color(255, 255, 255));

        jPanel2.setBackground(new Color(255, 255, 255));

        jLabel2.setFont(new Font("Segoe UI", 0, 14));
        jLabel2.setText("Url");

        dbUrl.setFont(new Font("Segoe UI", 0, 14));
        dbUrl.setBorder(null);

        jSeparator1.setBackground(new Color(153, 194, 93));
        jSeparator1.setForeground(new Color(153, 194, 93));

        jSeparator4.setBackground(new Color(153, 194, 93));
        jSeparator4.setForeground(new Color(153, 194, 93));
        jSeparator4.setOrientation(SwingConstants.VERTICAL);

        jLabel9.setFont(new Font("Segoe UI", 0, 14));
        jLabel9.setText("Main Color");

        mainColor.setFont(new Font("Segoe UI", 0, 14));
        mainColor.setBorder(null);

        jSeparator7.setBackground(new Color(153, 194, 93));
        jSeparator7.setForeground(new Color(153, 194, 93));

        jLabel1.setFont(new Font("Segoe UI", 1, 18));
        jLabel1.setText("Database Config");

        jLabel3.setFont(new Font("Segoe UI", 1, 18));
        jLabel3.setText("Colors Config");

        jLabel4.setFont(new Font("Segoe UI", 0, 14));
        jLabel4.setText("User Name");

        dbUsername.setFont(new Font("Segoe UI", 0, 14));
        dbUsername.setBorder(null);

        jSeparator2.setBackground(new Color(153, 194, 93));
        jSeparator2.setForeground(new Color(153, 194, 93));

        jLabel5.setFont(new Font("Segoe UI", 0, 14));
        jLabel5.setText("Password");

        jSeparator3.setBackground(new Color(153, 194, 93));
        jSeparator3.setForeground(new Color(153, 194, 93));

        dbPassword.setFont(new Font("Segoe UI", 0, 14));
        dbPassword.setBorder(null);

        jLabel10.setFont(new Font("Segoe UI", 0, 14));
        jLabel10.setText("Main Text Color");

        mainTextColor.setFont(new Font("Segoe UI", 0, 14));
        mainTextColor.setBorder(null);

        jSeparator8.setBackground(new Color(153, 194, 93));
        jSeparator8.setForeground(new Color(153, 194, 93));

        jLabel11.setFont(new Font("Segoe UI", 0, 14));
        jLabel11.setText("Buttons Color");

        buttonsColor.setFont(new Font("Segoe UI", 0, 14));
        buttonsColor.setBorder(null);

        jSeparator9.setBackground(new Color(153, 194, 93));
        jSeparator9.setForeground(new Color(153, 194, 93));

        jLabel12.setFont(new Font("Segoe UI", 0, 14));
        jLabel12.setText("Buttons Text Color");

        buttonsTextColor.setFont(new Font("Segoe UI", 0, 14));
        buttonsTextColor.setBorder(null);

        jSeparator10.setBackground(new Color(153, 194, 93));
        jSeparator10.setForeground(new Color(153, 194, 93));

        buttonDBClear.setBackground(new Color(153, 194, 93));
        buttonDBClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                UIUtilities.buttonHoverEntered(buttonDBClear);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverExited(buttonDBClear);
            }
        });

        jLabel6.setFont(new Font("Segoe UI", 1, 14));
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("CLEAR");

        GroupLayout jPanel1Layout = new GroupLayout(buttonDBClear);
        buttonDBClear.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        buttonDBSave.setBackground(new Color(153, 194, 93));
        buttonDBSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                UIUtilities.buttonHoverEntered(buttonDBSave);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverExited(buttonDBSave);
            }
        });

        jLabel15.setFont(new Font("Segoe UI", 1, 14));
        jLabel15.setForeground(new Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel15.setText("SAVE");

        GroupLayout jPanel6Layout = new GroupLayout(buttonDBSave);
        buttonDBSave.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        buttonColorSave.setBackground(new Color(153, 194, 93));
        buttonColorSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                UIUtilities.buttonHoverEntered(buttonColorSave);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverExited(buttonColorSave);
            }
        });


        jLabel17.setFont(new Font("Segoe UI", 1, 14));
        jLabel17.setForeground(new Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel17.setText("SAVE");

        GroupLayout jPanel8Layout = new GroupLayout(buttonColorSave);
        buttonColorSave.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        buttonColorClear.setBackground(new Color(153, 194, 93));
        buttonColorClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                UIUtilities.buttonHoverEntered(buttonColorClear);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                UIUtilities.buttonHoverExited(buttonColorClear);
            }
        });

        jLabel16.setFont(new Font("Segoe UI", 1, 14));
        jLabel16.setForeground(new Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel16.setText("CLEAR");

        GroupLayout jPanel9Layout = new GroupLayout(buttonColorClear);
        buttonColorClear.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel4)
                                                .addComponent(dbUsername, GroupLayout.Alignment.TRAILING)
                                                .addComponent(jSeparator2)
                                                .addComponent(jLabel2)
                                                .addComponent(dbUrl)
                                                .addComponent(jSeparator1)
                                                .addComponent(jLabel5)
                                                .addComponent(jSeparator3)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGap(31, 31, 31)
                                                        .addComponent(jLabel1))
                                                .addComponent(dbPassword))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(buttonDBClear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonDBSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(71, 71, 71)
                                .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGap(146, 146, 146)
                                                .addComponent(jLabel3)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(42, 42, 42)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jLabel10)
                                                                                .addComponent(mainTextColor)
                                                                                .addComponent(jSeparator8, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jLabel9)
                                                                                .addComponent(mainColor)
                                                                                .addComponent(jSeparator7, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jLabel12)
                                                                                .addComponent(buttonsTextColor)
                                                                                .addComponent(jSeparator10, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jLabel11)
                                                                                .addComponent(buttonsColor)
                                                                                .addComponent(jSeparator9, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(buttonColorClear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(buttonColorSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(54, 54, 54))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3))
                                                .addGap(41, 41, 41)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(dbUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(dbUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(dbPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel9)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(mainColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jSeparator7, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel11)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(buttonsColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jSeparator9, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(27, 27, 27)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel10)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(mainTextColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jSeparator8, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel12)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(buttonsTextColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jSeparator10, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))))
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(buttonDBClear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(buttonDBSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(buttonColorClear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(buttonColorSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap(78, Short.MAX_VALUE))
        );

        GroupLayout backgroundLayout = new GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
                backgroundLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
}
