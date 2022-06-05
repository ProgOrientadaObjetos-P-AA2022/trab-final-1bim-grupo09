package paquete03;
import java.io.*;
import java.util.*;

public class LeerBarrio {

    private ObjectInputStream entrada;
    private ArrayList<Barrio> barrio;
    private String nomArchivo;
    private String identificador;
    private Barrio buscarB;

    public LeerBarrio(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        File archivo = new File(nomArchivo);
        if(archivo.exists()){
            try{
                entrada = new ObjectInputStream(new FileInputStream(nomArchivo));
            } catch (Exception e) {
                System.out.println("A ocurrido un error al abrir el archvio");
                throw new RuntimeException(e);
            }
        }
    }

    public void setNomArchivo(String nomArchivo) {this.nomArchivo = nomArchivo;}

    public void setIdentificador(String identificador) {this.identificador = identificador;}

    public void setBarrio() {
        this.barrio = new ArrayList<>();
        File archivo = new File(nomArchivo);
        if(archivo.exists()){
            while(true){

                try {
                    Barrio historial = (Barrio) entrada.readObject();
                    barrio.add(historial);
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

    public void setBuscarB() {
        File archivo = new File(nomArchivo);
        while (true){
            if(archivo.exists()){
                try{
                    Barrio historial = (Barrio) entrada.readObject();
                    if(historial.getNomBarrio().equals(identificador)){
                        buscarB=historial;
                        break;
                    }
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

    public Barrio getBuscarB() {return buscarB;}

    public ArrayList<Barrio> getBarrio() {return barrio;}

    @Override
    public String toString() {
        String cadena = "Barrios\n";
        for (int i = 0; i < barrio.size(); i++) {
            Barrio bar = barrio.get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena,
                    (i + 1), bar.getNomBarrio(), bar.getReferencia());
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
