package com.Manuel.Crypto.Crypto.repositories;

import com.Manuel.Crypto.Crypto.model.Pedido;
import com.Manuel.Crypto.Crypto.model.Producto;
import com.Manuel.Crypto.Crypto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto,Integer> {

}
