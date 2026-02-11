package Laboratorio2.reto1;

public class CartItem {

    private final Product item;
    private int amount; 

    public CartItem (Product item, int amount) {
        this.item = item;
        this.amount = amount; 
    }

    public Product getProduct () { return this.item; }
    public int getAmount () { return this.amount; }

    public void addOneAmount (int amount) { this.amount += amount; }
    public void removeOneAmount (int amount) { this.amount -= amount; }

    
}
