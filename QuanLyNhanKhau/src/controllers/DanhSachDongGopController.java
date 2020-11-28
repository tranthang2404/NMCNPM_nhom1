/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Bean.HoKhauBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import models.EventModel;
import models.PaymentModel;
import services.DongGopService;
import services.HoKhauService;
import utility.ClassTableModel;
import utility.TableModelHoKhau;
import views.Payment.AddPayment;

/**
 *
 * @author Administrator
 */
public class DanhSachDongGopController {
     private JComboBox<String> JcbBox;
    private JPanel Jpn;
    private JFrame parentJFrame;
    private List<PaymentModel> list;
    private final DongGopService dongGopService = new DongGopService();
    private final ClassTableModel tableModel = new ClassTableModel();
     private final String COLUNMS[] = {"Mã đóng góp", "Mã hộ", "Tên hộ", "Số tiền", "Thời gian","Ghi chú"}; 
    
    public DanhSachDongGopController( JPanel Jpn, int eventID) {
        this.Jpn =Jpn;
        this.list = dongGopService.getAllPayments(eventID);
        setData();
    }

    
     public void setData() {
        DefaultTableModel model = tableModel.setTableDongGop(list, COLUNMS);
        
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
//                    HoKhauBean temp = list.get(table.getSelectedRow());
//                    AddPayment addPaymentFrame = new AddPayment(temp.getHoKhauModel().getMaHoKhau(),temp.toString(), parentJFrame);
//                     addPaymentFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//                    addPaymentFrame.setLocationRelativeTo(null);
//                    addPaymentFrame.setVisible(true);
                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        Jpn.removeAll();
        Jpn.setLayout(new BorderLayout());
        Jpn.add(scroll);
        Jpn.validate();
        Jpn.repaint();
    }

      public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
}
