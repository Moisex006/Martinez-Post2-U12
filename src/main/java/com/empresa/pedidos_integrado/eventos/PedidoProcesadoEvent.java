package com.empresa.pedidos_integrado.eventos;

import com.empresa.pedidos_integrado.dominio.Pedido;

public record PedidoProcesadoEvent(
        Pedido pedido) {
}