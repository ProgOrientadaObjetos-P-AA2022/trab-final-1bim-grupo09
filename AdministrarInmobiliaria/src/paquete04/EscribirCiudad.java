package paquete04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscribirCiudad {

    private String nomArchivo;
    private Ciudad registro;
    private ArrayList<Ciudad> ciudad;
    private ObjectOutputStream salida;

    public EscribirCiudad(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        setCiudad();
        try{
            salida = new ObjectOutputStream(new FileOutputStream(nomArchivo));
            if(ciudad.size()>0){
                for(int i =0; i<ciudad.size();i++){
                    setRegistro(ciudad.get(i));
                    setSalida();
                }
            }
        } catch (Exception e) {
            System.out.println("A ocurrido un error al abrir el archivo");
            throw new RuntimeException(e);
        }
    }

    public void setNomArchivo(String nomArchivo) {this.nomArchivo = nomArchivo;}

    public void setRegistro(Ciudad registro) {this.registro = registro;}

    public void setCiudad() {
        LeerCiudad ciu = new LeerCiudad(nomArchivo);
        ciu.setCiudad();
        this.ciudad = ciu.getCiudad();
    }

    public void setSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.out.println("A ocurrido un error al escribir en el archivo");
        }
    }

    public String getNomArchivo() {return nomArchivo;}

    public Ciudad getRegistro() {return registro;}

    public ArrayList<Ciudad> getCiudad() {return ciudad;}

    public ObjectOutputStream getSalida() {return salida;}

    public void errorArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        }
        catch (IOException ioException) {
            System.out.println("A ocurrido un error al cerrar el archivo");
        }
    }

}
