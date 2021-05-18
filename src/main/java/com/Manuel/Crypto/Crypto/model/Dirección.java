package com.Manuel.Crypto.Crypto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Direccion")
public class Dirección {
    @Id
    private String id;
    @Column(name="Ciudad", length=30)
    private String Ciudad;
    @Column(name="Localidad", length=30)
    private String Localidad;
    @Column(name="CP", length=30)
    private int CP;
    @Column(name="Calle", length=30)
    private String Calle;
    @Column(name="Numero", length=30)
    private int Numero;
    @Column(name="Puerta", length=30)
    private String Puerta;

}
