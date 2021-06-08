package es.urjc.code;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para versiones.
 *
 *  @author J. Manuel Colmenar
 */
public interface VersionRepository extends JpaRepository<Version, Long> {

}
