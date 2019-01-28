package pojo;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Clase que se utiliza para seleccionar el tipo de Lavado en el proceso de 
 * Factuacion.
 * Existen tres tipos de Lavado, expreso, semicompleto y completo.
 */
public class TipoLavado implements Serializable{
    private String codigo;
    private String nombre;
    private String descripcion;
    private Double pvp;
    private LocalTime tiempoEstimado; //tiempo estimado de duracion de lavado.

    public TipoLavado(String codigo, String nombre, String descripcion, Double pvp, LocalTime tiempoEstimado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.tiempoEstimado = tiempoEstimado;
    }

    
    
    
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    public LocalTime getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(LocalTime tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
    
    
    @Override
    public String toString() {
        String x = tiempoEstimado.getHour()> 0 ? " horas" : " min.";    
        int tiempo = tiempoEstimado.getHour()> 0 ? tiempoEstimado.getHour() : tiempoEstimado.getMinute();
        return  codigo + " " 
                + nombre + " | Costo: " + pvp +" | Time: "+ tiempo+ x;
    }
    
    
}
