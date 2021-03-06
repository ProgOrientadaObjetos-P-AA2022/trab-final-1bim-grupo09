package paquete06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscribirCasa {

    String nomArchivo;
    private ArrayList<Casa> casa;
    private final ObjectOutputStream salida;
    private Casa registro;

    public EscribirCasa(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        setCasa();
        try{
            salida = new ObjectOutputStream(new FileOutputStream(nomArchivo));
            if(casa.size()>0){
                for (Casa value : casa) {
                    setRegistro(value);
                    setSalida();
                }
            }
        } catch (Exception e) {
            System.out.println("A ocurrido un error al abrir el archivo");
            throw new RuntimeException(e);
        }
    }

    public void setNomArchivo(String nomArchivo) {this.nomArchivo = nomArchivo;}

    public void setCasa() {
        LeerCasa leerCa = new LeerCasa(nomArchivo);
        leerCa.setCasa();
        casa = leerCa.getCasa();
    }

    public void setSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.out.println("A ocurrido un error al escribir en el archivo");
        }
    }

    public void setRegistro(Casa registro) {this.registro = registro;}

    public String getNomArchivo() {return nomArchivo;}

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
