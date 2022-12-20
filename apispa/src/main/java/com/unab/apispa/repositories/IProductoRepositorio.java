package com.unab.apispa.repositories;

import com.unab.apispa.models.entidades.ProductoEntidad;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepositorio extends PagingAndSortingRepository<ProductoEntidad, Long> {
    List<ProductoEntidad> findAllByOrderByIdDesc();

    ProductoEntidad findByIdProducto(String id);
}
