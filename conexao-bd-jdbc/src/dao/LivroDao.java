package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import model.Livro;
import sql.Sql;
import util.FabricaConexao;

public class LivroDao {
	Logger LOG = Logger.getGlobal();

//	private static final String OBTER_POR_ID_SQL = "SELECT AUTOR, TITULO, COD_LIVRO, IMAGEM,PRECO, DESCRICAO FROM ESTOQUE WHERE COD_LIVRO = ?";
//	private static final String CONSULTAR_SQL = "SELECT COD_LIVRO, TITULO, AUTOR, PRECO, IMAGEM, DESCRICAO FROM ESTOQUE WHERE TITULO LIKE ?";
//	private static final String CONSULTAR_SQL = "SELECT * FROM ESTOQUE WHERE TITULO LIKE ?";
//	private static final String UPDATE_SQL = "UPDATE ESTOQUE SET TITULO = ?, AUTOR = ? WHERE COD_LIVRO = ?";

	public Livro consultar(int codigo) {
		Livro livro = null;
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(Sql.OBTER_POR_ID_SQL.getSql());) {
			consulta.setInt(1, codigo);

			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {
				livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
			}

			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.severe(e.toString());
		}
		return livro;
	}

	public List<Livro> consultar(String titulo) {
		ArrayList<Livro> lista = new ArrayList<Livro>();
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(Sql.CONSULTAR_SQL.getSql());) {
			consulta.setString(1, "%" + titulo.toUpperCase() + "%");

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {
				Livro livro = new Livro();
				livro.setAutor(resultado.getString("AUTOR"));
				livro.setCodigo(resultado.getInt("COD_LIVRO"));
				livro.setImagem(resultado.getString("IMAGEM"));
				livro.setPreco(resultado.getDouble("PRECO"));
				livro.setTitulo(resultado.getString("TITULO"));
				livro.setDescricao(resultado.getString("DESCRICAO"));
				lista.add(livro);
			}

			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.severe(e.toString());
		}
		return lista;
	}

	public void updateTitulo(Livro livro) {

		// String sql = "UPDATE ESTOQUE SET TITULO = ?, AUTOR = ? " + " WHERE COD_LIVRO
		// = ?";

		// Cria uma conexão com o banco
		// Cria um PreparedStatment, classe usada para executar a query

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(Sql.UPDATE_SQL.getSql());) {

			// Adiciona o valor do primeiro parâmetro da sql
			consulta.setString(1, livro.getTitulo());
			// Adicionar o valor do segundo parâmetro da sql
			consulta.setString(2, livro.getAutor());

			consulta.setInt(3, livro.getCodigo());

			// Executa a sql para inserção dos dados
			consulta.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

//		finally {
//
//			// Fecha as conexões
//			try {
//				if (consulta != null) {
//					consulta.close();
//				}
//
//				if (conexao != null) {
//					conexao.close();
//				}
//
//			} catch (Exception e) {
//
//				e.printStackTrace();
//			}
//		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM ESTOQUE WHERE COD_LIVRO = ?";

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(sql);){

			consulta.setInt(1, id);

			consulta.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
