package dat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import pojo.Cliente;
import util.ListaDoble;

/**
 * Permite realizar operaciones de lectura y escritura de archivos binarios
 * paran la gestion de clientes.
 */
public class ClientesDAT {

    private static final String CLIENTES_FILE = "./files/clientes.txt";
    //Write Object
    private FileOutputStream fos;
    private ObjectOutputStream oos;

    //Read Object
    private FileInputStream fis;
    private ObjectInputStream ois;

    private Boolean hayRegistros = true;
    private List<Cliente> clientes;
    private ListaDoble clientesListaDoble;

    /**
     * Guarda un objeto cliente. Recuperamos los objetos anteriormente guardados
     * y volvemos a escribir todo el archivo ya que solo es posible utilizar un
     * mismo {ObjectOutputStream} object para la escritura, para mas informacion
     *
     * @see https://stackoverflow.com/a/20262051/4896539
     *
     * @param cliente objeto cliente a ser guardado.
     * @return true si se guardo correctamente, caso contrario false.
     *
     */
    public Boolean guardarCliente(Cliente cliente, int numFila) {
        try {
            // recupera los clientes existentes en el archivo.
            clientes = listarClientes();
            if(clientes == null) {                
                clientes = new ArrayList<>();
            } 
            
            if(numFila < 0)           { 
                // agrega el nuevo cliente al final de la lista
                clientes.add(cliente);
            }else{
                clientes.set(numFila, cliente);
            }

            //apertura la escritura
            fos = new FileOutputStream(CLIENTES_FILE);
            oos = new ObjectOutputStream(fos);

            //agrega todos los objetos clientes al archivo.
            for (Cliente c : clientes) {
                oos.writeObject(c);
            }
            oos.flush();
            return true;
        } catch (IOException e) {
            System.out.println("Guardar Ciente Exception: " + e);
            return false;
        } finally {
            try {
                System.out.println("Guardar Ciente Called Finally Block");
                oos.close();
            } catch (IOException ex) {
                System.out.println("Guardar Ciente Exception Close File: " + ex);
                return false;
            }
        }
    }
        

    /**
     * Recupera todos los objectos cliente del archivo binario y los almacena en
     * una lista.
     *
     * @return la lista de Clientes.
     */
    public List<Cliente> listarClientes() {
        try {
            clientes = new ArrayList<>();
            // apertura la lectura.
            fis = new FileInputStream(CLIENTES_FILE);
            ois = new ObjectInputStream(fis);

            while (fis.available() != 0) {
                Cliente clienteReaded = (Cliente) ois.readObject();
                clientes.add(clienteReaded);
                System.out.println("Cliente Read: " + clienteReaded);
            }
            return clientes;
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            System.out.println("Leer Ciente Exception: " + ex);
            return null;
        } catch (IOException ioe) {
            System.out.println("Leer Ciente IOException: " + ioe);
            return null;
        }
    }
    
    /** 
     * Lista Clientes utilizando listas Dobles. Agrega uno a uno los clientes
     * leidos del archivo y los almacena en el nodo.
     * @return 
     */
    public ListaDoble listarClientesListaDobles() {
        try {            
            clientesListaDoble = new ListaDoble();
            // apertura la lectura.
            fis = new FileInputStream(CLIENTES_FILE);
            ois = new ObjectInputStream(fis);

            while (fis.available() != 0) {
                Cliente clienteReaded = (Cliente) ois.readObject();
                clientesListaDoble.agregarCliente(clienteReaded);
                System.out.println("Cliente Read: " + clienteReaded);
            }
            return clientesListaDoble;
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            System.out.println("Leer Ciente Exception: " + ex);
            return null;
        } catch (IOException ioe) {
            System.out.println("Leer Ciente IOException: " + ioe);
            return null;
        }
    }
    
    public Cliente getCliente(int pos){
        try {
            Cliente clienteReaded = new Cliente();
            // apertura la lectura.
            fis = new FileInputStream(CLIENTES_FILE);
            ois = new ObjectInputStream(fis);
            
            int posAux = 0;
            while (fis.available() != 0) {
                System.out.println("en el while, posAux:"+posAux+", pos:"+pos);
                clienteReaded = (Cliente) ois.readObject();                
                if(posAux == pos){                    
                    System.out.println("Cliente Read: " + clienteReaded);
                    break;
                }                
                posAux++;
            }
            return clienteReaded;
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            System.out.println("Leer Ciente Exception: " + ex);
            return null;
        } catch (IOException ioe) {
            System.out.println("Leer Ciente IOException: " + ioe);
            return null;
        }
    }

}
