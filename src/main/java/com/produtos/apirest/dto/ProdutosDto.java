package com.produtos.apirest.dto;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutosDto {
    
    private long id;

    private String nome;

    private BigDecimal quantidade;

    private BigDecimal valor;
}