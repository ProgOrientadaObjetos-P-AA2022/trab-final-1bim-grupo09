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

    private final double precioC;
    private final double metrosC;
    private double costeC;
    private final int cuartosC;
    private final Propietario propietario;
    private final Barrio barrio;
    private final Ciudad ciudad;
    private final Constructora constructora;

    public Casa(double precioC, double metrosC, int cuartosC, Propietario propietario, Barrio barrio, Ciudad ciudad, Constructora constructora) {
        this.precioC = precioC;
        this.metrosC = metrosC;
        this.cuartosC = cuartosC;
        this.propietario = propietario;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.constructora = constructora;
    }

    public void setCosteC() {
        this.costeC = precioC*metrosC;
    }

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
        return String.format("""
                        Informacion casa:
                        PROPIETARIO
                        Nombres: %s Apellidos: %s Identificacion: %s
                        Precio metro cuadrado: %.2f Numero metros Cuadrados: %.2f Numero Cuartos: %d Costo final: %.2f
                        BARRIO
                        Nombre barrio: %s Referencia: %s
                        CIUDAD
                        Nombre Ciudad: %s Nombre Provincia: %s\s
                        CONSTRUCTORA
                        Nombre Constructora: %s Id Empresa: %s
                        """,
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
    }

}
