package es.urjc.code.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface ProductService {
    
    public List<ProductoDto> findAllProducts();

    public List<VersionDto> findAllVersions();

    public void saveProduct(ProductoDto p);

}

