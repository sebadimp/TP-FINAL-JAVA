package com.ecommerce.tpfinal.repository;

import com.ecommerce.tpfinal.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Productos, Long> {

    List<Productos> findByNombreContainingIgnoreCase(String nombre);

    List<Productos> findByCategoriaContainingIgnoreCase(String categoria);

    List<Productos> findByNombreContainingIgnoreCaseAndCategoriaContainingIgnoreCase(
            String nombre, String categoria);

    List<Productos> findByPrecioBetween(Double minPrecio, Double maxPrecio);
}
