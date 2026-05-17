package com.empresa.pedidos_integrado.aplicacion;

import com.empresa.pedidos_integrado.dominio.TipoPedido;
import com.empresa.pedidos_integrado.dominio.puertos.ProcesadorPedido;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProcesadorPedidoFactory {

    private final Map<TipoPedido,
            ProcesadorPedido> procesadores;

    public ProcesadorPedidoFactory(
            List<ProcesadorPedido> lista) {

        this.procesadores =
                lista.stream()
                        .collect(Collectors.toMap(
                                ProcesadorPedido::getTipo,
                                Function.identity()
                        ));
    }

    public ProcesadorPedido obtener(
            TipoPedido tipo) {

        return Optional.ofNullable(
                        procesadores.get(tipo))
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Tipo no soportado"));
    }
}