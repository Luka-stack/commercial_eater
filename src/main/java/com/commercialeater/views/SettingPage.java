package com.commercialeater.views;

import com.commercialeater.Main;
import com.commercialeater.database.DatabaseConfig;
import com.commercialeater.utilities.FieldValidator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingPage extends JPanel {

    private DatabaseConfig dbConfig;

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
    private JSeparator dbUrlSeparator;
    private JSeparator buttonsTextColorSeparator;
    private JSeparator dbUsernameSeparator;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JSeparator mainColorSeparator;
    private JSeparator mainTextColorSeparator;
    private JSeparator buttonsColorSeparator;
    private JTextField mainColor;
    private JTextField mainTextColor;

    public SettingPage() {
        initComponents();
        fillDBFields();
        fillColorFields();
    }

    private void initComponents() {

        dbConfig = new DatabaseConfig();

        background = new JPanel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        dbUrl = new JTextField();
        dbUrlSeparator = new JSeparator();
        jSeparator4 = new JSeparator();
        jLabel9 = new JLabel();
        mainColor = new JTextField();
        mainColorSeparator = new JSeparator();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        dbUsername = new JTextField();
        dbUsernameSeparator = new JSeparator();
        jLabel5 = new JLabel();
        jSeparator3 = new JSeparator();
        dbPassword = new JPasswordField();
        jLabel10 = new JLabel();
        mainTextColor = new JTextField();
        mainTextColorSeparator = new JSeparator();
        jLabel11 = new JLabel();
        buttonsColor = new JTextField();
        buttonsColorSeparator = new JSeparator();
        jLabel12 = new JLabel();
        buttonsTextColor = new JTextField();
        buttonsTextColorSeparator = new JSeparator();
        buttonDBClear = new JPanel();
        jLabel6 = new JLabel();
        buttonDBSave = new JPanel();
        jLabel15 = new JLabel();
        buttonColorSave = new JPanel();
        jLabel17 = new JLabel();
        buttonColorClear = new JPanel();
        jLabel16 = new JLabel();

        background.setBackground(Main.colorUtilities.getBackground());

        jPanel2.setBackground(Main.colorUtilities.getBackground());

        jLabel2.setFont(new Font("Segoe UI", 0, 14));
        jLabel2.setText("Url");

        dbUrl.setFont(new Font("Segoe UI", 0, 14));
        dbUrl.setBackground(Main.colorUtilities.getBackground());
        dbUrl.setBorder(null);

        dbUrlSeparator.setBackground(Main.colorUtilities.getMainColor());
        dbUrlSeparator.setForeground(Main.colorUtilities.getMainColor());

        jSeparator4.setBackground(Main.colorUtilities.getMainColor());
        jSeparator4.setForeground(Main.colorUtilities.getMainColor());
        jSeparator4.setOrientation(SwingConstants.VERTICAL);

        jLabel9.setFont(new Font("Segoe UI", 0, 14));
        jLabel9.setText("Main Color");

        mainColor.setFont(new Font("Segoe UI", 0, 14));
        mainColor.setBackground(Main.colorUtilities.getBackground());
        mainColor.setBorder(null);

        mainColorSeparator.setBackground(Main.colorUtilities.getMainColor());
        mainColorSeparator.setForeground(Main.colorUtilities.getMainColor());

        jLabel1.setFont(new Font("Segoe UI", 1, 18));
        jLabel1.setText("Database Config");

        jLabel3.setFont(new Font("Segoe UI", 1, 18));
        jLabel3.setText("Colors Config");

        jLabel4.setFont(new Font("Segoe UI", 0, 14));
        jLabel4.setText("User Name");

        dbUsername.setFont(new Font("Segoe UI", 0, 14));
        dbUsername.setBackground(Main.colorUtilities.getBackground());
        dbUsername.setBorder(null);

        dbUsernameSeparator.setBackground(Main.colorUtilities.getMainColor());
        dbUsernameSeparator.setForeground(Main.colorUtilities.getMainColor());

        jLabel5.setFont(new Font("Segoe UI", 0, 14));
        jLabel5.setText("Password");

        jSeparator3.setBackground(Main.colorUtilities.getMainColor());
        jSeparator3.setForeground(Main.colorUtilities.getMainColor());

        dbPassword.setFont(new Font("Segoe UI", 0, 14));
        dbPassword.setBackground(Main.colorUtilities.getBackground());
        dbPassword.setBorder(null);

        jLabel10.setFont(new Font("Segoe UI", 0, 14));
        jLabel10.setText("Main Text Color");

        mainTextColor.setFont(new Font("Segoe UI", 0, 14));
        mainTextColor.setBackground(Main.colorUtilities.getBackground());
        mainTextColor.setBorder(null);

        mainTextColorSeparator.setBackground(Main.colorUtilities.getMainColor());
        mainTextColorSeparator.setForeground(Main.colorUtilities.getMainColor());

        jLabel11.setFont(new Font("Segoe UI", 0, 14));
        jLabel11.setText("Buttons Color");

        buttonsColor.setFont(new Font("Segoe UI", 0, 14));
        buttonsColor.setBackground(Main.colorUtilities.getBackground());
        buttonsColor.setBorder(null);

        buttonsColorSeparator.setBackground(Main.colorUtilities.getMainColor());
        buttonsColorSeparator.setForeground(Main.colorUtilities.getMainColor());

        jLabel12.setFont(new Font("Segoe UI", 0, 14));
        jLabel12.setText("Buttons Text Color");

        buttonsTextColor.setFont(new Font("Segoe UI", 0, 14));
        buttonsTextColor.setBackground(Main.colorUtilities.getBackground());
        buttonsTextColor.setBorder(null);

        buttonsTextColorSeparator.setBackground(Main.colorUtilities.getMainColor());
        buttonsTextColorSeparator.setForeground(Main.colorUtilities.getMainColor());

        buttonDBClear.setBackground(Main.colorUtilities.getButtonsColor());
        buttonDBClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fillDBFields();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.colorUtilities.buttonHoverEntered(buttonDBClear);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.colorUtilities.buttonHoverExited(buttonDBClear);
            }
        });

        jLabel6.setFont(new Font("Segoe UI", 1, 14));
        jLabel6.setForeground(Main.colorUtilities.getButtonsTextColor());
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("CANCEL");

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

        buttonDBSave.setBackground(Main.colorUtilities.getButtonsColor());
        buttonDBSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveDbConfig();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.colorUtilities.buttonHoverExited(buttonDBSave);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.colorUtilities.buttonHoverEntered(buttonDBSave);
            }
        });

        jLabel15.setFont(new Font("Segoe UI", 1, 14));
        jLabel15.setForeground(Main.colorUtilities.getButtonsTextColor());
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

        buttonColorSave.setBackground(Main.colorUtilities.getButtonsColor());
        buttonColorSave.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveColorConfig();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.colorUtilities.buttonHoverEntered(buttonColorSave);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.colorUtilities.buttonHoverExited(buttonColorSave);
            }
        });

        jLabel17.setFont(new Font("Segoe UI", 1, 14));
        jLabel17.setForeground(Main.colorUtilities.getButtonsTextColor());
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
                        .addComponent(jLabel17, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        buttonColorClear.setBackground(Main.colorUtilities.getButtonsColor());
        buttonColorClear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.colorUtilities.buttonHoverEntered(buttonColorClear);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.colorUtilities.buttonHoverExited(buttonColorClear);
            }
        });

        jLabel16.setFont(new Font("Segoe UI", 1, 14));
        jLabel16.setForeground(Main.colorUtilities.getButtonsTextColor());
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
                                                .addComponent(dbUsernameSeparator)
                                                .addComponent(jLabel2)
                                                .addComponent(dbUrl)
                                                .addComponent(dbUrlSeparator)
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
                                                                                .addComponent(mainTextColorSeparator, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jLabel9)
                                                                                .addComponent(mainColor)
                                                                                .addComponent(mainColorSeparator, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jLabel12)
                                                                                .addComponent(buttonsTextColor)
                                                                                .addComponent(buttonsTextColorSeparator, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jLabel11)
                                                                                .addComponent(buttonsColor)
                                                                                .addComponent(buttonsColorSeparator, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
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
                                                                .addComponent(dbUrlSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(dbUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(dbUsernameSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
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
                                                                                .addComponent(mainColorSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel11)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(buttonsColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(buttonsColorSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(27, 27, 27)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel10)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(mainTextColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(mainTextColorSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel12)
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(buttonsTextColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(buttonsTextColorSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))))
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

    private void fillColorFields() {

        mainColor.setText(Main.colorUtilities.getMainColorHEX());
        mainTextColor.setText(Main.colorUtilities.getMainTextColorHEX());
        buttonsColor.setText(Main.colorUtilities.getButtonsColorHEX());
        buttonsTextColor.setText(Main.colorUtilities.getButtonsTextColorHEX());
    }

    private void saveColorConfig() {

        if (validateColorFields()) {
            Main.colorUtilities.saveConfig(mainColor.getText(), mainTextColor.getText(),
                    buttonsColor.getText(), buttonsTextColor.getText());

            Main.redrawWindowWithNewStyle();
        }
        else {
            Main.mainWindow.setBottomInformation("Wrong Field(s) inputs");
        }
    }

    private boolean validateColorFields() {

        boolean valid = true;

        if (FieldValidator.validateHEXColor(mainColor.getText()) ||
            FieldValidator.validateRGBColor(mainColor.getText()))
        {
            mainColorSeparator.setBackground(Main.colorUtilities.getMainColor());
            mainColorSeparator.setForeground(Main.colorUtilities.getMainColor());
        }
        else {
            mainColorSeparator.setBackground(new Color(153, 0, 0));
            mainColorSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }

        if (FieldValidator.validateHEXColor(mainTextColor.getText()) ||
            FieldValidator.validateRGBColor(mainTextColor.getText()))
        {
            mainTextColorSeparator.setBackground(Main.colorUtilities.getMainColor());
            mainTextColorSeparator.setForeground(Main.colorUtilities.getMainColor());
        }
        else {
            mainTextColorSeparator.setBackground(new Color(153, 0, 0));
            mainTextColorSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }

        if (FieldValidator.validateHEXColor(buttonsColor.getText()) ||
            FieldValidator.validateRGBColor(buttonsColor.getText()))
        {
            buttonsColorSeparator.setBackground(Main.colorUtilities.getMainColor());
            buttonsColorSeparator.setForeground(Main.colorUtilities.getMainColor());
        }
        else {
            buttonsColorSeparator.setBackground(new Color(153, 0, 0));
            buttonsColorSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }

        if (FieldValidator.validateHEXColor(buttonsTextColor.getText()) ||
            FieldValidator.validateRGBColor(buttonsTextColor.getText()))
        {
            buttonsTextColorSeparator.setBackground(Main.colorUtilities.getMainColor());
            buttonsTextColorSeparator.setForeground(Main.colorUtilities.getMainColor());
        }
        else {
            buttonsTextColorSeparator.setBackground(new Color(153, 0, 0));
            buttonsTextColorSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }

        return valid;
    }

    private void fillDBFields() {

        dbUrl.setText(dbConfig.getDbUrl());
        dbUsername.setText(dbConfig.getDbUsername());
        dbPassword.setText(dbConfig.getDbPassword());
    }

    private void saveDbConfig() {

        if (validateDbFields()) {
            dbConfig.saveConfig(dbUrl.getText(), dbUsername.getText(),
                    String.valueOf(dbPassword.getPassword()));

            Main.mainWindow.setBottomInformation("Database config file successfully saved");
        }
        else {
            Main.mainWindow.setBottomInformation("Wrong Field(s) inputs");
        }
    }

    private boolean validateDbFields() {

        boolean valid = true;

        if (!FieldValidator.validateDBUrl(dbUrl.getText())) {
            dbUrlSeparator.setBackground(new Color(153, 0, 0));
            dbUrlSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }
        else {
            dbUrlSeparator.setBackground(Main.colorUtilities.getMainColor());
            dbUrlSeparator.setForeground(Main.colorUtilities.getMainColor());
        }

        if (dbUsername.getText().length() == 0) {
            dbUsernameSeparator.setBackground(new Color(153, 0, 0));
            dbUsernameSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }
        else {
            dbUrlSeparator.setBackground(Main.colorUtilities.getMainColor());
            dbUrlSeparator.setForeground(Main.colorUtilities.getMainColor());
        }

        return valid;
    }

}
