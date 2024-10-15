package ro.emanuel.oop.JDBC;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Properties;

	public class FlowerShop {
		
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
			
			//INSERT 
			String name = "Garden Grace";
			String address = "Tuscany";
			String phoneNumber = "0755678764";
			
			String sqlInsert = "INSERT INTO FlowerShop(name, address, phoneNumber) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sqlInsert);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phoneNumber);
			
			int rowsAff = ps.executeUpdate();
			System.out.println(rowsAff);
		
			
		
			
				
			//UPDATE
			
			String update = "UPDATE FlowerShop SET address = ? WHERE name = ?";
			PreparedStatement psu = conn.prepareStatement(update);
			psu.setString(1, address);
			psu.setString(2, "Garden Grace");
			psu.executeUpdate();
			
			
			//DELETE
			String deleteValue = "DELETE FROM flowershop WHERE phoneNumber =?";
			PreparedStatement ps3 = conn.prepareStatement(deleteValue);
			ps3.setInt(1,755678765 );
			int result = ps3.executeUpdate();
			System.out.println(result);
			
			
			//get result
			ResultSet rs = stmt.executeQuery("select * from flowershop");
			
			//map result
		while(rs.next()) {
				String fname = rs.getString("name");
				String faddress = rs.getString("address");
				String fphoneNumber = rs.getString("phoneNumber");
				
				System.out.println(fname + "|" + faddress + "|" + fphoneNumber);
			}
			
			conn.close();	
			
		}


}
