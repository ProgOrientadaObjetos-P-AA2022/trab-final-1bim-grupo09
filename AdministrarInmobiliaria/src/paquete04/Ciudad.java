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

    private String nomCiudad;
    private String nomProvincia;

    public Ciudad(String nomCiudad, String nomProvincia) {
        this.nomCiudad = nomCiudad;
        this.nomProvincia = nomProvincia;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    public void setNomProvincia(String nomProvincia) {
        this.nomProvincia = nomProvincia;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public String getNomProvincia() {
        return nomProvincia;
    }
}
