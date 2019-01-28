package pojo;

import java.io.Serializable;

/**
 * Clase Padre de la cual heredaran otras clases.
 */
public class Persona implements Serializable {
    private String cedula;
    private String nombre;
    private String apellido;
    private String genero;
    private String telefono;
    private String direccion;
    private Boolean estado;
    
    public Persona() {
        this.estado = true;
    }

    public Persona(String cedula, String nombre, String apellido, String genero, String telefono, String direccion, Boolean estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    

    /*@Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", nombre=" 
                + nombre + ", apellido=" + apellido + ", genero=" 
                + genero + ", telefono=" + telefono + ", direccion=" 
                + direccion + ", estado=" +estado+ '}';
    }*/
    
    @Override
    public String toString() {
        return  cedula + " " 
                + nombre + " " + apellido;
    }
    
    
}
