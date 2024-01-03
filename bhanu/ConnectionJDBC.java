package bhanu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class ConnectionJDBC {
	

	public static void main(String[] args) throws SQLException {
		
		// Driver class load
		
		String url="jdbc:mysql://localhost:3306/mfg";
		String user="root";
		String Password ="Berpm0@123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver load sucessfull:");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found " + e);
			e.printStackTrace();
		}
		Connection con=DriverManager.getConnection(url, user, Password);
		// Generate Statment
		Statement st=con.createStatement();
			
		int num;
		String sql;
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();
		sql="select * from bike where number=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, 1027);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			System.out.println("number " + rs.getInt(num));
		}
		System.out.println("Conncetion sucessfull:");
		con.close();

	}

}
