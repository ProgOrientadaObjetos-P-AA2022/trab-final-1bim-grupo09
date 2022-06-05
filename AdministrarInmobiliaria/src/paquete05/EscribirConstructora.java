package paquete05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class EscribirConstructora {

    private String nomArchivo;
    private ArrayList<Constructora> constructora;
    private Constructora registro;
    private final ObjectOutputStream salida;

    public EscribirConstructora(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        setConstructora();
        try{
            salida = new ObjectOutputStream(new FileOutputStream(nomArchivo));
            if(constructora.size()>0){
                for (Constructora value : constructora) {
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

    public void setConstructora() {
        LeerConstructora cons = new LeerConstructora(nomArchivo);
        cons.setConstructora();
        constructora = cons.getConstructora();
    }

    public void setRegistro(Constructora registro) {this.registro = registro;}

    public void setSalida() {
        try{
            salida.writeObject(registro);
        } catch (Exception e) {
            System.out.println("A ocurrido un error al escribir el archivo");
            throw new RuntimeException(e);
        }
    }

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
