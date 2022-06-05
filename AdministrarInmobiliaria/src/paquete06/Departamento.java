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

    private double precioD;
    private double metrosD;
    private double alicuotaD;
    private double costeD;
    private String nombreEdi;
    private String ubicaion;
    private Propietario propietario;
    private Barrio barrio;
    private Ciudad ciudad;
    private Constructora constructora;

    public Departamento(double precioD, double metrosD, double alicuotaD, String nombreEdi, String ubicaion, Propietario propietario, Barrio barrio, Ciudad ciudad, Constructora constructora) {
        this.precioD = precioD;
        this.metrosD = metrosD;
        this.alicuotaD = alicuotaD;
        this.nombreEdi = nombreEdi;
        this.ubicaion = ubicaion;
        this.propietario = propietario;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.constructora = constructora;
    }

    public double getPrecioD() {return precioD;}

    public void setPrecioD(double precioD) {this.precioD = precioD;}

    public double getMetrosD() {return metrosD;}

    public void setMetrosD(double metrosD) {this.metrosD = metrosD;}

    public double getAlicuotaD() {return alicuotaD;}

    public void setAlicuotaD(double alicuotaD) {this.alicuotaD = alicuotaD;}

    public double getCosteD() {return costeD;}

    public void setCosteD() {
        this.costeD = ((metrosD*precioD)+(alicuotaD*12));
    }

    public String getNombreEdi() {return nombreEdi;}

    public void setNombreEdi(String nombreEdi) {this.nombreEdi = nombreEdi;}

    public String getUbicaion() {return ubicaion;}

    public void setUbicaion(String ubicaion) {this.ubicaion = ubicaion;}

    public Propietario getPropietario() {return propietario;}

    public void setPropietario(Propietario propietario) {this.propietario = propietario;}

    public Barrio getBarrio() {return barrio;}

    public void setBarrio(Barrio barrio) {this.barrio = barrio;}

    public Ciudad getCiudad() {return ciudad;}

    public void setCiudad(Ciudad ciudad) {this.ciudad = ciudad;}

    public Constructora getConstructora() {return constructora;}

    public void setConstructora(Constructora constructora) {this.constructora = constructora;}
}
