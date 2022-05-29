/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

/**
 *
 * @author reroes
 */
public class Propietario {

    private String nombre;
    private String apellido;
    private int identificaion;

    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setApellido (String ape){
        this.apellido=ape;
    }
    public void setId (int id){this.identificaion=id;}

    public String getNombre() {return nombre;}

    public String getApellido() {return apellido;}

    public int getIdentificaion() {return identificaion;}

    public static void main(String[] args) {

    }

}
