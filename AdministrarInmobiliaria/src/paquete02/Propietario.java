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
public class Propietario {

    private String nombre;
    private String apellido;
    private String identificaion;

    public Propietario(String nombres, String apellidos, String identificaion) {
        this.nombre = nombres;
        this.apellido = apellidos;
        this.identificaion = identificaion;
    }

    public void setNombres(String nombres) {
        this.nombre = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellido = apellidos;
    }

    public void setIdentificaion(String identificaion) {
        this.identificaion = identificaion;
    }

    public String getNombres() {
        return nombre;
    }

    public String getApellidos() {
        return apellido;
    }

    public String getIdentificaion() {
        return identificaion;
    }
}
