package br.com.infracommerce.carrinho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.infracommerce.carrinho.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	

}