package com.conquer.produtoapi.service;

import org.springframework.stereotype.Service;
import com.conquer.conquerutils.dto.ProdutoDto;

@Service
public class ProdutoService {

	public boolean registrarProduto(ProdutoDto produto) {
//		Aqui ficará uma chamada para a consultaCurso da api de Cursos, para verificar se o curso existe na base
//		Logo em seguida haverá uma classe de negócio que validará os dados informados e subsequentemente efetuará a inclusão através da persistência

		return true;
		
	}
	
	public ProdutoDto consultarProduto(String codigoProduto) {
		ProdutoDto produtoDto = new ProdutoDto();
//		Aqui ficará a chamada à classe de negócio ou persistência necessária para buscar o produto na base de dados
		
		return produtoDto;
	}
}
