/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Scanner;

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
        ControlArbolAvl carbolavl = new ControlArbolAvl();
        NumerosAleatorios llena=new NumerosAleatorios();
        Scanner scan= new Scanner(System.in);
        //-------------------------------------------------------
//        System.out.println("Arbol bin");
//        llena.llenarbin(carbolBin);
//        System.out.println("----------------------------");
//        carbolBin.niveles();
//        System.out.println("in>orden----------------------------");
//        carbolBin.inOrdenRecursivo();
        System.out.println("#####################################");
        System.out.println("Arbol Avl");
        llena.llenarbinAvl(carbolavl);
        carbolavl.enorden();
        System.out.println(""+carbolavl.getAltura());
        carbolavl.niveles();
        
    }
    
}
