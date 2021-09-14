/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author USUARIO
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables locales
        
        ControlArbolbin carbolBin = new ControlArbolbin();
        NumerosAleatorios llena=new NumerosAleatorios();
        //-------------------------------------------------------
        llena.llenar(carbolBin);
        System.out.println("----------------------------");
        carbolBin.niveles();
        System.out.println("in>orden----------------------------");
        carbolBin.inOrdenRecursivo();
    }
    
}
