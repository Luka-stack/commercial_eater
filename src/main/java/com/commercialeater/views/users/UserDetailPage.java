package com.commercialeater.views.users;

import com.commercialeater.Main;
import com.commercialeater.models.City;
import com.commercialeater.models.User;
import com.commercialeater.persistance.entity.CityEntity;
import com.commercialeater.persistance.entity.Role;
import com.commercialeater.persistance.entity.UserEntity;
import com.commercialeater.persistance.service.CityService;
import com.commercialeater.persistance.service.UserService;
import com.commercialeater.utilities.CustomComboBoxUI;
import com.commercialeater.utilities.FieldValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class UserDetailPage extends JPanel {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final UserService userService = new UserService();
    private final CityService cityService = new CityService();

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
    private JPanel resetPasswordButton;
    private JSeparator emailFieldSeparator;
    private JSeparator jSeparator4;
    private JSeparator firstNameSeparator;
    private JSeparator cityFieldSeparator;
    private JSeparator lastNameSeparator;
    private JSeparator jSeparator8;
    private JLabel titleLabel;

    private JPanel cancelButton;
    private JPanel saveButton;
    private JPanel topUpButton;

    private JComboBox<String> cityField;
    private JTextField emailField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JComboBox<String> roleField;
    private JLabel balanceLabel;

    private Long entityID;
    private String password;

    public UserDetailPage() {
        initComponents();
        titleLabel.setText("Creating New User");

        this.entityID = -1L;
        setStandardPassword();
    }

    public UserDetailPage(Long entityID) {
        initComponents();

        this.entityID = entityID;
        //getUserFields();
    }

    private void initComponents() {

        background = new JPanel();
        jPanel1 = new JPanel();
        titleLabel = new JLabel();
        jPanel2 = new JPanel();
        jLabel2 = new JLabel();
        emailField = new JTextField();
        jLabel3 = new JLabel();
        emailFieldSeparator = new JSeparator();
        roleField = new JComboBox<>();
        jSeparator4 = new JSeparator();
        jLabel5 = new JLabel();
        firstNameField = new JTextField();
        firstNameSeparator = new JSeparator();
        jLabel8 = new JLabel();
        cityField = new JComboBox<>();
        cityFieldSeparator = new JSeparator();
        jLabel9 = new JLabel();
        lastNameField = new JTextField();
        lastNameSeparator = new JSeparator();
        jLabel10 = new JLabel();
        jSeparator8 = new JSeparator();
        resetPasswordButton = new JPanel();
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

        background.setBackground(Main.colorUtilities.getBackground());

        jPanel1.setBackground(Main.colorUtilities.getBackground());

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

        jPanel2.setBackground(Main.colorUtilities.getBackground());

        jLabel2.setFont(new Font("Segoe UI", 0, 14));
        jLabel2.setText("Email");

        emailField.setFont(new Font("Segoe UI", 0, 14));
        emailField.setBackground(Main.colorUtilities.getBackground());
        emailField.setBorder(null);

        jLabel3.setFont(new Font("Segoe UI", 0, 14));
        jLabel3.setText("Password");

        emailFieldSeparator.setBackground(Main.colorUtilities.getMainColor());
        emailFieldSeparator.setForeground(Main.colorUtilities.getMainColor());

        roleField.setEditable(false);
        roleField.setFont(new Font("Segoe UI", 0, 14));
        roleField.setMaximumRowCount(3);
        roleField.setModel(new DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        roleField.setSelectedIndex(1);
        roleField.setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));
        roleField.setBackground(Main.colorUtilities.getBackground());

        roleField.setUI(new CustomComboBoxUI());

        jSeparator4.setBackground(Main.colorUtilities.getMainColor());
        jSeparator4.setForeground(Main.colorUtilities.getMainColor());
        jSeparator4.setOrientation(SwingConstants.VERTICAL);

        jLabel5.setFont(new Font("Segoe UI", 0, 14));
        jLabel5.setText("First Name");

        firstNameField.setFont(new Font("Segoe UI", 0, 14));
        firstNameField.setBackground(Main.colorUtilities.getBackground());
        firstNameField.setBorder(null);

        firstNameSeparator.setBackground(Main.colorUtilities.getMainColor());
        firstNameSeparator.setForeground(Main.colorUtilities.getMainColor());

        jLabel8.setFont(new Font("Segoe UI", 0, 14));
        jLabel8.setText("City");

        cityField.setEditable(false);
        cityField.setFont(new Font("Segoe UI", 0, 14));
        cityField.setBackground(Main.colorUtilities.getBackground());
        cityField.setMaximumRowCount(3);

        cityField.setModel(new DefaultComboBoxModel<>(cityService.getCities().stream()
                .map(CityEntity::getName).toArray(String[]::new)));
        cityField.setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));
        cityField.setMinimumSize(new Dimension(72, 25));

        cityField.setUI(new CustomComboBoxUI());

        cityFieldSeparator.setBackground(Main.colorUtilities.getMainColor());
        cityFieldSeparator.setForeground(Main.colorUtilities.getMainColor());

        jLabel9.setFont(new Font("Segoe UI", 0, 14));
        jLabel9.setText("Last Name");

        lastNameField.setFont(new Font("Segoe UI", 0, 14));
        lastNameField.setBackground(Main.colorUtilities.getBackground());
        lastNameField.setBorder(null);

        lastNameSeparator.setBackground(Main.colorUtilities.getMainColor());
        lastNameSeparator.setForeground(Main.colorUtilities.getMainColor());

        jLabel10.setFont(new Font("Segoe UI", 0, 14));
        jLabel10.setText("Role");

        jSeparator8.setBackground(Main.colorUtilities.getMainColor());
        jSeparator8.setForeground(Main.colorUtilities.getMainColor());

        resetPasswordButton.setBackground(Main.colorUtilities.getButtonsColor());
        resetPasswordButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setStandardPassword();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.colorUtilities.buttonHoverEntered(resetPasswordButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.colorUtilities.buttonHoverExited(resetPasswordButton);
            }
        });

        jLabel1.setFont(new Font("Segoe UI", 1, 14));
        jLabel1.setForeground(Main.colorUtilities.getButtonsTextColor());
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Reset Password");

        GroupLayout jPanel4Layout = new GroupLayout(resetPasswordButton);
        resetPasswordButton.setLayout(jPanel4Layout);
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

        topUpButton.setBackground(Main.colorUtilities.getButtonsColor());
        topUpButton.setPreferredSize(new Dimension(172, 25));
        topUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BalancePopup newBalance = new BalancePopup(Main.mainWindow);
                balanceLabel.setText(newBalance.getBalance() + " zl");
                newBalance = null;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.colorUtilities.buttonHoverEntered(topUpButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.colorUtilities.buttonHoverExited(topUpButton);
            }
        });

        jLabel12.setFont(new Font("Segoe UI", 1, 14));
        jLabel12.setForeground(Main.colorUtilities.getButtonsTextColor());
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
                                                        .addComponent(emailFieldSeparator)
                                                        .addComponent(resetPasswordButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(89, 89, 89)
                                                .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel5)
                                                                .addComponent(firstNameField)
                                                                .addComponent(firstNameSeparator, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel8)
                                                                .addComponent(cityField)
                                                                .addComponent(cityFieldSeparator, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addComponent(balanceLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel9)
                                                .addComponent(lastNameField)
                                                .addComponent(lastNameSeparator, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
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
                                                .addGap(5, 5, 5)
                                                .addComponent(emailFieldSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(resetPasswordButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(5, 5, 5)
                                                                .addComponent(firstNameSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel9)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(5, 5, 5)
                                                                .addComponent(lastNameSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(5, 5, 5)
                                                                .addComponent(cityFieldSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(7, 7, 7)
                                                                .addComponent(roleField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                //.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGap(5, 5, 5)
                                                                .addComponent(jSeparator8, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(topUpButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel4)
                                                                .addComponent(balanceLabel)))))
                                .addGap(34, 34, 34))
        );

        jPanel3.setBackground(Main.colorUtilities.getBackground());

        cancelButton.setBackground(Main.colorUtilities.getButtonsColor());
        cancelButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancelButtonAction();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.colorUtilities.buttonHoverEntered(cancelButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.colorUtilities.buttonHoverExited(cancelButton);
            }
        });

        jLabel7.setFont(new Font("Segoe UI", 1, 14));
        jLabel7.setForeground(Main.colorUtilities.getButtonsTextColor());
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

        saveButton.setBackground(Main.colorUtilities.getButtonsColor());
        saveButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saveOrUpdateUser();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Main.colorUtilities.buttonHoverEntered(saveButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Main.colorUtilities.buttonHoverExited(saveButton);
            }
        });

        jLabel6.setFont(new Font("Segoe UI", 1, 14));
        jLabel6.setForeground(Main.colorUtilities.getButtonsTextColor());
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

    private void cancelButtonAction() {

        if (entityID < 0) {
            emailField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            cityField.setSelectedIndex(0);
            balanceLabel.setText("0 zl");
            roleField.setSelectedIndex(1);
            setStandardPassword();
        }
        else {
            getUserFields();
        }
    }

    private void getUserFields() {

        ResultSet user = User.getById(entityID);

        try {
            while (user.next()) {

                emailField.setText(user.getString(User.EMAIL));
                password = user.getString(User.PASSWORD);
                firstNameField.setText(user.getString(User.FIRST_NAME));
                lastNameField.setText(user.getString(User.LAST_NAME));
                cityField.setSelectedItem(user.getString(User.REF_CITY));
                balanceLabel.setText(user.getString(User.BALANCE) + " zl");

                String role = user.getString(User.ROLE);
                roleField.setSelectedIndex( role.equals("User") ? 1 : 0 );

                titleLabel.setText("Editing " + user.getString(User.EMAIL));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveOrUpdateUser() {

        if (validateFields()) {

            CityEntity cityEntity = cityService.getCityByName((String) cityField.getSelectedItem());
            BigDecimal balance = BigDecimal.valueOf(Long.parseLong(balanceLabel.getText().split(" ")[0]));

            UserEntity userEntity = new UserEntity(firstNameField.getText(), lastNameField.getText(),
                    emailField.getText(), Role.fromString((String) roleField.getSelectedItem()),
                    password, balance, cityEntity);

            System.out.println(userEntity.getRole());

            if (entityID < 0) {
                userService.createUser(userEntity);

                Main.mainWindow.setBottomInformation("Created new user '" + emailField.getText() + "'");
            } else {
                userEntity.setId(entityID);
                userService.updateUser(userEntity);

                String rowID = Main.mainWindow.getBottomInformation().split("#")[1];
                Main.mainWindow.setBottomInformation("User at row #" + rowID + " updated");
            }

            Main.mainWindow.loadUsersView(false);
        }
        else {
            Main.mainWindow.setBottomInformation("Wrong Field(s) inputs");
        }
    }

    private void setStandardPassword() {
        password = encoder.encode("qwerty");
    }

    private boolean validateFields() {

        boolean valid = true;

        if (!FieldValidator.validateEmail(emailField.getText())) {
            emailFieldSeparator.setBackground(new Color(153, 0, 0));
            emailFieldSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }
        else {
            emailFieldSeparator.setBackground(Main.colorUtilities.getMainColor());
            emailFieldSeparator.setForeground(Main.colorUtilities.getMainColor());
        }

        if (firstNameField.getText().length() == 0) {
            firstNameSeparator.setBackground(new Color(153, 0, 0));
            firstNameSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }
        else {
            firstNameSeparator.setBackground(Main.colorUtilities.getMainColor());
            firstNameSeparator.setForeground(Main.colorUtilities.getMainColor());
        }

        if (lastNameField.getText().length() == 0) {
            lastNameSeparator.setBackground(new Color(153, 0, 0));
            lastNameSeparator.setForeground(new Color(153, 0, 0));

            valid = false;
        }
        else {
            lastNameSeparator.setBackground(Main.colorUtilities.getMainColor());
            lastNameSeparator.setForeground(Main.colorUtilities.getMainColor());
        }

        return valid;
    }
}
