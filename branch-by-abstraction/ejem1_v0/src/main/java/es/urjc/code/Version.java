package es.urjc.code;

import javax.persistence.*;
import java.util.Date;

/**
 * Clase con datos sobre la version.
 *
 * @author J. M. Colmenar
 */
@Entity
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String version;
    private Date fecha;

    @ManyToOne
    private Producto producto;

    public Version() {}

    public Version(String version, Date fecha) {
        this.version = version;
        this.fecha = fecha;
    }

    public Version(String version, Date fecha, Producto producto) {
        this(version,fecha);
        this.producto = producto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return  "version='" + version + '\'' +
                ", fecha=" + fecha + ", producto=" + producto;
    }
}
