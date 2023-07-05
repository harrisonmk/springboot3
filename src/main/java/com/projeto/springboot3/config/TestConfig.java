package com.projeto.springboot3.config;

import com.projeto.springboot3.modelo.Categoria;
import com.projeto.springboot3.modelo.ItemPedido;
import com.projeto.springboot3.modelo.Pagamento;
import com.projeto.springboot3.modelo.Pedido;
import com.projeto.springboot3.modelo.Produto;
import com.projeto.springboot3.modelo.Usuario;
import com.projeto.springboot3.modelo.enuns.StatusPedido;
import com.projeto.springboot3.repositorio.CategoriaRepositorio;
import com.projeto.springboot3.repositorio.ItemPedidoRepositorio;
import com.projeto.springboot3.repositorio.PedidoRepositorio;
import com.projeto.springboot3.repositorio.ProdutoRepositorio;
import com.projeto.springboot3.repositorio.UsuarioRepositorio;
import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;
    
    
    @Autowired
    private ItemPedidoRepositorio itemPedidoRepositorio;
    

    //Quando o programa rodar esse metodo vai ser executado
    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Eletronicos");
        Categoria cat2 = new Categoria(null, "Livros");
        Categoria cat3 = new Categoria(null, "Computadores");

        Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2, cat3));

        produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategorias().add(cat2);
        p2.getCategorias().add(cat1);
        p2.getCategorias().add(cat3);
        p3.getCategorias().add(cat3);
        p4.getCategorias().add(cat3);
        p5.getCategorias().add(cat2);

        produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, u1);
        Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.ESPERANDO_PAGAMENTO, u2);
        Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.ESPERANDO_PAGAMENTO, u1);

        usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
        pedidoRepositorio.saveAll(Arrays.asList(o1, o2, o3));
        
        
        ItemPedido oi1 = new ItemPedido(o1, p1, 2, p1.getPreco());
        ItemPedido oi2 = new ItemPedido(o1, p3, 1, p3.getPreco());
        ItemPedido oi3 = new ItemPedido(o2, p3, 2, p3.getPreco());
        ItemPedido oi4 = new ItemPedido(o3, p5, 2, p5.getPreco());
        
        
        itemPedidoRepositorio.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
        
        
        
        Pagamento pay1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
	o1.setPagamento(pay1);

        pedidoRepositorio.save(o1);

    }

}
