package fciencias.unam.inventario.demo.entity;

public enum TipoProducto {
    SOLIDO("Solido"),
    LIQUIDO("Liquido");

    /** Tipo de producto */
    public final String tipo;


    private TipoProducto(String tipo) {
        this.tipo = tipo;
    }

}