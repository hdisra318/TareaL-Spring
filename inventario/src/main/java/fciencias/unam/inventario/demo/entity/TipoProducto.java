package fciencias.unam.inventario.demo.entity;

public enum TipoProducto {
    SOLIDO("Perecedero", "Solido"),
    LIQUIDO("Perecedero", "Liquido");

    /** Categoria a la que pertenece el producto */
    public final String categoria;

    /** Tipo de producto */
    public final String tipo;


    private TipoProducto(String categoria, String tipo) {
        this.categoria = categoria;
        this.tipo = tipo;
    }

}