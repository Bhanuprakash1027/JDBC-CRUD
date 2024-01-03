package bhanu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loded");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found " + e);
			e.printStackTrace();
		}

		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfg", "root", "Berpm0@123");
			System.out.println("Connection sucessfull");
			Statement st=con.createStatement();
			//*****************select all**************************
		try {
//				Scanner sc=new Scanner(System.in);
//				int num1=sc.nextInt();
//				String name=sc.next();
//				int cc=sc.nextInt();
//				int milage=sc.nextInt();
//				int seat=sc.nextInt();
//				
				String sql;
				sql="select * from bike";
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				System.out.println("number  Chacee_no  CC  Milage  Seat");
			System.out.println("------------------------------------");
//				ps.setInt(1, num1);
//				ps.setString(2, name);
//				ps.setInt(3, cc);
//				ps.setInt(4, milage);
//				ps.setInt(5, seat);
			while(rs.next())
				{
					System.out.print(" " + rs.getInt(1));
				System.out.print(" " + rs.getString(2));
					System.out.print(" " + rs.getInt(3));
					System.out.print(" " + rs.getInt(4));
					System.out.println(" " + rs.getInt(5));
				}
				
				System.out.println("------------------------------------");
			} catch (Exception e) {
				System.out.println("select All quary " + e);
			}
			
			
			
			//*******************Delete****************************
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println("enter deleted record numner:");
				int num=sc.nextInt();
				String sql;
				sql="delete from bike where number=?";
				ps=con.prepareStatement(sql);  // quary will get here
				ps.setInt(1, num);
				if(ps.executeUpdate()>0)
				{
					System.out.println("Record deleted sucessfull");
				}else
				{
					System.out.println("record is not found");
				}
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("quary issue " +e);
			}
			
			con.close();
		} catch (SQLException e) {
			System.out.println("SQLExcution " + e);
			e.printStackTrace();
		}
	}

}
