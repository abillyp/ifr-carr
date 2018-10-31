package br.com.infracommerce.carrinho.model;

import java.math.BigDecimal;

public class Item {


	private Produto produto;
	
	private Integer quantidade;
	
	private BigDecimal valorTotal;

	

	public Item() {
		this(new Produto(), new Integer(1), new BigDecimal(1));
	}

	public Item(Produto produto, Integer quantidade, BigDecimal valorTotal) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
	}

	/*
	 * Copy constructor 
	 */
	  
	Item(Item item) { 
        this.produto = item.getProduto(); 
        this.quantidade = item.getQuantidade();
        this.valorTotal = item.getValorTotal();
    }



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
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
		Item other = (Item) obj;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		return true;
	}




	public Produto getProduto() {
		return produto;
	}




	public void setProduto(Produto produto) {
		this.produto = produto;
	}




	public Integer getQuantidade() {
		return quantidade;
	}




	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}



	public BigDecimal getValorTotal() {
		return valorTotal;
	}




	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}




	public void addQuantidade(Integer qtd) {
		quantidade = new Integer(quantidade.intValue() +qtd.intValue());
		this.valorTotal = new BigDecimal(produto.getValor().doubleValue() *quantidade.intValue());
	}
	
	
}

