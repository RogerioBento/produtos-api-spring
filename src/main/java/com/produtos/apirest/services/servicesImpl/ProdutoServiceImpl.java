package com.produtos.apirest.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import com.produtos.apirest.dto.ProdutosDto;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import com.produtos.apirest.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor_ = { @Autowired })
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public void salvaProdutos(ProdutosDto produtos) {
        produtoRepository.save(dtoToModel(produtos));
    }

    @Override
    public List<Produto> listaProduto() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto listaProdutoUnico(long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? produto.get() : null;
    }

    @Override
    public void atualizarProduto(long id, ProdutosDto produtos) {
        Optional<Produto> produtoUpdate = produtoRepository.findById(id);

        produtoUpdate.ifPresent(temp -> {
            temp.setNome(produtos.getNome());
            temp.setQuantidade(produtos.getQuantidade());
            temp.setValor(produtos.getValor());
        });
        if (produtoUpdate.isPresent()) {
            produtoRepository.save(produtoUpdate.get());
        } else {
            throw new IllegalArgumentException();
        }
    }

    private Produto dtoToModel(ProdutosDto produtosDto) {
        return Produto.builder().nome(produtosDto.getNome()).quantidade(produtosDto.getQuantidade())
                .valor(produtosDto.getQuantidade()).build();
    }

    @Override
    public void deletaProduto(long id) {
        produtoRepository.deleteById(id);
    }

}