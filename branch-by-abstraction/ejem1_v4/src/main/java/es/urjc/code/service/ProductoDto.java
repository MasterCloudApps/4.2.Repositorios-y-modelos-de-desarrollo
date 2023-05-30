package es.urjc.code.service;

import java.util.Collections;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.MongoId;

public class ProductoDto {

    private long id;

    // Por ejemplo, marca y modelo
    private String datos;

    // Historial de versiones
    private List<VersionDto> versiones;

    public ProductoDto() {
    }

    public ProductoDto(String datos) {
        this(datos, Collections.<VersionDto>emptyList());
    }
    
    public ProductoDto(String datos, List<VersionDto> versiones) {
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

    public List<VersionDto> getVersiones() {
        return versiones;
    }

    public void setVersiones(List<VersionDto> versiones) {
        this.versiones = versiones;
    }

    @Override
    public String toString() {

        String strVersiones = "";
        for (VersionDto v : versiones) {
            strVersiones += " [" + v.toString() + "] ";
        }

        return "Producto{" +
                "id=" + id +
                ", datos='" + datos + '\'' +
                ", versiones=" + versiones +
                '}';
    }

}
