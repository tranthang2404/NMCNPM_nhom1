
package controllers;

import Bean.HoKhauBean;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import services.DongGopService;
import services.HoKhauService;
import utility.TableModelHoKhau;
import views.Payment.AddPayment;
import views.infoViews.InfoJframe;


/**
 *
 * @author Administrator
 */
public class DongGopPanelController {
    private JComboBox<String> JcbBox;
    private JPanel Jpn;
    private JFrame parentJFrame;
    private List<HoKhauBean> list;
    private final DongGopService dongGopService = new DongGopService();
    private final HoKhauService hoKhauService = new HoKhauService();
    private final TableModelHoKhau tableModelHoKhau = new TableModelHoKhau();
     private final String COLUNMS[] = {"Mã hộ khẩu", "Họ tên chủ hộ", "Địa chỉ"}; 
    
    public DongGopPanelController( JPanel Jpn) {
        this.Jpn =Jpn;
        this.list = hoKhauService.getListHoKhau();
        setData();
    }

    public DongGopPanelController() {
    }
     public void setData() {
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
                    AddPayment addPaymentFrame = new AddPayment(temp.getHoKhauModel().getMaHoKhau(),temp.toString(), parentJFrame);
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

      public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    public void setDataToComboBox(JComboBox<String> tmp){
        //query tu database => mang string
        List<EventModel> lst = dongGopService.getAllEvents();
        int lengh = lst.size();
        String[] arrStr = new String[lengh+1];
        arrStr[0]= "Chọn sự kiện";
        for(int i=0; i<lengh;i++){
            EventModel e = lst.get(i);
            arrStr[i+1] = e.getId()+": "+e.getTensukien();
        }
        tmp.setModel(new javax.swing.DefaultComboBoxModel<>(arrStr)); //new String[] { "1:Lu lut mien trung", "2: Ung ho nguoi ngheo" })
    }
    
 
}
