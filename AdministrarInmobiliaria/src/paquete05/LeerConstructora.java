package paquete05;
import java.io.*;
import java.util.*;

public class LeerConstructora {

    private String nomArchivo;
    private String identificar;
    private ArrayList<Constructora> constructora;
    private Constructora buscarCons;
    private ObjectInputStream entrada;

    public LeerConstructora(String nomArchivo) {
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

    public void setIdentificar(String identificar) {this.identificar = identificar;}

    public void setConstructora() {
        this.constructora = new ArrayList<>();
        File archivo = new File(nomArchivo);
        if(archivo.exists()){
            while(true){
                try{
                    Constructora historial = (Constructora) entrada.readObject();
                    constructora.add(historial);
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

    public void setBuscarCons() {
        File archivo = new File(nomArchivo);
        while(true){
            if(archivo.exists()){
                try{
                    Constructora historial = (Constructora) entrada.readObject();
                    if(historial.getIdEmpresa().equals(identificar)){
                        buscarCons = historial;
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

    public void setEntrada(ObjectInputStream entrada) {this.entrada = entrada;}

    public String getNomArchivo() {return nomArchivo;}

    public String getIdentificar() {return identificar;}

    public ArrayList<Constructora> getConstructora() {return constructora;}

    public Constructora getBuscarCons() {return buscarCons;}

    public ObjectInputStream getEntrada() {return entrada;}

    @Override
    public String toString() {
        String cadena = "Constructoras\n";
        for (int i = 0; i < constructora.size(); i++) {
            Constructora cons = constructora.get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena, (i + 1), cons.getNomConstructora(), cons.getIdEmpresa());
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
