package bank_management_system;
import java.sql.*;
public class Conn {
	
	
	Connection c;
	Statement stm;
	public Conn() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","root");
			stm = c.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	}

