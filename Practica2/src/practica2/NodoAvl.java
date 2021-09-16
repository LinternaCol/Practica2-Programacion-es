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
public class NodoAvl {
        private int cont;
        private int fe;
        private NodoAvl hijoizq;
        private NodoAvl hijoder;
        
        
    public NodoAvl(int dato){
    this.setCont(dato);
    this.setFe(0);
    this.setHijoder(null);
    this.setHijoizq(null);
    }
    public void inOrder(){
        if (hijoizq!=null) {
            hijoizq.inOrder();
        }
        System.out.println(cont);
        if (hijoder!=null) {
            hijoder.inOrder();
        }
    }
    public void preOrder(){
        System.out.println(cont);
        if (hijoizq!=null) {
            hijoizq.preOrder();
        }
        
        if (hijoder!=null) {
            hijoder.preOrder();
        }
    }
    public void postOrder(){
        if (hijoizq!=null) {
            hijoizq.postOrder();
        }
        if (hijoder!=null) {
            hijoder.postOrder();
        }
        System.out.println(cont);
    }
    public String texto(){
        if (hijoizq==null&&hijoder==null) {
            return String.valueOf(cont);
        }else{
        String texto="";
            if (hijoizq!=null) {
                texto=cont+"->"+hijoizq.texto()+"\n";
            }
            if (hijoder!=null) {
                texto+=cont+"->"+hijoder.texto()+"\n";
            }
            return texto;
        }
    }
    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public NodoAvl getHijoizq() {
        return hijoizq;
    }

    public void setHijoizq(NodoAvl hijoizq) {
        this.hijoizq = hijoizq;
    }

    public NodoAvl getHijoder() {
        return hijoder;
    }

    public void setHijoder(NodoAvl hijoder) {
        this.hijoder = hijoder;
    }
        
    

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
        
        
}
