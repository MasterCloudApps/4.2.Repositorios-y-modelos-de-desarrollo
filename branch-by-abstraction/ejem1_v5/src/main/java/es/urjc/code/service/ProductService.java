package es.urjc.code.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.code.mongo.MongoProductoRepository;
import es.urjc.code.mongo.Producto;
import es.urjc.code.mongo.Version;

@Component
public class ProductService {
    
    @Autowired
    MongoProductoRepository mongoProductoRepository;

    public List<Producto> findAllProducts() {
        return mongoProductoRepository.findAll();
    }

    public List<Version> findAllVersions() {
        return mongoProductoRepository
            .findAll()
            .stream()
            .map(Producto::getVersiones)
                .flatMap(List::stream)
                .toList();
    }

    public void saveProduct(Producto p) {
        mongoProductoRepository.save(p);
    }

}

