package fciencias.unam.inventario.demo.repository;

import fciencias.unam.inventario.demo.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {

}