package com.empresa.pedidos_integrado.dominio.puertos;

import com.empresa.pedidos_integrado.dominio.Pedido;
import com.empresa.pedidos_integrado.dominio.TipoPedido;

public interface ProcesadorPedido {

    TipoPedido getTipo();

    void procesar(Pedido pedido);
}