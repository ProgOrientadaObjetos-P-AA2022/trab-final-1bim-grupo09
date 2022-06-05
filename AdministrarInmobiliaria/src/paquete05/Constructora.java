/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete05;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Constructora implements Serializable {

    private final String nomConstructora;
    private final String idEmpresa;

    public Constructora(String nomConstructora, String idEmpresa) {
        this.nomConstructora = nomConstructora;
        this.idEmpresa = idEmpresa;
    }

    public String getNomConstructora() {
        return nomConstructora;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    @Override
    public String toString(){
        return String.format("%s - %s\n", getNomConstructora(), getIdEmpresa());
    }

}
