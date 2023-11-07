package fciencias.unam.inventario.demo.entity;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;

@Data
@Entity
public class Usuario {

    /** Id del usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;

    /** Nombre del usuario */
    @NotNull(message = "El nombre del usuario es obligatorio")
    public String nombre;

    /** Apellido paterno */
    @NotNull(message = "El apellido paterno del usuario es obligatorio")
    public String aPaterno;

    /** Apellido materno */
    @NotNull(message = "El apellido materno del usuario es obligatorio")
    public String aMaterno;

    /** Saldo del usuario */
    @NotNull(message = "El saldo del usuario es obligatorio")
    public double saldo;

}