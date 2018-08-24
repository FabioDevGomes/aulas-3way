package sql;

public enum Sql {
	
	OBTER_POR_ID_SQL("SELECT AUTOR, TITULO, COD_LIVRO, IMAGEM,PRECO, DESCRICAO FROM ESTOQUE WHERE COD_LIVRO = ?"),
	CONSULTAR_SQL("SELECT * FROM ESTOQUE WHERE TITULO LIKE ?"),
	UPDATE_SQL("UPDATE ESTOQUE SET TITULO = ?, AUTOR = ? WHERE COD_LIVRO = ?");
	
	private Sql(String sql) {
		this.sql = sql;
	}
	
	private String sql;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

}
