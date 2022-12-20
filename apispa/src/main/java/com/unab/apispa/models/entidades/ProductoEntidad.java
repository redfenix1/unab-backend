package com.unab.apispa.models.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "producto")
public class ProductoEntidad implements Serializable {
    private static final Long serialVersionUID=1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String idProducto;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String imagen;
    @Column(nullable = false)
    private String precio;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
