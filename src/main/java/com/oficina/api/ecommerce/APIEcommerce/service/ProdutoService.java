package com.oficina.api.ecommerce.APIEcommerce.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.api.ecommerce.APIEcommerce.DTOs.ProdutoDTO;
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
	
	public List<ProdutoDTO> listar() {
		List<ProdutoEntity> listaDeProdutos = produtoRepository.findAll();
		List<ProdutoDTO> listaDeProdutosDTO = listaDeProdutos
			.stream()
			.map(produto -> new ProdutoDTO(produto))
			.collect(Collectors.toList());
		
		return listaDeProdutosDTO;
	}
	
	public ProdutoDetalhadoDTO buscar(Long id) {
		ProdutoEntity produto = produtoRepository.findById(id).get();
		ProdutoDetalhadoDTO produtoDetalhadoDTO = new ProdutoDetalhadoDTO().toDTO(produto);
		return produtoDetalhadoDTO;
	}
	
	public void deletar(Long id) {
		ProdutoEntity produto = produtoRepository.findById(id).get();
		produtoRepository.delete(produto);
	}
	
	public ProdutoDetalhadoDTO atualizar(ProdutoDetalhadoDTO produtoDetalhadoDTO, Long id) {
		ProdutoEntity produtoEntity = produtoRepository.findById(id).get();
		ProdutoEntity produtoParaAtualizar = produtoDetalhadoDTO.toEntity();
		produtoParaAtualizar.setId(id);
		produtoParaAtualizar.setDataCadastro(produtoEntity.getDataCadastro());
		ProdutoEntity produtoAtualizado = produtoRepository.save(produtoParaAtualizar);
		produtoDetalhadoDTO = new ProdutoDetalhadoDTO().toDTO(produtoAtualizado);
		return produtoDetalhadoDTO;
	}
}
