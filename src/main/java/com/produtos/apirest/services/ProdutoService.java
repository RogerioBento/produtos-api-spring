package com.produtos.apirest.services;

import java.util.List;

import com.produtos.apirest.dto.ProdutosDto;
import com.produtos.apirest.models.Produto;

public interface ProdutoService {
    
    public List<Produto> listaProduto();
    public Produto listaProdutoUnico(long id);
    public void salvaProdutos(ProdutosDto produtos);
    public void deletaProduto(long id);
    public void atualizarProduto(long id, ProdutosDto produtos);
}