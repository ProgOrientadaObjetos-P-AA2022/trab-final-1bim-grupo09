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
                for(int i = 0; i<barrio.size();i++){
                    setRegistro(barrio.get(i));
                    setSalida();
                }
            }
        } catch (IOException IOexception) {
            System.out.println("A ocurrio un error al abrir el archivo");;
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

    public void setBarrio(ArrayList<Barrio> barrio) {this.barrio = barrio;}

    public String getNomArchivo() {return nomArchivo;}

    public ObjectOutputStream getSalida() {return salida;}

    public Barrio getRegistro() {return registro;}

    public ArrayList<Barrio> getBarrio() {return barrio;}

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
