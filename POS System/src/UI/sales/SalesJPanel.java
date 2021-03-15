/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.sales;

import Domain.Sales.Sale;
import TechnicalServices.Persistence.Register;
import UI.sales.NewSaleFrame;
import Utilities.SalesTableModel;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lenovo
 */
public class SalesJPanel extends javax.swing.JPanel {

    private NewSaleFrame newSaleJFrame ;
    private Register register;
    private SalesTableModel salesTableModel=new SalesTableModel();
    private List<Sale> ls;

    /**
     * Creates new form SalesJPanel
     */
    public SalesJPanel(Register register,List<Sale> ls) {
        initComponents();
        this.register=register;
        this.ls=ls;
        jTable1.setModel(salesTableModel);
        tableInitializer();
    }

    private void tableInitializer(){
            for(Sale s:ls){
                if(s.isIsComplete())
                salesTableModel.add(s);
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        newSale = new javax.swing.JPanel();
        pic = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        waitingList = new javax.swing.JPanel();
        pic1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N

        menu.setBackground(new java.awt.Color(241, 241, 241));
        menu.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.lightGray, java.awt.Color.darkGray));
        menu.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        menu.setMinimumSize(new java.awt.Dimension(100, 80));
        menu.setPreferredSize(new java.awt.Dimension(100, 80));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newSale.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(170, 170, 170)));
        newSale.setMinimumSize(new java.awt.Dimension(100, 80));
        newSale.setPreferredSize(new java.awt.Dimension(100, 80));
        newSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newSaleMousePressed(evt);
            }
        });

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/register.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("New Sale - POS");

        javax.swing.GroupLayout newSaleLayout = new javax.swing.GroupLayout(newSale);
        newSale.setLayout(newSaleLayout);
        newSaleLayout.setHorizontalGroup(
            newSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newSaleLayout.createSequentialGroup()
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );
        newSaleLayout.setVerticalGroup(
            newSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newSaleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 22, Short.MAX_VALUE))
        );

        menu.add(newSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 220, 75));

        waitingList.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(170, 170, 170)));
        waitingList.setMinimumSize(new java.awt.Dimension(100, 80));

        pic1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/waiting-list.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Wating List");

        javax.swing.GroupLayout waitingListLayout = new javax.swing.GroupLayout(waitingList);
        waitingList.setLayout(waitingListLayout);
        waitingListLayout.setHorizontalGroup(
            waitingListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(waitingListLayout.createSequentialGroup()
                .addComponent(pic1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );
        waitingListLayout.setVerticalGroup(
            waitingListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, waitingListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(waitingListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pic1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        menu.add(waitingList, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 2, 210, 75));

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(166, 166, 166), 1, true));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setForeground(new java.awt.Color(118, 138, 222));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Number", "Date", "Items", "Net Price", "Taxation", "Total Price", "Payment Method"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(166, 166, 166));
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newSaleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newSaleMousePressed
        try {
            // TODO add your handling code here:
            newSaleJFrame= new NewSaleFrame(register);
        } catch (SQLException ex) {
            Logger.getLogger(SalesJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        newSaleJFrame.setVisible(true);
    }//GEN-LAST:event_newSaleMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel newSale;
    private javax.swing.JLabel pic;
    private javax.swing.JLabel pic1;
    private javax.swing.JPanel waitingList;
    // End of variables declaration//GEN-END:variables
}