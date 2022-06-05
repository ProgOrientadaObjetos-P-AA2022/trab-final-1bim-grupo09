/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete05;

/**
 *
 * @author reroes
 */
public class Constructora {

    private String nomConstructora;
    private String idEmpresa;

    public Constructora(String nomConstructora, String idEmpresa) {
        this.nomConstructora = nomConstructora;
        this.idEmpresa = idEmpresa;
    }

    public void setNomConstructora(String nomConstructora) {
        this.nomConstructora = nomConstructora;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomConstructora() {
        return nomConstructora;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }
}
