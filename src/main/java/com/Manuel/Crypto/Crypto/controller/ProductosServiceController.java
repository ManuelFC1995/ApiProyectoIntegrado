package com.Manuel.Crypto.Crypto.controller;

import com.Manuel.Crypto.Crypto.exceptions.RecordNotFoundException;
import com.Manuel.Crypto.Crypto.exceptions.RecordNotFoundException1;
import com.Manuel.Crypto.Crypto.model.Producto;
import com.Manuel.Crypto.Crypto.model.Usuario;
import com.Manuel.Crypto.Crypto.services.ProductosService;
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
@RequestMapping("/Productos")
public class ProductosServiceController {


    @Autowired
    ProductosService service;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducts() {
        List<Producto> list = service.getAllProducto();

        return new ResponseEntity<List<Producto>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductById(@PathVariable("id") int id)
            throws RecordNotFoundException1 {
        Producto entity = service.getProductoById(id);

        return new ResponseEntity<Producto>(entity, new HttpHeaders(), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Producto> CreateProduct(@Valid @RequestBody Producto myItem){
        Producto created = service.createProducto(myItem);
        return new ResponseEntity<Producto>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Producto> UpdateProducto(@Valid @RequestBody Producto myItem)
            throws RecordNotFoundException1 {
        Producto updated = service.UpdateProducto(myItem);
        return new ResponseEntity<Producto>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteProductoById(@PathVariable("id") int id)
            throws RecordNotFoundException1 {
        service.deleteProductoById(id);
        return HttpStatus.ACCEPTED;
    }

}