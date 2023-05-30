package es.urjc.code;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import es.urjc.code.service.JPAProductService;
import es.urjc.code.service.MongoProductService;
import es.urjc.code.service.ProductService;
import es.urjc.code.service.ProductoDto;
import es.urjc.code.service.VersionDto;
import es.urjc.code.toggle.Features;

import org.togglz.core.manager.FeatureManager;

/**
 * Cargador de la BD y ejemplos de consulta.
 *
 * @author J. Manuel Colmenar
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

    private MongoProductService mongoService;

    private JPAProductService jpaService;

    private FeatureManager featureManager;

    public DatabaseLoader(MongoProductService mongoService, JPAProductService jpaService, FeatureManager featureManager) {
        this.mongoService = mongoService;
        this.jpaService = jpaService;
        this.featureManager = featureManager;
    }

    @Override
    public void run(String... args) throws ParseException {

        ProductService service = featureManager.isActive(Features.MONGO_DATABASE) ? mongoService : jpaService;

        // Guardando datos ...
        ProductoDto p1 = new ProductoDto("Apple Macbook");

        List<VersionDto> versiones = new ArrayList<>();
        versiones.add(new VersionDto("1.0",new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2015"),p1));
        versiones.add(new VersionDto("1.5",new SimpleDateFormat("dd/MM/yyyy").parse("15/10/2015"),p1));

        p1.setVersiones(versiones);
        service.saveProduct(p1);


        // Recupera versiones
        List<VersionDto> versionesFromDb = service.findAllVersions();
        System.out.println("Versiones con findAll():");
        System.out.println("----------------------------------------");
        muestraDatos(versionesFromDb);

        // Recupera productos
        List<ProductoDto> productos = service.findAllProducts();
        System.out.println("Productos con findAll():");
        System.out.println("----------------------------------------");
        muestraDatos(productos);

    }


    private static void muestraDatos(List datos) {
        for (Object p : datos) {
            System.out.println(p);
        }
        System.out.println();
    }

}
