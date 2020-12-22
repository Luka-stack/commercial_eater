package com.commercialeater.views.restaurants;

import com.commercialeater.Main;
import com.commercialeater.models.Restaurant;
import com.commercialeater.utilities.UIUtilities;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantDetailPage extends JPanel {

    private JTextField addressField;
    private JPanel background;
    private JPanel cancelButton;
    private JPanel clearButton;
    private JTextArea descriptionArea;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JSeparator nameFieldSeparator;
    private JSeparator addressFieldSeparator;
    private JTextField nameField;
    private JPanel saveButton;
    private JLabel titleLabel;

    private Long entityID;

    public RestaurantDetailPage() {
        initComponents();
        titleLabel.setText("Creating New Restaurant");

        this.entityID = -1L;
    }

    public RestaurantDetailPage(Long entityID) {
        initComponents();

        this.entityID = entityID;
        getRestaurantFields();
    }

    private void initComponents() {

        background = new JPanel();
        jPanel1 = new JPanel();
        titleLabel = new JLabel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        nameField = new JTextField();
        jLabel3 = new JLabel();
        addressField = new JTextField();
        jLabel4 = new JLabel();
        jScrollPane1 = new JScrollPane();
        descriptionArea = new JTextArea();

        clearButton = new JPanel();
        jLabel5 = new JLabel();
        nameFieldSeparator = new JSeparator();
        addressFieldSeparator = new JSeparator();
        jPanel3 = new JPanel();
        cancelButton = new JPanel();
        jLabel7 = new JLabel();
        saveButton = new JPanel();
        jLabel6 = new JLabel();

        background.setBackground(new Color(255, 255, 255));
        background.setForeground(new Color(255, 255, 255));

        jPanel1.setBackground(new Color(255, 255, 255));

        titleLabel.setFont(new Font("Segoe UI", 1, 24));

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
        jLabel2.setText("Name");

        nameField.setFont(new Font("Segoe UI", 0, 14));
        nameField.setBorder(null);
        nameField.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 45) {
                    super.insertString(offs, str, a);
                }
            }
        });

        jLabel3.setFont(new Font("Segoe UI", 0, 14));
        jLabel3.setText("Address");

        addressField.setFont(new Font("Segoe UI", 0, 14));
        addressField.setBorder(null);
        addressField.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 45) {
                    super.insertString(offs, str, a);
                }
            }
        });

        jLabel4.setFont(new Font("Segoe UI", 0, 14));
        jLabel4.setText("Description");

        descriptionArea.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null) {
                    return;
                }
                if ((getLength() + str.length()) <= 255) {
                    super.insertString(offs, str, a);
                }
            }
        });
        descriptionArea.setColumns(20);
        descriptionArea.setFont(new Font("Segoe UI", 0, 14));
        descriptionArea.setLineWrap(true);
        descriptionArea.setRows(5);
        descriptionArea.setBorder(new LineBorder(new Color(153, 194, 93), 1, true));
        jScrollPane1.setViewportView(descriptionArea);

        clearButton.setBackground(new Color(153, 194, 93));
        clearButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                descriptionArea.setText("");
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

        jLabel5.setFont(new Font("Segoe UI", 1, 14));
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Clear");

        GroupLayout clearButtonLayout = new GroupLayout(clearButton);
        clearButton.setLayout(clearButtonLayout);
        clearButtonLayout.setHorizontalGroup(
                clearButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, clearButtonLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
        );
        clearButtonLayout.setVerticalGroup(
                clearButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        nameFieldSeparator.setBackground(new Color(153, 194, 93));
        nameFieldSeparator.setForeground(new Color(153, 194, 93));

        addressFieldSeparator.setBackground(new Color(153, 194, 93));
        addressFieldSeparator.setForeground(new Color(153, 194, 93));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(nameField)
                                                        .addComponent(nameFieldSeparator)
                                                        .addComponent(addressField, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                        .addComponent(addressFieldSeparator))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(134, 134, 134))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(40, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                //.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGap(5, 5, 5)
                                                .addComponent(nameFieldSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                //.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(addressFieldSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
        );

        jPanel3.setBackground(new Color(244, 244, 244));

        cancelButton.setBackground(new Color(153, 194, 93));
        cancelButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancelButtonAction();
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

        jLabel7.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
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
                saveOrUpdateRestaurant();
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
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
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
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void cancelButtonAction() {

        if (entityID < 0) {
            descriptionArea.setText("");
            addressField.setText("");
            nameField.setText("");
        }
        else {
            getRestaurantFields();
        }
    }

    private void saveOrUpdateRestaurant() {

        if (validateFields()) {

            if (entityID < 0) {
                Restaurant.create(nameField.getText(), addressField.getText(), descriptionArea.getText());

                Main.mainWindow.setBottomInformation("Created new restaurant '" + nameField.getText() + "'");
            } else {
                Restaurant.update(entityID, nameField.getText(), addressField.getText(), descriptionArea.getText());

                String rowID = Main.mainWindow.getBottomInformation().split("#")[1];
                Main.mainWindow.setBottomInformation("Restaurant at row #" + rowID + " updated");
            }

            Main.mainWindow.loadRestaurantsView(false);
        }
        else {
            Main.mainWindow.setBottomInformation("Wrong Field(s) inputs");
        }
    }

    private void getRestaurantFields() {
        ResultSet restaurant = Restaurant.getById(entityID);

        try {
            while (restaurant.next()) {

                nameField.setText(restaurant.getString(Restaurant.NAME));
                addressField.setText(restaurant.getString(Restaurant.ADDRESS));
                descriptionArea.setText(restaurant.getString(Restaurant.DESCRIPTION));

                titleLabel.setText("Editing " + restaurant.getString(Restaurant.NAME));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean validateFields() {

        boolean valid = true;

        if (addressField.getText().length() == 0) {
            addressFieldSeparator.setBackground(new Color(153, 0, 0));
            addressFieldSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }
        else {
            addressFieldSeparator.setBackground(new Color(153, 194, 93));
            addressFieldSeparator.setForeground(new Color(153, 194, 93));
        }

        if (nameField.getText().length() == 0) {
            nameFieldSeparator.setBackground(new Color(153, 0, 0));
            nameFieldSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }
        else {
            nameFieldSeparator.setBackground(new Color(153, 194, 93));
            nameFieldSeparator.setForeground(new Color(153, 194, 93));
        }

        if (descriptionArea.getText().length() == 0) {
            descriptionArea.setBorder(new LineBorder(new Color(153, 0, 0), 1, true));

            valid = false;
        }
        else {
            descriptionArea.setBorder(new LineBorder(new Color(153, 194, 93), 1, true));
        }

        return valid;
    }
}
