/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author Santiago
 */
public class ControlArbolAvl {
    
    private NodoAvl raiz;
    public NodoAvl obtRaiz(){
    return raiz;
    }
    //Metodo para buscar un elemento del arbol Avl
    public void buscar(int dato){
        int x=0;
            buscar(dato, raiz,x);            
    }
    public NodoAvl buscar(int dato, NodoAvl s,int numcom) {
        
        if (s == null) {
            System.out.println("Dato no encontrado");
            return null;
        } else if (s.getCont() == dato) {
            System.out.println("Dato encontrado---> "+dato);
            System.out.println("El numero de comparaciones--->  " +numcom);
            return s;
        } else if (s.getCont() < dato) {
            return buscar(dato, s.getHijoder(),numcom++);
        } else {
            return buscar(dato, s.getHijoizq(),numcom++);
        }
    }
    //--------------------------------------------
    
    public int getEqu(NodoAvl nodo) {
        if (nodo == null) {
            return -1;
        } else {
            return nodo.getFe();
        }
        
    }
    //
    public NodoAvl haciaIzq(NodoAvl nodo) {
        NodoAvl aux = nodo.getHijoizq();
        nodo.setHijoizq(aux.getHijoder());
        aux.setHijoder(nodo);
        nodo.setFe(Math.max(getEqu(nodo.getHijoizq()), getEqu(nodo.getHijoder()) + 1));
        aux.setFe(Math.max(getEqu(aux.getHijoizq()), getEqu(aux.getHijoder()) + 1));
        return aux;
    }
    
    public NodoAvl haciaDer(NodoAvl nodo) {
        NodoAvl aux = nodo.getHijoder();
        nodo.setHijoder(aux.getHijoizq());
        aux.setHijoizq(nodo);
        nodo.setFe(Math.max(getEqu(nodo.getHijoizq()), getEqu(nodo.getHijoder()) + 1));
        aux.setFe(Math.max(getEqu(aux.getHijoizq()), getEqu(aux.getHijoder()) + 1));
        return aux;
    }
    
    public NodoAvl doblehaciaIzq(NodoAvl nodo) {
        NodoAvl temp;
        nodo.setHijoizq(haciaDer(nodo.getHijoizq()));
        temp = haciaIzq(nodo);
        return temp;
    }
    
    public NodoAvl doblehaciaDer(NodoAvl nodo) {
        NodoAvl temp;
        nodo.setHijoder(haciaIzq(nodo.getHijoder()));
        temp = haciaDer(nodo);
        return temp;
    }
    //-----------------------------------------------------
    //Insercion AVL
    public NodoAvl insertarAvl(NodoAvl nuevo, NodoAvl ar) {
        NodoAvl nuevoP = ar;
        if (nuevo.getCont() < ar.getCont()) {
            if (ar.getHijoizq() == null) {
                ar.setHijoizq(nuevo);
            } else {
                ar.setHijoizq(insertarAvl(nuevo, ar.getHijoizq()));
                if ((getEqu(ar.getHijoizq()) - getEqu(ar.getHijoder()) == 2)) {
                    if (nuevo.getCont() < ar.getHijoizq().getCont()) {
                        nuevoP = haciaIzq(ar);
                    } else {
                        nuevoP = doblehaciaIzq(ar);
                    }
                }
            }
        } else if (nuevo.getCont() > ar.getCont()) {
            if (ar.getHijoder() == null) {
                ar.setHijoder(nuevo);
            } else {
                ar.setHijoder(insertarAvl(nuevo, ar.getHijoder()));
                if ((getEqu(ar.getHijoder()) - getEqu(ar.getHijoizq()) == 2)) {
                    if (nuevo.getCont()>ar.getHijoder().getCont()) {
                        nuevoP=haciaDer(ar);
                    }else{
                    nuevoP=haciaDer(ar);
                    }
                }
            }
        }else{
            System.out.println("Nodo Duplicado");
        }
        //Actualizando Altura
        if ((ar.getHijoizq()==null)&&(ar.getHijoder()!=null)) {
            ar.setFe(ar.getHijoder().getFe()+1);
        }else if (ar.getHijoder()==null && ar.getHijoizq()!=null) {
            ar.setFe(ar.getHijoizq().getFe()+1);
        }else{
            ar.setFe(Math.max(getEqu(ar.getHijoizq()), getEqu(ar.getHijoder()))+1);
        }
        return nuevoP;
    }
    //Medoto de insertar
    public void insertar(int dato){
        NodoAvl nuevo=new NodoAvl(dato);
        if (raiz==null) {
            raiz=nuevo;
        }else{
            raiz=insertarAvl(nuevo,raiz);
             }
    }
    //Recorridos
    public void enorden(){
        if (raiz==null) {
            System.out.println("No hay datos existentes");
        }else{
            enOrden(raiz);
             }
    }
    public void enOrden(NodoAvl r){
        if (r!=null) {
            enOrden(r.getHijoizq());
            System.out.print(r.getCont()+", ");
            enOrden(r.getHijoder());
        }
    }
    public void Preorden(){
        if (raiz==null) {
            System.out.println("No hay datos existentes");
        }else{
            preOrden(raiz);
             }
    }
    
