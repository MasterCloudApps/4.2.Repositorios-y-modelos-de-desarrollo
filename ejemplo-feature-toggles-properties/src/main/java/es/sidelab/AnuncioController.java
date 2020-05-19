package es.sidelab;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.sidelab.model.Anuncio;

@RestController
public class AnuncioController {
	
	@Autowired
	private AnuncioRepository repository;
	
	@PostConstruct
	public void init() {
		Anuncio anuncio = new Anuncio("Mew", "Vendo moto", "Pocos kilómetros");
		repository.save(anuncio);
	}
	
	@RequestMapping(value = "/anuncios", method = RequestMethod.GET)
	public List<Anuncio> getAnuncios() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/anuncios", method = RequestMethod.POST)
	public ResponseEntity<Boolean> addAnuncio(@RequestBody Anuncio anuncio) {
		repository.save(anuncio);
		return new ResponseEntity<Boolean>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/anuncio/{name}")
	public Anuncio getAnuncio(@PathVariable(value = "name") String name) {
		return repository.findByNombre(name);
	}

}
