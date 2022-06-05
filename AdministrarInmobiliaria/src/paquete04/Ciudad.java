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

    private final String nombreC;
    private final String nombreP;

    public Ciudad(String nombreC, String nombreP) {
        this.nombreC = nombreC;
        this.nombreP = nombreP;
    }

    public String getNombreC() {
        return nombreC;
    }

    public String getNombreP() {
        return nombreP;
    }

    @Override
    public String toString(){
        return String.format("%s - %s\n",
                getNombreC(),
                getNombreP());
    }

}
