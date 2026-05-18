package com.empresa.pedidos_integrado.dominio.puertos;

import com.empresa.pedidos_integrado.eventos.PedidoProcesadoEvent;

public interface ServicioNotificacion {

    void notificar(PedidoProcesadoEvent evento);
}