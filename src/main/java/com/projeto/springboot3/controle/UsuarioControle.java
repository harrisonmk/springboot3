package com.projeto.springboot3.controle;

import com.projeto.springboot3.modelo.Usuario;
import com.projeto.springboot3.servicos.UsuarioServico;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UsuarioControle {

    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {

        List<Usuario> lista = usuarioServico.findAll();

        return ResponseEntity.ok().body(lista);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {

        Usuario obj = usuarioServico.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {
        usuario = usuarioServico.insert(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(usuario); //retorna 201 que é de criacao (created) com o corpo do objeto
    }

    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        usuarioServico.delete(id);
        return ResponseEntity.noContent().build(); //retorna o codigo 204 sem corpo que é da exclusao
    }

    
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario = usuarioServico.update(id, usuario);
        return ResponseEntity.ok().body(usuario); //retorna o status 200 ok com o corpo do objeto
    }
    
    

}
