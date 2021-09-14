/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploarboles;

/**
 *
 * @author s216e15
 */
public class EjemploArboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        ControlArbol carbol = new ControlArbol();
        
        
        carbol.insertar(23);
        carbol.insertar(55);
        carbol.insertar(28);
        carbol.insertar(16);
        carbol.insertar(39);
        carbol.insertar(85);
        carbol.insertar(1);
        
        System.out.println("altura:"+carbol.getAltura());
        
//        carbol.preOrdenIterativo();
        System.out.println("in>orden----------------------------");
        carbol.inOrdenRecursivo();
//        System.out.println("----------------------------");
//        carbol.posOrdenRecursivo();
        System.out.println("----------------------------");
        carbol.niveles();
        
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println("***************************************");
        
        ControlArbol carbolBin = new ControlArbol();
        
        
        carbolBin.insertarBin(23);
        carbolBin.insertarBin(55);
        carbolBin.insertarBin(28);
        carbolBin.insertarBin(16);
        carbolBin.insertarBin(39);
        carbolBin.insertarBin(85);
        carbolBin.insertarBin(1);
        carbolBin.insertarBin(109);
        carbolBin.insertarBin(74);
        carbolBin.insertarBin(70);
        carbolBin.insertarBin(79);

        System.out.println("in>orden----------------------------");
        carbolBin.inOrdenRecursivo();
        
        System.out.println("----------------------------");
        carbolBin.niveles();
        
        carbolBin.borradoBin(55);
        
        System.out.println("----------------------------");
        carbolBin.niveles();
        
        
    }
    
}
