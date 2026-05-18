package com.empresa.pedidos_integrado.adaptadores.procesadores;

import com.empresa.pedidos_integrado.dominio.*;
import com.empresa.pedidos_integrado.dominio.puertos.ProcesadorPedido;
import org.springframework.stereotype.Component;

@Component
public class ProcesadorPedidoEstandar
        implements ProcesadorPedido {

    @Override
    public TipoPedido getTipo() {
        return TipoPedido.ESTANDAR;
    }

    @Override
    public void procesar(Pedido pedido) {

        pedido.setCosto(
                pedido.getSubtotal() * 1.1
        );

        pedido.setEstado(
                EstadoPedido.PROCESADO
        );
    }
}