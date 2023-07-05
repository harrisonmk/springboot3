
package com.projeto.springboot3.repositorio;

import com.projeto.springboot3.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
    
}
