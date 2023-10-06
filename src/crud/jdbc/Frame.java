package crud.jdbc;

import crud.jdbc.CrudJdbc;
import java.sql.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frame extends javax.swing.JFrame {
  CrudJdbc connection = new CrudJdbc();
  String url = "jdbc:mysql://localhost:3306/acomernosesodb";
  String user = "root";
  String password = "";
  
  public void clean() {
    idInput.setText("");
    productNameInput.setText("");
    categoryInput.setText("");
    priceInput.setText("");
  }
  
  public void showTable(String value) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Nombre del producto");
    model.addColumn("Categoría");
    model.addColumn("Price");
    table.setModel(model);

    String query = "SELECT * FROM products WHERE CONCAT (product_name, '', category, '', price) LIKE '%" + value + "%'";
    Object[] data = new Object[4];
    DecimalFormat formatNumber = new DecimalFormat("#,###");
    try {
      Statement st = connection.getConnection().createStatement();
      ResultSet rs = st.executeQuery(query);
      rs.next();

      do {
        data[0] = rs.getInt("id");
        data[1] = rs.getString("product_name");
        data[2] = rs.getString("category");
        data[3] = formatNumber.format(rs.getInt("price"));
        System.out.println(rs.getString("product_name") + " : " + rs.getString("category") + " : " + rs.getInt("price"));
        model.addRow(data);
      } while (rs.next());
      table.setModel(model);

    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "No fue posible obtener los datos: " + e.getMessage() + ".");
    }
  }
  
  public Frame() {
    initComponents();
    connection.connect(url, user, password);
    clean();
    showTable("");
    
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        connection.disconnect();
      }
    });
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    layoutPanel = new javax.swing.JPanel();
    title = new javax.swing.JLabel();
    insertPanel = new javax.swing.JPanel();
    insertPanelTitle = new javax.swing.JLabel();
    idLabel = new javax.swing.JLabel();
    idInput = new javax.swing.JTextField();
    productNameLabel = new javax.swing.JLabel();
    productNameInput = new javax.swing.JTextField();
    categoryLabel = new javax.swing.JLabel();
    categoryInput = new javax.swing.JTextField();
    priceLabel = new javax.swing.JLabel();
    priceInput = new javax.swing.JTextField();
    saveButton = new javax.swing.JButton();
    updateButton = new javax.swing.JButton();
    deleteButton = new javax.swing.JButton();
    cleanButton = new javax.swing.JButton();
    tablePanel = new javax.swing.JPanel();
    tablePanelTitle = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    table = new javax.swing.JTable();
    background = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    layoutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    title.setBackground(new java.awt.Color(29, 28, 34));
    title.setFont(new java.awt.Font("Josefin Sans", 1, 48)); // NOI18N
    title.setForeground(new java.awt.Color(255, 255, 255));
    title.setText("¡A Comernos Eso!");
    title.setOpaque(true);
    layoutPanel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, -1, -1));

    insertPanel.setBackground(new java.awt.Color(25, 24, 29));

    insertPanelTitle.setBackground(new java.awt.Color(255, 255, 255));
    insertPanelTitle.setFont(new java.awt.Font("Josefin Sans", 1, 24)); // NOI18N
    insertPanelTitle.setForeground(new java.awt.Color(255, 255, 255));
    insertPanelTitle.setText("Inserta un producto");

    idLabel.setBackground(new java.awt.Color(23, 22, 26));
    idLabel.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
    idLabel.setForeground(new java.awt.Color(255, 255, 255));
    idLabel.setText("ID");

    idInput.setEditable(false);
    idInput.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
    idInput.setForeground(new java.awt.Color(40, 40, 40));
    idInput.setEnabled(false);
    idInput.setName(""); // NOI18N
    idInput.setOpaque(true);
    idInput.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        idInputActionPerformed(evt);
      }
    });

    productNameLabel.setBackground(new java.awt.Color(23, 22, 26));
    productNameLabel.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
    productNameLabel.setForeground(new java.awt.Color(255, 255, 255));
    productNameLabel.setText("Nombre del producto");

    productNameInput.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N

    categoryLabel.setBackground(new java.awt.Color(23, 22, 26));
    categoryLabel.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
    categoryLabel.setForeground(new java.awt.Color(255, 255, 255));
    categoryLabel.setText("Categoría");

    categoryInput.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N

    priceLabel.setBackground(new java.awt.Color(23, 22, 26));
    priceLabel.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
    priceLabel.setForeground(new java.awt.Color(255, 255, 255));
    priceLabel.setText("Precio");

    priceInput.setFont(new java.awt.Font("Josefin Sans", 0, 18)); // NOI18N
    priceInput.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        priceInputActionPerformed(evt);
      }
    });

    saveButton.setFont(new java.awt.Font("Josefin Sans", 1, 14)); // NOI18N
    saveButton.setText("Enviar");
    saveButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveButtonActionPerformed(evt);
      }
    });

    updateButton.setFont(new java.awt.Font("Josefin Sans", 1, 14)); // NOI18N
    updateButton.setText("Modificar");
    updateButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        updateButtonActionPerformed(evt);
      }
    });

    deleteButton.setFont(new java.awt.Font("Josefin Sans", 1, 14)); // NOI18N
    deleteButton.setText("Eliminar");
    deleteButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        deleteButtonActionPerformed(evt);
      }
    });

    cleanButton.setFont(new java.awt.Font("Josefin Sans", 1, 14)); // NOI18N
    cleanButton.setText("Limpiar");
    cleanButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cleanButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout insertPanelLayout = new javax.swing.GroupLayout(insertPanel);
    insertPanel.setLayout(insertPanelLayout);
    insertPanelLayout.setHorizontalGroup(
      insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(insertPanelLayout.createSequentialGroup()
        .addGap(32, 32, 32)
        .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(insertPanelLayout.createSequentialGroup()
            .addGap(94, 94, 94)
            .addComponent(insertPanelTitle)
            .addContainerGap(137, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertPanelLayout.createSequentialGroup()
            .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(insertPanelLayout.createSequentialGroup()
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(insertPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(productNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(categoryInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addGroup(insertPanelLayout.createSequentialGroup()
                .addComponent(priceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(38, 38, 38))
          .addGroup(insertPanelLayout.createSequentialGroup()
            .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(productNameLabel)
              .addComponent(categoryLabel))
            .addGap(0, 0, Short.MAX_VALUE))))
      .addGroup(insertPanelLayout.createSequentialGroup()
        .addGap(21, 21, 21)
        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(cleanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    insertPanelLayout.setVerticalGroup(
      insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(insertPanelLayout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(insertPanelLayout.createSequentialGroup()
            .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(insertPanelLayout.createSequentialGroup()
                .addComponent(insertPanelTitle)
                .addGap(44, 44, 44)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(idLabel))
                .addGap(18, 18, 18)
                .addComponent(productNameLabel))
              .addComponent(productNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(categoryLabel))
          .addComponent(categoryInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(priceLabel)
          .addComponent(priceInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(53, 53, 53)
        .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(saveButton)
          .addComponent(updateButton)
          .addComponent(deleteButton)
          .addComponent(cleanButton))
        .addContainerGap(18, Short.MAX_VALUE))
    );

    idInput.getAccessibleContext().setAccessibleName("inserta");

    layoutPanel.add(insertPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 490, 320));

    tablePanel.setBackground(new java.awt.Color(25, 24, 29));

    tablePanelTitle.setBackground(new java.awt.Color(23, 22, 26));
    tablePanelTitle.setFont(new java.awt.Font("Josefin Sans", 1, 24)); // NOI18N
    tablePanelTitle.setForeground(new java.awt.Color(255, 255, 255));
    tablePanelTitle.setText("Productos registrados");

    table.setFont(new java.awt.Font("Josefin Sans", 0, 15)); // NOI18N
    table.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "ID", "Nombre del producto", "Categoría", "Precio"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    table.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tableMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(table);
    if (table.getColumnModel().getColumnCount() > 0) {
      table.getColumnModel().getColumn(0).setResizable(false);
      table.getColumnModel().getColumn(1).setResizable(false);
      table.getColumnModel().getColumn(2).setResizable(false);
      table.getColumnModel().getColumn(3).setResizable(false);
    }

    javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
    tablePanel.setLayout(tablePanelLayout);
    tablePanelLayout.setHorizontalGroup(
      tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(tablePanelTitle)
        .addGap(235, 235, 235))
      .addGroup(tablePanelLayout.createSequentialGroup()
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(18, Short.MAX_VALUE))
    );
    tablePanelLayout.setVerticalGroup(
      tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tablePanelLayout.createSequentialGroup()
        .addGap(19, 19, 19)
        .addComponent(tablePanelTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(16, Short.MAX_VALUE))
    );

    layoutPanel.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 730, 600));

    background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/crud/jdbc/assets/background.jpg"))); // NOI18N
    background.setToolTipText("");
    layoutPanel.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(layoutPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(layoutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void priceInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceInputActionPerformed
    
  }//GEN-LAST:event_priceInputActionPerformed

  private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
    try {
      String query = "INSERT INTO products(product_name, category, price) VALUES(?, ?, ?)";
      PreparedStatement ps = connection.getConnection().prepareStatement(query);

      ps.setString(1, productNameInput.getText());
      ps.setString(2, categoryInput.getText());
      int price = Integer.parseInt(String.valueOf(priceInput.getText()));
      ps.setInt(3, price);

      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Producto insertado correctamente.");
      showTable("");
      ps.close();
      clean();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "No fue posible realizar la inserción: '" + e.getMessage() + "'.");
    }
  }//GEN-LAST:event_saveButtonActionPerformed

  private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
    try {
      String query = "UPDATE products SET product_name = ?, category = ?, price = ? WHERE id = ?";
      PreparedStatement ps = connection.getConnection().prepareStatement(query);

      ps.setString(1, productNameInput.getText());
      ps.setString(2, categoryInput.getText());
      int intPrice = Integer.parseInt(String.valueOf(priceInput.getText()));
      int intId = Integer.parseInt(idInput.getText());
      ps.setInt(3, intPrice);
      ps.setInt(4, intId);

      int affectedRows = ps.executeUpdate();
      if (affectedRows >= 1) {
        JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
        showTable("");
        ps.close();
        clean();
      } else {
        JOptionPane.showMessageDialog(null, "El producto enviado no fue encontrado en la tabla.");
      }
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "No fue posible realizar la actualización: " + e.getMessage() + ".");
    }
  }//GEN-LAST:event_updateButtonActionPerformed

  private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
    try {
      String query = "DELETE FROM products WHERE product_name = ? AND id = ?";
      PreparedStatement ps = connection.getConnection().prepareStatement(query);

      ps.setString(1, productNameInput.getText());
      int intId = Integer.parseInt(idInput.getText());
      ps.setInt(2, intId);

      ps.executeUpdate();
      JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.");
      showTable("");
      ps.close();
      clean();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "No fue posible eliminar el producto: '" + e.getMessage() + "'.");
    }
  }//GEN-LAST:event_deleteButtonActionPerformed

  private void cleanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanButtonActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_cleanButtonActionPerformed

  private void idInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInputActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_idInputActionPerformed

  private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
    int rows = this.table.getSelectedRow();
    this.idInput.setText(this.table.getValueAt(rows, 0).toString());
    this.productNameInput.setText(this.table.getValueAt(rows, 1).toString());
    this.categoryInput.setText(this.table.getValueAt(rows, 2).toString());
    String stringPrice = String.valueOf(this.table.getValueAt(rows, 3));
    String priceReplaced = stringPrice.replace(",", "");
    this.priceInput.setText(priceReplaced);
  }//GEN-LAST:event_tableMouseClicked

  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Frame().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel background;
  private javax.swing.JTextField categoryInput;
  private javax.swing.JLabel categoryLabel;
  private javax.swing.JButton cleanButton;
  private javax.swing.JButton deleteButton;
  private javax.swing.JTextField idInput;
  private javax.swing.JLabel idLabel;
  private javax.swing.JPanel insertPanel;
  private javax.swing.JLabel insertPanelTitle;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JPanel layoutPanel;
  private javax.swing.JTextField priceInput;
  private javax.swing.JLabel priceLabel;
  private javax.swing.JTextField productNameInput;
  private javax.swing.JLabel productNameLabel;
  private javax.swing.JButton saveButton;
  private javax.swing.JTable table;
  private javax.swing.JPanel tablePanel;
  private javax.swing.JLabel tablePanelTitle;
  private javax.swing.JLabel title;
  private javax.swing.JButton updateButton;
  // End of variables declaration//GEN-END:variables
}
