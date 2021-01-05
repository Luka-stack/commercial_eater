package com.commercialeater.views.dishes;

import com.commercialeater.Main;
import com.commercialeater.models.Dish;
import com.commercialeater.utilities.CustomComboBoxUI;
import com.commercialeater.utilities.FieldValidator;

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
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishDetailPage extends JPanel {

    private JPanel background;
    private JPanel cancelButton;
    private JPanel clearButton;
    private JComboBox<String> typeField;
    private JComboBox<String> dietField;
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
    private JScrollPane jScrollPane1;
    private JSeparator nameFieldSepartor;
    private JSeparator priceFieldSeparator;
    private JSeparator jSeparator3;
    private JSeparator jSeparator4;
    private JTextArea descriptionField;
    private JTextField nameField;
    private JTextField priceField;
    private JPanel saveButton;
    private JLabel titleLabel;

    private final String restaurantName;
    private final Long restaurantId;
    private final Long dishId;

    public DishDetailPage(String restaurantName, Long restaurantId, Long dishId) {

        this.restaurantName = restaurantName;
        this.restaurantId = restaurantId;
        this.dishId = dishId;

        initComponents();
        getDishFields();
    }

    public DishDetailPage(String restaurantName, Long restaurantId) {

        this.restaurantName = restaurantName;
        this.restaurantId = restaurantId;
        this.dishId = -1L;

        initComponents();
    }

    private void initComponents() {

        background = new JPanel();
        jPanel1 = new JPanel();
        titleLabel = new JLabel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        nameField = new JTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        clearButton = new JPanel();
        jLabel5 = new JLabel();
        nameFieldSepartor = new JSeparator();
        jScrollPane1 = new JScrollPane();
        descriptionField = new JTextArea();
        priceField = new JTextField();
        priceFieldSeparator = new JSeparator();
        jLabel8 = new JLabel();
        jSeparator3 = new JSeparator();
        jLabel9 = new JLabel();
        jSeparator4 = new JSeparator();
        typeField = new JComboBox<>();
        dietField = new JComboBox<>();
        jPanel3 = new JPanel();
        cancelButton = new JPanel();
        jLabel7 = new JLabel();
        saveButton = new JPanel();
        jLabel6 = new JLabel();

        background.setBackground(Main.uiUtilities.getBackground());

        jPanel1.setBackground(Main.uiUtilities.getBackground());

        titleLabel.setFont(new Font("Segoe UI", 1, 24));
        titleLabel.setText("Adding Dish For: "+ restaurantName);

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

        jPanel2.setBackground(Main.uiUtilities.getBackground());

        jLabel2.setFont(new Font("Segoe UI", 0, 14));
        jLabel2.setText("Name");

        nameField.setFont(new Font("Segoe UI", 0, 14));
        nameField.setBackground(Main.uiUtilities.getBackground());
        nameField.setBorder(null);

        jLabel3.setFont(new Font("Segoe UI", 0, 14));
        jLabel3.setText("Price");

        jLabel4.setFont(new Font("Segoe UI", 0, 14));
        jLabel4.setText("Description");

        clearButton.setBackground(Main.uiUtilities.getButtonsColor());
        clearButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                descriptionField.setText("");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.uiUtilities.buttonHoverEntered(clearButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.uiUtilities.buttonHoverExited(clearButton);
            }
        });

        jLabel5.setFont(new Font("Segoe UI", 1, 14));
        jLabel5.setForeground(Main.uiUtilities.getButtonsTextColor());
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("CLEAR");

        GroupLayout clearButtonLayout = new GroupLayout(clearButton);
        clearButton.setLayout(clearButtonLayout);
        clearButtonLayout.setHorizontalGroup(
                clearButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        clearButtonLayout.setVerticalGroup(
                clearButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        nameFieldSepartor.setBackground(Main.uiUtilities.getMainColor());
        nameFieldSepartor.setForeground(Main.uiUtilities.getMainColor());

        descriptionField.setDocument(new PlainDocument() {
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
        descriptionField.setBorder(new LineBorder(Main.uiUtilities.getMainColor(), 1, true));
        descriptionField.setBackground(Main.uiUtilities.getBackground());
        descriptionField.setFont(new Font("Segoe UI", 0, 14));
        jScrollPane1.setViewportView(descriptionField);

        priceField.setFont(new Font("Segoe UI", 0, 14));
        priceField.setBackground(Main.uiUtilities.getBackground());
        priceField.setBorder(null);

        priceFieldSeparator.setBackground(Main.uiUtilities.getMainColor());
        priceFieldSeparator.setForeground(Main.uiUtilities.getMainColor());

        jLabel8.setFont(new Font("Segoe UI", 0, 14));
        jLabel8.setText("Type");

        jSeparator3.setBackground(Main.uiUtilities.getMainColor());
        jSeparator3.setForeground(Main.uiUtilities.getMainColor());

        jLabel9.setFont(new Font("Segoe UI", 0, 14));
        jLabel9.setText("Diet");

        jSeparator4.setBackground(Main.uiUtilities.getMainColor());
        jSeparator4.setForeground(Main.uiUtilities.getMainColor());

        typeField.setEditable(false);
        typeField.setFont(new Font("Segoe UI", 0, 14));
        typeField.setBackground(Main.uiUtilities.getBackground());
        typeField.setMaximumRowCount(3);
        typeField.setModel(new DefaultComboBoxModel<>(new String[] { "None", "Vegan", "Vegetarian" }));
        typeField.setBorder(BorderFactory.createLineBorder(Main.uiUtilities.getBackground()));
        typeField.setMinimumSize(new Dimension(72, 25));
        typeField.setUI(new CustomComboBoxUI());

        dietField.setEditable(false);
        dietField.setFont(new Font("Segoe UI", 0, 14));
        dietField.setBackground(Main.uiUtilities.getBackground());
        dietField.setMaximumRowCount(3);
        dietField.setModel(new DefaultComboBoxModel<>(new String[] {
                "Appetizers", "Drinks", "Main Courses", "Sides", "Others"
        }));
        dietField.setBorder(BorderFactory.createLineBorder(Main.uiUtilities.getBackground()));
        dietField.setMinimumSize(new Dimension(72, 25));
        dietField.setUI(new CustomComboBoxUI());

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(priceFieldSeparator, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(priceField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(nameFieldSepartor, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(typeField, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel9)
                                                                .addGap(22, 22, 22)
                                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(dietField, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))))
                                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(55, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)
                                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameFieldSepartor, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(priceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(priceFieldSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(typeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(dietField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
        );

        jPanel3.setBackground(Main.uiUtilities.getBackground());

        cancelButton.setBackground(Main.uiUtilities.getButtonsColor());
        cancelButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.uiUtilities.buttonHoverEntered(cancelButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.uiUtilities.buttonHoverExited(cancelButton);
            }
        });

        jLabel7.setFont(new Font("Segoe UI", 1, 14));
        jLabel7.setForeground(Main.uiUtilities.getButtonsTextColor());
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setText("CANCEL");

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

        saveButton.setBackground(Main.uiUtilities.getButtonsColor());
        saveButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveOrUpdateDish();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.uiUtilities.buttonHoverEntered(saveButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.uiUtilities.buttonHoverExited(saveButton);
            }
        });

        jLabel6.setFont(new Font("Segoe UI", 1, 14));
        jLabel6.setForeground(Main.uiUtilities.getButtonsTextColor());
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("SAVE");

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
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
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

    private void cancelButtonAction() {}

    private void saveOrUpdateDish() {

        if (validateFields()) {

        }

    }

    private void getDishFields() {

        ResultSet dish = Dish.getById(dishId);

        try {
            while (dish.next()) {

                nameField.setText(dish.getString(Dish.NAME));
                priceField.setText(dish.getString(Dish.PRICE));

                String dishType = dish.getString(Dish.TYPE);
                if (dishType.equals("NONE")) {
                    typeField.setSelectedIndex(0);
                }
                else if (dishType.equals("Vegan")) {
                    typeField.setSelectedIndex(1);
                }
                else {
                    typeField.setSelectedIndex(2);
                }

                String dishDiet = dish.getString(Dish.DIET);
                if (dishDiet.equals("APPETIZERS")) {
                    dietField.setSelectedIndex(0);
                }
                else if (dishDiet.equals("DRINKS")) {
                    dietField.setSelectedIndex(1);
                }
                else if (dishDiet.equals("SIDES")) {
                    dietField.setSelectedIndex(3);
                }
                else if (dishDiet.equals("OTHERS")) {
                    dietField.setSelectedIndex(4);
                }
                else {
                    dietField.setSelectedIndex(2);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        titleLabel.setText("Editing Dish For: "+ restaurantName);
    }

    private boolean validateFields() {

        boolean valid = true;

        if (nameField.getText().length() == 0) {
            nameFieldSepartor.setBackground(new Color(153, 0, 0));
            nameFieldSepartor.setForeground(new Color(153, 0, 0));

            valid = false;
        }
        else {
            nameFieldSepartor.setBackground(Main.uiUtilities.getMainColor());
            nameFieldSepartor.setForeground(Main.uiUtilities.getMainColor());
        }

        if (!FieldValidator.validateMoney(priceField.getText())) {
            priceFieldSeparator.setBackground(new Color(153, 0, 0));
            priceFieldSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }
        else {
            priceFieldSeparator.setBackground(Main.uiUtilities.getMainColor());
            priceFieldSeparator.setForeground(Main.uiUtilities.getMainColor());
        }

        return valid;
    }
}
