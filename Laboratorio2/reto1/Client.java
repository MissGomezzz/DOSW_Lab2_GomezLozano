package Laboratorio2.reto1;

public class Client {
    private String typeOfClient;

    public Client (String typeOfClient) {
        isTypeValid(typeOfClient);
        this.typeOfClient = typeOfClient.toLowerCase();
    }

    public String getTypeOfClient() { return typeOfClient; }

    private void isTypeValid (String typeOfClient) {

        if (!typeOfClient.equals("new") && !typeOfClient.equals("frequent")) {
            throw new IllegalArgumentException(
                "Error. The type of client does not exist");
        }
    }

    
}
