package Laboratorio2.reto1;

public class DiscountStrategyFactory {

    public static DiscountStrategy getStrategy(String clientType) {
        clientType = clientType.toLowerCase();
        switch (clientType) {
            case "new":
                return new NewClientDiscount();
            case "frequent":
                return new FrequentClientDiscount();
            default:
                throw new  IllegalArgumentException ("Error. Invalid type of client.");
        }   
    }
}

