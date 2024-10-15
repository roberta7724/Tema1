package ro.emanuel.oop.JDBC;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Properties;

	public class Flowers {
		
		public static void main(String[] args) throws SQLException {
			
			Properties connectionProps = new Properties();
			connectionProps.put("user", "root");
			connectionProps.put("password","");
			
			//open connection
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/oop2024",
					connectionProps);
			
			//open statement
			Statement stmt = conn.createStatement();
			
//			//INSERT 
			String name = "Lebanese rose";
			String origin = "Lebanon";
			String flower = "Rose";
			int price = 20;
			
			String sqlInsert = "INSERT INTO flowers(name, origin, flower, price) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sqlInsert);
			ps.setString(1, name);
			ps.setString(2, origin);
			ps.setString(3, flower);
			ps.setInt(4, price);
			int rowsAff = ps.executeUpdate();
			System.out.println(rowsAff);
//		
//			
//		
//			
//				
//			//UPDATE
//			
			String update = "UPDATE flowers SET name = ? WHERE origin = ?";
			PreparedStatement psu = conn.prepareStatement(update);
			psu.setString(1, name);
			psu.setString(2, "Turkey");
			psu.executeUpdate();
//			
//			
//			//DELETE
			String deleteValue = "DELETE FROM flowers WHERE origin =?";
			PreparedStatement ps3 = conn.prepareStatement(deleteValue);
			ps3.setString(1,"Lebanon" );
			int result = ps3.executeUpdate();
			System.out.println(result);
			
			
			//get result
			ResultSet rs = stmt.executeQuery("select * from flowers");
			
			//map result
		while(rs.next()) {
				String fname = rs.getString("name");
				String forigin = rs.getString("origin");
				String fflower = rs.getString("flower");
				int fprice = rs.getInt("price");
				System.out.println(fname + "|" + forigin + "|" + fflower + "|" + fprice);
			}
			
			conn.close();	
			
		}


}
