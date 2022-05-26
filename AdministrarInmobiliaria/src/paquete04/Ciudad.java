/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;

/**
 *
 * @author reroes
 */
public class Ciudad {

    private String nombreC;
    private String nombreP;

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
}
