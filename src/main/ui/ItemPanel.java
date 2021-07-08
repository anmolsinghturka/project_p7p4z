// Citation: Code in this file has been modeled from given sample

package ui;

import model.ShoppingItem;

import javax.swing.*;
import java.awt.*;

// displays shopping items onto GUI
public class ItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form item
     */
    static GridBagConstraints constraints;

    static {
        constraints = new java.awt.GridBagConstraints();
        constraints.gridwidth = 9;
        constraints.gridheight = 9;
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.insets = new java.awt.Insets(5, 5, 5, 5);
    }

    // Variables declaration
    private javax.swing.JButton addButton;
    private javax.swing.JLabel brandLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JLabel stockLabel;

    /*
     * EFFECTS: initialize the card board for inventory item
     */
    public ItemPanel(ShoppingItem inventoryItem) {
        initComponents();
        brandLabel.setText(inventoryItem.brand);
        stockLabel.setText("Stock: " + inventoryItem.stock);
        ratingLabel.setText("Rating: " + inventoryItem.rating);
        priceLabel.setText("Price: " + inventoryItem.price);
    }

    /*
     * EFFECTS: initialize the card board for inventory item
     */
    private void initComponents() {
        addButton = new javax.swing.JButton();
        brandLabel = new javax.swing.JLabel();
        stockLabel = new javax.swing.JLabel();
        ratingLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addButton.setText("Add to Cart");
        brandLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        brandLabel.setText("Brand");
        stockLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stockLabel.setText("Stock");
        ratingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ratingLabel.setText("Rating");
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel.setText("Price");
        initComponents2();
    }

    /*
     * EFFECTS: initialize the card board for inventory item
     */
    private void initComponents2() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(27, 27, 27).addComponent(addButton)
                                .addContainerGap(30, Short.MAX_VALUE)).addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(stockLabel, javax.swing.GroupLayout.Alignment.TRAILING,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(brandLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ratingLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addContainerGap())
        );
        initComponents3(layout);
    }

    /*
     * EFFECTS: initialize the card board for inventory item
     */
    private void initComponents3(GroupLayout layout) {
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap().addComponent(brandLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stockLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ratingLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(priceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        12, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addContainerGap())
        );
    }

    /*
     * EFFECTS: returns addButton
     */
    public JButton getAddButton() {
        return addButton;
    }
}
