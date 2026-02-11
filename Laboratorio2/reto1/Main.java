package Laboratorio2.reto1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // Available products 

        Product shirt = new Product("Shirt", 20);
        Product pants = new Product("Pants", 30);
        Product shoes = new Product ("Shoes", 35);
        Product jacket = new Product("Jacket", 40);

        Product juice = new Product ("Juice", 5);
        Product cookies = new Product ("Cookies", 3);
        Product candy = new Product ("Candy", 2.5);


        Map<String, Product> catalog = new HashMap<>();

        catalog.put("shirt", shirt);
        catalog.put("pants", pants);
        catalog.put("shoes", shoes);
        catalog.put("jacket", jacket);
        catalog.put("juice", juice);
        catalog.put("cookies", cookies);
        catalog.put("candy", candy);

        Cart cart = new Cart();

        Client currentClient = new Client ("new");

        // Applying the pattern 
        DiscountStrategy strategy = DiscountStrategyFactory.getStrategy(currentClient.getTypeOfClient());   
        OrderService order = new OrderService(strategy);

        // Welcome message + available products

        System.out.println("      Welcome to Don Pepe's place!");
        System.out.println("      Client: "+ currentClient.getTypeOfClient());

        System.out.println("      Available products:");
        System.out.println("         - Shirt");
        System.out.println("         - Pants");
        System.out.println("         - Shoes");
        System.out.println("         - Jacket");
        System.out.println("         - Juice");
        System.out.println("         - Cookies");
        System.out.println("         - Candy");


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter product name (press Enter to finish): ");
            String productName = scanner.nextLine().trim().toLowerCase();

            // If user pressed Enter 
            if (productName.isBlank()) {
                break;
            }
            
            if (!catalog.containsKey(productName)) {
                System.out.println("Sorry. The product you wrote doesn't exist.");
                continue;
            }

            System.out.print("Enter quantity: ");
            String quantityInput = scanner.nextLine().trim();

            try {
                int quantity = Integer.parseInt(quantityInput);

                if (quantity <= 0) {
                    System.out.println("Quantity must be greater than 0.");
                    continue;
                }

                cart.addProduct(catalog.get(productName), quantity);
                System.out.println("Product: " + productName);
                System.out.println("Quantity: " + quantity);

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        // Calculations 
        double subtotal = cart.calculateSubtotal();
        double totalPrice = order.calculateTotal(cart);
        double discount = subtotal - totalPrice; 

        // Registering the items bought 

        // Printing loop guided with ChatGPT
        cart.getItems().stream()
        .forEach(item -> {
            Product product = item.getProduct();
            System.out.println("      " +    
                        item.getAmount() + " units of " + product.getName() 
                    + " added to the cart. "
            );
        });

        System.out.println();

        // Printing the receipt 
        System.out.println("--- BUYING RECEIPT: DON PEPE'S PLACE!--- ");

        System.out.println("          Type of Client: " + currentClient.getTypeOfClient().toUpperCase());

        System.out.println("          Products:");

            cart.getItems().stream()
            .forEach(item -> {
                Product product = item.getProduct();
                System.out.println("          - " +    
                          product.getName() + " x" + item.getAmount() +
                    " - $" + product.getPrice()*item.getAmount()
                );
            });

        // format recommendation by ChatGPT
        System.out.printf("          Subtotal: $%.2f%n", subtotal);
        System.out.printf("          Discount applied: $%.2f%n", discount);
        System.out.printf("          Total price: $%.2f%n", totalPrice);
        System.out.println("          ------------------");
        System.out.println("          Thanks for buying!");
        System.out.println();

        // Empty the cart. 
        cart.clear(); 
    }
}
