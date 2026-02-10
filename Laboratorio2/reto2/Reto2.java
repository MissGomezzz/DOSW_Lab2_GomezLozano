package Laboratorio2.reto2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Reto2 {
    private static final Map<String, Integer> PRECIOS = new LinkedHashMap<>();

    static {
        // PANES
        PRECIOS.put("Pan", 3000);
        PRECIOS.put("Pan de Ajo", 3500);
        PRECIOS.put("Pan Brioche", 4000);

        // CARNES
        PRECIOS.put("Carne", 10000);
        PRECIOS.put("Pollo", 9000);
        PRECIOS.put("Doble Carne", 16000);

        // QUESOS
        PRECIOS.put("Queso", 5000);
        PRECIOS.put("Cheddar", 5500);
        PRECIOS.put("Mozzarella", 5200);

        // VEGETALES
        PRECIOS.put("Lechuga", 800);
        PRECIOS.put("Tomate", 900);
        PRECIOS.put("Cebolla", 700);
        PRECIOS.put("Pepinillos", 1000);

        // SALSAS
        PRECIOS.put("Mayonesa", 500);
        PRECIOS.put("Ketchup", 400);
        PRECIOS.put("BBQ", 600);
        PRECIOS.put("Mostaza", 450);
    }

    private static final String[] PANES = {"Pan", "Pan de Ajo", "Pan Brioche"};
    private static final String[] CARNES = {"Carne", "Pollo", "Doble Carne"};
    private static final String[] QUESOS = {"Queso", "Cheddar", "Mozzarella"};
    private static final String[] VEGETALES = {"Lechuga", "Tomate", "Cebolla", "Pepinillos"};
    private static final String[] SALSAS = {"Mayonesa", "Ketchup", "BBQ", "Mostaza"};

    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nRETO #2: El chef de 5 estrellas");
        System.out.println("Seleccione ingredientes para su hamburguesa:\n");

        HamburguesaPersonalizada.Builder builder = new HamburguesaPersonalizada.Builder();

        // 1) Pan (obligatorio)
        String pan = elegirUno(sc, "PAN", PANES);
        builder.conPan(pan);

        // 2) Carne (obligatorio)
        String carne = elegirUno(sc, "CARNE", CARNES);
        builder.conCarne(carne);

        // 3) Queso (opcional)
        System.out.print("\n¿Desea queso? (s/n): ");
        String respQ = sc.nextLine().trim().toLowerCase();
        if (respQ.equals("s")) {
            String queso = elegirUno(sc, "QUESO", QUESOS);
            builder.conQueso(queso);
        }

        // 4) Vegetales (0..n)
        elegirMultiples(sc, "VEGETALES (0 para terminar)", VEGETALES, builder);

        // 5) Salsas (0..n)
        elegirMultiplesSalsas(sc, "SALSAS (0 para terminar)", SALSAS, builder);

        // Chef genera la hamburguesa final
        HamburguesaPersonalizada hamburguesa = builder.build();
        System.out.println("\nEl chef ha generado la hamburguesa final");

        // Mostrar ingredientes
        hamburguesa.mostrarHamburguesa();

        // Total con streams
        int total = hamburguesa.calcularTotal(PRECIOS);
        System.out.println("TOTAL A PAGAR: $" + total);
    }

    private static String elegirUno(Scanner sc, String titulo, String[] opciones) {
        System.out.println("--- " + titulo + " ---");
        for (int i = 0; i < opciones.length; i++) {
            String nombre = opciones[i];
            int precio = PRECIOS.getOrDefault(nombre, 0);
            System.out.println((i + 1) + ". " + nombre + " ($" + precio + ")");
        }

        int op = leerNumero(sc, 1, opciones.length);
        return opciones[op - 1];
    }

    private static void elegirMultiples(Scanner sc, String titulo, String[] opciones, HamburguesaPersonalizada.Builder builder) {
        System.out.println("\n--- " + titulo + " ---");
        for (int i = 0; i < opciones.length; i++) {
            String nombre = opciones[i];
            int precio = PRECIOS.getOrDefault(nombre, 0);
            System.out.println((i + 1) + ". " + nombre + " ($" + precio + ")");
        }

        while (true) {
            int op = leerNumero(sc, 0, opciones.length);
            if (op == 0) break;
            builder.agregarVegetales(opciones[op - 1]);
        }
    }

    private static void elegirMultiplesSalsas(Scanner sc, String titulo, String[] opciones, HamburguesaPersonalizada.Builder builder) {
        System.out.println("\n--- " + titulo + " ---");
        for (int i = 0; i < opciones.length; i++) {
            String nombre = opciones[i];
            int precio = PRECIOS.getOrDefault(nombre, 0);
            System.out.println((i + 1) + ". " + nombre + " ($" + precio + ")");
        }

        while (true) {
            int op = leerNumero(sc, 0, opciones.length);
            if (op == 0) break;
            builder.agregarSalsas(opciones[op - 1]);
        }
    }

    private static int leerNumero(Scanner sc, int min, int max) {
        while (true) {
            System.out.print("Opción (" + min + "-" + max + "): ");
            String input = sc.nextLine().trim();
            try {
                int n = Integer.parseInt(input);
                if (n >= min && n <= max) return n;
            } catch (NumberFormatException ignored) { }
            System.out.println("Entrada inválida. Intenta de nuevo.");
        }
    }
}
