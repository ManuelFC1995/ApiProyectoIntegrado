package com.Manuel.Crypto.Crypto.services;

import com.Manuel.Crypto.Crypto.exceptions.RecordNotFoundException;
import com.Manuel.Crypto.Crypto.exceptions.RecordNotFoundException1;
import com.Manuel.Crypto.Crypto.model.Pedido;
import com.Manuel.Crypto.Crypto.model.Producto;
import com.Manuel.Crypto.Crypto.model.Usuario;
import com.Manuel.Crypto.Crypto.repositories.PedidoRepository;
import com.Manuel.Crypto.Crypto.repositories.ProductoRepository;
import com.Manuel.Crypto.Crypto.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ProductosService {
    @Autowired

    ProductoRepository repository;


    //devuelve todos los Productos
    public List<Producto> getAllProducto()
    {

        List<Producto> PList = repository.findAll();

        if(PList.size() > 0) {
            return PList;
        } else {
            return new ArrayList<Producto>();
        }
    }


//devuelve un producto por id

    public Producto getProductoById(int id) throws RecordNotFoundException1 {
        Optional<Producto> p = repository.findById(id);

        if(p.isPresent()) {
            return p.get();
        } else {
            throw new RecordNotFoundException1("No item record exist for given id",id);
        }
    }

    //inserta un Producto en la base de datos
    public Producto createProducto(Producto entity){
        entity = repository.save(entity);
        return entity;
    }

    //actualiza un Producto
    public Producto UpdateProducto(Producto entity) throws RecordNotFoundException1
    {

        Optional<Producto> item = repository.findById(entity.getId());

        if(item.isPresent())
        {
            Producto newEntity = item.get();
            //newEntity.setId(entity.getId());
            newEntity.setName(entity.getName());
            newEntity.setDescripcion(entity.getDescripcion());
            newEntity.setPrecio(entity.getPrecio());
            newEntity.setId_pedido(entity.getId_pedido());
            newEntity.setImagene1(entity.getImagene1());
            newEntity.setImagene2(entity.getImagene2());
            newEntity.setImagene3(entity.getImagene3());
            newEntity.setCategoria(entity.getCategoria());
            newEntity.setCategoria3(entity.getCategoria3());
            newEntity.setCategoria2(entity.getCategoria2());
            newEntity.setUnidades(entity.getUnidades());
            newEntity.setDescripcion(entity.getDescripcion());
            newEntity.setVendidos(entity.getVendidos());
            newEntity.setColor(entity.getColor());
            newEntity.setMarca(entity.getMarca());

//alomejor hay que añadir los pedidos
            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            throw new RecordNotFoundException1("Item not found",entity.getId());
        }
    }
    //Borra un Producto por id
    public void deleteProductoById(int id) throws RecordNotFoundException1
    {
        Optional<Producto> item = repository.findById(id);

        if(item.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException1("No item record exist for given id",id);
        }
    }




//Metodo que filtre por categoria??
    }
