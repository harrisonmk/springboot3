package com.projeto.springboot3.servicos.excecoes;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Recurso nao encontrado. Id " + id);
    }

}
