package com.empresa.pedidos_integrado.infraestructura.persistencia;
import com.empresa.pedidos_integrado.infraestructura.persistencia.RepositorioPedidosJpa;
import com.empresa.pedidos_integrado.dominio.Pedido;
import com.empresa.pedidos_integrado.dominio.puertos.RepositorioPedido;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RepositorioPedidosJpa
        implements RepositorioPedido {

    @Override
    public Pedido guardar(Pedido pedido) {

        pedido.setId(1L);

        return pedido;
    }

    @Override
    public Optional<Pedido> buscarPorId(Long id) {

        return Optional.empty();
    }
}