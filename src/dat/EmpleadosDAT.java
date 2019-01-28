package dat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import pojo.Empleado;

/**
 * Permite realizar operaciones de lectura y escritura de archivos binarios
 * paran la gestion de Empleados.
 */
public class EmpleadosDAT {

    private static final String EMPLEADOS_FILE = "./files/empleados.txt";
    //Write Object
    private FileOutputStream fos;
    private ObjectOutputStream oos;

    //Read Object
    private FileInputStream fis;
    private ObjectInputStream ois;

    private Boolean hayRegistros = true;
    private List<Empleado> empleados;

    /**
     * Guarda un objeto empleado. Recuperamos los objetos anteriormente guardados
     * y volvemos a escribir todo el archivo ya que solo es posible utilizar un
     * mismo {ObjectOutputStream} object para la escritura, para mas informacion
     *
     * @see https://stackoverflow.com/a/20262051/4896539
     *
     * @param empleado objeto empleado a ser guardado.
     * @return true si se guardo correctamente, caso contrario false.
     *
     */
    public Boolean guardarEmpleado(Empleado empleado, int numFila) {
        try {
            // recupera los empleados existentes en el archivo.
            empleados = listarEmpleados();
            if(empleados == null) {                
                empleados = new ArrayList<>();
            } 
            
            if (numFila < 0){
                // agrega el nuevo empleados al final de la lista
                empleados.add(empleado);
            }else{
                empleados.set(numFila, empleado);
            }

            //apertura la escritura
            fos = new FileOutputStream(EMPLEADOS_FILE);
            oos = new ObjectOutputStream(fos);

            //agrega todos los objetos empleados al archivo.
            for (Empleado emp : empleados) {
                oos.writeObject(emp);
            }
            oos.flush();
            return true;
        } catch (IOException e) {
            System.out.println("Guardar Empleado Exception: " + e);
            return false;
        } finally {
            try {
                System.out.println("Guardar Empleado Called Finally Block");
                oos.close();
            } catch (IOException ex) {
                System.out.println("Guardar Empleado Exception Close File: " + ex);
                return false;
            }
        }
    }

    /**
     * Recupera todos los objectos empleado del archivo binario y los almacena en
     * una lista.
     *
     * @return la lista de Empleado.
     */
    public List<Empleado> listarEmpleados() {
        try {
            empleados = new ArrayList<>();
            // apertura la lectura.
            fis = new FileInputStream(EMPLEADOS_FILE);
            ois = new ObjectInputStream(fis);

            while (fis.available() != 0) {
                Empleado empleadoReaded = (Empleado) ois.readObject();
                empleados.add(empleadoReaded);
                System.out.println("Empleado Read: " + empleadoReaded);
            }
            return empleados;
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            System.out.println("Leer Empleado Exception: " + ex);
            return null;
        } catch (IOException ioe) {
            System.out.println("Leer Empleado IOException: " + ioe);
            return null;
        }
    }
    
    public Empleado getEmpleado(int pos){
        try {
            Empleado empleadoReaded = new Empleado();
            // apertura la lectura.
            fis = new FileInputStream(EMPLEADOS_FILE);
            ois = new ObjectInputStream(fis);
            
            int posAux = 0;
            while (fis.available() != 0) {
                System.out.println("en el while, posAux:"+posAux+", pos:"+pos);
                empleadoReaded = (Empleado) ois.readObject();                
                if(posAux == pos){                    
                    System.out.println("Empleado Read: " + empleadoReaded);
                    break;
                }                
                posAux++;
            }
            return empleadoReaded;
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            System.out.println("Leer Empleado Exception: " + ex);
            return null;
        } catch (IOException ioe) {
            System.out.println("Leer Empleado IOException: " + ioe);
            return null;
        }
    }

}
