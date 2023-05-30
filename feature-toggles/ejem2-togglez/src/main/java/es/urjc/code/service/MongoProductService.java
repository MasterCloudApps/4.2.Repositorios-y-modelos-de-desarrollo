package es.urjc.code.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.code.mongo.MongoProductoRepository;
import es.urjc.code.mongo.Producto;

@Component
public class MongoProductService implements ProductService {

	@Autowired
	MongoProductoRepository mongoProductoRepository;

	@Autowired
	ModelMapper mapper;

	public List<ProductoDto> findAllProducts() {
		return mongoProductoRepository.findAll().stream().map(p -> mapper.map(p, ProductoDto.class)).toList();
	}

	public List<VersionDto> findAllVersions() {
		List<Producto> products = mongoProductoRepository.findAll();
		return products
			.stream()
			.flatMap((p) -> p.getVersiones().stream())
			.map((v) -> mapper.map(v, VersionDto.class)).toList();
	}

	public void saveProduct(ProductoDto p) {
		mongoProductoRepository.save(toMongoDocument(p));
	}

	private es.urjc.code.mongo.Producto toMongoDocument(ProductoDto p) {
		return new es.urjc.code.mongo.Producto(p.getDatos(), toMongoVersiones(p.getVersiones()));
	}

	private List<es.urjc.code.mongo.Version> toMongoVersiones(List<VersionDto> versiones) {
		List<es.urjc.code.mongo.Version> mongoVersiones = new ArrayList<>();
		for (VersionDto v : versiones) {
			mongoVersiones.add(new es.urjc.code.mongo.Version(v.getVersion(), v.getFecha()));
		}
		return mongoVersiones;
	}
}
