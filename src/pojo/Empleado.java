package pojo;

import java.io.Serializable;

/**
 *
 * Clase Empleado, hereda de la Clase padre Persona
 */
public class Empleado extends Persona implements Serializable{    
    private Double salario;
    private Integer anioIngreso;
    
    public Empleado(){
        
    }
    
    public Empleado(String cedula, String nombre, String apellido, 
            String genero, String telefono, String direccion, Boolean estado, Double salario,
            Integer anioIngreso) {
        super(cedula, nombre, apellido, genero, telefono, direccion, estado);
        
        
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(Integer anioIngreso) {
        this.anioIngreso = anioIngreso;
    }
    
}