    public void preOrden(NodoAvl node){
        if (node!=null) {
            System.out.print(node.getCont()+", ");
            preOrden(node.getHijoizq());
            preOrden(node.getHijoder());
        }
    }
    public void postOrden(){
        if (raiz==null) {
            System.out.println("No hay datos existentes");
        }else{
            postOrden(raiz);
             }
    }
    public void postOrden(NodoAvl node){
        if (node!=null) {
            preOrden(node.getHijoizq());
            preOrden(node.getHijoder());
            System.out.print(node.getCont()+", ");
        }
    }
    //------------------------------------------------
    //Impresion por niveles
    public int getAltura(){
        return getAltura(raiz);
    }
    
    private int getAltura(NodoAvl n){
        if(n == null){
            return 0;
        }else{
            int altIzq = getAltura(n.getHijoizq());
            int atlDer = getAltura(n.getHijoder());
            //debe obtener el max
            if(altIzq>atlDer){
                return altIzq+1; 
            }else{
                return atlDer+1; 
            }
        }
    }
    
    public void niveles(){
        NodoAvl n=raiz;
        int  numN = getAltura(n);
        for (int i = 1; i <= numN; i++) {
            System.out.println("Nivel:"+i);
            nivelRecursivo(n,i);
        }
    }
    
    public void nivelRecursivo(NodoAvl n,int nvl){
        if(n==null){
        }else if(nvl ==1){
            System.out.println(n.getCont()+",");
        }else{
            nivelRecursivo(n.getHijoizq(),nvl-1);
            nivelRecursivo(n.getHijoder(),nvl-1);
        }
    }
    //------------------------------
    //Eliminar 
    private NodoAvl nodoMax(NodoAvl node){
    NodoAvl act=node;
    while(act.getHijoder()!=null){
        act=act.getHijoder();
    }
    return act;
    }
     public void eliminar(int dato){
    raiz=eliminarAvl(raiz,dato);
    }
    private NodoAvl eliminarAvl(NodoAvl act, int dato) {
        if (act == null) {
            return act;
        }
        if (dato < act.getCont()) {
            act.setHijoizq(eliminarAvl(act.getHijoizq(), dato));
        } else if (dato > act.getCont()) {
            act.setHijoder(eliminarAvl(act.getHijoder(), dato));
        } else {
            if (act.getHijoizq() == null || act.getHijoder() == null) {
                NodoAvl temp = null;
                if (temp == act.getHijoizq()) {
                    temp = act.getHijoder();
                } else {
                    temp = act.getHijoizq();
                }
                //si no tiene hijos
                if (temp == null) {
                    act = null;//se elimina dejandolo en null
                } else {//con hijo
                    act = temp;//el valor actual toma el valor del hijo
                }
            }else{
            //nodo con dos hijos, se busca el anterior
            NodoAvl temp=nodoMax(act.getHijoizq());
            act.setCont(temp.getCont());
            act.setHijoizq(eliminarAvl(act.getHijoizq(),temp.getCont()));
            }
        }
        int fe=getEqu(act);
        //Rotacion hacia la derecha
        if (fe>1 &&getEqu(act.getHijoizq())>=0) {
            return haciaDer(act);
        }
        //Rotacion Izq
        if (fe<-1&&getEqu(act.getHijoder())<=0) {
            return haciaIzq(act);
        }
        //Rotacion Izq-Derecha
        if (fe>1&&getEqu(act.getHijoizq())<0) {
            act.setHijoizq(haciaIzq(act.getHijoizq()));
            return haciaDer(act);
        }
        //Rotacion Derecha-Izq
        if (fe<-1&&getEqu(act.getHijoder())>0) {
            act.setHijoder(haciaDer(act.getHijoder()));
            return haciaIzq(act);
        }
        return act;
    }
}
