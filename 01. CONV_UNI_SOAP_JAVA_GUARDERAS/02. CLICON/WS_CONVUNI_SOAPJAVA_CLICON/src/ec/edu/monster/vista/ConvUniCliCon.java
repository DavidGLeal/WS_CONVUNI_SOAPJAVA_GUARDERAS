/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.monster.vista;

import ec.edu.monster.controlador.ConvUniControlador;
import ec.edu.monster.controlador.LogInControlador;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author USER
 */
public class ConvUniCliCon {

    private static Scanner scan = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        logIn();
    }
    
    private static void logIn() throws IOException{
        try {
            limpiar();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConvUniCliCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        LogInControlador controlador = new LogInControlador();
        
        boolean res = false;
        for(int i = 0; i<3;i++){
            String us = "";
            String ps = "";

            System.out.print("Usuario: ");
            us = scan.nextLine();
            System.out.print("Contraseña: ");
            ps = new String(System.console().readPassword());

            res = controlador.verificar(us, ps);

            if(res){
                menuPrincipal();
                break;
            }else{
                System.out.println("Usuario y/o contraseña incorrectos.");
                continue;
            }
        }
        
        if(!res){
            System.out.println("Excedió el número de intentos.");
            System.out.println("Cerrando sistema.");
            System.exit(0);
        }
        
    }
    
    private static void menuPrincipal() throws IOException{
        
        boolean salir = false;
        try {
            limpiar();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConvUniCliCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\t\t\t\tCONVERSOR DE UNIDADES (SOAP - JAVA)");
        System.out.println("\n---------------------------------------------------");
        do{
            
            System.out.println("\nElija una opción:\n");
            System.out.println("1. Kg a Lb");
            System.out.println("2. Lb a Kg");
            System.out.println("3. Salir");
            System.out.print("=> ");
            try{
                int op = scan.nextInt();
                switch(op){
                    case 1: {
                        converKgLb();
                        break;
                    }case 2:{
                        converLbKg();
                        break;
                    }case 3: {
                        salir = true;
                        break;
                    }default:{
                        System.out.println("Opción inválida. vuelva a intentar.");
                        break;
                    }
                }
            }catch(InputMismatchException e){
                System.out.println("Opción inválida. vuelva a intentar.");
                
            }
            
        }while(!salir);
        
    }
    
    private static void converKgLb() throws IOException{
        ConvUniControlador controlador = new ConvUniControlador();
        try {
            limpiar();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConvUniCliCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\t\t\t\t(KG -> LB)\n");
        System.out.println("\n---------------------------------------------------\n");
        System.out.print("Ingrese la cantidad en Kg => ");
        
        boolean valida = false;
        double kg = 0;
        while(!valida){
            try{
                kg = scan.nextDouble();
                valida = true;
            }catch(InputMismatchException e){
                System.out.println("Entrada no válida. Vuelva a ingresar.\n");
                System.out.print("=> ");
                scan.next();
            }
        }
    
        double respuesta = controlador.convKgLb(kg);
        
        if(respuesta == -1){
            System.out.println("Error: El servicio web no está disponible o falló la conexión.");
            System.exit(1);
        }
        if(respuesta == -2){
            System.out.println("Se produjo un error inesperado.");
            System.exit(1);
        }
        
        System.out.println("\n"+kg+"Kg = "+respuesta+"lb");
        
        int op = postMenu();
        try {
            limpiar();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConvUniCliCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(op == 1){
            converKgLb();
        }else{
            return;
        }
    }
    
    private static void converLbKg() throws IOException{
        ConvUniControlador controlador = new ConvUniControlador();
        try {
            limpiar();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConvUniCliCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\t\t\t\t(LB -> KG)\n");
        System.out.println("\n---------------------------------------------------\n");
        System.out.print("Ingrese la cantidad en lb => ");
        
        boolean valida = false;
        double lb = 0;
        while(!valida){
            try{
                lb = scan.nextDouble();
                valida = true;
            }catch(InputMismatchException e){
                System.out.println("Entrada no válida. Vuelva a ingresar.\n");
                System.out.print("=> ");
                scan.next();
            }
        }
    
        double respuesta = controlador.convLbKg(lb);
        System.out.println("\n"+lb+"lb = "+respuesta+"Kg");
        
        int op = postMenu();
        try {
            limpiar();
        } catch (InterruptedException ex) {
            Logger.getLogger(ConvUniCliCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(op == 1){
            converLbKg();
        }else{
            return;
        }
    }
    
    private static int postMenu(){
        System.out.println("\n¿Qué desea hacer a continuación?\n");
        System.out.println("1. Convertir de nuevo.\n");
        System.out.println("2. Regresar\n");
        System.out.print("=> ");
        
        boolean valida = false;
        int op = 0;
        while(!valida){
            try{
                op = scan.nextInt();
                if(op > 2 || op < 1){
                    throw new InputMismatchException();
                }else{
                    valida = true;
                }
            }catch(InputMismatchException e){
                System.out.println("Opción inválida. vuelva a intentar.");
                
                System.out.print("=> ");
                scan.next();
            }
        }
        return op;
    }
    
    private static void limpiar() throws IOException, InterruptedException{
        try{
            if(System.getProperty("os.name").toLowerCase().contains("win")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else{
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
