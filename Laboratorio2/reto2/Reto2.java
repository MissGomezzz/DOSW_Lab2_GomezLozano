package Laboratorio2.reto2;
import Laboratorio2.reto2.HamburguesaPersonalizada;

public class Reto2 {
    public static void main(String[] args) {
        HamburguesaPersonalizada h = new HamburguesaPersonalizada.Builder()
        .conPan("Pan de Ajo")
        .conCarne("Carne de Res")
        .conQueso("Queso Cheddar")
        .agregarVegetal("Lechuga")
        .agregarVegetal("Tomate")
        .agregarSalsa("Mayonesa")
        .agregarSalsa("Ketchup")
        .build();

        h.mostrar();


    }
}
