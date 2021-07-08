// Citation: Code in this file has been modeled from given sample

package ui;

import model.ShoppingItem;
import model.ShoppingItemsInventory;
import model.User;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

// Displays the main menu for the Shopping Cart on Dashboard Graphical User Interface
public class DashBoard extends JFrame {

    private final String jsonStore;
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;
    // creates an empty ShoppingItemsInventory
    private final ShoppingItemsInventory inventory;
    private final User user;
    DefaultTableModel cartModel;
    DefaultTableModel historyModel;
    private ShoppingItemsInventory searchInventory;
    private ItemPanel[] gridItems;
    private boolean searchflag = false;
    // Variables declaration
    private JButton addButton;
    private JLabel brandLabel;
    private JTextField brandTextbox;
    private JLabel cartLabel;
    private JLabel cartLabel2;
    private JPanel cartPanel;
    private JTable cartTable;
    private JButton filterButton;
    private JLabel inventoryLabel;
    private JLabel inventoryLabel2;
    private JPanel inventoryPanel;
    private JPanel itemsGrid;
    private JScrollPane jscrollpane1;
    private JScrollPane jscrollpane2;
    private JScrollPane jscrollpane3;
    private JSplitPane jsplitpane1;
    private JButton loadButton;
    private JPanel menuPanel;
    private JLabel nameLabel;
    private JButton payButton;
    private JLabel priceLabel;
    private JTextField priceTextbox;
    private JLabel puchaseHistoryLabel;
    private JLabel puchaseHistoryLabel2;
    private JPanel purchaseHistoryPanel;
    private JTable purchaseHistoryTable;
    private JLabel ratingLabel;
    private JTextField ratingTextbox;
    private JButton saveButton;
    private JComboBox<String> sortComboBox;
    private JLabel sortLabel;
    private JLabel stockLabel;
    private JTextField stockTextbox;
    private JPanel transitionPanel;

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
        this.jsonStore = "./data/shopping_app.json";
        jsonReader = new JsonReader(jsonStore);
        jsonWriter = new JsonWriter(jsonStore);
        this.inventory = new ShoppingItemsInventory();
        this.user = new User(JOptionPane.showInputDialog("Tell us your name..."));
        initComponents();
        nameLabel.setText(user.userName);
        this.cartModel = (DefaultTableModel) cartTable.getModel();
        this.historyModel = (DefaultTableModel) purchaseHistoryTable.getModel();
        addItemsToDisplay(inventory.getInventory());

    }

    /*
     * MODIFIES: this
     * EFFECTS: creates an empty Pane, Label, Panel, text field, button label
     */
    private void initComponents() {
        jsplitpane1 = new JSplitPane();
        menuPanel = new JPanel();
        inventoryLabel = new JLabel();
        cartLabel = new JLabel();
        puchaseHistoryLabel = new JLabel();
        saveButton = new JButton();
        loadButton = new JButton();
        nameLabel = new JLabel();
        transitionPanel = new JPanel();
        inventoryPanel = new JPanel();
        inventoryLabel2 = new JLabel();
        priceTextbox = new JTextField();
        stockTextbox = new JTextField();
        ratingTextbox = new JTextField();
        brandTextbox = new JTextField();
        filterButton = new JButton();
        jscrollpane1 = new JScrollPane();
        itemsGrid = new JPanel();
        addButton = new JButton();
        priceLabel = new JLabel();
        stockLabel = new JLabel();
        ratingLabel = new JLabel();
        initComponents2();
    }

    /*
     * EFFECTS: initialises the dashboard layout components
     */
    private void initComponents2() {
        brandLabel = new JLabel();
        sortComboBox = new JComboBox<>();
        sortLabel = new JLabel();
        cartPanel = new JPanel();
        cartLabel2 = new JLabel();
        payButton = new JButton();
        jscrollpane2 = new JScrollPane();
        cartTable = new JTable();
        purchaseHistoryPanel = new JPanel();
        puchaseHistoryLabel2 = new JLabel();
        jscrollpane3 = new JScrollPane();
        purchaseHistoryTable = new JTable();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jsplitpane1.setDividerLocation(200);
        jsplitpane1.setDividerSize(2);
        menuPanel.setBackground(new java.awt.Color(255, 153, 153));
        inventoryLabel.setText("Inventory");
        inventoryLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        initComponents3();
    }

    /*
     * EFFECTS: initialises the dashboard layout components
     */
    private void initComponents3() {
        inventoryLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryLabelMouseClicked(evt);
            }
        });
        cartLabel.setText("Cart");
        cartLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cartLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartLabelMouseClicked(evt);
            }
        });
        puchaseHistoryLabel.setText("Purchased History");
        puchaseHistoryLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        puchaseHistoryLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                puchaseHistoryLabelMouseClicked(evt);
            }
        });
        saveButton.setText("Save");
        initComponents4();
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents4() {
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        loadButton.setText("Load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nameLabel.setText("Name");
        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        initComponents5(menuPanelLayout);
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents5(GroupLayout menuPanelLayout) {
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(Alignment.LEADING).addComponent(inventoryLabel,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cartLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(puchaseHistoryLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE).addGroup(menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(Alignment.LEADING)
                                .addGroup(menuPanelLayout.createSequentialGroup().addContainerGap()
                                        .addComponent(saveButton, GroupLayout.PREFERRED_SIZE,
                                                73, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(loadButton, GroupLayout.PREFERRED_SIZE,
                                                73, GroupLayout.PREFERRED_SIZE))
                                .addGroup(menuPanelLayout.createSequentialGroup().addGap(62, 62, 62)
                                        .addComponent(nameLabel)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        initComponents55(menuPanelLayout);
        initComponents6();
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents55(GroupLayout menuPanelLayout) {
        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(Alignment.LEADING).addGroup(menuPanelLayout.createSequentialGroup()
                        .addContainerGap().addComponent(nameLabel).addGap(113, 113, 113)
                        .addComponent(inventoryLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cartLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(puchaseHistoryLabel, GroupLayout.PREFERRED_SIZE,
                                45, GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                        .addGroup(menuPanelLayout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(saveButton).addComponent(loadButton))
                        .addContainerGap(153, Short.MAX_VALUE))
        );
        jsplitpane1.setLeftComponent(menuPanel);
        transitionPanel.setLayout(new java.awt.CardLayout());
        inventoryLabel2.setText("Inventory:");
        priceTextbox.setForeground(new java.awt.Color(153, 153, 153));
        stockTextbox.setForeground(new java.awt.Color(153, 153, 153));
        ratingTextbox.setForeground(new java.awt.Color(153, 153, 153));
        brandTextbox.setForeground(new java.awt.Color(153, 153, 153));
        filterButton.setText("Filter");
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents6() {
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });
        itemsGrid.setLayout(new java.awt.GridBagLayout());
        jscrollpane1.setViewportView(itemsGrid);
        addButton.setText("Add a Item");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        priceLabel.setText("Price:");
        stockLabel.setText("Stock:");
        ratingLabel.setText("Rating:");
        brandLabel.setText("Brand:");
        initComponents7();
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents7() {
        sortComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Price(High-Low)",
                "Price(Low-High)", "Stock(High-Low)",

                "Stock(Low-High)", "Rating(High-Low)", "Rating(Low-High)", "Brand(A-Z)", "Brand(Z-A)"}));
        sortComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortComboBoxActionPerformed(evt);
            }
        });
        sortLabel.setText("sort by: ");
        initComponents8();
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents8() {
        GroupLayout layout = new GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(layout);
        ParallelGroup pg = layout.createParallelGroup(Alignment.LEADING);
        pg.addComponent(jscrollpane1);
        SequentialGroup sg = layout.createSequentialGroup().addContainerGap();
        sg.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(priceTextbox, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                        .addComponent(priceLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addComponent(stockTextbox, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                        .addComponent(stockLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                .addComponent(inventoryLabel2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE));

        initComponents85(layout, pg, sg);
        initComponents9(layout);
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents85(GroupLayout layout, ParallelGroup pg, SequentialGroup sg) {
        sg.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                .addComponent(ratingTextbox, GroupLayout.PREFERRED_SIZE,
                                        86, GroupLayout.PREFERRED_SIZE).addComponent(ratingLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(brandLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(brandTextbox, GroupLayout.PREFERRED_SIZE,
                                        87, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup().addComponent(addButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(sortLabel))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(filterButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap();
        pg.addGroup(sg);
        layout.setHorizontalGroup(pg);
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents9(GroupLayout ipl) {
        ipl.setVerticalGroup(ipl.createParallelGroup(Alignment.LEADING).addGroup(ipl.createSequentialGroup()
                .addContainerGap().addGroup(ipl.createParallelGroup(Alignment.BASELINE)
                        .addComponent(inventoryLabel2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addButton).addComponent(sortComboBox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(sortLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ipl.createParallelGroup(Alignment.BASELINE).addComponent(priceLabel)
                        .addComponent(stockLabel).addComponent(ratingLabel).addComponent(brandLabel))
                .addGap(5, 5, 5).addGroup(ipl.createParallelGroup(Alignment.BASELINE)
                        .addComponent(priceTextbox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(stockTextbox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(ratingTextbox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(brandTextbox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterButton)).addGap(18, 18, 18)
                .addComponent(jscrollpane1, GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)));
        initComponents10();
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents10() {
        transitionPanel.add(inventoryPanel, "card2");
        cartLabel2.setText("Cart:");
        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonactionperformed(evt);
            }
        });
        cartTable.setModel(new DefaultTableModel(
                new Object[][]{}, new String[]{"Brand", "Description", "Section", "Price", "Stock", "Rating", "ID"}) {
            final boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        cartTable.getTableHeader().setReorderingAllowed(false);
        jscrollpane2.setViewportView(cartTable);
        initComponents11();
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents11() {
        GroupLayout cartPanelLayout = new GroupLayout(cartPanel);
        cartPanel.setLayout(cartPanelLayout);
        cartPanelLayout.setHorizontalGroup(cartPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(cartPanelLayout.createSequentialGroup().addContainerGap()
                        .addComponent(cartLabel2, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE).addComponent(payButton).addContainerGap())
                .addComponent(jscrollpane2, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );
        cartPanelLayout.setVerticalGroup(cartPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, cartPanelLayout.createSequentialGroup().addContainerGap()
                        .addGroup(cartPanelLayout.createParallelGroup(Alignment.BASELINE).addComponent(payButton)
                                .addComponent(cartLabel2, GroupLayout.PREFERRED_SIZE, 27,
                                        GroupLayout.PREFERRED_SIZE)).addGap(18, 18, 18)
                        .addComponent(jscrollpane2, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
        );
        initComponents12();
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents12() {
        transitionPanel.add(cartPanel, "card3");
        puchaseHistoryLabel2.setText("Purchased History:");
        purchaseHistoryTable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Brand", "Description", "Section", "Price", "Stock", "Rating", "ID"}
        ) {
            final boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        purchaseHistoryTable.getTableHeader().setReorderingAllowed(false);
        jscrollpane3.setViewportView(purchaseHistoryTable);
        initComponents13();
    }

    /*
     * EFFECTS: initialises the dashboard layout
     */
    private void initComponents13() {
        GroupLayout purchaseHistoryPanelLayout = new GroupLayout(purchaseHistoryPanel);
        purchaseHistoryPanel.setLayout(purchaseHistoryPanelLayout);
        purchaseHistoryPanelLayout.setHorizontalGroup(
                purchaseHistoryPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(jscrollpane3, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                        .addGroup(purchaseHistoryPanelLayout.createSequentialGroup().addContainerGap()
                                .addComponent(puchaseHistoryLabel2, GroupLayout.PREFERRED_SIZE, 141,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        purchaseHistoryPanelLayout.setVerticalGroup(
                purchaseHistoryPanelLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(purchaseHistoryPanelLayout.createSequentialGroup().addContainerGap()
                                .addComponent(puchaseHistoryLabel2, GroupLayout.PREFERRED_SIZE,
                                        26, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jscrollpane3, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
        );
        transitionPanel.add(purchaseHistoryPanel, "card4");
        jsplitpane1.setRightComponent(transitionPanel);
        getContentPane().add(jsplitpane1, java.awt.BorderLayout.CENTER);
        pack();
    }

    /*
     * EFFECTS: inventory button event handler
     */
    private void inventoryLabelMouseClicked(java.awt.event.MouseEvent evt) {
        ((CardLayout) transitionPanel.getLayout()).show(transitionPanel, "card2");
    }

    /*
     * EFFECTS: cart button event handler
     */
    private void cartLabelMouseClicked(java.awt.event.MouseEvent evt) {
        ((CardLayout) transitionPanel.getLayout()).show(transitionPanel, "card3");
    }

    /*
     * EFFECTS: purchase button event handler
     */
    private void puchaseHistoryLabelMouseClicked(java.awt.event.MouseEvent evt) {
        ((CardLayout) transitionPanel.getLayout()).show(transitionPanel, "card4");
    }

    /*
     * EFFECTS: add button event handler
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        addAItem();
        addItemsToDisplay(inventory.getInventory());
    }

    /*
     * EFFECTS: display a list of ShoppingItem based on filter
     */
    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {
        searchInventory = new ShoppingItemsInventory();
        try {
            boolean[] checks = filtersCheck();
            for (ShoppingItem shoppingItem : inventory.getInventory()) {
                if (checks[0] && shoppingItem.price < Double.parseDouble(priceTextbox.getText())) {
                    continue;
                } else if (checks[1] && shoppingItem.stock < Integer.parseInt(stockTextbox.getText())) {
                    continue;
                } else if (checks[2] && shoppingItem.rating < Integer.parseInt(ratingTextbox.getText())) {
                    continue;
                } else if (checks[3] && !shoppingItem.brand.equals(brandTextbox.getText())) {
                    continue;
                }
                searchInventory.addItem(shoppingItem);
            }
            addItemsToDisplay(searchInventory.getInventory());
            if (searchInventory.getInventory().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Cannot get any results...");
            }
            searchflag = true;
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "Cannot get any results...");
        }
    }

    /*
     * EFFECTS: creates an audio visual when list of ShoppingItem is purchased
     */
    private void payButtonactionperformed(java.awt.event.ActionEvent evt) {

        addItemsInPuchasedHistoryTable(user.cart.getItems());
        user.purchaseItemsInCart();
        cartModel.setRowCount(0);
        try {
            // https://www.youtube.com/watch?v=84frnbTWGis
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("./data/ping.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            Logger.getLogger(DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showConfirmDialog(null,
                "Purchase Completed...", "Purchase Completed", JOptionPane.DEFAULT_OPTION,
                // https://stackoverflow.com/questions/52054838/handle-android-billing-response-when-successful-popup-appear
                JOptionPane.PLAIN_MESSAGE, new ImageIcon("./data/Tick.png"));
    }

    /*
     * EFFECTS: saves a list of ShoppingItem to json file
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            jsonWriter.open();
            jsonWriter.write(user, inventory);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "Saved shopping state to " + jsonStore);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Unable to write to file: " + jsonStore);
            e.printStackTrace();
        }
    }

    /*
     * EFFECTS: loads a list of ShoppingItem from json file
     */
    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {
        inventory.getInventory().clear();
        user.getCart().getItems().clear();
        user.getPurchases().getPurchaseHistory().clear();
        cartModel.setRowCount(0);
        historyModel.setRowCount(0);
        try {
            jsonReader.read(user, inventory);
            addItemsInCartTable(user.cart.getItems());
            addItemsInPuchasedHistoryTable(user.purchases.getPurchaseHistory());
            JOptionPane.showMessageDialog(null, "Loaded shopping app from " + jsonStore);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to read from file: " + jsonStore);
        }
    }

    /*
     * EFFECTS: display inventory onto screen based on search
     */
    private void sortComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        if (searchflag) {
            addItemsToDisplay(searchInventory.getInventory());

        } else {
            addItemsToDisplay(inventory.getInventory());
        }

    }

    /*
     * EFFECTS: add ShoppingItem into the inventory
     */
    private void addAItem() {
        try {
            String brand = JOptionPane.showInputDialog("Enter the brand name");
            String description = JOptionPane.showInputDialog("Enter description");
            String section = JOptionPane.showInputDialog("Enter section (clothing, electronic, etc)");
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter price"));
            int stock = Integer.parseInt(JOptionPane.showInputDialog("Enter stock"));
            int rating = Integer.parseInt(JOptionPane.showInputDialog("Enter rating"));
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter product id"));
            inventory.addItem(new ShoppingItem(brand, description, section, price, stock, rating, id));
            addItemsToDisplay(inventory.getInventory());
            JOptionPane.showMessageDialog(null, "Item Added successfully...");
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Item not added successfully...");
        }
    }

    /*
     * EFFECTS: creates a list of ShoppingItem in Inventory
     */
    private void addItemsToDisplay(List<ShoppingItem> inventoryItems) {
        int sortindex = sortComboBox.getSelectedIndex();
        sort(inventoryItems, sortindex);
        itemsGrid.removeAll();
        gridItems = new ItemPanel[inventoryItems.size()];
        for (int i = 0; i < inventoryItems.size(); i++) {
            ShoppingItem inventoryItem = inventoryItems.get(i);

            ItemPanel.constraints.gridx += 9;
            if (i % 3 == 0) {
                ItemPanel.constraints.gridx = 0;
                ItemPanel.constraints.gridy += 9;
            }
            gridItems[i] = new ItemPanel(inventoryItem);
            gridItems[i].getAddButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addItemToCart(inventoryItem);
                }
            });
            itemsGrid.add(gridItems[i], ItemPanel.constraints);
        }
        ItemPanel.constraints.gridx = 0;
        ItemPanel.constraints.gridy = 0;
        itemsGrid.updateUI();

    }

    /*
     * EFFECTS: creates a list of ShoppingItem in Cart
     */
    private void addItemToCart(ShoppingItem item) {
        if (item.stock > 0) {
            item.decrementStock();
            user.addItemToCart(item);
            Object[] row = new Object[7];
            row[0] = item.brand;
            row[1] = item.description;
            row[2] = item.section;
            row[3] = item.price;
            row[4] = item.stock;
            row[5] = item.rating;
            row[6] = item.id;
            cartModel.addRow(row);
            JOptionPane.showMessageDialog(null, item.description + " of brand " + item.brand + " added to cart");
        } else {
            JOptionPane.showMessageDialog(null, "Item not present in inventory");
        }

    }

    /*
     * EFFECTS: creates a list of ShoppingItem in Purchase history
     */
    private void addItemsInPuchasedHistoryTable(Map<Integer, ShoppingItem> purchasedItems) {

        Object[] row = new Object[7];
        for (ShoppingItem purchasedItem : purchasedItems.values()) {
            row[0] = purchasedItem.brand;
            row[1] = purchasedItem.description;
            row[2] = purchasedItem.section;
            row[3] = purchasedItem.price;
            row[4] = purchasedItem.stock;
            row[5] = purchasedItem.rating;
            row[6] = purchasedItem.id;
            historyModel.addRow(row);
        }
    }

    /*
     * EFFECTS: creates a list of ShoppingItem onto the dashboard
     */
    private void addItemsInCartTable(Map<Integer, ShoppingItem> cartItems) {
        Object[] row = new Object[7];
        for (ShoppingItem cartItem : cartItems.values()) {
            row[0] = cartItem.brand;
            row[1] = cartItem.description;
            row[2] = cartItem.section;
            row[3] = cartItem.price;
            row[4] = cartItem.stock;
            row[5] = cartItem.rating;
            row[6] = cartItem.id;
            cartModel.addRow(row);
        }
    }

    /*
     * EFFECTS: sort the items according to the Price, Stock, Brand, Rating
     */
    private void sort(List<ShoppingItem> inventoryItems, int sortindex) {
        switch (sortindex) {
            case 0:
                Collections.sort(inventoryItems, (a, b) -> Double.compare(b.price, a.price));
            case 1:
                Collections.sort(inventoryItems, (a, b) -> Double.compare(a.price, b.price));
            case 2:
                Collections.sort(inventoryItems, (a, b) -> b.stock - a.stock);
            case 3:
                Collections.sort(inventoryItems, (a, b) -> a.stock - b.stock);
            case 4:
                Collections.sort(inventoryItems, (a, b) -> b.rating - a.rating);
            case 5:
                Collections.sort(inventoryItems, (a, b) -> a.rating - b.rating);
            case 6:
                Collections.sort(inventoryItems, (a, b) -> a.brand.compareTo(b.brand));
            case 7:
                Collections.sort(inventoryItems, (a, b) -> b.brand.compareTo(a.brand));
        }
    }

    /*
     * EFFECTS: returns true if the text boxes are empty otherwise false
     */
    private boolean[] filtersCheck() {
        boolean[] checks = new boolean[4];
        if (!priceTextbox.getText().equals("")) {
            checks[0] = true;
        }
        if (!stockTextbox.getText().equals("")) {
            checks[1] = true;
        }
        if (!ratingTextbox.getText().equals("")) {
            checks[2] = true;
        }
        if (!brandTextbox.getText().equals("")) {
            checks[3] = true;
        }
        return checks;
    }
}
