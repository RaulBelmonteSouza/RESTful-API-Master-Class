package com.oficina.api.ecommerce.APIEcommerce.DTOs;

import java.time.LocalDateTime;

import com.oficina.api.ecommerce.APIEcommerce.entity.ProdutoEntity;

public class ProdutoDetalhadoDTO {

	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private String quantidadeEstoque;
	private Boolean ativo;
	private LocalDateTime dataCadastro;
	
	public ProdutoDetalhadoDTO(Long id, String nome, String descricao, Double preco, String quantidadeEstoque,
			Boolean ativo, LocalDateTime dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
	}

	public ProdutoDetalhadoDTO(String nome, String descricao, Double preco, String quantidadeEstoque,
			Boolean ativo) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidadeEstoque = quantidadeEstoque;
		this.ativo = ativo;
	}
	
	public ProdutoDetalhadoDTO() {}
	
	public ProdutoEntity toEntity() {
		return new ProdutoEntity(nome, descricao, preco, quantidadeEstoque, ativo, dataCadastro);
	}
	
	public ProdutoDetalhadoDTO toDTO(ProdutoEntity produtoEntity) {
		return new ProdutoDetalhadoDTO(produtoEntity.getId(),
				produtoEntity.getNome(),
				produtoEntity.getDescricao(),
				produtoEntity.getPreco(),
				produtoEntity.getQuantidadeEstoque(),
				produtoEntity.getAtivo(),
				produtoEntity.getDataCadastro());
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

	public String getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	
}
