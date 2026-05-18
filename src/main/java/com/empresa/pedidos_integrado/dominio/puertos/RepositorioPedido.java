package com.empresa.pedidos_integrado.dominio.puertos;

import com.empresa.pedidos_integrado.dominio.Pedido;

import java.util.Optional;

public interface RepositorioPedido {

    Pedido guardar(Pedido pedido);

    Optional<Pedido> buscarPorId(Long id);
}