package bhanu;


import java.sql.*;
public class FindAll {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			// Driver class loding
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded:");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not fount " + e);
		}

		// JDBC connection establish
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mfg", "root", "Berpm0@123");
			System.out.println("Database connection sucessfull: ");
			Statement st=con.createStatement();
			//***********************************************
			String sql="select * from bike";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			System.out.println("number  chacee_no  cc  Milage  seat");
			System.out.println("----------------------------------------");
			while(rs.next())
			{
				System.out.print("  " + rs.getInt(1));
				System.out.print("  " + rs.getString(2));
				System.out.print("  " + rs.getInt(3));
				System.out.print("  " + rs.getInt(4));
				System.out.println("  " + rs.getInt(5));
			}
			System.out.println("----------------------------------------");
			con.close();
			
			//***********************************************
		} catch (SQLException e) {
			System.out.println("sql statment exception " + e);
		}
	}

}
