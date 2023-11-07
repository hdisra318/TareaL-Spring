package fciencias.unam.inventario.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import fciencias.unam.inventario.demo.entity.Producto;
import org.springframework.stereotype.Repository;

@Repository
public class InventarioRepositoryArrayList {
    
    private final List<Producto> list = new ArrayList<>();

    private final Logger logger = LogManager.getLogger(InventarioRepositoryArrayList.class);
    
}
