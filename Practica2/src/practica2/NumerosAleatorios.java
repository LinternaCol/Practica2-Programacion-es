/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author Juan Pablo U
 */
public class NumerosAleatorios {
    int [] llenar= new int[10000000];
    
    //metodo para llenar Arbol binario
    public void llenar(ControlArbolbin contenidobin,ControlArbolAvl contenidoavl){
        for (int i = 0; i < 100; i++) {
            int j = llenar[i];
            llenar[i]= (int) (Math.random()*1000000) ;
            contenidobin.insertarBin(llenar[i]);
            contenidoavl.insertar(llenar[i]);
            
        }
    }
    //-------------------------------------------
    
}
