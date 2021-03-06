package com.Manuel.Crypto.Crypto.repositories;


import com.Manuel.Crypto.Crypto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
    @Repository
    public interface UsuarioRepository
            extends JpaRepository<Usuario,String> {

        @Query(
                value="SELECT * FROM Usuarios AS u WHERE u.name LIKE %?1%",
                nativeQuery=true)
        public List<Usuario> getByName(String title);

        @Query(
                value="SELECT * FROM Usuarios ORDER BY cash",
                nativeQuery=true)
        public List<Usuario> getByCash();

    }

