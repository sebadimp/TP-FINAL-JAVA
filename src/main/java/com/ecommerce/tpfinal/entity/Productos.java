package com.ecommerce.tpfinal.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;

    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoria;
    private String imagen;
    private Integer stock;
}
