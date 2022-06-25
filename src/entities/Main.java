package entities;

import adt.tad.*;
import exeptions.NonExistantElement;

import java.io.BufferedReader;
import java.io.FileReader;
import com.opencsv.CSVReader;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {


    static HashOb<String, Style> availableStyles = new HashTableOb(String.class);
    static HashOb<String, User> validUsers = new HashTableOb(String.class);
    static HashOb<Long, Beer> validBeers = new HashTableOb(Long.class);
    static HashOb<Long, Review> validReviews = new HashTableOb(Long.class);
    static HashOb<Long, Brewery> validBreweries = new HashTableOb(Long.class);

    public static void main(String[] args) {


        String linea;
        String partes[] = null;

        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        try {

            CSVReader lector = new CSVReader(new FileReader(""));/*Fixme Poner nombre de archivo*/
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("");
            while ((partes = lector.readNext()) != null) {

                //Agregar datos a las clases
                try {
                    //,brewery_id(1),brewery_name(2),review_time(3),review_overall(4),review_aroma(5),review_appearance(6),
                    // review_profilename(7),beer_style(8),review_palate(9),review_taste(10),beer_name(11),beer_abv(12),
                    // beer_beerid(13)
                    long revId = Long.parseLong(partes[0]);
                    long brewerId = Long.parseLong(partes[1]);
                    LocalDateTime dateOfRev = Instant.ofEpochSecond(Long.parseLong(partes[3])).atZone(ZoneId.systemDefault()).toLocalDateTime();
                    double revOv = Double.parseDouble(partes[4]);
                    double revAr = Double.parseDouble(partes[5]);
                    double revAp = Double.parseDouble(partes[6]);
                    double revFl = Double.parseDouble(partes[10]); //Supongo que "Flavor" es lo mismo que review_taste
                    double bAbv = Double.parseDouble(partes[12]);
                    long beerId = Long.parseLong(partes[13]);
                    if(availableStyles.get(partes[8]) == null){
                        availableStyles.put(partes[8], new Style(partes[8]));//Crear nuevo Estilo y ponerlo en la lista
                    }
                    if(validBeers.get(beerId) == null){
                        validBeers.put(beerId, new Beer(beerId, partes[11],bAbv,availableStyles.get(partes[8]))); //Crear nueva cerveza y ponerla en la lista
                    }
                    if(validBreweries.get(brewerId) == null){
                        validBreweries.put(brewerId, new Brewery(brewerId, partes[2])); //Crear nueva cervecería y ponerla en la lista
                    }
                    if(validUsers.get(partes[7]) == null){
                        validUsers.put(partes[7],new User(partes[7])); //Crear nuevo usuario y ponerlo en la lista
                    }
                    if(validReviews.get(revId) == null){
                        validReviews.put(revId, new Review(revId, dateOfRev, revOv, revAr,
                                revAp, revFl, validBreweries.get(brewerId), validUsers.get(partes[7])));//Crear nueva reseña y ponerla en la lista
                    }
                    validUsers.get(partes[7]).setReviews(validUsers.get(partes[7]).getReviews() + 1); //No funciona....



                } catch (NumberFormatException firstLine) {
                    System.out.println("Fila Primera o Invalida " + partes[0]); //Para borrar después de que se verifique el código
                }

            }
            lector.close();
            linea = null;
            partes = null;
        } catch (Exception e) {
            e.printStackTrace();
        }


        while (!salir) {
            System.out.println("Elija la consultar a realizar o si desea salir del programa:");
            System.out.println();
            System.out.println("1. Listar las 10 casas de cerveza con más reseñas en un año");
            System.out.println("2. Top 15 catadores con más reseñas");
            System.out.println("3. Reviews en un periodo de tiempo");
            System.out.println("4. Top 7 estilos de cervezas con mejor aroma");
            System.out.println("5. Top 5 cervezas con más reviews");
            System.out.println("6. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    //consulta1();
                    break;
                case 2:
                    //consulta2();
                    break;
                case 3:
                    //consulta3();
                    break;
                case 4:
                    //consulta4();
                    break;
                case 5:
                    //consulta5();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo puede ingresar números entre 1 y 6");
            }
        }

    }

    void consulta1(int año){
        Brewery[] ranking = new Brewery[10];

            for(int i = 0; i < validReviews.size(); i++){
                try {
                    if(validReviews.get(validReviews.getKeys().get(i)).getDate().getYear() == año){

                    }
                }catch (NonExistantElement n){

                }

            }



    }

    void consulta2(){
        User[] ranking = new User[15];
        try {
            for (int i = 0; i < validUsers.size(); i++) {
                validUsers.getKeys().get(i);


            }
        }catch (NonExistantElement e){
            System.out.println("No hay usuarios");
        }

    }

    void consulta3(){

    }

    void consulta4(){

    }

    void consulta5(){

    }

    void mergeSort(Object[] array){
        if(array.length == 1){

        }

    }

}

