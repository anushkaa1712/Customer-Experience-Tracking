package complaint;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Complaint {
	int custId;  //Customer Id
	int compId;  //Complaint Id
	String desc; //Description of Complaint
	String staus; //Status of Complaint
	String compDate; //Complaint Date

	Connection cn;
	PreparedStatement ps;
	
	//Register Complaint
	void regComp(int custId, String desc) throws SQLException {
		
		//Complaint Registration Query
		String reg = "insert into complaint (cus_id, description, status, c_date) values (?, ?, 'Open', Now())";
		
		ps = cn.prepareStatement(reg);
		ps.setInt(1, custId);
		ps.setString(2, desc);
		ps.executeUpdate();
	}
	
	void viewComp(int custId) throws SQLException {
		
		// Customer Complaint View Query
		String view = "select * from complaint where cus_id = ?";
		
		ps = cn.prepareStatement(view);
		ps.setInt(1, custId);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt("com_id") + " " + rs.getString("description") + " " + rs.getString("status") + " " + rs.getDate("c_date"));
		}
	}
	
	
}
