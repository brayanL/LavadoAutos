/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import pojo.Cliente;
import pojo.Empleado;

/**
 *
 * @author Estefania
 */
public class ListaDoble {

    private Nodo inicio;
    private Nodo fin;

    public ListaDoble() {
        inicio = fin = null;
    }

    public void agregarCliente(Cliente cliente) {
        Nodo nuevo = new Nodo(cliente, fin, null);
        if (fin != null) {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        } else {
            inicio = fin = nuevo;
        }
    }
    
     public void agregarEmpleado(Empleado empleado) {
        Nodo nuevo = new Nodo(empleado, fin, null);
        if (fin != null) {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        } else {
            inicio = fin = nuevo;
        }
    }

    public void imprimir() {

        Nodo aux = inicio;

        while (aux != null) {
            System.out.println(aux.getCliente());
            aux = aux.getSiguiente();
        }

    }
    
    /**
     * Obtiene el nodo de inicio.
     * @return el nodo inicio para que se itere sobre el y de esta manera
     * extraer uno a uno los elementos deseados.
     */
    public Nodo getNodoInicio() {
        return inicio;
    }

    public void buscar(String cedula) {
        Nodo aux = inicio;

        while (aux != null) {

            if (cedula.compareToIgnoreCase(aux.getCliente().getCedula()) == 0) {
                System.out.println(aux.getCliente());
            }

            aux = aux.getSiguiente();
        }
    }

//    public double precioTipo(String placa) {
//        Double precio = 0.0;
//        Nodo aux = inicio;
//
//        while (aux != null) {
//            if (placa.compareToIgnoreCase(aux.getAuto().getPlaca()) == 0) {
//                if (aux.getAuto().getClase().compareToIgnoreCase("Sedan") == 0 || aux.getAuto().getClase().compareToIgnoreCase("Hashback") == 0) {
//                    precio = 10.00;
//                    //  System.out.println(aux.getCliente().getNombre() + " || " + aux.getCliente().getCedula() + " || "
//                    //    + aux.getAuto().getPlaca() + " || " + aux.getAuto().getClase()+" || "+ precio +" || "+precio*0.12 );
//                }
//                if (aux.getAuto().getClase().compareToIgnoreCase("Jeep") == 0 || aux.getAuto().getClase().compareToIgnoreCase("camioneta") == 0) {
//                    precio = 15.00;
//                }
//
//                if (aux.getAuto().getClase().compareToIgnoreCase("Bus") == 0 || aux.getAuto().getClase().compareToIgnoreCase("Camion") == 0
//                        || aux.getAuto().getClase().compareToIgnoreCase("Trailer") == 0) {
//                    precio = 20.00;
//                }
//
//            }
//
//            aux = aux.getSiguiente();
//        }
//
//        return precio;
//
//    }

    public double precioTipoLavado(String lavado) {
        double precioLavado = 0.0;

        if (lavado.compareToIgnoreCase("Expres") == 0) {
            precioLavado = 4.00;
            //  System.out.println(aux.getCliente().getNombre() + " || " + aux.getCliente().getCedula() + " || "
            //    + aux.getAuto().getPlaca() + " || " + aux.getAuto().getClase()+" || "+ precio +" || "+precio*0.12 );
        }
        if (lavado.compareToIgnoreCase("Convecional") == 0) {
            precioLavado = 7.00;
        }

        if (lavado.compareToIgnoreCase("Completo") == 0) {
            precioLavado = 18.00;
        }

        return precioLavado;
    }

//    public ListaDoble a(String placa) {
//        ListaDoble atendidos = new ListaDoble();
//
//        Nodo aux = inicio;
//
//        while (aux != null) {
//
//            if (placa.compareTo(aux.getAuto().getPlaca()) == 0) {
//                atendidos.agregarCliente(new Cliente(aux.getCliente().getNombre(), aux.getCliente().getCedula(),
//                        aux.getCliente().getTelefono(), aux.getCliente().getDireccion(), aux.getCliente().isMembresia()),
//                        new Auto(aux.getAuto().getPlaca(), aux.getAuto().getColor(), aux.getAuto().getClase()));
//            }
//
//            aux = aux.getSiguiente();
//        }
//
//        return atendidos;
//    }

//    public void imprimirFactura(String placa, String lavado) {
//
//        double subtotal = precioTipo(placa) + precioTipoLavado(lavado);
//        Nodo aux = inicio;
//
//        while (aux != null) {
//            if (placa.compareToIgnoreCase(aux.getAuto().getPlaca()) == 0) {
//                System.out.println(aux.getCliente().getNombre() + " || " + aux.getCliente().getCedula() + " || "
//                        + aux.getAuto().getPlaca() + " || " + aux.getAuto().getClase() + " ||  " + lavado + " || " + subtotal + " || " + subtotal * 1.12);
//            }
//            aux = aux.getSiguiente();
//        }
//
//    }


//    public void eliminar(String placa) {
//        Nodo aux = inicio;
//        while (aux != null) {
//            if (placa.compareToIgnoreCase(aux.getAuto().getPlaca()) == 0) {
//                aux.getAnterior().setSiguiente(aux.getSiguiente());
//                aux.getSiguiente().setAnterior(aux.getAnterior());
//            }
//            aux = aux.getSiguiente();
//
//        }
//    }
    
    
    
}
