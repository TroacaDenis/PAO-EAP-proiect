package jdbc;

import distributors.Distributor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DistributorsDatabase {
	
	public static void createTable() {
		Connection DBconnection = DatabaseConnection.getDBconnection();
        try {
            Statement stmt = DBconnection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS distributors" + "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(50), phoneNumber varchar(15))");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static int insertDistributor (String name, String phoneNumber) {
		Connection DBconnection = DatabaseConnection.getDBconnection();
		try {
			PreparedStatement ps = DBconnection.prepareStatement("INSERT INTO distributors(name, phoneNumber) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setString(2, phoneNumber);
			ps.executeUpdate();
			
			//return generated id
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){	
				int id = rs.getInt(1);
				ps.close();
				return id;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void removeDistributor (int id) {
		Connection DBconnection = DatabaseConnection.getDBconnection();
		try {
			PreparedStatement ps = DBconnection.prepareStatement("DELETE FROM distributors WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Distributor> getDistributors(){
		List<Distributor> products = new ArrayList<>();
		Connection DBconnection = DatabaseConnection.getDBconnection();
		try {
			Statement stmt = DBconnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM distributors");
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phoneNumber = rs.getString(3);
				products.add(new Distributor(id, name, phoneNumber));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	
}
