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
import pojo.Factura;
import pojo.Factura;

/**
 * Permite realizar operaciones de lectura y escritura de archivos binarios
 * paran la gestion de facturas.
 */
public class FacturasDAT {

    private static final String FACTURAS_FILE = "./files/facturas.txt";
    //Write Object
    private FileOutputStream fos;
    private ObjectOutputStream oos;

    //Read Object
    private FileInputStream fis;
    private ObjectInputStream ois;

    private Boolean hayRegistros = true;
    private List<Factura> facturas;

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
    public Boolean guardarFactura(Factura factura) {
        try {
            // recupera los facturas existentes en el archivo.
            facturas = listarFacturas();
            if(facturas == null) {                
                facturas = new ArrayList<>();
            } 
                
            facturas.add(factura);


            //apertura la escritura
            fos = new FileOutputStream(FACTURAS_FILE);
            oos = new ObjectOutputStream(fos);

            //agrega todos los objetos facturas al archivo.
            for (Factura c : facturas) {
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
    public List<Factura> listarFacturas() {
        try {
            facturas = new ArrayList<>();
            // apertura la lectura.
            fis = new FileInputStream(FACTURAS_FILE);
            ois = new ObjectInputStream(fis);

            while (fis.available() != 0) {
                Factura facturaReaded = (Factura) ois.readObject();
                facturas.add(facturaReaded);
                //System.out.println("Factura Read: " + facturaReaded);
            }
            return facturas;
        } catch (FileNotFoundException | ClassNotFoundException ex) {
            System.out.println("Leer Factura Exception: " + ex);
            return null;
        } catch (IOException ioe) {
            System.out.println("Leer Factura IOException: " + ioe);
            return null;
        }
    }
    
    
    public int  numFacturasPorCliente( Cliente cliente) {
        try{
            int numFacturasCliente = 0;
            for(Factura fact : listarFacturas()){
                System.out.println("num fac cliente: "+fact.getCliente());
                 if (cliente.getCedula().equals(   fact.getCliente().getCedula() )){
                     System.out.println("es igual cliente: "+fact.getCliente());
                     numFacturasCliente++;
                 }
                 if (numFacturasCliente > 1) break;
            }
            return numFacturasCliente;
        }catch(Exception ex) {
            System.out.println("Leer Factura Exception 222: " + ex);
            return -1;
        } 
    }
    
    /*public Factura getCliente(int pos){
        try {
            Factura clienteReaded = new Factura();
            // apertura la lectura.
            fis = new FileInputStream(CLIENTES_FILE);
            ois = new ObjectInputStream(fis);
            
            int posAux = 0;
            while (fis.available() != 0) {
                System.out.println("en el while, posAux:"+posAux+", pos:"+pos);
                clienteReaded = (Factura) ois.readObject();                
                if(posAux == pos){                    
                    System.out.println("Factura Read: " + clienteReaded);
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
    }*/

}
