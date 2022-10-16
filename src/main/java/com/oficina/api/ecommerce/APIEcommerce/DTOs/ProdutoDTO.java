package com.oficina.api.ecommerce.APIEcommerce.DTOs;

import com.oficina.api.ecommerce.APIEcommerce.entity.ProdutoEntity;

public class ProdutoDTO {
	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	
	public ProdutoDTO(ProdutoEntity produtoEntity) {
		this.id = produtoEntity.getId();
		this.nome = produtoEntity.getNome();
		this.descricao = produtoEntity.getDescricao();
		this.preco = produtoEntity.getPreco();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getPreco() {
		return preco;
	}
	
	
}
