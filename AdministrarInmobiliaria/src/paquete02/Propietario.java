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

    private String nombres;
    private String apellidos;
    private String identificaion;

    public Propietario(String nombres, String apellidos, String identificaion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificaion = identificaion;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setIdentificaion(String identificaion) {
        this.identificaion = identificaion;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getIdentificaion() {
        return identificaion;
    }
}
