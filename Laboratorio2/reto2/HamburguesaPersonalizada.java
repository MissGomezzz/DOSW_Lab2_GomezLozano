package Laboratorio2.reto2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void mostrar() {
        System.out.println("\n--- HAMBURGUESA PERSONALIZADA ---");
        System.out.println("Pan: " + (pan == null ? "No" : pan));
        System.out.println("Carne: " + (carne == null ? "No" : carne));
        System.out.println("Queso: " + (queso == null ? "No" : queso));
        System.out.println("Vegetales: " + (vegetales.isEmpty() ? "Ninguno" : String.join(", ", vegetales)));
        System.out.println("Salsas: " + (salsas.isEmpty() ? "Ninguna" : String.join(", ", salsas)));
        System.out.println("--------------------------------\n");
    }

    public static class Builder {
        private String pan;
        private String carne;
        private String queso;   
        private List<String> vegetales = new ArrayList<>(); 
        private List<String> salsas = new ArrayList<>();;

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
        public Builder agregarVegetal(String vegetal) {
            if (vegetal != null && !vegetal.isBlank()) {
                this.vegetales.add(vegetal);
            }
            return this;
        }
        public Builder agregarSalsa(String salsa) {
            if (salsa != null && !salsa.isBlank()) {
                this.salsas.add(salsa);
            }
            return this;
        }

        public HamburguesaPersonalizada build() {
            return new HamburguesaPersonalizada(this);
        }
    }

    

}
