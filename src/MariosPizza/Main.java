package MariosPizza;

import Menu.GeneriskMenu;
import Tools.PizzaReader;

import java.time.LocalTime;
import java.util.*;

public class Main {
    private ArrayList<Order> pizzaQueue = new ArrayList<>();


    public void sortAfterPickUpTime() {
        for (int i = 1; i < pizzaQueue.size(); i++) {
            for (int j = 0; j < pizzaQueue.size(); j++) {
                Order temp = pizzaQueue.get(j);
                if (temp.getPickUptime().isAfter(pizzaQueue.get(i).getPickUptime())) {
                    temp = pizzaQueue.get(i);
                    pizzaQueue.set(i, pizzaQueue.get(j));
                    pizzaQueue.set(j, temp);

                }
            }
        }
    }

    void nextOrder() {
        sortAfterPickUpTime();
        if (pizzaQueue.size() < 1) {
            System.out.println("Ingen nuværende ordrer\n");
        } else
            pizzaQueue.get(0).showOrder();
    }

    void orderAdder() {
        Order order = new Order();
        ArrayList<Pizza> pizzas = order.inputOrder();
        LocalTime timeNow = LocalTime.now();
        double totalPriceOrder = new Order(timeNow, pizzas).totalPrice();
        LocalTime pickUpTime = timeNow.plusMinutes(60);
        System.out.println("Er ordren bestilt i butikken? (y/n)");
        String orderInStore = new Scanner(System.in).nextLine();
        if (orderInStore.equalsIgnoreCase("y"))
            pickUpTime = timeNow.plusMinutes(15);
        pizzaQueue.add(new Order(timeNow, pickUpTime, pizzas, totalPriceOrder));

    }

    void run() {
        GeneriskMenu menu = new GeneriskMenu("Marios PizzaBar", "Vælg menupunkt: ",
                new String[]{"1. Se menukort", "2. Indtast bestilling", "3. Vis bestillingskø",
                        "4. Næste ordre", "5. Færdiggør ordre",  "9. Exit"});
        boolean run = true;

        while (run) {

            menu.printGeneriskMenu();
            int choice = menu.readChoice();

            switch (choice) {
                case 1:
                    new PizzaReader().printMenu();
                    break;
                case 2:
                    orderAdder();
                    break;
                case 3:
                    sortAfterPickUpTime();
                    for (Order element : pizzaQueue)
                        element.showOrder();
                    break;
                case 4:
                    nextOrder();
                    break;
                case 5:
                    sortAfterPickUpTime();
                    System.out.println("Afslut næste ordre i køen? (y/n)");
                    String brugerSvar = new Scanner(System.in).nextLine();
                    if (brugerSvar.equalsIgnoreCase("y")) {
                        if (pizzaQueue.size() > 0)  {
                            pizzaQueue.remove(0);
                            break;
                        }
                    }
                    break;

                case 9:
                    run = false;
                    return;

            }
        }
    }


    public static void main(String[] args) {

        new Main().run();


    }
}
