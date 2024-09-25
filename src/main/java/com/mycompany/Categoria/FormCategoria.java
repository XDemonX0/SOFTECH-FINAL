
package com.mycompany.Categoria;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.TableColumnModel;

public class FormCategoria extends javax.swing.JFrame {
    
    public FormCategoria() {
       initComponents();
        Font montserratFont = new Font("Montserrat", Font.PLAIN, 12);
        
        Categoria objetoCategoria = new Categoria();
        objetoCategoria.MostrarCategoria(tbCategoria);
        utilidades util = new utilidades();
        TableColumnModel columnModel = tbCategoria.getColumnModel();

        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setHeaderRenderer(util.new GestionEncabezadoTabla());
        }
        
       utilidades2 utils2 = new utilidades2();
       tbCategoria.setDefaultRenderer(Object.class, utils2.new GestionCeldas("texto"));

       txtFormDescripcion.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume(); 
                }
            }
        });
       tbCategoria.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        button1 = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFormId = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txtFormDescripcion = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnactivar = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCategoria = new javax.swing.JTable();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jButton3.setText("jButton3");

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("ID Categoria");

        jLabel2.setText("Descripcion de categoria:");

        txtFormId.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtFormId.setEnabled(false);

        btnGuardar.setBackground(new java.awt.Color(148, 215, 242));
        btnGuardar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        txtFormDescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnEditar.setBackground(new java.awt.Color(148, 215, 242));
        btnEditar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(148, 215, 242));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEliminar.setText("DESACTIVAR");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnactivar.setBackground(new java.awt.Color(148, 215, 242));
        btnactivar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnactivar.setText("ACTIVAR");
        btnactivar.setBorder(null);
        btnactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactivarActionPerformed(evt);
            }
        });

        btnEliminar1.setBackground(new java.awt.Color(148, 215, 242));
        btnEliminar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEliminar1.setText("LIMPIAR");
        btnEliminar1.setBorder(null);
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                .addComponent(btnactivar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtFormDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtFormId, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFormId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFormDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnactivar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista Categorias"));
        jPanel2.setPreferredSize(new java.awt.Dimension(903, 437));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(10, 10));

        tbCategoria.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tbCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbCategoria.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbCategoria.setGridColor(new java.awt.Color(255, 255, 255));
        tbCategoria.setInheritsPopupMenu(true);
        tbCategoria.setMaximumSize(new java.awt.Dimension(999999, 999999));
        tbCategoria.setPreferredSize(new java.awt.Dimension(5000, 10000));
        tbCategoria.setRequestFocusEnabled(false);
        tbCategoria.setRowHeight(80);
        tbCategoria.setShowGrid(false);
        tbCategoria.setShowHorizontalLines(true);
        tbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCategoriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCategoria);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
       Categoria objetoCategoria =  new Categoria();
       objetoCategoria.insertarCategoria(txtFormDescripcion, tbCategoria); 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCategoriaMouseClicked
        // TODO add your handling code here:
        Categoria objetosCategoria = new Categoria();
        objetosCategoria.SeleccionarCategoria(tbCategoria, txtFormId, txtFormDescripcion);
    }//GEN-LAST:event_tbCategoriaMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        Categoria objetoCategoria =  new Categoria();
        objetoCategoria.EditarCategoria(txtFormId, txtFormDescripcion, tbCategoria);
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        Categoria objetoCategoria = new Categoria();
        objetoCategoria.EliminarCategoria(txtFormId, tbCategoria);
       
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactivarActionPerformed
        Categoria objetoCategoria = new  Categoria();
        objetoCategoria.ActivarCategoria(txtFormId, tbCategoria);
        
        
    }//GEN-LAST:event_btnactivarActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        Categoria objetoCategoria = new  Categoria();
        objetoCategoria.LimpiarCampos(txtFormId, txtFormDescripcion);
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCategoria().setVisible(true);
            }
        });
    }
  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnactivar;
    private java.awt.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbCategoria;
    private javax.swing.JTextField txtFormDescripcion;
    private javax.swing.JTextField txtFormId;
    // End of variables declaration//GEN-END:variables

   
}
