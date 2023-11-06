package fciencias.unam.inventario.demo.entity;

import lombok.Data;

@Data
@Entity
public class Usuario {

    /** Id del usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;

    /** Nombre del usuario */
    @NotNull
    @Column(name = "nombre_usuario", length = 50)
    public String nombre;

    /** Apellido paterno */
    @NotNull
    @Column(name = "a_paterno", length = 50)
    public String aPaterno;

    /** Apellido materno */
    @NotNull
    @Column(name = "a_materno", length = 50)
    public String aMaterno;

    /** Saldo del usuario */
    @NotNull
    public double saldo;

}