package com.unab.apispa.controllers;

import com.unab.apispa.models.entidades.ProductoEntidad;
import com.unab.apispa.models.peticiones.ProductoActualizarReqModelo;
import com.unab.apispa.models.peticiones.ProductoCrearReqModelo;
import com.unab.apispa.models.respuestas.ProductoDataResModelo;
import com.unab.apispa.repositories.IProductoRepositorio;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {

    @Autowired
    IProductoRepositorio iProductoRepositorio;

    @PostMapping()
    public ProductoDataResModelo crearProducto(@RequestBody ProductoCrearReqModelo productoCrearReqModelo){

        ProductoEntidad productoEntidad= new ProductoEntidad();
        productoEntidad.setIdProducto(UUID.randomUUID().toString());

        BeanUtils.copyProperties(productoCrearReqModelo, productoEntidad);

        ProductoEntidad productoGuardado= iProductoRepositorio.save(productoEntidad);

        ProductoDataResModelo productoEntregado= new ProductoDataResModelo();

        BeanUtils.copyProperties(productoGuardado, productoEntregado);

        return productoEntregado;
    }

    @GetMapping()
    public List<ProductoDataResModelo> obtenerProductos(){

        List<ProductoEntidad> listaProductosGuardados= iProductoRepositorio.findAllByOrderByIdDesc();

        List<ProductoDataResModelo> listaProductosEntregados= new ArrayList<>();

        for (ProductoEntidad productoEntidad : listaProductosGuardados){
            ProductoDataResModelo productoDataResModelo= new ProductoDataResModelo();
            BeanUtils.copyProperties(productoEntidad, productoDataResModelo);
            listaProductosEntregados.add(productoDataResModelo);
        }

        return listaProductosEntregados;
    }

    @GetMapping(path="/{id}")
    public ProductoDataResModelo detalleProducto(@PathVariable String id){

        ProductoEntidad productoGuardado= iProductoRepositorio.findByIdProducto(id);

        ProductoDataResModelo productoEntregado= new ProductoDataResModelo();

        BeanUtils.copyProperties(productoGuardado, productoEntregado);

        return productoEntregado;
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarProducto(@PathVariable String id){
        ProductoEntidad productoGuardado= iProductoRepositorio.findByIdProducto(id);

        iProductoRepositorio.delete(productoGuardado);

        return "Producto eliminado con éxito!";
    }

    @PutMapping(path = "/{id}")
    public ProductoDataResModelo actualizarProducto(@PathVariable String id, @RequestBody ProductoActualizarReqModelo productoActualizarReqModelo){

        ProductoEntidad productoGuardado= iProductoRepositorio.findByIdProducto(id);
        productoGuardado.setTitulo(productoActualizarReqModelo.getTitulo());
        productoGuardado.setImagen(productoActualizarReqModelo.getImagen());
        productoGuardado.setPrecio(productoActualizarReqModelo.getPrecio());
        productoGuardado.setCategoria(productoActualizarReqModelo.getCategoria());
        productoGuardado.setDescripcion(productoActualizarReqModelo.getDescripcion());

        ProductoEntidad productoActualizado= iProductoRepositorio.save(productoGuardado);

        ProductoDataResModelo productoEntregado= new ProductoDataResModelo();

        BeanUtils.copyProperties(productoActualizado, productoEntregado);

        return productoEntregado;
    }
}
