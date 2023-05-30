package es.urjc.code.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.code.mongo.MongoProductoRepository;
import es.urjc.code.mongo.Producto;
import es.urjc.code.mongo.Version;
import es.urjc.code.sql.JdbcProductoRepository;
import es.urjc.code.sql.VersionRepository;

@Component
public class ProductService {
    
    @Autowired
    JdbcProductoRepository jdbcProductoRepository;

    @Autowired
    VersionRepository jdbcVersionRepository;

    @Autowired
    MongoProductoRepository mongoProductoRepository;

    @Autowired
    ModelMapper mapper;

    public List<ProductoDto> findAllProducts() {
        return jdbcProductoRepository
            .findAll()
            .stream()
            .map(p -> mapper.map(p, ProductoDto.class))
            .toList();
    }

    public List<VersionDto> findAllVersions() {
        return jdbcVersionRepository
            .findAll()
            .stream()
            .map(v -> mapper.map(v, VersionDto.class))
            .toList();
    }

    public void saveProduct(ProductoDto p) {
        // We save in both repositories (as per phase 3, commit 4)
        jdbcProductoRepository.save(mapper.map(p, es.urjc.code.sql.Producto.class));
        mongoProductoRepository.save(mapper.map(p, Producto.class));
    }

}

