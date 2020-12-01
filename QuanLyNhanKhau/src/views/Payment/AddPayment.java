/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Payment;

import controllers.DongGopPanelController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.PaymentModel;
import services.DongGopService;

/**
 *
 * @author Administrator
 */
public class AddPayment extends javax.swing.JFrame {

    private String content;
    private JFrame parentJFrame;
    private DongGopPanelController dongGopController;
    private int eventID;
    private String idHoKhau;
    private final DongGopService dongGopService = new DongGopService();

    public AddPayment(String idHoKhau, String content, JFrame parentJFrame) {
        initComponents();
        this.idHoKhau = idHoKhau;
        this.content = content;
        this.JlbContent.setText(content);
        this.parentJFrame = parentJFrame;
        this.setTitle("Thêm đóng góp");
        dongGopController = new DongGopPanelController();
        dongGopController.setDataToComboBox(JcbEvent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JlbContent = new javax.swing.JLabel();
        JtfValue = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JcbEvent = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtfNote = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JlbContent.setText("jLabel1");

        JtfValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JtfValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtfValueActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("Lưu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("x1000 đồng");

        jLabel2.setText("Ghi chú");

        JcbEvent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        JcbEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JcbEventActionPerformed(evt);
            }
        });

        JtfNote.setColumns(20);
        JtfNote.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        JtfNote.setRows(5);
        jScrollPane1.setViewportView(JtfNote);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JcbEvent, 0, 223, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(JtfValue, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(29, 29, 29))
            .addComponent(JlbContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JlbContent, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JtfValue, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JcbEvent, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JtfValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtfValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtfValueActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String tmp = JtfValue.getText();
        int value;
        try {
            value = Integer.parseInt(tmp);
        } catch (Exception e) {
            value = 0;
        }
        String note = JtfNote.getText();
        if (value > 0 && eventID >0) {
            PaymentModel p = new PaymentModel();
            p.setGhichu(note);
            p.setIdHoKhau(idHoKhau);
            p.setIdSukien(eventID);
            p.setSoTienDaDong(value);
            boolean b = dongGopService.addPayment(p);
            if(b) {
                JOptionPane.showMessageDialog(null, "OK!! ", "Đã lưu!!", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!! ", "Warning!!", JOptionPane.ERROR_MESSAGE);
                
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!! Vui lòng nhập đủ thông tin!", "Warning!!", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void JcbEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JcbEventActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String eventName = (String) cb.getSelectedItem();
        try {

            eventID = Integer.parseInt(eventName.substring(0, eventName.indexOf(':')));
        } catch (Exception e) {

            eventID = -1;
        }
        System.err.println(eventID + "  " + idHoKhau);
    }//GEN-LAST:event_JcbEventActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JcbEvent;
    private javax.swing.JLabel JlbContent;
    private javax.swing.JTextArea JtfNote;
    private javax.swing.JTextField JtfValue;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
