package paquete06;

import java.io.*;
import java.util.*;

public class LeerDepartamento {

    private String nomArchivo;
    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamento;

    public LeerDepartamento(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        File archivo = new File(nomArchivo);
        if(archivo.exists()){
            try{
                entrada = new ObjectInputStream(new FileInputStream(nomArchivo));
            } catch (Exception e) {
                System.out.println("A ocurrido un error al abrir el archivo" + e);
                throw new RuntimeException(e);
            }
        }
    }

    public void setNomArchivo(String nomArchivo) {this.nomArchivo = nomArchivo;}

    public void setEntrada(ObjectInputStream entrada) {this.entrada = entrada;}

    public void setDepartamento() {
        this.departamento = new ArrayList<>();
        File archivo = new File(nomArchivo);
        if(archivo.exists()){
            while (true){
                try{
                    Departamento historial = (Departamento) entrada.readObject();
                } catch (EOFException endOfFileException) {
                    break;
                } catch (IOException ex) {
                    System.out.println("A ocurrido un error al leer el archivo");
                } catch (ClassNotFoundException ex) {
                    System.out.println("No se pudo crear el objeto" + ex);
                }
            }
        }
    }

    public String getNomArchivo() {return nomArchivo;}

    public ObjectInputStream getEntrada() {return entrada;}

    public ArrayList<Departamento> getDepartamento() {return departamento;}

    @Override
    public String toString(){
        String cadena = "Departamentos:\n";
        for(int i = 0;i<departamento.size();i++){
            cadena = String.format("%s(%d) Informacion del Departamento\n"
                    + "PROPIETARIO\n"
                    + "\tNombres: %s Apellidos: %s Identificacion: %s\n"
                    + "ESPECIFICACIONES\n"
                    + "\tNombre Edificio: %s Ubicación en el Edificio: %s\n"
                    + "\tPrecio por metro cuadrado: %.2f Numero de metros cuadrados: %.2f\n"
                    + "\tValor Alícuota Mensual: %.2f Costo final: %.2f\n"
                    + "BARRIO\n"
                    + "\tNombre Barrio: %s Referencia%s\n"
                    + "CIUDAD\n"
                    + "\tNombre Ciudad: %s Nombre Provincia: %s\n"
                    + "CONSTRUCTORA\n"
                    + "\tNombre Constructora: %s ID Empresa: %s\n",
                    cadena,
                    (i + 1),
                    departamento.get(i).getPropietario().getNombres(),
                    departamento.get(i).getPropietario().getApellidos(),
                    departamento.get(i).getPropietario().getIdentificaion(),
                    departamento.get(i).getNombreEdi(),
                    departamento.get(i).getUbicaion(),
                    departamento.get(i).getPrecioD(),
                    departamento.get(i).getMetrosD(),
                    departamento.get(i).getAlicuotaD(),
                    departamento.get(i).getCosteD(),
                    departamento.get(i).getBarrio().getNomBarrio(),
                    departamento.get(i).getBarrio().getReferencia(),
                    departamento.get(i).getCiudad().getNombreC(),
                    departamento.get(i).getCiudad().getNombreP(),
                    departamento.get(i).getConstructora().getNomConstructora(),
                    departamento.get(i).getConstructora().getIdEmpresa());
        }
        return cadena;
    }
    public void errorArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.out.println("A ocurrido un error al cerrar el archivo");
        }
    }

}
