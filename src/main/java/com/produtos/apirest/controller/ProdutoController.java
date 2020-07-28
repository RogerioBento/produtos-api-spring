package com.produtos.apirest.controller;

import java.util.List;

import com.produtos.apirest.dto.ProdutosDto;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping(value = "/api")
public class ProdutoController {

    private final ProdutoService produtosService;

    @GetMapping(value = "/produtos")
    public List<Produto> listaProduto() {
        return produtosService.listaProduto();
    }

    @GetMapping(value = "/produtos/{id}")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
        return produtosService.listaProdutoUnico(id);
    }

    @PostMapping(value = "/produtos")
    public void salvaProdutos(@RequestBody ProdutosDto produtos) {
        produtosService.salvaProdutos(produtos);
    }

    @DeleteMapping(value = "/produtos/{id}")
    public void deletaProduto(@PathVariable(value = "id") long id) {
        produtosService.deletaProduto(id);
    }

    @PutMapping(value = "/produtos/{id}")
    public void updateProduto(@PathVariable(value = "id") long id, @RequestBody ProdutosDto produtos) {
        produtosService.atualizarProduto(id, produtos);
    }
}