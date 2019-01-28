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
public class Nodo {
    
    private Cliente cliente;    
    private Empleado empleado;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo(Empleado empleado, Nodo anterior, Nodo siguiente) {
        this.empleado = empleado;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }


    public Nodo(Cliente cliente, Nodo anterior, Nodo siguiente) {
        this.cliente = cliente;
        
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
}
