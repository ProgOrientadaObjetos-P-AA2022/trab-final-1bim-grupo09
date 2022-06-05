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
                    "Ingrese los datos de un nuevo proietario");
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

    public static Barrio localizarB(){

        Scanner entrada = new Scanner(System.in);
        String nomB, referencia;
        String nomArchivo = "datos/barrio.dat";
        System.out.println("Ingrese el nombre del Barrio");
        nomB=entrada.nextLine();
        Barrio bLocalizado;
        LeerBarrio leerB = new LeerBarrio(nomArchivo);
        leerB.setIdentificador(nomArchivo);
        leerB.setBuscarB();
        bLocalizado = leerB.getBuscarB();
        if(bLocalizado != null){
            System.out.printf("Barrio encontrado %s\n",bLocalizado);
            return bLocalizado;
        }else{
            System.out.println("Barrio no localizado,\n" +
                    "Ingrese los datos de un nuevo barrio");
            System.out.println("Ingrese el nombre del barrio");
            nomB=entrada.nextLine();
            System.out.println("Ingrese una referencia del barrio");
            referencia = entrada.nextLine();
            //Aqui envaimos los datos ingresados al archvio Propietario.java y usamos el constructor Barrio
            Barrio barrio = new Barrio(nomB,referencia);
            //Aqui enviamos los datos al archvio barrio.dat
            EscribirBarrio escribirB = new EscribirBarrio(nomArchivo);
            escribirB.setRegistro(barrio);
            escribirB.setSalida();
            return barrio;
        }

    }

    public static Ciudad localizarC(){

        Scanner entrada = new Scanner(System.in);
        String nomC, nomP;
        String nomArchivo = "datos/ciudad.dat";
        System.out.println("Ingrese el nombre de la Ciudad");
        nomC = entrada.nextLine();
        Ciudad cLocalizada;
        LeerCiudad leerC = new LeerCiudad(nomArchivo);
        leerC.setIdentificador(nomC);
        leerC.setBuscarC();
        cLocalizada = leerC.getBuscarC();
        if(cLocalizada != null){
            System.out.printf("Ciudad localizada %s\n",cLocalizada);
            return cLocalizada;
        }else{
            System.out.println("Ciudad no localizada,\n" +
                    "Ingrese los datos de una nueva ciudad");
            System.out.println("Ingrese el nombre de la ciudad: ");
            nomC = entrada.nextLine();
            System.out.println("Ingrese el nombre de la provincia: ");
            nomP = entrada.nextLine();
            Ciudad ciu = new Ciudad(nomC, nomP);
            EscribirCiudad escribirciu = new EscribirCiudad(nomArchivo);
            escribirciu.setRegistro(ciu);
            escribirciu.setSalida();
            return ciu;
        }
    }

    public static Constructora localizarCons(){

        Scanner entrada = new Scanner(System.in);
        String nomConstructora,idEmpresa;
        String nomArchivo = "datos/constructora.dat";
        System.out.println("Ingrese la identificaion del propietario : ");
        idEmpresa = entrada.nextLine();
        Constructora consLocalizado;
        //Enviamos las informacion al archivo LeerPropietario.java
        LeerConstructora leerCons = new LeerConstructora(nomArchivo);
        leerCons.setIdentificar(idEmpresa);
        leerCons.setBuscarCons();
        consLocalizado = leerCons.getBuscarCons();
        if(consLocalizado != null){
            System.out.printf("Propietario localizado %s \n", consLocalizado);
            return consLocalizado;
        }else{
            System.out.println("Propietario no localizado,\n" +
                    "Ingrese los datos de un nuevo proietario");
            System.out.println("Ingrese el nombre de la constructora");
            nomConstructora=entrada.nextLine();
            System.out.println("Ingrese la identificaion de la constructora");
            idEmpresa=entrada.nextLine();
            //Aqui envaimos los datos ingresados al archvio Propietario.java y usamos el constructor Propietario
            Constructora constructora = new Constructora(nomConstructora,idEmpresa);
            //Aqui enviamos los datos al archvio propietario.dat
            EscribirConstructora escribirCons = new EscribirConstructora(nomArchivo);
            escribirCons.setRegistro(constructora);
            escribirCons.setSalida();
            return constructora;

        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String nomEdi;
        String ubicacion;
        Propietario propietario;
        Barrio barrio;
        Ciudad ciudad;
        Constructora constructora;
        double precio, metrosCua;
        int op, Cuartos;
        Ejecutor obj = new Ejecutor();
        System.out.println("Inicio del programa");
        do {
            op = obj.menu();
            switch (op) {
                case 1:
                    propietario = localizarP();
                    barrio = localizarB();
                    ciudad = localizarC();
                    constructora = localizarCons();
                    System.out.println("Ingrese el valor del metro cuadrado: ");
                    precio = entrada.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados de la casa: ");
                    metrosCua = entrada.nextDouble();
                    System.out.println("Ingrese el numero de cuartos de la casa: ");
                    Cuartos = entrada.nextInt();
                    Casa casa = new Casa(precio, metrosCua, Cuartos, propietario, barrio, ciudad, constructora);
                    casa.setCosteC();
                    EscribirCasa archivocasa = new EscribirCasa("datos/casa.dat");
                    archivocasa.setRegistro(casa);
                    archivocasa.setSalida();
                    break;
                case 2:
                    propietario = localizarP();
                    barrio = localizarB();
                    ciudad = localizarC();
                    constructora = localizarCons();
                    System.out.println("Ingrese el precio por metro cuadrado: ");
                    precio = entrada.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados: ");
                    metrosCua = entrada.nextDouble();
                    System.out.println("Ingrese valor alicuota mensual: ");
                    Double valorAlicuota = entrada.nextDouble();
                    entrada.nextLine();
                    System.out.println("Ingrese el nombre del edificio: ");
                    nomEdi = entrada.nextLine();
                    System.out.println("Ingrese la ubicacion en el edificio: ");
                    ubicacion = entrada.nextLine();
                    Departamento departamento = new Departamento(precio, metrosCua, valorAlicuota, nomEdi, ubicacion, propietario, barrio, ciudad, constructora);
                    departamento.setCosteD();
                    EscribirDepartamento archivodepar = new EscribirDepartamento("datos/departamentos.dat");
                    archivodepar.setRegistro(departamento);
                    archivodepar.setSalida();
                    break;
                case 3:
                    System.out.println("Ingrese nombres del propietario: ");
                    String nombresPropietario = entrada.nextLine();
                    System.out.println("Ingrese apellidos del propietario: ");
                    String apellidosPropietario = entrada.nextLine();
                    System.out.println("Ingrese identificacion del propietario(dni): ");
                    String identificacionPropietario = entrada.nextLine();
                    propietario = new Propietario(nombresPropietario, apellidosPropietario, identificacionPropietario);
                    EscribirPropietario archivop = new EscribirPropietario("datos/propietarios.dat");
                    System.out.println(propietario);
                    archivop.setRegistro(propietario);
                    archivop.setSalida();
                    break;
                case 4:
                    System.out.println("Ingrese nombre del barrio: ");
                    String nombre = entrada.nextLine();
                    System.out.println("Ingrese referencia del barrio: ");
                    String referencia = entrada.nextLine();
                    barrio = new Barrio(nombre, referencia);
                    EscribirBarrio archivob = new EscribirBarrio("datos/barrios.dat");
                    System.out.println(archivob.toString());
                    archivob.setRegistro(barrio);
                    archivob.setSalida();
                    break;
                case 5:
                    System.out.println("Ingrese nombre de la ciudad: ");
                    String nombreCiudad = entrada.nextLine();
                    System.out.println("Ingrese nombre de la provincia: ");
                    String provincia = entrada.nextLine();
                    ciudad = new Ciudad(nombreCiudad, provincia);
                    EscribirCiudad archivociu = new EscribirCiudad("datos/ciudades.dat");
                    archivociu.setRegistro(ciudad);
                    archivociu.setSalida();
                    break;
                case 6:

                    System.out.println("Ingrese nombre de la constructora: ");
                    String nombreConstructora = entrada.nextLine();
                    System.out.println("Ingrese id de la constructora:");
                    String idEmpresa = entrada.nextLine();
                    Constructora c1 = new Constructora(nombreConstructora, idEmpresa);
                    EscribirConstructora archivocons = new EscribirConstructora("datos/constructoras.dat");
                    archivocons.setRegistro(c1);
                    archivocons.setSalida();
                    break;
                case 7:
                    do {
                        op = obj.menu2();
                        main2(op);
                    } while (op != 0);
                    op = 7;
                    break;
            }
        } while (op != 0);

    }

    public static void main2 (int op2) {
        switch (op2) {
            case 1:
                LeerCasa leerC = new LeerCasa("datos/casa.dat");
                leerC.setCasa();
                System.out.printf("%s", leerC.toString());
                leerC.errorArchivo();
                break;
            case 2:
                LeerDepartamento leerD = new LeerDepartamento("datos/departamento.dat");
                leerD.setDepartamento();
                System.out.printf("%s", leerD.toString());
                leerD.errorArchivo();
                break;
            case 3:
                LeerPropietario leerP = new LeerPropietario("datos/propietario.dat");
                leerP.setPropietario();
                System.out.printf("%s", leerP.toString());
                leerP.errorArchivo();
                break;
            case 4:
                LeerBarrio leerB = new LeerBarrio("datos/barrio.dat");
                leerB.setBarrio();
                System.out.printf("%s", leerB.toString());
                leerB.errorArchivo();
                break;
            case 5:
                LeerCiudad leerCiu = new LeerCiudad("datos/ciudad.dat");
                leerCiu.setCiudad();
                System.out.printf("%s", leerCiu.toString());
                leerCiu.errorArchivo();
                break;
            case 6:
                LeerConstructora leerCons = new LeerConstructora("datos/constructora.dat");
                leerCons.setConstructora();
                System.out.printf("%s", leerCons.toString());
                leerCons.errorArchivo();
                break;
        }

    }
    
}
