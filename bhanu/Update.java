package bhanu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		
		// driver class load
		
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 System.out.println("Driver class is lodded sucessfully:");
			 
			
		} catch (ClassNotFoundException e) {
			System.out.println("class not found " + e);
		}
		
		// JDBC connection 
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mfg", "root", "Berpm0@123");
			System.out.println("JDBC connection established sucessfull: ");
			
			String sql;
			sql = "select * from bike";
	//		System.out.println("Sql response" +sql);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println("number  Chacee_no  CC  milage  Seat");
			System.out.println("------------------------------------");
			
			while(rs.next())
			{
				System.out.print("  " + rs.getInt(1));
				System.out.print("  " + rs.getString(2));
				System.out.print("  " + rs.getInt(3));
				System.out.print("  " + rs.getInt(4));
				System.out.println("  " + rs.getInt(5));
			}
			
			
			System.out.println("------------------------------------");
			
			
			//*****************updated quary**********************
			Scanner sc =new Scanner(System.in);
			System.out.println("enter updated record number:");
			int n=sc.nextInt();
			
			//sql ="update bike set chacee_no='babu2027',seat='2' where number = ?";
			sql ="select * from bike where number =?";
			ps =con.prepareStatement(sql);
			ps.setInt(1, n);
			rs = ps.executeQuery();
			
			System.out.println("number  Chacee_no  CC  milage  Seat");
			System.out.println("------------------------------------");
			
			if(rs.next())
			{
				System.out.print("  " + rs.getInt(1));
				System.out.print("  " + rs.getString(2));
				System.out.print("  " + rs.getInt(3));
				System.out.print("  " + rs.getInt(4));
				System.out.println("  " + rs.getInt(5));
				System.out.println("Record updated :");
			}
			else
			{
				System.out.println("Record not found ");
			}
			
			con.close();
			sc.close();
			
		} catch (SQLException e) {
			System.out.println("Quary Exception " + e);
		}
		
	}

	
}
