package ro.emanuel.tema2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.tema2.helper.DBHelper;
import ro.emanuel.tema2.pojo.RubiksCube;

public class RubicCubeDao {
	public static List<RubiksCube> getAllRubiksCube() throws SQLException {
        List<RubiksCube> RubiksCubeList = new ArrayList<>(); 
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from RubiksCube");
        while(rs.next()) {
            int id = rs.getInt("id");
            String brand = rs.getString("brand");
            Double weight = rs.getDouble("weight");
            int sides = rs.getInt("sides");
            RubiksCube rc = new RubiksCube(id, brand, weight, sides);
            RubiksCubeList.add(rc);
        }
        DBHelper.closeConnection();        
        return RubiksCubeList;
    }
    
    public static int deleteOneBook(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        int deletedRows = stmt.executeUpdate("delete from RubiksCube where id = " + id);
        DBHelper.closeConnection();
        return deletedRows; 
    }
    
    public static int createOneNewRubiksCube(RubiksCube rcToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into RubiksCube (brand, weight, sides) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, rcToCreate.getBrand()); 
        ps.setDouble(2, rcToCreate.getWeight());
        ps.setInt(3, rcToCreate.getSides());
        int affectedRows = ps.executeUpdate();
        DBHelper.closeConnection();
        return affectedRows; 
    }
    
    public static int updateRubiksCube(RubiksCube rc) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update RubiksCube set brand= ?, weight= ?, sides= ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, rc.getBrand());
        ps.setDouble(2, rc.getWeight());
        ps.setInt(3, rc.getSides());
        ps.setInt(4, rc.getId());
        int rowsUpdated = ps.executeUpdate();
        DBHelper.closeConnection();
        return rowsUpdated; 
    }
    
   
    public static RubiksCube getRubiksCubeById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection(); 
        List<RubiksCube> rcb = getAllRubiksCube(); 
        for(RubiksCube rc : rcb) { 
            if(rc.getId() == id) { 
                return rc; 
            }
        }
        return null; 
    }
}
