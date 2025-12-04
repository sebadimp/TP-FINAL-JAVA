package com.ecommerce.tpfinal.controller;

import com.ecommerce.tpfinal.entity.Productos;
import com.ecommerce.tpfinal.services.ProductoServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "https://milo-pasteleria.netlify.app/")
@RestController
@RequestMapping("/ecommerce/api/productos")
public class ProductoController {

    private final ProductoServices productoServices;

    public ProductoController(ProductoServices productoServices) {

        this.productoServices = productoServices;
    }

    @GetMapping
    public ResponseEntity<?> obtenerProductos() {
        return ResponseEntity.ok(productoServices.obtenerProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable Long id) {

        Productos producto = productoServices.obtenerProductoPorId(id);

        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto no encontrado con id: " + id);
        }

        return ResponseEntity.ok(producto);
    }


    @GetMapping("/buscar")
    public ResponseEntity<?> buscar(
            @RequestParam(required = false,defaultValue = "") String nombre,
            @RequestParam(required = false,defaultValue = "") String categoria,
            @RequestParam(required = false) Double minPrecio,
            @RequestParam(required = false) Double maxPrecio) {

        return ResponseEntity.ok(productoServices.buscarPorFiltros(nombre, categoria, minPrecio, maxPrecio));
    }

    @PostMapping
    public ResponseEntity<?> agregarProducto(@RequestBody Productos producto){

        return ResponseEntity.status(HttpStatus.CREATED).body(productoServices.agregarProducto(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarProductoPorId(@PathVariable Long id, @RequestBody Productos producto){
        return ResponseEntity.ok(productoServices.actualizarProducto(id, producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProductoPorId(@PathVariable Long id){

        Productos producto = productoServices.eliminarProducto(id);

        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto no encontrado con id: " + id);
        }

        return ResponseEntity.noContent().build();
    }

}
