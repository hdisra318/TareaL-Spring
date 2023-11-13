package fciencias.unam.inventario.demo.repository;

import org.springframework.stereotype.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

import fciencias.unam.inventario.demo.entity.Producto;
import fciencias.unam.inventario.demo.entity.TipoProducto;

@Repository
public class ProductoRepositoryImp {
    
    private final Logger logger = LogManager.getLogger(ProductoRepository.class);

    private final List<Producto> productList = new ArrayList<>();

    /**
     * Regresa la lista de ingredientes (productos) para el inventario
     */
    public List<Producto> getProductList() {
        return productList;
    }

    /**
     * Regresa el objeto producto dado su nombre
     */
    public Producto findProductoByName(String nombreProducto) {
        for(Producto producto : this.productList) {
            if(producto.getNombreProducto().equals(nombreProducto))
                return producto;
        }

        return null;
    }
    
    /**
     * Guarda un producto en el inventario
     */
    public Producto save(Producto p) {
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombreProducto(p.getNombreProducto());
        nuevoProducto.setStock(p.getStock());
        nuevoProducto.setTipoProducto(p.getTipoProducto());
        nuevoProducto.setCosto(p.getCosto());
        nuevoProducto.setFechaAdquision(p.getFechaAdquision());
        nuevoProducto.setFechaCaducidad(p.getFechaCaducidad());
        nuevoProducto.setNombreProducto(p.getNombreProveedor());
        nuevoProducto.setDescripcion(p.getDescripcion());
        nuevoProducto.setComentarios(p.getComentarios());

        this.productList.add(nuevoProducto);
        return nuevoProducto;
    }

    /** 
     * Actualiza un producto del inventario
     */
    public Producto update(Producto p) {

        Producto nuevoProducto = this.findProductoByName(p.getNombreProducto());
        nuevoProducto.setNombreProducto(p.getNombreProducto());
        nuevoProducto.setStock(p.getStock());
        nuevoProducto.setTipoProducto(p.getTipoProducto());
        nuevoProducto.setCosto(p.getCosto());
        nuevoProducto.setFechaAdquision(p.getFechaAdquision());
        nuevoProducto.setFechaCaducidad(p.getFechaCaducidad());
        nuevoProducto.setNombreProducto(p.getNombreProveedor());
        nuevoProducto.setDescripcion(p.getDescripcion());
        nuevoProducto.setComentarios(p.getComentarios());

        return nuevoProducto;
    }


}
