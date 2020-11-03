package MariosPizza;

import java.time.LocalTime;
import java.util.ArrayList;

public class Order {
    private LocalTime time;
    private ArrayList<Pizza> pizzas;
    private double totalPrice;



    double totalPrice() {
        double sum = 0.0;
        for (Pizza element : pizzas) {
            sum += element.getPrice();
        }
        return sum;
    }




}
