# Laboratorio 2 - Identificando los patrones de diseño 

## RETO 1 - El problema de la tienda de Don Pepe – Patrón comportamental 

**Diagrama de clases**

Diagrama de clases realizado en Mermaid: 

![alt text](<images/DonPepe.png>)


**Descripción**


Consideramos que para este problema podría ser óptimo el uso del patrón de Strategy, ya que en esta situación se requiere implementar tipos de clientes; acá podríamos implementar interfaces para facilitar el manejo de los productos de la tienda de Pepe, en donde cambiamos el algoritmo durante el tiempo de ejecución. 

Para empezar, se crearon las clases principales para el ejercicio, como Cart, Product, Client y CartItem. Después de esto empezamos a organizar las siguientes clases para aplicarle el patrón de Strategy: creamos DiscountStrategy, el cual es una interface muy puntual con el método para calcular el descuento. La clase DiscountStrategyFactory se encarga de instanciar las clases concretas que implementan la interfaz DiscountStrategy y devolverlas como dicho tipo. Para esto creamos clases llamadas NewClientDiscount y FrequentClientDiscount, las cuales guardan la tasa de descuento para su tipo de cliente. 


A continuación se muestran algunas de las clases que fueron esenciales para la aplicación del patrón Strategy con una clase del patrón Factory para facilitar el manejo de los tipos de clientes con sus respectivos descuentos. Mientras el Strategy se usa por tipo de descuento, el Factory se usa como un patrón secundario para decidir qué tipo de Strategy usar dependiendo del cliente y así evitar el uso de if else en el Main. 


![DiscountStrategy](images/image.png)


![DiscountStrategyFactory](images/aaa.png)


![FrequentClientDiscount](images/image-1.png)


![NewClientDiscount](images/image-2.png)


Ahora bien, teniendo estas clases en cuenta, el "flujo" entre esas clases es el siguiente:


Client -> DiscountStrategyFactory -> DiscountStrategy  -> FrequentClientDiscount v NewClientDiscount


Así logramos organizar de forma práctica los algoritmos que se deben realizar para cada tipo de cliente, en donde Factory encapsula los diferentes Strategies, uno por tipo de discuento por cliente.

Si analizamos la forma en la que desarrollamos el ejercicio, acá estamos aplicando conceptos como polimorfismo, responsabilidad única y Open/Closed principle, pues estamos usando interfaces de tal forma que si llega a ver un nuevo tipo de cliente, simplemente se añade ese nueva clase y se le agrega esa línea en DiscountStrategyFactory para poder instanciar dicho objeto del nuevo tipo del cliente. 


En adición, calculos restantes se realizan en la clase de OrderService:

![alt text](images/image-3.png)


Finalmente, en el Main logramos la impresión y recolección de todos los resultados, productos, cálculos, tipos de cliente, entre otros. 

Un ejemplo de entrada y salida es el siguiente.

### Ejemplo: 



![alt text](images/results.png)



## RETO 2 - El chef de 5 estrellas – Patrón creacional 


**Diagrama de clases**

**Descripción**
Para este problema identificamos que el mejor patrón de diseño para manejar la creación de hamburguesas es el Builder: esto se debe a que, por el contexto de la creación de las hamburguesas, este patrón nos ofrece un rango de posibles opciones para los pedidos de los usuarios – es decir, con este patrón logramos resultados personalizados. 



