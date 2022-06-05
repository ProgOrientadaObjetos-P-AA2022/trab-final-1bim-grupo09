/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete06;

import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;
import java.io.*;

/**
 *
 * @author reroes
 */
public class Casa implements Serializable {

    private double precioC;
    private double metrosC;
    private double costeC;
    private int cuartosC;
    private Propietario propietario;
    private Barrio barrio;
    private Ciudad ciudad;
    private Constructora constructora;

    public Casa(double precioC, double metrosC, int cuartosC, Propietario propietario, Barrio barrio, Ciudad ciudad, Constructora constructora) {
        this.precioC = precioC;
        this.metrosC = metrosC;
        this.cuartosC = cuartosC;
        this.propietario = propietario;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.constructora = constructora;
    }

    public void setPrecioC(double precioC) {this.precioC = precioC;}

    public void setMetrosC(double metrosC) {this.metrosC = metrosC;}

    public void setCosteC() {
        this.costeC = precioC*metrosC;
    }

    public void setCuartosC(int cuartosC) {this.cuartosC = cuartosC;}

    public void setPropietario(Propietario propietario) {this.propietario = propietario;}

    public void setBarrio(Barrio barrio) {this.barrio = barrio;}

    public void setCiudad(Ciudad ciudad) {this.ciudad = ciudad;}

    public void setConstructora(Constructora constructora) {this.constructora = constructora;}

    public double getPrecioC() {return precioC;}

    public double getMetrosC() {return metrosC;}

    public double getCosteC() {return costeC;}

    public int getCuartosC() {return cuartosC;}

    public Propietario getPropietario() {return propietario;}

    public Barrio getBarrio() {return barrio;}

    public Ciudad getCiudad() {return ciudad;}

    public Constructora getConstructora() {return constructora;}

    @Override
    public String toString(){
        String cadena = String.format("Informacion casa:\n"
                + "PROPIETARIO\n"
                + "Nombres: %s Apellidos: %s Identificacion: %s\n"
                + "Precio metro cuadrado: %.2f Numero metros Cuadrados: %.2f Numero Cuartos: %d Costo final: %.2f\n"
                + "BARRIO\n"
                + "Nombre barrio: %s Referencia: %s\n"
                + "CIUDAD\n"
                + "Nombre Ciudad: %s Nombre Provincia: %s \n"
                + "CONSTRUCTORA\n"
                + "Nombre Constructora: %s Id Empresa: %s\n",
                propietario.getNombres(),
                propietario.getApellidos(),
                propietario.getIdentificaion(),
                precioC,
                metrosC,
                cuartosC,
                costeC,
                barrio.getNomBarrio(),
                barrio.getReferencia(),
                ciudad.getNombreC(),
                ciudad.getNombreP(),
                constructora.getNomConstructora(),
                constructora.getIdEmpresa());
        return cadena;
    }

}
