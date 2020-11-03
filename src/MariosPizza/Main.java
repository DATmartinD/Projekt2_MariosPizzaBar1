package MariosPizza;

import Menu.GeneriskMenu;
import Tools.PizzaReader;

public class Main {



    void run() {
        GeneriskMenu menu = new GeneriskMenu("Marios PizzaBar", "Vælg menupunkt: ",
                new String[]{"1. Se menukort", "9. Exit"});
        menu.printGeneriskMenu();
        int choice = menu.readChoice();

        switch (choice) {
            case 1:
                new PizzaReader().printMenu();
                break;
            case 9:
                return;

        }
    }


    public static void main(String[] args) {

        new Main().run();


    }
}
