package es.sidelab;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.sidelab.model.Anuncio;

@CacheConfig(cacheNames="anuncios")
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

	@CacheEvict(allEntries=true)
	Anuncio save(Anuncio anuncio);
	
//	select nombre, asunto, comentario
//	from anuncios
//	where nombre = nombreAnuncio
	@Cacheable
	Anuncio findByNombre(String nombre);
	
	@Cacheable
	List<Anuncio> findAll();
	
}
