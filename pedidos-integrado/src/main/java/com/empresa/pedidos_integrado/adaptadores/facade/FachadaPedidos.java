package com.empresa.pedidos_integrado.adaptadores.facade;

import com.empresa.pedidos_integrado.aplicacion.ProcesadorPedidoFactory;
import com.empresa.pedidos_integrado.dominio.Pedido;
import com.empresa.pedidos_integrado.dominio.puertos.RepositorioPedido;
import com.empresa.pedidos_integrado.eventos.PedidoProcesadoEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class FachadaPedidos {

    private final ProcesadorPedidoFactory factory;
    private final RepositorioPedido repositorio;
    private final ApplicationEventPublisher publisher;

    public FachadaPedidos(
            ProcesadorPedidoFactory factory,
            RepositorioPedido repositorio,
            ApplicationEventPublisher publisher) {

        this.factory = factory;
        this.repositorio = repositorio;
        this.publisher = publisher;
    }

    public Pedido crearPedido(Pedido pedido) {

        factory.obtener(
                        pedido.getTipo())
                .procesar(pedido);

        Pedido guardado =
                repositorio.guardar(pedido);

        publisher.publishEvent(
                new PedidoProcesadoEvent(
                        guardado
                )
        );

        return guardado;
    }
}