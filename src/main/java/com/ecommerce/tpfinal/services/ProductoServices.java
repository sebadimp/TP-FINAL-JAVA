package com.ecommerce.tpfinal.services;

import com.ecommerce.tpfinal.entity.Productos;
import com.ecommerce.tpfinal.repository.ProductoRepository;
import com.ecommerce.tpfinal.utils.ProductoUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServices {


    private final ProductoRepository productoRepository;

    public ProductoServices(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Productos> obtenerProductos() {
        return productoRepository.findAll();
    }

    public Productos obtenerProductoPorId(Long id){
        return productoRepository.findById(id)
                .orElse(null);
    }

    public List<Productos> buscarPorFiltros(String nombre, String categoria, Double minPrecio, Double maxPrecio) {

        boolean nombreOk = ProductoUtils.nombreValido(nombre);
        boolean categoriaOk = ProductoUtils.categoriaValida(categoria);
        // precioOk = ProductoUtils.precioValido(precio);

        // Caso 1: nombre + categoria
        if (nombreOk && categoriaOk) {
            return productoRepository
                    .findByNombreContainingIgnoreCaseAndCategoriaContainingIgnoreCase(nombre, categoria);
        }

        // Caso 2: solo nombre
        if (nombreOk) {
            return productoRepository.findByNombreContainingIgnoreCase(nombre);
        }

        // Caso 3: solo categoria
        if (categoriaOk) {
            return productoRepository.findByCategoriaContainingIgnoreCase(categoria);
        }

        // Caso 4: precio entre min y max
        if(ProductoUtils.precioValido(minPrecio)&&ProductoUtils.precioValido(maxPrecio)){
            return productoRepository.findByPrecioBetween(minPrecio,maxPrecio);
        }

        // Sin filtros → retornar todo
        return productoRepository.findAll();
    }

    public Productos agregarProducto(Productos producto){
        System.out.println("Producto agregado correctamente");
        return productoRepository.save(producto);
    }

    public Productos actualizarProducto(long id, Productos producto) {
        Productos p = obtenerProductoPorId(id);

        if (producto.getNombre() != null){
            p.setNombre(producto.getNombre());
        }

        if (producto.getDescripcion() != null) {
            p.setDescripcion(producto.getDescripcion());
        }

        if (producto.getPrecio() != null && producto.getPrecio() >= 0) {
            p.setPrecio(producto.getPrecio());
        }

        if (producto.getCategoria() != null) {
            p.setCategoria(producto.getCategoria());
        }

        if (producto.getImagen() != null){
            p.setImagen(producto.getImagen());
        }
        if (producto.getStock() != null && producto.getStock() >= 0) {
            p.setStock(producto.getStock());
        }


        return productoRepository.save(p);
    }

    public Productos eliminarProducto(Long id){
        Optional<Productos> p = productoRepository.findById(id);

        if (p.isEmpty()) {
            System.out.println("No existe producto con id: " + id);
            return null;
        }

        productoRepository.deleteById(p.get().getId());
        System.out.println("Producto con id: " + id + " - eliminado correctamente");
        return p.orElse(null);

    }


}
