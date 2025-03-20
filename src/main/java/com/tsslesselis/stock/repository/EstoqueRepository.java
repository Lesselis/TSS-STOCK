package com.tsslesselis.stock.repository;

import com.tsslesselis.stock.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    @Transactional
    void deleteByProdutoId(Long produtoId);
}
