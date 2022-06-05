package paquete02;
import java.io.*;
import java.util.*;

public class EscribirPropietario {

    private String nomAtchivo;
    private ObjectOutputStream salida;
    private Propietario registro;
    private ArrayList<Propietario> propietario;

    public EscribirPropietario(String nomAtchivo) {
        this.nomAtchivo = nomAtchivo;
        setPropietario();
        try{
            //Aqui declaramos a salida como el archvio propietario.dat
            salida = new ObjectOutputStream(new FileOutputStream(nomAtchivo));
            if(propietario.size()>0){
                for(int i =0;i<propietario.size();i++){
                    setRegistro(propietario.get(i));
                    setSalida();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setNomAtchivo(String nomAtchivo) {this.nomAtchivo = nomAtchivo;}

    public void setSalida() {
        //Aqui enviamos la informacion del registro al archivo propiestario.dat
        try{
            salida.writeObject(registro);
        } catch (Exception e) {
            System.out.println("A ocurrio un error al escribir en el archivo");
            throw new RuntimeException(e);

        }
    }

    public void setRegistro(Propietario registro) {this.registro = registro;}

    public void setPropietario() {
        LeerPropietario leerP = new LeerPropietario(nomAtchivo);
        leerP.setPropietario();
        this.propietario = leerP.getPropietario();
    }

    public String getNomAtchivo() {return nomAtchivo;}

    public ObjectOutputStream getSalida() {return salida;}

    public Propietario getRegistro() {return registro;}

    public ArrayList<Propietario> getPropietario() {return propietario;}

    public void errorArchivo(){
        //Aqui presentamos si esque hubo algun error al escribir en el erchivo
        try{
            if(salida != null){
                salida.close();
            }
        } catch (Exception e) {
            System.out.println("A ocurrido un error al cerrar el archivo");
            throw new RuntimeException(e);
        }
    }

}
