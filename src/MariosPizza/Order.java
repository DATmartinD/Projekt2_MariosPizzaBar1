package MariosPizza;

import Tools.PizzaReader;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private LocalTime time;
    private ArrayList<Pizza> pizzas;
    private double totalPrice;


    public Order() {
        super();
    }

    public Order(LocalTime time, ArrayList<Pizza> pizzas) {
        this.time = time;
        this.pizzas = pizzas;
    }


    public Order(LocalTime time, ArrayList<Pizza> pizzas, double totalPrice) {
        this.time = time;
        this.pizzas = pizzas;
        this.totalPrice = totalPrice;
    }



    ArrayList<Pizza> inputOrder() {
        Scanner in = new Scanner(System.in);
        boolean orderFinished = false;
        pizzas = new PizzaReader().loadMenu();

        while (true) {


            System.out.println("Indtast pizzanavn");
            String name = in.nextLine();
            System.out.println("Antal af denne pizza?");
            int antal = in.nextInt();

            int pizzaNr = new PizzaReader().searchForPizza(name);
            double price = pizzas.get(pizzaNr).getPrice();


            for(int i = 1; i <= antal; i++) {
                pizzas.add(new Pizza(name, price));
            }
            System.out.println("Er ordren færdig? (n for at tilføje mere til ordren, y for at afslutte ordren");
            in.nextLine();
            String orderDone = in.nextLine();

            if (orderDone.equalsIgnoreCase("y")) {
                orderFinished = true;
                return pizzas;
            }


        }
    }







    double totalPrice() {
        double sum = 0.0;
        for (Pizza element : pizzas) {
            sum += element.getPrice();
        }
        return sum;
    }




}
