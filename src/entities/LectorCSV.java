package entities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LectorCSV  {

    private BufferedReader lector;
    private String linea;
    private String partes[]= null;

    public void leerArchivo (String archName){
        try {
            lector = new BufferedReader(new InputStreamReader(new FileInputStream(archName),"UTF-16"));
            while((linea = lector.readLine())!=null){
                partes =linea.split(",");
                //Agregar datos a las clases
            }
            lector.close();
            linea=null;
            partes=null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
