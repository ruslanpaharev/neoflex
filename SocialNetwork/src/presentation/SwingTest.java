package presentation;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import business.UserBusiness;
import entities.User;
import support.SystemOutput;

public class SwingTest {
	
    private JTable jTabPeople;
 
    public SwingTest() {
        
        JFrame jfrm = new JFrame("User Example");
        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SystemOutput.setSystemOutputNullable();
        UserBusiness userBusiness = new UserBusiness();
        
        ArrayList<User> users = userBusiness.getAll();
                
        MyTableModel tModel = new MyTableModel(users);
        jTabPeople = new JTable(tModel);
        JScrollPane jscrlp = new JScrollPane(jTabPeople);
        
        jfrm.setSize(1013, 320);
        jTabPeople.setPreferredScrollableViewportSize(new Dimension(950, 200));
        jfrm.getContentPane().add(jscrlp);
        jfrm.setVisible(true);

        JButton btnPress = new JButton("Add new User");
        
        btnPress.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent ae) {
            	
            	User user = new User();
            	
            	user.setLogin("mySwingUser" + (int) (Math.random() * 1000000000));
        		user.setPassword("123456");
        		
        		user.id = userBusiness.Insert(user);
        		            	
            	users.add(user);
                tModel.fireTableDataChanged();
            }
        });
        
        jfrm.add(btnPress);
        
    }
 
    public static void main(String[] args) {
 
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingTest();
            }
        });
        
    }

}
