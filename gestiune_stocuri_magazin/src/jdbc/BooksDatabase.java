package jdbc;

import products.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BooksDatabase {
	
	public static void createTable() {
		Connection DBconnection = DatabaseConnection.getDBconnection();
        try {
            Statement stmt = DBconnection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS books" + "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(50), price double, qty int, distributorId int, discountPercentage int, author varchar(30))");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static int insertBook (String name, double price, int qty, int distributorId, int discountPercentage, String author) {
		Connection DBconnection = DatabaseConnection.getDBconnection();
		try {
			PreparedStatement ps = DBconnection.prepareStatement("INSERT INTO books(name, price, qty, distributorId, discountPercentage, author) VALUES(?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setInt(3, qty);
			ps.setInt(4, distributorId);
			ps.setInt(5, discountPercentage);
			ps.setString(6, author);
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
	
	public static void removeBook (int id) {
		Connection DBconnection = DatabaseConnection.getDBconnection();
		try {
			PreparedStatement ps = DBconnection.prepareStatement("DELETE FROM books WHERE id = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Book> getBookProducts(){
		List<Book> products = new ArrayList<>();
		Connection DBconnection = DatabaseConnection.getDBconnection();
		try {
			Statement stmt = DBconnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM books");
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				int qty = rs.getInt(4);
				int distributorId = rs.getInt(5);
				int discountPercentage = rs.getInt(6);
				String author = rs.getString(7);
				products.add(new Book(Integer.toString(id), name, price, qty, distributorId, discountPercentage, author));
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
			ps = DBconnection.prepareStatement("Update books SET discountPercentage=? WHERE id=?");
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
			ps = DBconnection.prepareStatement("Update books SET qty=? WHERE id=?");
			ps.setInt(1, qty);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
}
