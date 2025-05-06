/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adivinaelnumero;

import java.util.Scanner;

/**
 *
 * @author FABIANG
 */
public class AdivinaElNumero {

    /**
     * @param args the command line arguments
     */
    static Scanner scanner;
    static int numeroSecreto;
    static int intentosMaximos;
    static int rangoMaximo;
    static boolean jugarOtraVez = true;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        do {
            int opcion = mostrarMenuDificultad();
            configurarDificultad(opcion);
            generarNumeroSecreto();
            jugarRonda();
        } while (jugarOtraVez);
    }

    static int mostrarMenuDificultad() {
        System.out.println("Bienvenido al juego de adivinar el número");
        System.out.println("1. Fácil");
        System.out.println("2. Medio");
        System.out.println("3. Difícil");
        System.out.println("4. Experto");
        System.out.println("5. Dios");
        System.out.print("Seleccione la dificultad: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return opcion;
    }

    static void configurarDificultad(int opcion) {
        switch (opcion) {
            case 1 -> {
                intentosMaximos = 4;
                rangoMaximo = 10;
            }
            case 2 -> {
                intentosMaximos = 5;
                rangoMaximo = 50;
            }
            case 3 -> {
                intentosMaximos = 6;
                rangoMaximo = 100;
            }
            case 4 -> {
                intentosMaximos = 8;
                rangoMaximo = 500;
            }
            case 5 -> {
                intentosMaximos = 10;
                rangoMaximo = 1000;
            }
            default -> {
                System.out.println("Advertencia: Opción inválida. Se asignará dificultad Fácil.");
                intentosMaximos = 4;
                rangoMaximo = 10;
            }
        }
    }

    static void generarNumeroSecreto() {
        numeroSecreto = (int) (Math.random() * rangoMaximo) + 1;
    }

    static void jugarRonda() {
        System.out.println("Tienes " + intentosMaximos + " intentos para adivinar el número.");
        System.out.println("Rango de 1 hasta " + rangoMaximo);

        for (int i = 1; i <= intentosMaximos; i++) {
            System.out.print("Intento #" + i + ": ");
            int intento = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            if (intento == numeroSecreto) {
                System.out.println("==============");
                System.out.println("    ¡Ganaste!   ");
                System.out.println("==============");
                preguntarContinuar();
                return;
            }

            if (intento > numeroSecreto) {
                System.out.println("El número es menor.");
            } else {
                System.out.println("El número es mayor.");
            }
        }

        System.out.println("==============");
        System.out.println("   Perdiste   ");
        System.out.println("El número era: " + numeroSecreto);
        System.out.println("==============");
        preguntarContinuar();
    }

    static void preguntarContinuar() {
        System.out.print("¿Deseas jugar otra vez? (s/n): ");
        String respuesta = scanner.nextLine();
        jugarOtraVez = respuesta.equalsIgnoreCase("s");
    }

}
