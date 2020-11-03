package Tools;

import MariosPizza.Pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PizzaReader {
    private Scanner fileReader;
    private File pizzaMenu;


    public ArrayList<Pizza> loadMenu() {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        pizzaMenu = new File("PizzaMenu");
        try {
            fileReader = new Scanner(pizzaMenu);
            while (fileReader.hasNext()) {
                String name = fileReader.nextLine();
                String[] ingredients = fileReader.nextLine().split(",");
                double price = Double.parseDouble(fileReader.nextLine());

                pizzas.add(new Pizza(name, ingredients, price));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return pizzas;

    }


    public void printMenu(){
        ArrayList<Pizza> pizzas = loadMenu();

        int i = 1;
        for (Pizza element : pizzas) {

            System.out.println(i + ". " + element.toString());
            i++;
        }

    }
}
