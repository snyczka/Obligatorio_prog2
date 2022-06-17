package entities;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int opcion;
    boolean salir=false;



    while(salir==false){
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

