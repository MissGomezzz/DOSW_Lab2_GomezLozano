package Laboratorio2.reto1;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items;

    public Cart () {
        this.items = new ArrayList<>(); 
    }

    public boolean isEmpty() {return items.isEmpty(); }

    public List<CartItem> getItems() { return this.items; }

    public void clear() {items.clear(); }


    public void addProduct(Product productToAdd, int quantity) {
        boolean found = false;

        for (CartItem item: items) {
            if (item.getProduct().equals(productToAdd)) {
                item.addOneAmount(quantity);
                found = true;
                break;
            }
        }
            if (!found) { 
                CartItem itemToAdd = new CartItem(productToAdd, quantity);
                items.add(itemToAdd);
            }
    }

    public void removeProduct(Product productToRemove, int quantity) {
        boolean found = false;

        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);

            if (item.getProduct().equals(productToRemove)) {
                found = true;

                item.removeOneAmount(quantity);

                if (item.getAmount() <= 0) {
                    items.remove(i);
                }

                break;
            }
        }

        if (!found) {
            System.out.println("The item you want to remove does not exist.");
        }
    }
    

    public double calculateSubtotal () {

        double subtotal = items.stream()
        // Quantity of the product * price of the product 
        .map(item -> item.getProduct().getPrice() * item.getAmount())
        // Line provided by ChatGPT - used to sum all of the elements 
        .reduce(0.0, Double::sum);

        return subtotal; 
    }
}



