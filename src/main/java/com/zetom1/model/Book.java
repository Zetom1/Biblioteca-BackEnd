package com.zetom1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "titulo")
    private String titulo;

    @Column(name = "reserva")
    private Boolean reserva;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "url")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getReserva() {
        return reserva;
    }

    public void setReserva(Boolean reserva) {
        this.reserva = reserva;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setCantidad(String url) {
        this.url = url;
    }

    public Book(){}

    public Book (String titulo, Boolean reserva, Integer cantidad){
        this.titulo = titulo;
        this.reserva = reserva;
        this.cantidad = cantidad;
    }

    @Override
    public String toString(){
        return "BookEntity [id="+id+",titulo="+titulo+",reserva="+reserva+",cantidad="+cantidad+"]";
    }
}
