package com.conquer.produtoapi.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conquer.conquerutils.dto.ProdutoDto;
import com.conquer.produtoapi.service.ProdutoService;
import com.google.gson.Gson;

@RestController
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping(path = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registrarProduto(@RequestBody ProdutoDto produto, HttpServletRequest request){
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(produto));
		
		if(this.produtoService.registrarProduto(produto)) {
			return ResponseEntity.ok().body(produto);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(produto);
		}
		
	}
	
	@GetMapping(value = "/consultar", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> consultarProduto(@RequestParam("codigo") String codigoProduto){
		
		ProdutoDto produtoDto = this.produtoService.consultarProduto(codigoProduto);
		
		return ResponseEntity.ok().body(produtoDto);
	}
}
