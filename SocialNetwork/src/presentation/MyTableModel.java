package presentation;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import entities.User;

public class MyTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> users;
    
    public MyTableModel(ArrayList<User> users) {
        super();
        this.users = users;
    }
	
	@Override
    public int getRowCount() {
        return users.size();
    }
    
	@Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Object getValueAt(int row, int coll) {
    
    	switch (coll) {
            case 0:
                return users.get(row).id;
            case 1:
                return users.get(row).getLogin();
            case 2:
                return users.get(row).getPassword();
            default:
                return "";
        }
    }
    
    @Override
    public String getColumnName(int coll) {
        
    	String result = "";
    	
        switch (coll) {
            case 0:
                result = "ID";
                break;
            case 1:
                result = "Login";
                break;
            case 2:
                result = "Password";
                break;
        }
        
        return result;
    }
   
}
