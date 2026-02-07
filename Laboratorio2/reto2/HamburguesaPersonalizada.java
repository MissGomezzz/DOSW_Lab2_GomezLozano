package Laboratorio2.reto2;

public class HamburguesaPersonalizada {
    private String pan;
    private String carne;
    private String queso;
    private String vegetales;
    private String salsas;

    public HamburguesaPersonalizada(String pan, String carne, String queso, String vegetales, String salsas) {
        this.pan = pan;
        this.carne = carne;
        this.queso = queso;
        this.vegetales = vegetales;
        this.salsas = salsas;
    }

    
    public static void main(String[] args) {
        HamburguesaPersonalizada miHamburguesa = new HamburguesaPersonalizada("Pan de Ajo", "Carne de Res", "Queso Cheddar", "Lechuga, Tomate, Cebolla", "Mayonesa, Ketchup");
    }

}