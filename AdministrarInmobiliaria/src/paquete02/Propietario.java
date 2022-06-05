/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;
import java.io.*;

/**
 *
 * @author reroes
 */
public class Propietario implements Serializable {

    private String nombre;
    private String apellido;
    private String identificacion;

    public Propietario(String nombres, String apellidos, String identificacion) {
        this.nombre = nombres;
        this.apellido = apellidos;
        this.identificacion = identificacion;
    }

    public void setNombres(String nombres) {this.nombre = nombres;}

    public void setApellidos(String apellidos) {this.apellido = apellidos;}

    public void setIdentificaion(String identificaion) {this.identificacion = identificaion;}

    public String getNombres() {return nombre;}

    public String getApellidos() {return apellido;}

    public String getIdentificaion() {
        return identificacion;
    }

    @Override
    public String toString(){
        String cadena = String.format("%s - %s - %s\n", getNombres(), getApellidos(), getIdentificaion());
        return cadena;
    }
}
