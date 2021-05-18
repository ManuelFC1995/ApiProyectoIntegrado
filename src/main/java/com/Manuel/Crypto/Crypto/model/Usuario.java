package com.Manuel.Crypto.Crypto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="usuarios")

public class Usuario {
    @Id
    private String id;

    @Column(name="Email", length=30)
    private String Email;
    @Column(name="direccion", length=30)
    private String Ultima_Direccion;
    @Column(name="name", length=30)
    private String name;
    @Column(name="surname", length=30)
    private String surname;
    @Column(name="phone", length=30)
    private String phone;


    @JsonIgnoreProperties(value = {"comprador"},allowSetters = true)
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "comprador", cascade = {CascadeType.MERGE})
    private List<Pedido> Pedidos ;

    public Usuario() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pedido> getPedidos() {
        return Pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        Pedidos = pedidos;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", Email='" + Email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", Pedidos=" + Pedidos +
                '}';
    }
}