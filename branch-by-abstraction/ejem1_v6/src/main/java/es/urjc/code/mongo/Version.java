package es.urjc.code.mongo;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

public class Version {

    private String version;
    private Date fecha;

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
