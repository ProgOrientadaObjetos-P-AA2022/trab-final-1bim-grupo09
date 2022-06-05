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

    public void setDepartamento() {
        this.departamento = new ArrayList<>();
        File archivo = new File(nomArchivo);
        if(archivo.exists()){
            while (true){
                try{
                    Departamento historial = (Departamento) entrada.readObject();
                    departamento.add(historial);
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

    public ArrayList<Departamento> getDepartamento() {return departamento;}

    @Override
    public String toString(){
        String cadena = "Departamentos:\n";
        for(int i = 0;i<departamento.size();i++){
            cadena = String.format("""
                            %s(%d) Informacion del Departamento
                            PROPIETARIO
                            \tNombres: %s Apellidos: %s Identificacion: %s
                            ESPECIFICACIONES
                            \tNombre Edificio: %s Ubicación en el Edificio: %s
                            \tPrecio por metro cuadrado: %.2f Numero de metros cuadrados: %.2f
                            \tValor Alícuota Mensual: %.2f Costo final: %.2f
                            BARRIO
                            \tNombre Barrio: %s Referencia%s
                            CIUDAD
                            \tNombre Ciudad: %s Nombre Provincia: %s
                            CONSTRUCTORA
                            \tNombre Constructora: %s ID Empresa: %s
                            """,
                    cadena,
                    (i + 1),
                    departamento.get(i).getPropietario().getNombres(),
                    departamento.get(i).getPropietario().getApellidos(),
                    departamento.get(i).getPropietario().getIdentificaion(),
                    departamento.get(i).getNombreEdi(),
                    departamento.get(i).getUbicacion(),
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
