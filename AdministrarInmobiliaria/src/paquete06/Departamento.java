/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete06;

import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;
import java.io.*;

/**
 *
 * @author reroes
 */
public class Departamento implements Serializable {

    private final double precioD;
    private final double metrosD;
    private final double alicuotaD;
    private double costeD;
    private final String nombreEdi;
    private final String ubicacion;
    private final Propietario propietario;
    private final Barrio barrio;
    private final Ciudad ciudad;
    private final Constructora constructora;

    public Departamento(double precioD, double metrosD, double alicuotaD, String nombreEdi, String ubicacion, Propietario propietario, Barrio barrio, Ciudad ciudad, Constructora constructora) {
        this.precioD = precioD;
        this.metrosD = metrosD;
        this.alicuotaD = alicuotaD;
        this.nombreEdi = nombreEdi;
        this.ubicacion = ubicacion;
        this.propietario = propietario;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.constructora = constructora;
    }

    public double getPrecioD() {return precioD;}

    public double getMetrosD() {return metrosD;}

    public double getAlicuotaD() {return alicuotaD;}

    public double getCosteD() {return costeD;}

    public void setCosteD() {
        this.costeD = ((metrosD*precioD)+(alicuotaD*12));
    }

    public String getNombreEdi() {return nombreEdi;}

    public String getUbicacion() {return ubicacion;}

    public Propietario getPropietario() {return propietario;}

    public Barrio getBarrio() {return barrio;}

    public Ciudad getCiudad() {return ciudad;}

    public Constructora getConstructora() {return constructora;}

}
