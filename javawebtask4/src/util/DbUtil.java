package util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Book;

public class DbUtil {

	public Connection connection = null;
	public PreparedStatement statement = null;
	public ResultSet resultSet = null;

	public Connection getConnection() {
		String classdriver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "123456";
		String dburl = "jdbc:mysql://localhost:3306/library?characterEncoding=utf8";

		try {
			Class.forName(classdriver);
			connection = DriverManager.getConnection(dburl, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void releaseConnetion() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void execSqlWithoutReturn(String sql, Object... args) {
		try {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
				statement.setObject(i+1, args[i]);
				
			}
			System.out.println(statement);
			statement.executeUpdate();
			releaseConnetion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Object> execSqlWithVaryReturn(String sql, Object... args) {
		List list = new ArrayList<Object>();
		try {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				statement.setObject(i+1, args[i]);
			}
			resultSet = statement.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String author = resultSet.getString(3);
				String publisher = resultSet.getString(4);
				Date publishdate = resultSet.getDate(5);
				float price = resultSet.getFloat(6);
				list.add(new Book(id, name, author, publisher, publishdate,
						price));
			}

			releaseConnetion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public Object execSqlWithSingleReturn(String sql, Object... args) {
		Book book = new Book();
		try {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				statement.setObject(1, args[i]);
			}
			System.out.println(statement);
			resultSet = statement.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String author = resultSet.getString(3);
				String publisher = resultSet.getString(4);
				Date publishdate = resultSet.getDate(5);
				float price = resultSet.getFloat(6);

				book = new Book(id, name, author, publisher, publishdate, price);
			}

			releaseConnetion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
}
