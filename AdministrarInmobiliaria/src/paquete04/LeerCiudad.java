package paquete04;

import java.io.*;
import java.util.*;

public class LeerCiudad {

    private String nomArchivo;
    private String identificador;
    private Ciudad buscarC;
    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciudad;

    public LeerCiudad(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        File archivo = new File(nomArchivo);
        if(archivo.exists()){
            try{
                entrada = new ObjectInputStream(new FileInputStream(nomArchivo));
            } catch (Exception e) {
                System.out.println("A ocurrido un error al abiir el archivo" + e);
                throw new RuntimeException(e);
            }
        }
    }

    public void setCiudad() {
        this.ciudad = new ArrayList<>();
        File archivo = new File(nomArchivo);
        if (archivo.exists()){
            while (true){
                try{
                    Ciudad historial = (Ciudad) entrada.readObject();
                    ciudad.add(historial);
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

    public void setNomArchivo(String nomArchivo) {this.nomArchivo = nomArchivo;}

    public void setIdentificador(String identificador) {this.identificador = identificador;}

    public void setBuscarC() {
        File archivo = new File(nomArchivo);
        while (true){
            if (archivo.exists()){
                try{
                    Ciudad historial = (Ciudad) entrada.readObject();
                    if(historial.getNombreC().equals(identificador)){
                        buscarC = historial;
                    }
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

    public ArrayList<Ciudad> getCiudad() {return ciudad;}

    public String getNomArchivo() {return nomArchivo;}

    public Ciudad getBuscarC() {return buscarC;}

    @Override
    public String toString(){
        String cadena = "Ciudades\n";
        for(int i =0; i< ciudad.size();i++){
            Ciudad ciu = ciudad.get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena,(i+1),ciu.getNombreC(),ciu.getNombreP());
        }
        return cadena;
    }

    public void errorArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.out.println("A ocurrido un error al cerrar el archivo");
        }
    }

}
