package paquete06;

import java.io.*;
import java.util.*;

public class LeerCasa {

    private ArrayList<Casa> casa;
    private ObjectInputStream entarda;
    private String nomArchivo;

    public LeerCasa(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        File archivo = new File(nomArchivo);
        if(archivo.exists()){
            try{
                entarda = new ObjectInputStream(new FileInputStream(nomArchivo));
            } catch (Exception e) {
                System.out.println("A ocurrido un error al abrir el archivo" + e);
                throw new RuntimeException(e);
            }
        }
    }

    public void setCasa() {
        this.casa = new ArrayList<>();
        File archivo = new File(nomArchivo);
        if(archivo.exists()){
            while (true){
                try {
                    Casa historial = (Casa) entarda.readObject();
                    casa.add(historial);
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

    public void setEntarda(ObjectInputStream entarda) {this.entarda = entarda;}

    public void setNomArchivo(String nomArchivo) {this.nomArchivo = nomArchivo;}

    public ArrayList<Casa> getCasa() {return casa;}

    public ObjectInputStream getEntarda() {return entarda;}

    public String getNomArchivo() {return nomArchivo;}

    @Override
    public String toString() {
        String cadena = "Casa\n";
        for(int i = 0;i<casa.size();i++){
            Casa ca = casa.get(i);
            cadena = String.format("%s(%d) Informacion casa:\n"
                    + "PROPIETARIO\n"
                    + "\tNombres: %s Apellidos: %s Identificacion: %s\n"
                    + "DETALLES\n"
                    + "\tPrecio metro cuadrado: %.2f Numero metros Cuadrados: %.2f Numero Cuartos: %d Costo final: %.2f\n"
                    + "BARRIO\n"
                    + "\tNombre barrio: %s Referencia: %s\n"
                    + "CIUDAD\n"
                    + "\tNombre Ciudad: %s Nombre Provincia: %s \n"
                    + "CONSTRUCTORA\n"
                    + "\tNombre Constructora: %s Id Empresa: %s\n", cadena,(i + 1),
                    casa.get(i).getPropietario().getNombres(),
                    casa.get(i).getPropietario().getApellidos(),
                    casa.get(i).getPropietario().getIdentificaion(),
                    casa.get(i).getPrecioC(),
                    casa.get(i).getMetrosC(),
                    casa.get(i).getCuartosC(),
                    casa.get(i).getCosteC(),
                    casa.get(i).getBarrio().getNomBarrio(),
                    casa.get(i).getBarrio().getReferencia(),
                    casa.get(i).getCiudad().getNombreC(),
                    casa.get(i).getCiudad().getNombreP(),
                    casa.get(i).getConstructora().getNomConstructora(),
                    casa.get(i).getConstructora().getIdEmpresa());
        }
        return cadena;
    }

    public void errorArchivo(){
        try{
            if(entarda!=null){
                entarda.close();
            }
        } catch (Exception e) {
            System.out.println("A ocurrido un error al cerrar el archivo");
            throw new RuntimeException(e);
        }
    }

}
