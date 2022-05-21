package jdbc;

import products.Food;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.SortedSet;
import java.util.TreeSet;

public class FoodDatabase {
	
	public static void createTable() {
		Connection DBconnection = DatabaseConnection.getDBconnection();
        try {
            Statement stmt = DBconnection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS food" + "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(50), price double, qty int, distributorId int, discountPercentage int, expirationDate date)");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static int insertFood (String name, double price, int qty, int distributorId, int discountPercentage, LocalDate expirationDate) {
		Connection DBconnection = DatabaseConnection.getDBconnection();
		try {
			PreparedStatement ps = DBconnection.prepareStatement("INSERT INTO food(name, price, qty, distributorId, discountPercentage, expirationDate) VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setInt(3, qty);
			ps.setInt(4, distributorId);
			ps.setInt(5, discountPercentage);
			ps.setDate(6, Date.valueOf(expirationDate));
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
	
	public static void removeFood (int id) {
		Connection DBconnection = DatabaseConnection.getDBconnection();
		try {
			PreparedStatement ps = DBconnection.prepareStatement("DELETE FROM food WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static SortedSet<Food> getFoodProducts(){
		SortedSet<Food> products = new TreeSet<>();
		Connection DBconnection = DatabaseConnection.getDBconnection();
		try {
			Statement stmt = DBconnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM food");
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				int qty = rs.getInt(4);
				int distributorId = rs.getInt(5);
				int discountPercentage = rs.getInt(6);
				LocalDate expirationDate = rs.getDate(7).toLocalDate();
				products.add(new Food(Integer.toString(id), name, price, qty, distributorId, discountPercentage, expirationDate));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public static void updateDiscountPercentage(int id, int discountPercentage) {
		Connection DBconnection = DatabaseConnection.getDBconnection();
		PreparedStatement ps;
		try {
			ps = DBconnection.prepareStatement("Update food SET discountPercentage=? WHERE id=?");
			ps.setInt(1, discountPercentage);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateQty(int id, int qty) {
		Connection DBconnection = DatabaseConnection.getDBconnection();
		PreparedStatement ps;
		try {
			ps = DBconnection.prepareStatement("Update food SET qty=? WHERE id=?");
			ps.setInt(1, qty);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
}
