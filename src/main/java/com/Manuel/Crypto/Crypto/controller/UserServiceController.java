package com.Manuel.Crypto.Crypto.controller;


import com.Manuel.Crypto.Crypto.exceptions.RecordNotFoundException;
import com.Manuel.Crypto.Crypto.model.Usuario;


import com.Manuel.Crypto.Crypto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins ="*",maxAge = 3600)

@RequestMapping("/Users")
public class UserServiceController {


    @Autowired
    UserService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        List<Usuario> list = service.getAllUsers();

        return new ResponseEntity<List<Usuario>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id") String id)
            throws RecordNotFoundException {
        Usuario entity = service.getUserById(id);

        return new ResponseEntity<Usuario>(entity, new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/search/{name}")
    public ResponseEntity<List<Usuario>> getUserByName(@PathVariable("name") String name) {
        List<Usuario> list = service.getUserByname(name);

        return new ResponseEntity<List<Usuario>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/search/{cash}")
    public ResponseEntity<List<Usuario>> getUserByCash() {
        List<Usuario> list = service.getUserBycash();

        return new ResponseEntity<List<Usuario>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser(@Valid @RequestBody Usuario myItem){
        Usuario created = service.createUser(myItem);
        return new ResponseEntity<Usuario>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Usuario> UpdateUser(@Valid @RequestBody Usuario myItem)
            throws RecordNotFoundException {
        Usuario updated = service.UpdateUser(myItem);
        return new ResponseEntity<Usuario>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") String id)
            throws RecordNotFoundException {
        service.deleteUserById(id);
        return HttpStatus.ACCEPTED;
    }

}