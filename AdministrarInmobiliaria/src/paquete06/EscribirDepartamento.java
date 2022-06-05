package paquete06;

import java.io.*;
import java.util.*;

public class EscribirDepartamento {

    private String nomArchivo;
    private Departamento registro;
    private ObjectOutputStream salida;
    private ArrayList<Departamento> departamento;

    public EscribirDepartamento(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        setDepartamento();
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nomArchivo));
            if(departamento.size()>0){
                for(int i = 0; i < departamento.size(); i++){
                    setRegistro(departamento.get(i));
                    setSalida();
                }
            }
        } catch (Exception e) {
            System.out.println("A ocurrido un error al abrir el archivo");
            throw new RuntimeException(e);
        }
    }

    public void setNombreArchivo(String nomArchivo) {this.nomArchivo = nomArchivo;}

    public void setRegistro(Departamento registro) {this.registro = registro;}

    public void setSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.out.println("A ocurrido un escribir en el archivo");
        }
    }

    public void setDepartamento() {
        LeerDepartamento depa = new LeerDepartamento(nomArchivo);
        depa.setDepartamento();
        this.departamento = depa.getDepartamento();
    }

    public String getNomArchivo() {return nomArchivo;}

    public Departamento getRegistro() {return registro;}

    public ObjectOutputStream getSalida() {return salida;}

    public ArrayList<Departamento> getDepartamento() {return departamento;}

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
