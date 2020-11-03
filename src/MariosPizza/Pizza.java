package MariosPizza;

public class Pizza {
    private String name;
    private String[] ingredients;
    private double price;
    // private boolean familySize;


    public Pizza(String name, String[] ingredients, double price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {return name;}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        String stringIngredients = "";
        for (String element : ingredients) {
            stringIngredients += element + ",";
        }
        String format = String.format("%s: %s %,.2f", name, stringIngredients, price);
        return format;
    }



}
