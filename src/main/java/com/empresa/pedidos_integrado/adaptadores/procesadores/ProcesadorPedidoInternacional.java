package com.empresa.pedidos_integrado.adaptadores.procesadores;


import com.empresa.pedidos_integrado.dominio.*;
import com.empresa.pedidos_integrado.dominio.puertos.ProcesadorPedido;
import org.springframework.stereotype.Component;

@Component
public class ProcesadorPedidoInternacional
        implements ProcesadorPedido {

    @Override
    public TipoPedido getTipo() {
        return TipoPedido.INTERNACIONAL;
    }

    @Override
    public void procesar(Pedido pedido) {

        pedido.setCosto(
                pedido.getSubtotal() * 1.5 + 25
        );

        pedido.setEstado(
                EstadoPedido.PROCESADO
        );
    }
}