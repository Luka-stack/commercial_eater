package com.commercialeater.views.dishes;

import com.commercialeater.Main;
import com.commercialeater.models.Diet;
import com.commercialeater.models.Dish;
import com.commercialeater.models.DishType;
import com.commercialeater.models.Restaurant;
import com.commercialeater.persistance.entity.DishEntity;
import com.commercialeater.persistance.service.DishService;
import com.commercialeater.utilities.CustomComboBoxUI;
import com.commercialeater.utilities.FieldValidator;

import java.math.BigDecimal;
import java.util.List;
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

public class DishPage extends JPanel {

    private final DishService dishService = new DishService();

    private JTextField priceFilter;
    private JPanel background;
    private JPanel clearButton;
    private JComboBox<String> dietFilter;
    private JComboBox<String> typeFilter;
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
    private JTable jTable1;
    private DefaultTableModel tableModel;

    private JTextField nameFilter;
    private JPanel searchButton;

    private final Long restaurantId;
    private String restaurantName;

    public DishPage(final Long restaurantId, final String restaurantName) {
        initComponents();
        this.restaurantName = restaurantName;
        this.restaurantId = restaurantId;

        getDishesData();
    }

    private void initComponents() {

        background = new JPanel();
        jPanel3 = new JPanel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        nameFilter = new JTextField();
        jLabel4 = new JLabel();
        priceFilter = new JTextField();
        searchButton = new JPanel();
        jLabel5 = new JLabel();
        clearButton = new JPanel();
        jLabel1 = new JLabel();
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jLabel6 = new JLabel();
        jSeparator3 = new JSeparator();
        jLabel7 = new JLabel();
        jSeparator4 = new JSeparator();
        dietFilter = new JComboBox<>();
        typeFilter = new JComboBox<>();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        tableModel = new DefaultTableModel();

        background.setBackground(Main.colorUtilities.getBackground());

        jPanel3.setBackground(Main.colorUtilities.getBackground());

        jLabel2.setFont(new Font("Segoe UI", 0, 18));
        jLabel2.setText("Filters");

        jLabel3.setFont(new Font("Segoe UI", 0, 14));
        jLabel3.setText("Name");

        nameFilter.setFont(new Font("Segoe UI", 0, 14));
        nameFilter.setBackground(Main.colorUtilities.getBackground());
        nameFilter.setBorder(null);

        jLabel4.setFont(new Font("Segoe UI", 0, 14));
        jLabel4.setText("Price");

        priceFilter.setFont(new Font("Segoe UI", 0, 14));
        priceFilter.setBackground(Main.colorUtilities.getBackground());
        priceFilter.setBorder(null);

        searchButton.setBackground(Main.colorUtilities.getButtonsColor());
        searchButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.white, Color.white, Color.lightGray, Color.white));
        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filterDishes();
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

        jLabel5.setFont(new Font("Segoe UI", 1, 14));
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

        jLabel1.setFont(new Font("Segoe UI", 1, 14));
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
        jLabel6.setText("Type");

        jSeparator3.setBackground(Main.colorUtilities.getMainColor());
        jSeparator3.setForeground(Main.colorUtilities.getMainColor());

        jLabel7.setFont(new Font("Segoe UI", 0, 14));
        jLabel7.setText("Diet");

        jSeparator4.setBackground(Main.colorUtilities.getMainColor());
        jSeparator4.setForeground(Main.colorUtilities.getMainColor());

        dietFilter.setEditable(false);
        dietFilter.setFont(new Font("Segoe UI", 0, 14));
        dietFilter.setBackground(Main.colorUtilities.getBackground());
        dietFilter.setMaximumRowCount(3);
        dietFilter.setModel(new DefaultComboBoxModel<>(new String[] {
                "All", Diet.NONE.getType(), Diet.VEGETARIAN.getType(), Diet.VEGAN.getType()
        }));
        dietFilter.setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));
        dietFilter.setMinimumSize(new Dimension(72, 25));
        dietFilter.setUI(new CustomComboBoxUI());

        typeFilter.setEditable(false);
        typeFilter.setFont(new Font("Segoe UI", 0, 14));
        typeFilter.setBackground(Main.colorUtilities.getBackground());
        typeFilter.setMaximumRowCount(3);
        typeFilter.setModel(new DefaultComboBoxModel<>(new String[] {
                "All", DishType.MAIN_COURSES.getType(), DishType.SIDES.getType(),
                DishType.APPETIZERS.getType(), DishType.DRINKS.getType(), DishType.OTHERS.getType()
        }));
        typeFilter.setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));
        typeFilter.setMinimumSize(new Dimension(72, 25));
        typeFilter.setUI(new CustomComboBoxUI());

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
                                        .addComponent(nameFilter, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(typeFilter, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(dietFilter, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(priceFilter, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(50, Short.MAX_VALUE))
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
                                                                        .addComponent(nameFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel3))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel6)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(typeFilter, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator3, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(priceFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jSeparator2, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                                                                .addComponent(dietFilter, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())
        );

        jScrollPane1.setBackground(Main.colorUtilities.getBackground());
        jScrollPane1.setBorder(BorderFactory.createLineBorder(Main.colorUtilities.getBackground()));

        JMenuItem popupItemEdit = new JMenuItem("Edit Current Row");
        popupItemEdit.addActionListener(event -> editSelectedRow());

        JMenuItem popupItemRemove = new JMenuItem("Remove Current Row");
        popupItemRemove.addActionListener(event -> removeSelectedRow());

        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(popupItemEdit);
        popupMenu.add(popupItemRemove);

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
                "Id", "Restaurant", "Dish", "Type", "Diet", "Price"
        });

        jTable1.setModel(tableModel);
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);

        jTable1.setFocusable(false);
        jTable1.setGridColor(Main.colorUtilities.getMainColor());
        jTable1.setBackground(Main.colorUtilities.getBackground());
        jTable1.setIntercellSpacing(new Dimension(0, 0));
        jTable1.setRowHeight(40);
        jTable1.setSelectionBackground(Main.colorUtilities.getMainColor());
        jTable1.setShowGrid(true);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
        }

        jTable1.setComponentPopupMenu(popupMenu);
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
                        .addGroup(backgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void removeSelectedRow() {

        int selectedRow = jTable1.getSelectedRow();
        Long entityId = Long.parseLong(tableModel.getValueAt(selectedRow, 0).toString());
        dishService.deleteDish(entityId);

        String dish = tableModel.getValueAt(selectedRow, 1).toString();
        tableModel.removeRow(selectedRow);
        Main.mainWindow.setBottomInformation("Dish '"+ dish +"' was deleted");
    }

    private void editSelectedRow() {

        int selectedRow = jTable1.getSelectedRow();
        Long rowId = Long.parseLong(tableModel.getValueAt(selectedRow, 0).toString());

        Main.mainWindow.setBottomInformation("Editing Row #" + (selectedRow+1));
        Main.mainWindow.loadDishCreationPage(rowId);
    }

    private void clearButtonClicked() {
        nameFilter.setText("");
        priceFilter.setText("");
        typeFilter.setSelectedIndex(0);
        dietFilter.setSelectedIndex(0);

        getDishesData();
    }

    private void getDishesData() {

        tableModel.setRowCount(0);

        List<DishEntity> dishes = dishService.getDishes(restaurantId);
        String[] rows = new String[6]; // "Id", "Restaurant", "Dish", "Type", "Diet", "Price"

        for (var dish : dishes) {

            rows[0] = String.valueOf(dish.getId());
            rows[1] = restaurantName;
            rows[2] = dish.getName();
            rows[3] = dish.getType().getType();
            rows[4] = dish.getDiet().getType();
            rows[5] = dish.getPrice().toString();

            tableModel.addRow(rows);
        }

        Main.mainWindow.setBottomInformation("Found " + dishes.size() + " dishes");
    }

    private void filterDishes() {

        String pricePattern = "";
        BigDecimal priceValue = BigDecimal.ZERO;

        if (FieldValidator.validateMoneyFilter(priceFilter.getText())) {

            String[] tokens = priceFilter.getText().split(" ");
            pricePattern = tokens[0];
            priceValue = BigDecimal.valueOf(Long.parseLong(tokens[1]));
        }

        String diet = dietFilter.getSelectedItem().toString();
        if (!diet.equals("All")) {
            diet = Diet.fromString(diet).name();
        }

        String type = dietFilter.getSelectedItem().toString();
        if (!type.equals("All")) {
            type = DishType.fromString(diet).name();
        }

        List<DishEntity> dishes = dishService.getDishes(restaurantId, nameFilter.getText(), priceValue,
                type, diet, pricePattern);

        tableModel.setRowCount(0);
        String[] rows = new String[6]; // "Id", "Restaurant", "Dish", "Type", "Diet", "Price"

        for (var dish : dishes) {

            rows[0] = String.valueOf(dish.getId());
            rows[1] = restaurantName;
            rows[2] = dish.getName();
            rows[3] = dish.getType().getType();
            rows[4] = dish.getDiet().getType();
            rows[5] = String.valueOf(dish.getPrice());

            tableModel.addRow(rows);
        }

        Main.mainWindow.setBottomInformation("Found " + dishes.size() + " dishes");
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() { return restaurantName; }
}
