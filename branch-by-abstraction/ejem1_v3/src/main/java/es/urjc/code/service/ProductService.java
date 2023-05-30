package es.urjc.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.code.sql.Producto;
   import es.urjc.code.mongo.MongoProductoRepository;
import es.urjc.code.sql.JdbcProductoRepository;
import es.urjc.code.sql.Version;
import es.urjc.code.sql.VersionRepository;

@Component
public class ProductService {
    
    @Autowired
    JdbcProductoRepository productoRepository;

    @Autowired
    VersionRepository versionRepository;
    
    @Autowired
    MongoProductoRepository mongoRepo;

    public List<Producto> findAllProducts() {
        return productoRepository.findAll();
    }

    public List<Version> findAllVersions() {
        return versionRepository.findAll();
    }

    public void saveProduct(Producto p) {
        productoRepository.save(p);
    }
}
