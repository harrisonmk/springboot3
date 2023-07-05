package com.projeto.springboot3.servicos;

import com.projeto.springboot3.modelo.Produto;
import com.projeto.springboot3.repositorio.ProdutoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;
    
    
        @GetMapping
    public List<Produto> findAll() {

        return produtoRepositorio.findAll();
    }

    
    
    public Produto findById(Long id) {

        Optional<Produto> obj = produtoRepositorio.findById(id);
        return obj.get();

    }
    

}
