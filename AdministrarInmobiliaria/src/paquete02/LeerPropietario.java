package paquete02;
import java.io.*;
import java.util.*;

public class LeerPropietario {

    private String nomArchivo;
    private String identificador;
    private ArrayList<Propietario> propietario;
    private Propietario buscarP;
    private ObjectInputStream entrada;

    public LeerPropietario(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        File archivo = new File(nomArchivo);
        //Aqui verfificamos si el archivo existe y declaramos a entrada como un objeto del archivo Propietario.dat
        if(archivo.exists()){
            try{
                entrada = new ObjectInputStream(new FileInputStream(nomArchivo));
            } catch (IOException e) {
                System.out.println("A ocurrido un error al abrie el archivo");
                throw new RuntimeException(e);
            }
        }
    }

    public void setNomArchivo(String nomArchivo) {this.nomArchivo = nomArchivo;}

    public void setIdentificador(String identificador) {this.identificador = identificador;}

    public void setPropietario() {
        this.propietario = new ArrayList<>();
        File archivo = new File(nomArchivo);
        if(archivo.exists()){
            while (true){
                try {
                    //Aqui decalramos a historial como un objeto de entrada para leerlo y añadir la informacion recibida
                    Propietario historial = (Propietario) entrada.readObject();
                    propietario.add(historial);
                } catch (EOFException endOfFileException) {
                    break;
                } catch (IOException ex) {
                    System.out.println("A ocurrido un error al leer el archivo");
                } catch (ClassNotFoundException ex) {
                    System.out.println("No se pudo crear el objeto" + ex);
                }
            }
        }
    }

    public void setBuscarP() {
        File archivo = new File(nomArchivo);
        while (true){
            if(archivo.exists()){
                try{
                    Propietario historial = (Propietario) entrada.readObject();
                    //Aqui buscamos al propietario en base de la identificaion o cedula
                    if(historial.getIdentificaion().equals(identificador)){
                        buscarP = historial;
                        break;
                    }
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.out.println("A ocurrido un error al leer el archivo");
                } catch (ClassNotFoundException ex) {
                    System.out.println("No se pudo crear el objeto" + ex);
                }
            }
        }
    }


    public String getNomArchivo() {return nomArchivo;}

    public String getIdentificador() {return identificador;}

    public ArrayList<Propietario> getPropietario() {return propietario;}

    public Propietario getBuscarP() {return buscarP;}

    @Override
    public String toString(){
        //Aqui presentamos los propietarios
        String cadena = "Lista de propietarios\n";
        for(int i = 0; i<propietario.size();i++){
            Propietario pro = propietario.get(i);
            cadena = String.format("%s(%d) %s-%s-%s\n", cadena, (i+1),pro.getNombres(),pro.getApellidos(),pro.getIdentificaion());
        }
        return cadena;
    }
}
