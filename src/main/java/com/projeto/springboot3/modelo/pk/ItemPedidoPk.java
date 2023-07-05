package com.projeto.springboot3.modelo.pk;

import com.projeto.springboot3.modelo.Pedido;
import com.projeto.springboot3.modelo.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

//Classe como se fosse uma tabela de relacionamento com o id do produto e do pedido
@Embeddable //para classe composta
public class ItemPedidoPk implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.pedido);
        hash = 41 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPedidoPk other = (ItemPedidoPk) obj;
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        return Objects.equals(this.produto, other.produto);
    }
    
    
    
}
