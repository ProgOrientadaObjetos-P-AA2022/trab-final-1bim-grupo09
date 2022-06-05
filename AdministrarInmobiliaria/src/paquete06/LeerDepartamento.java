package paquete06;

import java.io.*;
import java.util.*;

public class LeerDepartamento {

    private String nomArchivo;
    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamento;

    public LeerDepartamento(String nomArchivo) {
        this.nomArchivo = nomArchivo;
    }

    public void setNomArchivo(String nomArchivo) {this.nomArchivo = nomArchivo;}

    public void setEntrada(ObjectInputStream entrada) {this.entrada = entrada;}

    public void setDepartamento(ArrayList<Departamento> departamento) {this.departamento = departamento;}

    public String getNomArchivo() {return nomArchivo;}

    public ObjectInputStream getEntrada() {return entrada;}

    public ArrayList<Departamento> getDepartamento() {return departamento;}
}
