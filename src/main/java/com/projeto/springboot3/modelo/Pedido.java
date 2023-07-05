package com.projeto.springboot3.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.springboot3.modelo.enuns.StatusPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;

    private Integer statusPedido;

    @ManyToOne
    @JoinColumn(name = "cliente_id") //entre aspas é o nome da chave estrangeira que vai ligar cliente e pedido
    private Usuario cliente;

    
    
    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();
    
    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL) //entre aspas e o atributo pedido na classe pagamento que faz a relacao
    private Pagamento pagamento;
    
    
    public Pedido(Long id, Instant momento, StatusPedido statusPedido, Usuario cliente) {
        this.id = id;
        this.momento = momento;
        setStatusPedido(statusPedido);
        this.cliente = cliente;
    }

    public Pedido() {
    }

    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }

    public StatusPedido getStatusPedido() {
        return StatusPedido.valueOf(statusPedido);
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        if (statusPedido != null) {
            this.statusPedido = statusPedido.getCodigo();
        }
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    
    public Set<ItemPedido> getItens(){
        
    return itens;    
        
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
    public Double getTotal(){
        
      double soma = 0.0;
      for(ItemPedido x : itens){
          soma = soma + x.getSubTotal();
      }
        return soma;
        
    }
    
    
    
    
    
}
