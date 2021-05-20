package com.Manuel.Crypto.Crypto.controller;


import com.Manuel.Crypto.Crypto.exceptions.RecordNotFoundException;
import com.Manuel.Crypto.Crypto.exceptions.RecordNotFoundException1;
import com.Manuel.Crypto.Crypto.model.Pedido;
import com.Manuel.Crypto.Crypto.model.Usuario;
import com.Manuel.Crypto.Crypto.services.PedidosService;
import com.Manuel.Crypto.Crypto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins ="*",maxAge = 3600)
@RequestMapping("/Pedidos")
public class PedidosServiceController {


    @Autowired
    PedidosService service;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> list = service.getAllpedidos();


        return new ResponseEntity<List<Pedido>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") int id)
            throws RecordNotFoundException1 {
        Pedido entity = service.getPedidoById(id);

        return new ResponseEntity<Pedido>(entity, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Pedido> createPedido(@Valid @RequestBody Pedido myItem) {
        Pedido created = service.createPedido(myItem);
        return new ResponseEntity<Pedido>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Pedido> UpdatePedido(@Valid @RequestBody Pedido myItem)
            throws RecordNotFoundException1 {
        Pedido updated = service.UpdatePedido(myItem);
        return new ResponseEntity<Pedido>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePedidoById(@PathVariable("id") int id)
            throws RecordNotFoundException1 {
        service.deletePedidoById(id);
        return HttpStatus.ACCEPTED;
    }
}

