/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;
import java.io.*;

/**
 *
 * @author reroes
 */
public class Ciudad implements Serializable {

    private String nombreC;
    private String nombreP;

    public Ciudad(String nombreC, String nombreP) {
        this.nombreC = nombreC;
        this.nombreP = nombreP;
    }

    public void setNombreC (String nomCiudad){
        this.nombreC=nomCiudad;
    }
    public void setNombreP (String nomProvincia){
        this.nombreP=nomProvincia;
    }

    public String getNombreC() {
        return nombreC;
    }

    public String getNombreP() {
        return nombreP;
    }

    @Override
    public String toString(){
        String cadena = String.format("%s - %s\n",
                getNombreC(),
                getNombreP());
        return cadena;
    }

}
