package br.com.triway.service;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.triway.dao.LivroDao;
import br.com.triway.dao.PedidoDao;
import br.com.triway.model.Carrinho;
import br.com.triway.model.Cliente;
import br.com.triway.model.EnumTipoPagamento;
import br.com.triway.model.ItemCarrinho;
import br.com.triway.model.Livro;
import br.com.triway.model.Pedido;

public class CompraService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoDao dao;
	@Inject
	private LivroDao livroDao;

	public ItemCarrinho novoItemCarrinho(int codigo) {
		ItemCarrinho item = null;
		Livro livro = livroDao.consultar(codigo);
		item = new ItemCarrinho();
		item.setLivro(livro);
		// item.setCodigo(codigo);
		return item;
	}

	public boolean efetivarPedido(Cliente cliente, Carrinho car, EnumTipoPagamento pag, String cartao) {

		try {
			Pedido pedido = new Pedido();
			Date dataPedido = new Date(pedido.getDataPedido().getTime());
			pedido.setCliente(cliente);
			pedido.setDataPedido(dataPedido);
			pedido.setItens(car.getItens());
			pedido.setStatus("Pedido Registrado");
			pedido.setValorTotal(car.getValor());
			pedido.setPagamento(pag);
			pedido.setTipoCartao(cartao);
			// PedidoDao dao = new PedidoDao();
			dao.salvar(pedido);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Pedido> localizarPedidosPorCodCliente(int codCliente) {
		/*
		 * PedidoDao dao = null; try{ dao = new PedidoDao(); } catch(Exception
		 * e){ e.printStackTrace(); }
		 */ return dao.listar(codCliente);
	}

	public List<ItemCarrinho> obterItensPorCodPedido(int codPedido) {
		List<ItemCarrinho> itens = null;
		try {
			// PedidoDao dao = new PedidoDao();
			itens = dao.listarItem(codPedido);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return itens;
	}
}
