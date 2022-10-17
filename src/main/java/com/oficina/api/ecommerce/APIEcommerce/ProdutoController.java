package com.oficina.api.ecommerce.APIEcommerce;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oficina.api.ecommerce.APIEcommerce.DTOs.ProdutoDTO;
import com.oficina.api.ecommerce.APIEcommerce.DTOs.ProdutoDetalhadoDTO;
import com.oficina.api.ecommerce.APIEcommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<ProdutoDetalhadoDTO> criaProduto(@RequestBody ProdutoDetalhadoDTO produtoDTO) {
		ProdutoDetalhadoDTO prudutoCriado =  this.produtoService.criar(produtoDTO);
		return ResponseEntity.created(null).body(prudutoCriado);
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> listar() {
		List<ProdutoDTO> listaDeProdutos = this.produtoService.listar();
		return ResponseEntity.ok(listaDeProdutos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDetalhadoDTO> buscar(@PathVariable("id") Long id) {
		try {
			ProdutoDetalhadoDTO produtoDTO = this.produtoService.buscar(id);
			return ResponseEntity.ok(produtoDTO);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
