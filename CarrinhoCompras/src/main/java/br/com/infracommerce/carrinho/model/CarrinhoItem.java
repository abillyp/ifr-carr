package br.com.infracommerce.carrinho.model;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CarrinhoItem {
	

	private Map<Long, Item> listaCarrinho;// = new LinkedHashMap<Long, Item>();
	
	private BigDecimal valorCarrinho;

	public BigDecimal getTotalCarrinho() {
		return valorCarrinho;
	}

	public void setTotalCarrinho(BigDecimal totalCarrinho) {
		this.valorCarrinho = totalCarrinho;
	}
	
	public Item findById(Long id) {
		return listaCarrinho.containsKey(id) ? listaCarrinho.get(id) : null; 
	}

	
	public CarrinhoItem() {
		super();
		this.valorCarrinho = new BigDecimal(0);
		this.listaCarrinho = new LinkedHashMap<Long, Item>();
	}

	/*
	 * Adiciona um produto ao carrinho
	 * Se jรก existir, somente incrementa a quantidade e valor.
	 */
	public boolean add(Item item) {
		
		boolean ok = true;
		Item itemCarrinho = getItemFromCarrinho(item.getProduto().getId());

		// Se ja existe o item no carrinho, somente atualiza a qtd e valor total do carrinho
		if ( itemCarrinho != null)	{
			this.updateCarrinho(item);
		} 
		else { //novo item no carrinho
			listaCarrinho.put( item.getProduto().getId(), item );
		}
		valorCarrinho = valorCarrinho.add(new BigDecimal( item.getProduto().getValor().doubleValue() * item.getQuantidade().intValue()));
		return ok;
	}
	
	/*
	 * Retorna o total de itens no carrinho de um determinado produto
	 */
	public int getTotalItem(Item item) {

		Long productId = item.getProduto().getId();
		return listaCarrinho.get(productId).getQuantidade();
    }

	/*
	 * Remove um produto do carrinho
	 */
	
	public void delete(Long productId) {
			this.listaCarrinho.remove(productId);
	}

	/*
	 * Atualiza um carrinho
	 */
	public void updateCarrinho(Item item) {
		Long productId = item.getProduto().getId();
		Integer quantity = item.getQuantidade();
		Item itemCarrinho = getItemFromCarrinho(productId);
		itemCarrinho.addQuantidade(quantity);
		Item itemUpdated = new Item(itemCarrinho);
		this.valorCarrinho = valorCarrinho.add(itemCarrinho.getValorTotal());
		listaCarrinho.replace(productId, itemCarrinho, itemUpdated);
	}
	
	
	private Item getItemFromCarrinho(Long productId) {
		Item itemCarrinho = null;
		if (listaCarrinho.containsKey(productId) ) {
			itemCarrinho = listaCarrinho.get(productId);
		}
		return itemCarrinho;
	}
		
	
	public Map<Long, Item> getListaCarrinho() {
		return listaCarrinho;
	}


	public BigDecimal getValorCarrinho() {
		return valorCarrinho;
	}

	public void setValorCarrinho(BigDecimal valorCarrinho) {
		this.valorCarrinho = valorCarrinho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaCarrinho == null) ? 0 : listaCarrinho.hashCode());
		result = prime * result + ((valorCarrinho == null) ? 0 : valorCarrinho.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarrinhoItem other = (CarrinhoItem) obj;
		if (listaCarrinho == null) {
			if (other.listaCarrinho != null)
				return false;
		} else if (!listaCarrinho.equals(other.listaCarrinho))
			return false;
		if (valorCarrinho == null) {
			if (other.valorCarrinho != null)
				return false;
		} else if (!valorCarrinho.equals(other.valorCarrinho))
			return false;
		return true;
	}


	
	
	

}

