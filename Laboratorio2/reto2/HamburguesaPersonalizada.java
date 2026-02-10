package Laboratorio2.reto2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class HamburguesaPersonalizada {
    private final String pan;
    private final String carne;
    private final String queso; 
    private final List<String> vegetales;
    private final List<String> salsas;

    private HamburguesaPersonalizada(Builder builder) {
        this.pan = builder.pan;
        this.carne = builder.carne;
        this.queso = builder.queso;
        this.vegetales = Collections.unmodifiableList(new ArrayList<>(builder.vegetales));
        this.salsas = Collections.unmodifiableList(new ArrayList<>(builder.salsas));
    }

    public void mostrarHamburguesa() {
        System.out.println("\n--- HAMBURGUESA PERSONALIZADA ---");
        System.out.println("Pan: " + (pan == null ? "No" : pan));
        System.out.println("Carne: " + (carne == null ? "No" : carne));
        System.out.println("Queso: " + (queso == null ? "No" : queso));
        System.out.println("Vegetales: " + (vegetales.isEmpty() ? "Ninguno" : String.join(", ", vegetales)));
        System.out.println("Salsas: " + (salsas.isEmpty() ? "Ninguna" : String.join(", ", salsas)));
        System.out.println("--------------------------------\n");
    }

    
    public int calcularTotal(Map<String, Integer> precios) {
        Stream<String> base = Stream.of(pan, carne, queso).filter(x -> x != null);

        Stream<String> extras = Stream.concat(vegetales.stream(), salsas.stream());

        return Stream.concat(base, extras)
                .mapToInt(nombre -> precios.getOrDefault(nombre, 0))
                .sum();
    }

    public static class Builder {
        private String pan;
        private String carne;
        private String queso;
        private final List<String> vegetales = new ArrayList<>();
        private final List<String> salsas = new ArrayList<>();

        public Builder conPan(String pan) {
            this.pan = pan;
            return this;
        }

        public Builder conCarne(String carne) {
            this.carne = carne;
            return this;
        }

        public Builder conQueso(String queso) {
            this.queso = queso;
            return this;
        }

        public Builder agregarVegetales(String vegetal) {
            if (vegetal != null && !vegetal.isBlank()) {
                this.vegetales.add(vegetal);
            }
            return this;
        }

        public Builder agregarSalsas(String salsa) {
            if (salsa != null && !salsa.isBlank()) {
                this.salsas.add(salsa);
            }
            return this;
        }

        public HamburguesaPersonalizada build() {
            if (pan == null || pan.isBlank()) throw new IllegalStateException("Debe elegir un pan.");
            if (carne == null || carne.isBlank()) throw new IllegalStateException("Debe elegir una carne.");
            return new HamburguesaPersonalizada(this);
        }
    }
}
