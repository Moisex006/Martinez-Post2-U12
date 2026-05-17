package com.empresa.pedidos_integrado.infraestructura.notificaciones;


import com.empresa.pedidos_integrado.dominio.puertos.ServicioNotificacion;
import com.empresa.pedidos_integrado.eventos.PedidoProcesadoEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacionEmail
        implements ServicioNotificacion {

    @EventListener
    @Override
    public void notificar(
            PedidoProcesadoEvent evento) {

        System.out.println(
                "Email enviado para pedido "
                        + evento.pedido().getId()
        );
    }
}