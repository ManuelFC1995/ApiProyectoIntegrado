package com.Manuel.Crypto.Crypto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "Importe", length = 30)
    private float Importe;

    @Column(name = "Fecha_Compra")
    private Date Fecha_Compra;

    @Column(name = "Completado")
    private Boolean completado;

    @Column(name = "NIF")
    private String NIF;
    @Column(name = "codigo_comprador")
    private String Codigo_Comprador;
    @Column(name = "email")
    private String Email;

    @Column(name = "Localidad")
    private String Localidad;

    @Column(name = "Provincia")
    private String Provincia;

    @Column(name = "CP")
    private String CP;

    @Column(name = "Calle")
    private String Calle;

    @Column(name = "numero")
    private int numero;

    @Column(name = "puerta")
    private String puerta;

    @Column(name="phone", length=30)
    private int phone;

    @Column(name="secreto", length=30)
    private String secreto;

    @Column(name="numero_cuenta", length=30)
    private String numero_cuenta;

    @Column(name="metodoPago", length=30)
    private String metedoPago;
    @Column(name="nombre_comprador", length=30)
    private String nombre_comprador;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name="id_comprador")
    @JsonIgnoreProperties(value = {"Pedidos"},allowSetters = true)
    protected Usuario comprador;

    @JsonIgnoreProperties(value = {"id_pedido"},allowSetters = true)
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name="id_pedido")
    private List<Producto> Productos ;

    public Pedido(int importe, Date fecha_Compra, Usuario comprador) {
        Importe = importe;
        Fecha_Compra = fecha_Compra;
        this.comprador = comprador;
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getImporte() {
        return Importe;
    }

    public Boolean getCompletado() {
        return completado;
    }

    public void setCompletado(Boolean completado) {
        this.completado = completado;
    }


    public void setImporte(float importe) {
        Importe = importe;
    }

    public Date getFecha_Compra() {
        return Fecha_Compra;
    }

    public void setFecha_Compra(Date fecha_Compra) {
        Fecha_Compra = fecha_Compra;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public List<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(List<Producto> productos) {
        Productos = productos;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String calle) {
        Calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNombre_comprador() {
        return nombre_comprador;
    }

    public void setNombre_comprador(String nombre_comprador) {
        this.nombre_comprador = nombre_comprador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id == pedido.id && Float.compare(pedido.Importe, Importe) == 0 && Objects.equals(Fecha_Compra, pedido.Fecha_Compra) && Objects.equals(completado, pedido.completado) && Objects.equals(NIF, pedido.NIF) && Objects.equals(Localidad, pedido.Localidad) && Objects.equals(Provincia, pedido.Provincia) && Objects.equals(CP, pedido.CP) && Objects.equals(Calle, pedido.Calle) && Objects.equals(numero, pedido.numero) && Objects.equals(puerta, pedido.puerta) && Objects.equals(phone, pedido.phone) && Objects.equals(comprador, pedido.comprador) && Objects.equals(Productos, pedido.Productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Importe, Fecha_Compra, completado, NIF, Localidad, Provincia, CP, Calle, numero, puerta, phone, comprador, Productos);
    }

    public String getSecreto() {
        return secreto;
    }

    public void setSecreto(String secreto) {
        this.secreto = secreto;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public String getMetedoPago() {
        return metedoPago;
    }

    public void setMetedoPago(String metedoPago) {
        this.metedoPago = metedoPago;
    }

    public String getCodigo_Comprador() {
        return Codigo_Comprador;
    }

    public void setCodigo_Comprador(String codigo_Comprador) {
        Codigo_Comprador = codigo_Comprador;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", Importe=" + Importe +
                ", Fecha_Compra=" + Fecha_Compra +
                ", completado=" + completado +
                ", NIF='" + NIF + '\'' +
                ", Localidad='" + Localidad + '\'' +
                ", Provincia='" + Provincia + '\'' +
                ", CP='" + CP + '\'' +
                ", Calle='" + Calle + '\'' +
                ", numero='" + numero + '\'' +
                ", puerta='" + puerta + '\'' +
                ", phone='" + phone + '\'' +
                ", comprador=" + comprador +
                ", Productos=" + Productos +
                '}';
    }
}
