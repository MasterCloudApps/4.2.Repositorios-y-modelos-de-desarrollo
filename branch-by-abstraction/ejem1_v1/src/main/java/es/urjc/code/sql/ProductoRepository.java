package es.urjc.code.sql;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para productos.
 *
 *  @author J. Manuel Colmenar
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
