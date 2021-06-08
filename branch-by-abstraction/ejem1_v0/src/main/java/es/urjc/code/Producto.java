package es.urjc.code;

import javax.persistence.*;
import java.util.List;

/**
 * Entidad Producto.
 *
 * @author J. Manuel Colmenar
 */
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // Por ejemplo, marca y modelo
    private String datos;

    // Historial de versiones
//    @OneToMany(cascade=CascadeType.ALL, mappedBy="producto", fetch = FetchType.EAGER)
    @OneToMany(cascade=CascadeType.ALL, mappedBy="producto")
    private List<Version> versiones;

    public Producto() {
    }

    public Producto(String datos) {
        this.datos = datos;
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
