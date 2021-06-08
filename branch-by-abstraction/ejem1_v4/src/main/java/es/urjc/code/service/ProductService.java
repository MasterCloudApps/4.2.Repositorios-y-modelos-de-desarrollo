package es.urjc.code.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.code.sql.Producto;
import es.urjc.code.sql.ProductoRepository;
import es.urjc.code.sql.Version;
import es.urjc.code.sql.VersionRepository;

@Component
public class ProductService {
    
    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    VersionRepository versionRepository;

    @Autowired
    es.urjc.code.mongo.ProductoRepository mongoProductoRepository;

    public List<Producto> findAllProducts() {
        return productoRepository.findAll();
    }

    public List<Version> findAllVersions() {
        return versionRepository.findAll();
    }

    public void saveProduct(Producto p) {
        productoRepository.save(p);
        mongoProductoRepository.save(toMongoDocument(p));
    }

    private es.urjc.code.mongo.Producto toMongoDocument(Producto p) {
        return new es.urjc.code.mongo.Producto(p.getDatos(), toMongoVersiones(p.getVersiones()));
    }

    private List<es.urjc.code.mongo.Version> toMongoVersiones(List<Version> versiones) {
        List<es.urjc.code.mongo.Version> mongoVersiones = new ArrayList<>();
        for(Version v : versiones) {
            mongoVersiones.add(new es.urjc.code.mongo.Version(v.getVersion(), v.getFecha()));
        }
        return mongoVersiones;
    }
}

