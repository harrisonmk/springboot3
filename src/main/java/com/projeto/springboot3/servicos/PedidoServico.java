
package com.projeto.springboot3.servicos;

import com.projeto.springboot3.modelo.Pedido;
import com.projeto.springboot3.repositorio.PedidoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;



@Service
public class PedidoServico {
    
    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    
    
    @GetMapping
    public List<Pedido> findAll() {

        return pedidoRepositorio.findAll();
    }

    
    
    public Pedido findById(Long id) {

        Optional<Pedido> obj = pedidoRepositorio.findById(id);
        return obj.get();

    }
    
}
