/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Barrio implements Serializable {

    public String nomBarrio;
    public String referencia;

    public Barrio(String nomBarrio, String referencia) {
        this.nomBarrio = nomBarrio;
        this.referencia = referencia;
    }

    public void setNomBarrio(String nomBarrio) {this.nomBarrio = nomBarrio;}

    public void setReferencia(String referencia) {this.referencia = referencia;}

    public String getNomBarrio() {
        return nomBarrio;
    }

    public String getReferencia() {
        return referencia;
    }

    @Override
    public String toString(){
        String cadena = String.format("%s - %s\n", getNomBarrio(), getReferencia());
        return cadena;
    }
}
