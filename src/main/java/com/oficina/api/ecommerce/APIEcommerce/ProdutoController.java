package com.oficina.api.ecommerce.APIEcommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficina.api.ecommerce.APIEcommerce.DTOs.ProdutoDetalhadoDTO;
import com.oficina.api.ecommerce.APIEcommerce.service.ProdutoService;

@RestController
@RequestMapping(name = "produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<ProdutoDetalhadoDTO> criaProduto(@RequestBody ProdutoDetalhadoDTO produtoDTO) {
		ProdutoDetalhadoDTO prudutoCriado =  this.produtoService.criar(produtoDTO);
		return ResponseEntity.created(null).body(prudutoCriado);
	}
	
}
