package db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import business.Stuffy;

public class StuffyDB implements DAO<Stuffy> {
	
	private Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/stuffy?allowPublicKeyRetrieval=true&useSSL=false";
		String username = "stuffy_user";
		String password = "sesame";
		
		Connection connection = DriverManager.getConnection(dbURL, username, password);
		return connection;
	}

	@Override
	public Stuffy get(String code) {

		return null;
	}

	@Override
	public List<Stuffy> getAll() throws SQLException {
		List<Stuffy> stuffies = new ArrayList<Stuffy>();
		Connection connection = getConnection();		
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * from Stuffy");
		while (rs.next()) {
			int id = rs.getInt(1);
			String type = rs.getString(2);
			String color = rs.getString(3);
			String size = rs.getString(4);
			Stuffy stuffy = new Stuffy(id, type, size, color);
			stuffies.add(stuffy);
		}
		rs.close();
		return stuffies;
	}

	@Override
	public boolean add(Stuffy s) throws SQLException {
		boolean success = false;
		Connection connection = getConnection();
		
		String query = "insert into stuffy" +
				"(type, color, size)" +
				"values ('" + s.getType() + "', '" + 
				s.getColor() + "', '" + s.getSize() + "')";
		
		Statement statement = connection.createStatement();
		int rowCount = statement.executeUpdate(query);
		
		if (rowCount > 0) {
			success = true;
		}
		
		return success;
	}

	@Override
	public boolean update(Stuffy s) {
		Connection connection = getConnection();
		
		// String query = 
		
		
		return false;
	}
	
	@Override
	public boolean delete(Stuffy s) throws SQLException {
		Connection connection = getConnection();
		String query = "DELETE from Stuffy WHERE ID = " + s.getId();
		Statement statement = connection.createStatement();
		int rowCount = statement.executeUpdate(query);
		boolean success = false;
		
		if (rowCount > 0) {
			success = true;
		}
		return success;
	}

}
