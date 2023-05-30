package es.urjc.code.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.code.sql.JdbcProductoRepository;
import es.urjc.code.sql.Producto;
import es.urjc.code.sql.VersionRepository;

@Component
public class JPAProductService implements ProductService {

	@Autowired
	JdbcProductoRepository productoRepository;

	@Autowired
	VersionRepository versionRepository;

	@Autowired
	ModelMapper mapper;

	public List<ProductoDto> findAllProducts() {
		return productoRepository.findAll().stream().map(p -> mapper.map(p, ProductoDto.class)).toList();
	}

	public List<VersionDto> findAllVersions() {
		return versionRepository.findAll().stream().map(v -> mapper.map(v, VersionDto.class)).toList();
	}

	public void saveProduct(ProductoDto p) {
		productoRepository.save(mapper.map(p, Producto.class));
	}

}
