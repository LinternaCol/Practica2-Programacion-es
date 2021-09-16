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
public class Menu {
    
    //Declaracion de variables 
    private final ControlArbolbin coAborlbin= new ControlArbolbin();
    private final ControlArbolAvl coAborlavl= new ControlArbolAvl();
    private final NumerosAleatorios numa= new NumerosAleatorios();
    int Tomadeci=1;
    private final Scanner scan= new Scanner(System.in);
    int llenado=0;
    int ordenar=0;
    //-----------------------------------------------
    //MENU
    public void Menu(){ 
        while(Tomadeci!=0){
            //Bienvenida al programa
            System.out.println("----|-----|-------|---|----|-----|------|----|----");
            System.out.println("Bienvenido al programa de comparacion");
            System.out.println("-----------------------------------------------");
            System.out.println("Presione el numero de extension sino  lo conoce presione"
                    + " 2 para acceder al menu");
            System.out.println("-----------------------------------------------");
            Tomadeci= Integer.parseInt(scan.nextLine());
            // ---------------------------------------------------------------
            // Mostrar el menu
            if(Tomadeci==2){
                System.out.println("----------------------------------------");
                System.out.println("Bienvenido al menu");
                System.out.println("-----------------------------------------");
                System.out.println("Las opciones son :");
                System.out.println("-----------------------------------------");
                System.out.println("Opcion 0 Cerrar el programa");
                System.out.println("-----------------------------------------");
                System.out.println("Opcion 2 Menu");
                System.out.println("-----------------------------------------");
                System.out.println("Opcion 3  Llenar el arbol Binario de busqueda y el arbol Avl");
                System.out.println("-----------------------------------------");
                System.out.println("Opcion 4 Buscar datos en el arbol binario");
                System.out.println("--------------------------------------------");
                System.out.println("Opcion 5 Imprimir los datos por niveles");
                System.out.println("-------------------------------------------");
                System.out.println("Opcion 6 buscar datos en el arbol AVL");
                System.out.println("---------------------------------------------");
                System.out.println("Opcion 7 Imprimir los arboles en inorden");
                System.out.println("---------------------------------------------");
                System.out.println("Opcion 8 eliminar un dato de los arboles");
                System.out.println("-----------------------------------------------");
            }
            //------------------------------------------
            
            //Opcion 3 Llenar la lista doblemente enlazada
            if(Tomadeci==3){ 
                if(llenado==0){  
                    //LLamada a llenar los numeros aleatorios
                    numa.llenar(coAborlbin,coAborlavl);
                    System.out.println("Arboles llenados");
                    System.out.println("--------------------------");
                    llenado++;
                    //------------------------------------
                }else {
                    System.out.println("Ya llenaste los arboles previamente");
                    System.out.println("--------------------------");
                }
            }
            //-----------------------------------------------------
            
            //Opcion 4 Buscar un dato arbol  bin
            if(Tomadeci==4){
                if(llenado!=0){ 
                   int dato;
                   System.out.println("digete dato a buscar");
                   dato =  Integer.parseInt(scan.nextLine());
                   coAborlbin.buscar(dato);
                   System.out.println("----------------------------");  
                }
                else{
                    System.out.println(" Primero llena los arboles");
                }
                
                
            }
            //----------------------------------------------------------
            
            //Opcion 5 Ordenar  la lista
            if(Tomadeci== 5){
                if(llenado!=0){
                    int opc;
                    System.out.println("Presione 1 siquiere imprimir por niveles el arbol bin o 2 el arbol Avl");
                    opc= Integer.parseInt(scan.nextLine());
                    if(opc==1){
                        System.out.println("Arbol Bin------");
                       coAborlbin.niveles();
                       System.out.println("-----------------");
                    }if(opc==2){
                       System.out.println("Arbol Avl------");
                       coAborlavl.niveles();
                       System.out.println("-----------------"); 
                    }
                }else{
                    System.out.println("Error la lista se encuentra vacia");
                }
                
            }
            
            //----------------------------------------------------------
            
            //Opcion 6 buscar dato en el arbol avl
            if(Tomadeci== 6){
                if(ordenar==1){
                   int dato;
                   System.out.println("digete dato a buscar");
                   dato =  Integer.parseInt(scan.nextLine());
                   coAborlavl.buscar(dato);
                   System.out.println("----------------------------");
                    
                }else{
                    System.out.println(" Primero llena los arboles");
                }       
            }
            //----------------------------------------------------------------------------------
            //opcion 7 mostrar inorden los arboles
            if(Tomadeci==7){
                if(llenado!=0){
                    System.out.println("Arbol Avl------");
                    coAborlavl.Preorden();
                    System.out.println("-----------------");
                    System.out.println("Arbol Bin------");
                    coAborlbin.inOrdenRecursivo();
                    System.out.println("-----------------");
                }else{
                    System.out.println("Error la lista se encuentra vacia");
                }
                
            }
            //----------------------------
            if(Tomadeci== 8){
                if(llenado!=0){
                    int opc;
                    System.out.println("Presione 1 siquiere eliminar del arbol bin o 2 el arbol Avl");
                    opc= Integer.parseInt(scan.nextLine());
                    if(opc==1){
                        System.out.println("Arbol Bin------");
                        int dato;
                       System.out.println("digete dato a eliminar");
                       dato =  Integer.parseInt(scan.nextLine());
                       coAborlbin.borradoBin(dato);
                       System.out.println("-----------------");
                    }if(opc==2){
                       System.out.println("Arbol Avl------");
                       int dato;
                       System.out.println("digete dato a eliminar");
                       dato =  Integer.parseInt(scan.nextLine());
                       coAborlavl.eliminar(dato);
                       System.out.println("-----------------"); 
                    }
                }else{
                    System.out.println("Error la lista se encuentra vacia");
                }
                
            }
        }
        //Despedida del programa
        if(Tomadeci==0){
            System.out.println("Garcias por utlizar este programa");
            System.out.println("----------------------------------");
            System.out.println("Santiago Soto,Juan Pablo Suarez Perdomo");
        }
        //----------------------------------------------------------
    }
    //------------------------------------------------------------------------------

}
