package com.Manuel.Crypto.Crypto.repositories;

import com.Manuel.Crypto.Crypto.model.Pedido;
import com.Manuel.Crypto.Crypto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository
        extends JpaRepository<Pedido,Integer> {

    @Query(
            value = "SELECT * FROM pedidos  ORDER BY Fecha_Compra",
            nativeQuery = true)
    public List<Usuario> getByName(String title);
}