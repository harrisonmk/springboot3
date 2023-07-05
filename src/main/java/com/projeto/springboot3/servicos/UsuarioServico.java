package com.projeto.springboot3.servicos;

import com.projeto.springboot3.modelo.Usuario;
import com.projeto.springboot3.repositorio.UsuarioRepositorio;
import com.projeto.springboot3.servicos.excecoes.DatabaseException;
import com.projeto.springboot3.servicos.excecoes.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> findAll() {

        return usuarioRepositorio.findAll();
    }

    public Usuario findById(Long id) {

        Optional<Usuario> obj = usuarioRepositorio.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public Usuario insert(Usuario usuario) {

        return usuarioRepositorio.save(usuario);

    }

   public void delete(Long id) {
        try {
            usuarioRepositorio.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Usuario update(Long id, Usuario usuario) {
        try {
            Usuario entity = usuarioRepositorio.getReferenceById(id);
            updateData(entity, usuario);
            return usuarioRepositorio.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }      

    private void updateData(Usuario entity, Usuario obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setTelefone(obj.getTelefone());
    }
    
    
    

}
