import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Product milk = new Product("молоко", 150, 1);
        Product plum = new Product("слива", 300, 2);
        Product apple = new Product("яблоко", 220, 3);
        Product oil = new Product("масло", 630, 4);
        Product bread = new Product("хлеб", 140, 6);
        Product meat = new Product("мясо", 980, 8);

        Product.addBucket(milk);
        Product.addBucket(plum);
        Product.addBucket(apple);
        Product.addBucket(oil);
        Product.addBucket(bread);
        Product.addBucket(meat);

        Map<Product, Integer> set1 = new HashMap<>();
        set1.put(meat, 5);
        set1.put(apple, 4);
        set1.put(plum, 2);
        set1.put(oil, 8);
        Recipe<Product> recipe5 = new Recipe<>("jdkj", set1);

        System.out.println(recipe5.getSumOfTheRecipe());
        System.out.println(Product.getBucket());

    }
}
