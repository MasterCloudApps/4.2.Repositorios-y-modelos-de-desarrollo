package es.urjc.code;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import es.urjc.code.service.ProductService;
import es.urjc.code.sql.Producto;
import es.urjc.code.sql.Version;

/**
 * Cargador de la BD y ejemplos de consulta.
 *
 * @author J. Manuel Colmenar
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
    private ProductService service;

    @Override
    public void run(String... args) throws ParseException {

        // Guardando datos ...
        Producto p1 = new Producto("Apple Macbook");

        List<Version> versiones = new ArrayList<>();
        versiones.add(new Version("1.0",new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2015"),p1));
        versiones.add(new Version("1.5",new SimpleDateFormat("dd/MM/yyyy").parse("15/10/2015"),p1));

        p1.setVersiones(versiones);
        service.saveProduct(p1);


        // Recupera versiones
        List<Version> versionesFromDb = service.findAllVersions();
        System.out.println("Versiones con findAll():");
        System.out.println("----------------------------------------");
        muestraDatos(versionesFromDb);

        // Recupera productos
        List<Producto> productos = service.findAllProducts();
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
