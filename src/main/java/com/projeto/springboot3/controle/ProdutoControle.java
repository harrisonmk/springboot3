package com.projeto.springboot3.controle;

import com.projeto.springboot3.modelo.Produto;
import com.projeto.springboot3.servicos.ProdutoServico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoControle {

    @Autowired
    private ProdutoServico produtoServico;

    
    
    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {

        List<Produto> lista = produtoServico.findAll();

        return ResponseEntity.ok().body(lista);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {

        Produto obj = produtoServico.findById(id);
        return ResponseEntity.ok().body(obj);

    }
    
    
    

}
