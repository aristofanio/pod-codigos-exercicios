package pod.q1.node4.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pod.q1.node4.JdbcConnect;

public class JdbcConnectImpl implements JdbcConnect {
	
	protected Connection connection(){
		try {
			Class.forName(DriverManager.class.getName());
			return DriverManager.getConnection("jdbc:postgresql://192.168.99.100:5432/db2q1", "postgres", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String query(String params) {
		Connection conn  = connection();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from tbnode2");
			if (rs.next()) {
				String name = rs.getString("name");
				return name;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

}
