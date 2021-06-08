package es.urjc.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.code.mongo.Producto;
import es.urjc.code.mongo.Version;

@Component
public class ProductService {
    
    @Autowired
    es.urjc.code.mongo.ProductoRepository mongoProductoRepository;

    public List<Producto> findAllProducts() {
        return mongoProductoRepository.findAll();
    }

    public List<Version> findAllVersions() {
        return mongoProductionRepository.findAllVersions();
    }

    public void saveProduct(Producto p) {
        mongoProductoRepository.save(p);
    }

}

