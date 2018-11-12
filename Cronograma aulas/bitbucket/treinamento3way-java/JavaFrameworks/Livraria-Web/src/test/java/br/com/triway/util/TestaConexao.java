package br.com.triway.util;

import java.sql.*;

public class TestaConexao {
	
	public static void main(String[] args){
		Connection con;
		try{
			con = FabricaConexao.getConexao();
			if(con!=null){
				System.out.println("Conexão Estabelecida!");
		        con.close();
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
