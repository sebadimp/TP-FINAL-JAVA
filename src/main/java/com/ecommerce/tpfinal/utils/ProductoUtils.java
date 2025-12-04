package com.ecommerce.tpfinal.utils;

public class ProductoUtils {

    public static boolean precioValido(Double precio) {
        return precio != null && precio >= 0;
    }

    public static boolean nombreValido(String nombre) {
        return  nombre != null && !nombre.isBlank();
    }

    public static boolean categoriaValida(String categoria) {
        return  categoria != null && !categoria.isBlank();
    }

}
