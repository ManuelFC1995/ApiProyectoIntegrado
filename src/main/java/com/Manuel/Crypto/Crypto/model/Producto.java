package com.Manuel.Crypto.Crypto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected int Id;
    @Column(name = "name", length = 30)
    private String name;
    @Column(name = "id_producto", length = 30)
    private int id_producto;
    @Column(name = "talla", length = 30)
    private String talla;
    @Column(name = "descripcion", length = 80)
    private String descripcion;
    @Column(name = "Categoria", length = 80)
    private String Categoria;

    @Column(name = "Marca", length = 80)
    private String Marca;
    @Column(name = "Color")
    private String Color;

    @Column(name = "Sexo")
    private Boolean Sexo;
    @Column(name = "Precio", length = 30)
    private float Precio;
    @Column(name = "Uds", length = 30)
    private float Unidades;
    @Column(name = "vendidos", length = 30)
    private int vendidos;
    @Column(name = "Imagen1", length = 30)
    protected String imagene1;
    @Column(name = "Imagen2", length = 30)
    protected String imagene2;
    @Column(name = "Imagen3", length = 30)
    protected String imagene3;




    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
    @JsonIgnoreProperties(value = {"Productos"},allowSetters = true)
    @JoinColumn(name="comprador")
    protected List<Pedido> id_pedido;




    public Producto(String name, String descripcion, int precio, String imagene1, String imagene2, String imagene3) {
        this.name = name;
        this.descripcion = descripcion;
        Precio = precio;
        this.imagene1 = imagene1;
        this.imagene2 = imagene2;
        this.imagene3 = imagene3;

    }


    public Producto() {

    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public Boolean getSexo() {
        return Sexo;
    }

    public void setSexo(Boolean sexo) {
        Sexo = sexo;
    }
    @JsonIgnore
    public List<Pedido> getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(List<Pedido> id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public String getImagene1() {
        return imagene1;
    }

    public void setImagene1(String imagene1) {
        this.imagene1 = imagene1;
    }

    public String getImagene2() {
        return imagene2;
    }

    public void setImagene2(String imagene2) {
        this.imagene2 = imagene2;
    }

    public String getImagene3() {
        return imagene3;
    }

    public void setImagene3(String imagene3) {
        this.imagene3 = imagene3;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public float getUnidades() {
        return Unidades;
    }

    public void setUnidades(float unidades) {
        Unidades = unidades;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setVendidos(int vendidos) {
        vendidos = vendidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Id == producto.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", Precio=" + Precio +
                ", imagene1='" + imagene1 + '\'' +
                ", imagene2='" + imagene2 + '\'' +
                ", imagene3='" + imagene3 + '\'' +
                ", id_pedido=" + id_pedido +
                '}';
    }
}