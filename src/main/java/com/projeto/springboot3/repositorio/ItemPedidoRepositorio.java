
package com.projeto.springboot3.repositorio;

import com.projeto.springboot3.modelo.ItemPedido;
import com.projeto.springboot3.modelo.pk.ItemPedidoPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, ItemPedidoPk> {
    
}
