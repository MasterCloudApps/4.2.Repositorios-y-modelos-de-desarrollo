package es.urjc.code.service;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

public class VersionDto {

    private String version;
    private Date fecha;

    private ProductoDto producto;

    public VersionDto() {}

    public VersionDto(String version, Date fecha) {
        this.version = version;
        this.fecha = fecha;
    }

    public VersionDto(String version, Date fecha, ProductoDto producto) {
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

    public ProductoDto getProducto() {
        return producto;
    }

    public void setProducto(ProductoDto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return  "version='" + version + '\'' +
                ", fecha=" + fecha + ", producto=" + producto.getDatos();
    }

}
