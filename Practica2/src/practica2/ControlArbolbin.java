/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Stack;

/**
 *
 * @author s216e15
 */
public class ControlArbolbin {
    
    private Nodobinclass raiz;
    
    public void insertarBin(int valor){
        Nodobinclass n = new Nodobinclass(valor);
        if(raiz == null){
            raiz = n;
        }else{
            Nodobinclass actual = raiz;
            Nodobinclass anterior = null;
            // busca don voy a insertar 
            while(actual != null){
                anterior = actual;
                if(valor  < actual.getContenido()){
                    actual = actual.getHijoIzquierdo();
                }else if(valor > actual.getContenido()){
                        actual = actual.getHijoDerecho();
                }
            }//end while
            
            if(valor  < anterior.getContenido()){
                anterior.setHijoIzquierdo(n);
            }else if(valor > anterior.getContenido()){
                anterior.setHijoDerecho(n);
            } 
        }
    }//fin insertar
    public void borradoBin(int valor){
        raiz = borradoBinRecursivo(raiz,valor);
    }
    
    private Nodobinclass borradoBinRecursivo(Nodobinclass n, int valor){
        
        if(n == null){
            return n;
        }
        
        if(valor < n.getContenido()){
            n.setHijoIzquierdo(borradoBinRecursivo(n.getHijoIzquierdo(),valor));
        }else if(valor > n.getContenido()){
            n.setHijoDerecho(borradoBinRecursivo(n.getHijoDerecho(),valor));
        }else{
            if(n.getHijoIzquierdo() == null){
                return n.getHijoDerecho();
            }else if (n.getHijoDerecho() == null){
                return n.getHijoIzquierdo();
            }
            n.setContenido(getMinSubArbol(n.getHijoDerecho()));
            n.setHijoDerecho(borradoBinRecursivo(n.getHijoDerecho(),n.getContenido()));
        }
    
        return n;
    }
    
    private int getMinSubArbol(Nodobinclass n){
        int menor = n.getContenido();
        while(n.getHijoIzquierdo() != null){
            menor =  n.getHijoIzquierdo().getContenido();
            n = n.getHijoIzquierdo();
        }
        return menor;
    }
    
    
    //sobre carga
    public void preOrdenRecursivo(){
        preOrdenRecursivo(raiz);
        System.out.println("");
    }
    
    
    public void preOrdenRecursivo(Nodobinclass actual){
            //procesar nodo
            System.out.print(actual.getContenido()+",");
            if(actual.getHijoIzquierdo() != null){
                preOrdenRecursivo(actual.getHijoIzquierdo());
            }
            
            if(actual.getHijoDerecho() != null){
                preOrdenRecursivo(actual.getHijoDerecho());
            }
    }
    
    
    //sobre carga
    public void inOrdenRecursivo(){
        inOrdenRecursivo(raiz);
        System.out.println("");
    }
    
    
    public void inOrdenRecursivo(Nodobinclass actual){
            
            if(actual.getHijoIzquierdo() != null){
                inOrdenRecursivo(actual.getHijoIzquierdo());
            }
            //procesar nodo
            System.out.print(actual.getContenido()+",");
            if(actual.getHijoDerecho() != null){
                inOrdenRecursivo(actual.getHijoDerecho());
            }
    }    
    

    //sobre carga
    public void posOrdenRecursivo(){
        posOrdenRecursivo(raiz);
        System.out.println("");
    }
    
    
    public void posOrdenRecursivo(Nodobinclass actual){
            
            if(actual.getHijoIzquierdo() != null){
                posOrdenRecursivo(actual.getHijoIzquierdo());
            }
            if(actual.getHijoDerecho() != null){
                posOrdenRecursivo(actual.getHijoDerecho());
            }
            //procesar nodo
            System.out.print(actual.getContenido()+",");
            
    }
    public int getAltura(){
        return getAltura(raiz);
    }
    
    private int getAltura(Nodobinclass n){
        if(n == null){
            return 0;
        }else{
            int altIzq = getAltura(n.getHijoIzquierdo());
            int atlDer = getAltura(n.getHijoDerecho());
            //debe obtener el max
            if(altIzq>atlDer){
                return altIzq+1; 
            }else{
                return atlDer+1; 
            }
        }
    }
    
    public void niveles(){
        Nodobinclass n = raiz;
        int  numN = getAltura(n);
        for (int i = 1; i <= numN; i++) {
            System.out.println("Nivel:"+i);
            nivelRecursivo(n,i);
        }
    }
    
    public void nivelRecursivo(Nodobinclass n,int nvl){
        if(n==null){
            
        }else if(nvl ==1){
            System.out.println(n.getContenido()+",");
        }else{
            nivelRecursivo(n.getHijoIzquierdo(),nvl-1);
            nivelRecursivo(n.getHijoDerecho(),nvl-1);
        }
    }
    //Metodo para buscar un elemento del arbol Avl
    public void buscar(int dato){
        int x=0;
            buscar(dato,raiz,x);            
    }
    public Nodobinclass buscar(int dato, Nodobinclass s,int numcom) {
        
        if (s == null) {
            System.out.println("No se encotro el dato");
            return null;
        } else if (s.getContenido() == dato) {
            System.out.println("Dato encontrado---> "+dato);
            System.out.println("El numero de comparaciones--->  " +numcom);
            return s;
        } else if (s.getContenido() < dato) {
            return buscar(dato, s.getHijoDerecho(),numcom++);
        } else {
            numcom++;
            return buscar(dato, s.getHijoIzquierdo(),numcom++);
        }
    }
    //--------------------------------------------
    
    
}
