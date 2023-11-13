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
    public String nombreProducto;

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


    public String getNombreProducto(){
        return this.nombreProducto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public float getCosto() {
        return costo;
    }

    public int getStock() {
        return stock;
    }

    public LocalDate getFechaAdquision() {
        return fechaAdquision;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setFechaAdquision(LocalDate fechaAdquision) {
        this.fechaAdquision = fechaAdquision;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
