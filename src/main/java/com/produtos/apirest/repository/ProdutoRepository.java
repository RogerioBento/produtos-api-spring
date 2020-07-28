package com.produtos.apirest.repository;

import com.produtos.apirest.dto.ProdutosDto;
import com.produtos.apirest.models.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}