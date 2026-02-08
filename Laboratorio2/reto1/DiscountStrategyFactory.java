package Laboratorio2.reto1;

public class DiscountStrategyFactory {

    public static DiscountStrategy getStrategy(String clientType) {
        clientType = clientType.toLowerCase();
        if (clientType.equals("new")) {
            return new NewClientDiscount();
            
        } else if (clientType.equals("frequent")) {
            return new FrequentClientDiscount();
        } else {
            throw new  IllegalArgumentException ("Error. Invalid type of client.");
        }   
    }
}

