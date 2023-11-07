package fciencias.unam.inventario.demo.entity;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Producto {

    /** Id del tipo de producto */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProducto;

    /** Nombre del producto */
    @NotNull(message = "El nombre del producto es obligatorio")
    @Column(name = "nombre_producto", length = 50)
    private String nombreProducto;

    /** Stock del producto */
    @NotNull(message = "El stock del producto es obligatorio")
    private int stock;

    /** Tipo del producto */
    @NotNull(message = "El stock del producto es obligatorio")
    private TipoProducto tipoProducto;

    /** Costo del producto */
    @NotNull(message = "El costo del producto es obligatorio")
    private float costo;

    /** Fecha de Adquision del producto */
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaAdquision;

    /** Fecha de Caducidad del producto */
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCaducidad;

    /** Nombre del proveedor */
    @NotNull(message = "El nombre del proveedor es obligatorio")
    private String nombreProveedor;

    /** Descripcion del producto */
    @NotNull(message = "La descripcion es obligatoria")
    private String descripcion;

    /** Comentarios del producto */
    private String comentarios;
    
}
