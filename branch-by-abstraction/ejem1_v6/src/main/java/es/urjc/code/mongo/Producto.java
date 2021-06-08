package es.urjc.code.mongo;

import java.util.Collections;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.MongoId;

public class Producto {

    @MongoId
    private long id;

    // Por ejemplo, marca y modelo
    private String datos;

    // Historial de versiones
    private List<Version> versiones;

    public Producto() {
    }

    public Producto(String datos) {
        this(datos, Collections.<Version>emptyList());
    }
    
    public Producto(String datos, List<Version> versiones) {
    	this.datos = datos;
    	this.versiones = versiones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public List<Version> getVersiones() {
        return versiones;
    }

    public void setVersiones(List<Version> versiones) {
        this.versiones = versiones;
    }

    @Override
    public String toString() {

        String strVersiones = "";
        for (Version v : versiones) {
            strVersiones += " [" + v.toString() + "] ";
        }

        return "Producto{" +
                "id=" + id +
                ", datos='" + datos + '\'' +
                ", versiones=" + versiones +
                '}';
    }

}
