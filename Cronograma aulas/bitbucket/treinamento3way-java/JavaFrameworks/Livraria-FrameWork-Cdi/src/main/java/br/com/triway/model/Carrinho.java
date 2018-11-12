package br.com.triway.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrinho implements Serializable {

	private List<ItemCarrinho> itens = new ArrayList<ItemCarrinho>();
	
	public void adicionar(ItemCarrinho item){
		for(ItemCarrinho itm : itens){
			if(itm.equals(item)){
				itm.setQtd(itm.getQtd()+1);
				return;
			}
		}
		itens.add(item);
	}
	
	public void subtrair(ItemCarrinho item){
		for(ItemCarrinho itm : itens){
			if(itm.getQtd() == 1){
				return;
			}
			else if(itm.equals(item)){
				itm.setQtd(itm.getQtd()-1);
				return;
			}
			
		}
		itens.remove(item);
	}
	
	private ItemCarrinho get(int codigo){
		return itens.stream().filter(e->e.getLivro().getCodigo()==codigo).findFirst().get();
	}
	
	public void adicionar(int codItem){
		adicionar(get(codItem));
	}
	
	public void subtrair(int codItem){
		subtrair(get(codItem));
	}
	
	
	
	public boolean isEmptyCarrinho(){
		if(itens.size()==0)
			return true;
		else
			return false;
	}
	
	public double getValor(){
		double result = 0;
		for(ItemCarrinho item:itens){
			result += item.getValor();
		}
		return result;
	}
	
	public void remover(ItemCarrinho item){
		itens.remove(item);
	}
	
	public void remover(int codigo){
		remover(get(codigo));
	}
	
	
	public List<ItemCarrinho> getItens(){
		return itens;
	}
	
	public void setItens(List<ItemCarrinho> itens){
		this.itens = itens;
	}
}
