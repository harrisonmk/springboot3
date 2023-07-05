
package com.projeto.springboot3.servicos;

import com.projeto.springboot3.modelo.Categoria;
import com.projeto.springboot3.repositorio.CategoriaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class CategoriaServico {
    
    
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    
    
    @GetMapping
    public List<Categoria> findAll() {

        return categoriaRepositorio.findAll();
    }

    
    
    public Categoria findById(Long id) {

        Optional<Categoria> obj = categoriaRepositorio.findById(id);
        return obj.get();

    }
    
}
