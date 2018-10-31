package br.com.infracommerce.carrinho.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.com.infracommerce.carrinho.model.Produto;
import br.com.infracommerce.carrinho.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto atualizar(Long code, Produto prod ) {
		Produto produtoSaved = findByCode(code);

		BeanUtils.copyProperties(prod, produtoSaved, "id");
		return produtoRepository.save(produtoSaved);
	}
	
	public Produto findByCode(Long code) {
		Produto productSaved = produtoRepository.findOne(code);
		if (productSaved == null)
			throw new EmptyResultDataAccessException(1);
		return productSaved;
	}
	
	public Produto save(Produto product) {
		if (product.getId() != null && produtoRepository.exists(product.getId())) {
			throw new EntityExistsException("Já existe este produto na base de dados.");
		}
		return produtoRepository.save(product);
	}
	
	public Produto update(Produto product) {
		if (product.getId() != null && !produtoRepository.exists(product.getId())) {
			throw new EntityNotFoundException("Não existe produto com este código na base de dados.");
		}

		return produtoRepository.save(product);
	}

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto findOne(Long id) {
		return produtoRepository.findOne(id);
	}

	public void delete(Long id) {
		produtoRepository.delete(id);
	}	
	
	
	
}
