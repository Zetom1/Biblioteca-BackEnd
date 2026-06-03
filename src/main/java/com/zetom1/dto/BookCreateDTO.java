package com.zetom1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;


public class BookCreateDTO {

    @NotBlank
    private String titulo;

    @NotNull
    private Boolean reserva;

    @NotNull
    @Min(0)
    private Integer cantidad;

    private String url;

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

    
    public String getUrl() {
        return url;
    }

    public void setCantidad(String url) {
        this.url = url;
    }
}
