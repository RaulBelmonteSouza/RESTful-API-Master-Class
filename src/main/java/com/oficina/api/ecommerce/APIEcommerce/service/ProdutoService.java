package com.oficina.api.ecommerce.APIEcommerce.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.api.ecommerce.APIEcommerce.DTOs.ProdutoDetalhadoDTO;
import com.oficina.api.ecommerce.APIEcommerce.entity.ProdutoEntity;
import com.oficina.api.ecommerce.APIEcommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ProdutoDetalhadoDTO criar(ProdutoDetalhadoDTO produto) {
		ProdutoEntity produtoEntity = produto.toEntity();
		produtoEntity.setDataCadastro(LocalDateTime.now());
		ProdutoEntity produtoSalvo = this.produtoRepository.save(produtoEntity);
		ProdutoDetalhadoDTO produtoSalvoDTO = new ProdutoDetalhadoDTO().toDTO(produtoSalvo);
		return produtoSalvoDTO;
	}
}
