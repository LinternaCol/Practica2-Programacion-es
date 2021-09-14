/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploarboles;

import java.util.Stack;

/**
 *
 * @author s216e15
 */
public class ControlArbol {
    
    private Nodo raiz;
    
    public void insertarBin(int valor){
        Nodo n = new Nodo(valor);
        if(raiz == null){
            raiz = n;
        }else{
            Nodo actual = raiz;
            Nodo anterior = null;
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
    
    private Nodo borradoBinRecursivo(Nodo n, int valor){
        
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
    
    private int getMinSubArbol(Nodo n){
        int menor = n.getContenido();
        while(n.getHijoIzquierdo() != null){
            menor =  n.getHijoIzquierdo().getContenido();
            n = n.getHijoIzquierdo();
        }
        return menor;
    }
    
    public void insertar(int valor){
        Nodo n = new Nodo(valor);
        if(raiz == null){
            raiz = n;
        }else{
            Nodo actual = raiz;
            Nodo anterior = null;
            
            while(actual != null){
                anterior = actual;
                if(actual.getHijoIzquierdo() == null){
                    actual = actual.getHijoIzquierdo();
                }else{
                    if(actual.getHijoDerecho()== null){
                        actual = actual.getHijoDerecho();
                    }else{
                        actual = actual.getHijoIzquierdo();
                    }
                }
            }//end while
            if(anterior.getHijoIzquierdo() == null){
                anterior.setHijoIzquierdo(n);
            }else if(anterior.getHijoDerecho() == null){
                anterior.setHijoDerecho(n);
            } 
        }
        
    }//fin insertar
    
    public void preOrdenIterativo(){
        Stack<Nodo> pila = new Stack<>();
        Nodo actual = raiz;
        pila.push(actual);
        
        while(!pila.isEmpty()){
            
            //procesar nodo
            System.out.print(actual.getContenido()+",");
            if(actual.getHijoDerecho() != null){
                //guardo el hijo derecho para despues
                pila.push(actual.getHijoDerecho()); // apilando
            }
            
            if(actual.getHijoIzquierdo() != null){
                actual = actual.getHijoIzquierdo();
            }else{
                actual = pila.pop(); // desapilando
            }
            
        }
        System.out.println("");
    }
    
    //sobre carga
    public void preOrdenRecursivo(){
        preOrdenRecursivo(raiz);
        System.out.println("");
    }
    
    
    public void preOrdenRecursivo(Nodo actual){
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
    
    
    public void inOrdenRecursivo(Nodo actual){
            
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
    
    
    public void posOrdenRecursivo(Nodo actual){
            
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
    
    private int getAltura(Nodo n){
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
        Nodo n = raiz;
        int  numN = getAltura(n);
        for (int i = 1; i <= numN; i++) {
            System.out.println("Nivel:"+i);
            nivelRecursivo(n,i);
        }
    }
    
    public void nivelRecursivo(Nodo n,int nvl){
        if(n==null){
            
        }else if(nvl ==1){
            System.out.println(n.getContenido()+",");
        }else{
            nivelRecursivo(n.getHijoIzquierdo(),nvl-1);
            nivelRecursivo(n.getHijoDerecho(),nvl-1);
        }
    }
    
}
