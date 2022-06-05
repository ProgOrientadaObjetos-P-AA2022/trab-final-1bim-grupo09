package paquete01;

import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;
import paquete06.*;

import java.util.Scanner;

/**
 *
 * @author reroes
 */
public class Ejecutor {
    Scanner entrada = new Scanner(System.in);
    public int menu (){
        int opc;
        System.out.println("Ingrese los datos de la casa :                   [1]");
        System.out.println("Ingrese los datos del departamento :             [2]");
        System.out.println("Ingrese los datos del propietario :              [3]");
        System.out.println("Ingrese los datos del barrio :                   [4]");
        System.out.println("Ingrese los datos de la ciudad :                 [5]");
        System.out.println("Ingrese los datos de la constructora :           [6]");
        System.out.println("Prsentar los datos :                             [7]");
        System.out.println("Salir :                                          [0]");
        opc = entrada.nextInt();
        return opc;
    }

    public int menu2 (){
        int opc;
        System.out.println("Prsentar los datos de la casa :                  [1]");
        System.out.println("Prsentar los datos del departamento :            [2]");
        System.out.println("Prsentar los datos del propietario :             [3]");
        System.out.println("Prsentar los datos del barrio :                  [4]");
        System.out.println("Prsentar los datos de la ciudad :                [5]");
        System.out.println("Prsentar los datos de la constructora :          [6]");
        System.out.println("Volver :                                         [0]");
        opc = entrada.nextInt();
        return opc;
    }

    public static Propietario localizarP(){

        Scanner entrada = new Scanner(System.in);
        String id, nom,ape;
        String nomArchivo = "datos/propietario.dat";
        System.out.println("Ingrese la identificaion del propietario : ");
        id = entrada.nextLine();
        Propietario pLocalizado;
        //Enviamos las informacion al archivo LeerPropietario.java
        LeerPropietario leerP = new LeerPropietario(nomArchivo);
        leerP.setIdentificador(id);
        leerP.setBuscarP();
        pLocalizado = leerP.getBuscarP();
        if(pLocalizado != null){
            System.out.printf("Propietario localizado %s \n", pLocalizado);
            return pLocalizado;
        }else{
            System.out.println("Propietario no localizado,\n" +
                    "Ingrese los datos des un nuevo proietario");
            System.out.println("Ingrese el nombre del propietario");
            nom=entrada.nextLine();
            System.out.println("Ingrese el apellido del propietario");
            ape = entrada.nextLine();
            System.out.println("Ingrese la identificaion del propietario");
            id=entrada.nextLine();
            //Aqui envaimos los datos ingresados al archvio Propietario.java y usamos el constructor Propietario
            Propietario propietario = new Propietario(nom,ape,id);
            //Aqui enviamos los datos al archvio propietario.dat
            EscribirPropietario escribirP = new EscribirPropietario(nomArchivo);
            escribirP.setRegistro(propietario);
            escribirP.setSalida();
            return propietario;

        }
    }

    /*public static Ciudad localizarC(){

        Scanner entrada = new Scanner(System.in);
        String nomC, nomP;
        String nomArchivo = "datos/ciudad.dat";

    }*/

    public static void main(String[] args) {


        /*
        Propietario pro = new Propietario();
        Barrio ba = new Barrio();
        Ciudad ci = new Ciudad();
        Constructora cons = new Constructora();
        Departamento de = new Departamento();
        */

    }
    
}
