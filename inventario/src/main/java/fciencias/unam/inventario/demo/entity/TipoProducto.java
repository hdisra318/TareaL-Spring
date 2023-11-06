package fciencias.unam.inventario.demo.entity;

import lombok.Data;

@Data
@Entity
public class TipoProducto {

    /** Id del tipo de producto */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProducto;

    /** Nombre del producto */
    @NotNull
    @Column(name = "nombre_producto", length = 50)
    public String nombreProducto;

    /** Categoria a la que pertenece el producto */
    @NotNull
    @Column(name = "categoria", length = 50)
    public String categoria;

    /** Stock del producto */
    @NotNull
    public int stock;



}