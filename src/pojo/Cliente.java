package pojo;

import java.io.Serializable;

/**
 * Clase Cliente, hereda de la Clase padre Persona
 */
public class Cliente extends Persona implements Serializable{
   private Boolean membresia;

    public Cliente() {       
    }

    public Cliente(String cedula, String nombre, String apellido, 
            String genero, String telefono, String direccion, Boolean estado, Boolean membresia) {
        super(cedula, nombre, apellido, genero, telefono, direccion, estado);        
        this.membresia = membresia;
    }   

    public Boolean getMembresia() {
        return membresia;
    }

    public void setMembresia(Boolean membresia) {
        this.membresia = membresia;
    }    
    
    
    
}
