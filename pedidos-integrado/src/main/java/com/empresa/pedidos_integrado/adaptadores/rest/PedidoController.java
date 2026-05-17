package com.empresa.pedidos_integrado.adaptadores.rest;

import com.empresa.pedidos_integrado.adaptadores.facade.FachadaPedidos;
import com.empresa.pedidos_integrado.dominio.Pedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final FachadaPedidos fachada;

    public PedidoController(
            FachadaPedidos fachada) {

        this.fachada = fachada;
    }

    @PostMapping
    public ResponseEntity<Pedido> crear(
            @RequestBody Pedido pedido) {

        return ResponseEntity.ok(
                fachada.crearPedido(pedido)
        );
    }
}