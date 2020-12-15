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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import views.Payment.AddEvent;
import views.Payment.AddPayment;
import views.Payment.ChangePayment;

/**
 *
 * @author Administrator
 */
public class DanhSachDongGopController {

    private JComboBox<String> JcbBox;
    private JPanel Jpn;
    private JFrame parentJFrame;
    private static List<PaymentModel> listPayment;
    private int eventID;

    private static final HoKhauService hoKhauService = new HoKhauService();
    private static final DongGopService dongGopService = new DongGopService();
    private final ClassTableModel tableModel = new ClassTableModel();

    private static final TableModelHoKhau tableModelHoKhau = new TableModelHoKhau();
    private final String COLUNMS[] = {"Mã đóng góp", "Mã hộ", "Tên hộ", "Số tiền", "Thời gian", "Ghi chú"};

    public DanhSachDongGopController(JPanel Jpn, int eventID) {
        this.Jpn = Jpn;
        this.eventID = eventID;
        this.listPayment = dongGopService.getAllPayments(eventID);
        setData();
    }

    public  void setData() {
        DefaultTableModel model = tableModel.setTableDongGop(listPayment, COLUNMS);

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
                    PaymentModel temp = listPayment.get(table.getSelectedRow());
                    ChangePayment changePayment = new ChangePayment(temp.getId(), eventID, temp.getIdHoKhau(), temp.getTenChuHo(), temp.getSoTienDaDong(), temp.getGhichu());
                    changePayment.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

                    changePayment.setLocationRelativeTo(null);
                    changePayment.setVisible(true);
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

    public static void setDataChuaDong(JPanel Jpn, List<HoKhauBean> list, String COLUNMS[]) {
        DefaultTableModel model = tableModelHoKhau.setTableHoKhau(list, COLUNMS);

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
                    HoKhauBean temp = list.get(table.getSelectedRow());
                    AddPayment addPaymentFrame = new AddPayment(temp.getHoKhauModel().getMaHoKhau(),temp.toString(),null);
                    
                     addPaymentFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    addPaymentFrame.setLocationRelativeTo(null);
                    addPaymentFrame.setVisible(true);
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

    public static void setDanhSachChuaDongGop(JPanel Jpn, int eventID) {
        Set<String> setIDHoKhauDaDong = new HashSet<String>();
         List<PaymentModel>   lstPay = dongGopService.getAllPayments(eventID);
        for (int i = 0; i < lstPay.size(); i++) {
            String tmp = lstPay.get(i).getIdHoKhau();
            setIDHoKhauDaDong.add(tmp);
        }
        List<HoKhauBean> lstChuaDong = new ArrayList<>();
        List<HoKhauBean> lstHoKhau = hoKhauService.getListHoKhau();
        for (int i = 0; i < lstHoKhau.size(); i++) {
            if (!setIDHoKhauDaDong.contains(lstHoKhau.get(i).getHoKhauModel().getMaHoKhau())) {
                lstChuaDong.add(lstHoKhau.get(i));
            }
        }
        String COLUNMS[] = {"Mã hộ khẩu", "Họ tên chủ hộ", "Địa chỉ"};
        setDataChuaDong(Jpn, lstChuaDong, COLUNMS);
    }
}
