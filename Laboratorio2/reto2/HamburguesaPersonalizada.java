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

    public void mostrarIngredientes() {
        System.out.println("Hamburguesa Personalizada:");
        System.out.println("Pan: " + pan);
        System.out.println("Carne: " + carne);
        System.out.println("Queso: " + queso);
        System.out.println("Vegetales: " + vegetales);
        System.out.println("Salsas: " + salsas);
    }
    public static void main(String[] args) {
        HamburguesaPersonalizada miHamburguesa = new HamburguesaPersonalizada("Pan de Ajo", "Carne de Res", "Queso Cheddar", "Lechuga, Tomate, Cebolla", "Salsa BBQ");
        miHamburguesa.mostrarIngredientes();
    }
}