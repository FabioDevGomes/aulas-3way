package br.com.triway.util;

import java.sql.*;

public class FabricaConexao {
	static String url = "jdbc:postgresql://localhost:5432/livraria";
	static String usuario = "postgres";
	static String senha = "postgres";
 	
	public static Connection getConexao() throws SQLException{
		try{
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url,usuario,senha);
		} catch(ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}
	}

}
