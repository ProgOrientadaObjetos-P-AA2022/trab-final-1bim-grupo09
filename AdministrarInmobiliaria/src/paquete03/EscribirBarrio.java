package paquete03;
import java.io.*;
import java.util.*;

public class EscribirBarrio {

    private String nomArchivo;
    private ObjectOutputStream salida;
    private Barrio registro;
    private ArrayList<Barrio> barrio;

    public EscribirBarrio(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        getBarrio();
        try{
            //Aqui declaramos a salida como el archvio barrio.dat
            salida = new ObjectOutputStream(new FileOutputStream(nomArchivo));
            if(barrio.size()>0){
                for (Barrio value : barrio) {
                    setRegistro(value);
                    setSalida();
                }
            }
        } catch (IOException IOexception) {
            System.out.println("A ocurrio un error al abrir el archivo");
        }
    }

    public void setNomArchivo(String nomArchivo) {this.nomArchivo = nomArchivo;}

    public void setSalida() {
        //Aqui enviamos la informacion del registro al archivo propiestario.dat
        try{
            salida.writeObject(registro);
        } catch (Exception e) {
            System.out.println("A ocurrido un error al ecribir en el archivo");
            throw new RuntimeException(e);
        }
    }

    public void setRegistro(Barrio registro) {this.registro = registro;}

    public String getNomArchivo() {return nomArchivo;}

    public void getBarrio() {
        LeerBarrio ba = new LeerBarrio(nomArchivo);
        ba.setBarrio();
        barrio = ba.getBarrio();
    }

    public void errorArchivo(){
        //Aqui presentamos si esque hubo algun error al escribir en el erchivo
        try{
            if(salida!=null){
                salida.close();
            }
        } catch (Exception e) {
            System.out.println("A ocurrido un error al cerra el archivo");
            throw new RuntimeException(e);
        }
    }
}
