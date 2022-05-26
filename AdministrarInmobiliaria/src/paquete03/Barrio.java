/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

/**
 *
 * @author reroes
 */
public class Barrio {

    private String nombreB;
    private String referencia;

    public void setNombreB (String nomBarrio){
        this.nombreB=nomBarrio;
    }
    public void setReferencia (String ref){
        this.referencia=ref;
    }

    public String getNombreB() {
        return nombreB;
    }

    public String getReferencia() {
        return referencia;
    }
}
