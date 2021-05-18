package com.Manuel.Crypto.Crypto.services;

import com.Manuel.Crypto.Crypto.exceptions.RecordNotFoundException;
import com.Manuel.Crypto.Crypto.exceptions.RecordNotFoundException1;
import com.Manuel.Crypto.Crypto.model.Pedido;
import com.Manuel.Crypto.Crypto.model.Usuario;
import com.Manuel.Crypto.Crypto.repositories.PedidoRepository;
import com.Manuel.Crypto.Crypto.repositories.UsuarioRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



    @Service
    public class PedidosService {
        @Autowired

        PedidoRepository repository;
UserService uservice;

        //devuelve todos los Pedidos
        public List<Pedido> getAllpedidos()
        {
            List<Pedido> PedidoList = repository.findAll();

            if(PedidoList.size() > 0) {
                return PedidoList;
            } else {
                return new ArrayList<Pedido>();
            }
        }

//devuelve un pedido por id

        public Pedido getPedidoById(int id) throws RecordNotFoundException1 {
            Optional<Pedido> p = repository.findById(id);

            if(p.isPresent()) {
                return p.get();
            } else {
                throw new RecordNotFoundException1("No item record exist for given id",id);
            }
        }

        //inserta un pedido en la base de datos
        public Pedido createPedido(Pedido entity){

            entity = repository.save(entity);
            return entity;
        }

        //actualiza un usuario(name, foto, bio , y publicaciones)
        public Pedido UpdatePedido(Pedido entity) throws RecordNotFoundException1
        {

            Optional<Pedido> item = repository.findById(entity.getId());

            if(item.isPresent())
            {
                Pedido newEntity = item.get();
                //newEntity.setId(entity.getId());
                newEntity.setCompletado(entity.getCompletado());
                newEntity.setFecha_Compra(entity.getFecha_Compra());
                newEntity.setImporte(entity.getImporte());
                newEntity.setComprador(entity.getComprador());
                newEntity.setCalle(entity.getCalle());
                newEntity.setLocalidad(entity.getLocalidad());
                newEntity.setCP(entity.getCP());
                newEntity.setNIF(entity.getNIF());
                newEntity.setPhone(entity.getPhone());
                newEntity.setNumero(entity.getNumero());
                newEntity.setProductos(entity.getProductos());
                newEntity.setPuerta(entity.getPuerta());
                newEntity.setNumero_cuenta(entity.getNumero_cuenta());
                newEntity.setSecreto(entity.getSecreto());
                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException1("Item not found",entity.getId());
            }
        }
        //Borra un usuario por id
        public void deletePedidoById(int id) throws RecordNotFoundException1
        {
            Optional<Pedido> item = repository.findById(id);

            if(item.isPresent())
            {
                repository.deleteById(id);
            } else {
                throw new RecordNotFoundException1("No item record exist for given id",id);
            }
        }

}
