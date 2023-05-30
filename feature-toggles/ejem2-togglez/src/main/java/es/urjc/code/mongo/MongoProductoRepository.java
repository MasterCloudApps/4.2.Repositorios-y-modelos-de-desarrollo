package es.urjc.code.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoProductoRepository extends MongoRepository<Producto, Long> {
    
}