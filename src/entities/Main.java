package entities;

import adt.tad.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {


        HashOb<String, Style> availableStyles = new HashTableOb();
        ListOb<String> styleKeys = new ArrayListOb(String.class);
        HashOb<String, User> validUsers = new HashTableOb();
        ListOb<String> userKeys = new ArrayListOb(String.class);
        HashOb<Long, Beer> validBeers = new HashTableOb();
        ListOb<Long> beerKeys = new ArrayListOb(Long.class);
        HashOb<Long, Review> validReviews = new HashTableOb();
        ListOb<Long> reviewKeys = new ArrayListOb(Long.class);
        HashOb<Long, Brewery> validBreweries = new HashTableOb();
        ListOb<Long> breweryKeys = new ArrayListOb(Long.class);
        BufferedReader lector;
        String linea;
        String partes[] = null;

        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        try {

            lector = new BufferedReader(new InputStreamReader(new FileInputStream("beer_dataset_full.cvs"), "UTF-16"));
            while ((linea = lector.readLine()) != null) {
                partes = linea.split(",");
                //Agregar datos a las clases
                try {
                    //,brewery_id(1),brewery_name(2),review_time(3),review_overall(4),review_aroma(5),review_appearance(6),
                    // review_profilename(7),beer_style(8),review_palate(9),review_taste(10),beer_name(11),beer_abv(12),
                    // beer_beerid(13)
                    long revId = Long.parseLong(partes[0]);
                    long brewerId = Long.parseLong(partes[1]);
                    Date dateOfRev = new Date(partes[3]);
                    double revOv = Double.parseDouble(partes[4]);
                    double revAr = Double.parseDouble(partes[5]);
                    double revAp = Double.parseDouble(partes[6]);
                    double revFl = Double.parseDouble(partes[10]); //Supongo que "Flavor" es lo mismo que review_taste
                    double bAbv = Double.parseDouble(partes[12]);
                    long beerId = Long.parseLong(partes[12]);
                    if(availableStyles.get(partes[8]) == null){
                        availableStyles.put(partes[8], new Style(partes[8]));//Crear nuevo Estilo y ponerlo en la lista
                        styleKeys.add(partes[8]); //Almacenar llave en un formato fácil de iterar
                    }
                    if(validBeers.get(beerId) == null){
                        validBeers.put(beerId, new Beer(beerId, partes[11],bAbv,availableStyles.get(partes[8]))); //Crear nueva cerveza y ponerla en la lista
                        beerKeys.add(beerId); //Almacenar llave en un formato fácil de iterar
                    }
                    if(validBreweries.get(brewerId) == null){
                        validBreweries.put(brewerId, new Brewery(brewerId, partes[2])); //Crear nueva cervecería y ponerla en la lista
                        breweryKeys.add(brewerId); //Almacenar llave en un formato fácil de iterar
                    }
                    if(validUsers.get(partes[7]) == null){
                        validUsers.put(partes[7],new User(partes[7])); //Crear nuevo usuario y ponerlo en la lista
                        userKeys.add(partes[7]); //Almacenar llave en un formato fácil de iterar
                    }
                    if(validReviews.get(revId) == null){
                        validReviews.put(revId, new Review(revId, dateOfRev, revOv, revAr,
                                revAp, revFl, validBreweries.get(brewerId), validUsers.get(partes[7])));//Crear nueva reseña y ponerla en la lista
                        reviewKeys.add(revId);//Almacenar llave en un formato fácil de iterar
                    }


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
}

