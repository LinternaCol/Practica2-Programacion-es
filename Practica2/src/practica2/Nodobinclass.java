/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author s216e15
 */
public class Nodobinclass {
    
    private int contenido;
    private Nodobinclass hijoIzquierdo;
    private Nodobinclass hijoDerecho;

    public Nodobinclass(int contenido) {
        this.contenido = contenido;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public Nodobinclass getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodobinclass hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Nodobinclass getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodobinclass hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
    
    
    
    
    
}
