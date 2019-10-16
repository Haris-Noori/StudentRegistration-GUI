package pkg;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class controller {

	private model m = new model();
	private regFrame f = new regFrame();
	private tableFrame t = new tableFrame();
	
	controller()
	{
		JOptionPane.showMessageDialog(null, "Consrt called");
	}
	
	public controller(model mod, regFrame frame)
	{
		this.m = mod;
		this.f = frame;
		
		m.connect();  //connect with database
		
		f.setVisible(true);  // opening registration form 
		f.setcont(this);
	}
	
	public void createTableFrame(tableFrame table)
	{
		this.t = table;
		t.setVisible(true);
	}
	
	public void getInfo(String rollno, String name, String fname, String gender, String email, String address)
	{
		m.saveInfo(rollno, name, fname, gender, email, address);
	}
	
	public void getDataFromTable()
	{
		ResultSet res = m.getTable();
		
		try {
			while (res.next()) {
				System.out.print(res.getString(1));
				System.out.print(res.getString(2));
				System.out.print(res.getString(3));
				System.out.print(res.getString(4));
				System.out.print(res.getString(5));
				System.out.print(res.getString(6));
				System.out.print("\r");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableFrame.addDataToTable(res);
	}
	
	public void searchFromTable(String searchName)  // Search From Database name we want to search
	{
		ResultSet res = m.searchTable(searchName);
		
		try {
			while(res.next())
			{
				System.out.print(res.getString(1));
				System.out.print(res.getString(2));
				System.out.print(res.getString(3));
				System.out.print(res.getString(4));
				System.out.print(res.getString(5));
				System.out.print(res.getString(6));
				System.out.print("\r");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tableFrame.addDataToTable(res);
		
	}
	

}
