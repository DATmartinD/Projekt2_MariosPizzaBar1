package MariosPizza;

import Menu.GeneriskMenu;
import Tools.PizzaReader;

import java.time.LocalTime;
import java.util.*;

public class Main {
    private Queue<Order> pizzaQueue = new LinkedList<>();


    void run() {
        GeneriskMenu menu = new GeneriskMenu("Marios PizzaBar", "Vælg menupunkt: ",
                new String[]{"1. Se menukort", "2. Indtast bestilling", "9. Exit"});
        menu.printGeneriskMenu();
        int choice = menu.readChoice();

        switch (choice) {
            case 1:
                new PizzaReader().printMenu();
                break;
            case 2:
                ArrayList<Pizza> pizzas = new Order().inputOrder();
                LocalTime timeNow = LocalTime.now();
                double totalPriceOrder = new Order(timeNow, pizzas).totalPrice();
                pizzaQueue.add(new Order(timeNow,pizzas,totalPriceOrder));
                break;


            case 9:
                return;

        }
    }


    public static void main(String[] args) {

        new Main().run();


    }
}
