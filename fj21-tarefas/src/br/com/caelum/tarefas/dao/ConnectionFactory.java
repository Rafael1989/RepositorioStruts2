package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21?useTimezone=true&serverTimezone=UTC","root","root");
		}catch(SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
