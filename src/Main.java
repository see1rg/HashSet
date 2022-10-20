import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

        Recipe<Product> recipe1 = new Recipe<>("recipe1", milk, plum);
        Recipe<Product> recipe2 = new Recipe<>("recipe2", milk, plum);
        Recipe<Product> recipe3 = new Recipe<>("recipe3", apple, oil, bread);
        Recipe<Product> recipe4 = new Recipe<>("recipe4", meat, oil, bread);
        recipe1.getLotsOfProducts().add(new Product("мука",123,222));
        Recipe recipe5;
        recipe5 = new Recipe<>("jdkj", (Set<Product>) recipe1);
        Recipe.addProductSet(recipe1);
        Recipe.addProductSet(recipe2);
        Recipe.addProductSet(recipe3);
        Recipe.addProductSet(recipe4);

        System.out.println(Product.getBucket());
        System.out.println(Recipe.getProductSet());

//        Задание 2.2

        ArrayList<Integer> list = new ArrayList<>();
        int capacity = 20;
        for (int i = 0; i < capacity; i++) {
            int random_int = (int) Math.floor(Math.random() * (1000 - 1));
            list.add(random_int);
        }
        System.out.print(list + ", " + "\n");

        list.removeIf(e -> e % 2 == 1);
        System.out.print(list + ", ");

        //        Задание 3.2
        ArrayList<String> questions = new ArrayList<>();
        Set<Integer> check = new HashSet<>();
        for (int i = 0; i < 15; ) {
            int a = randomInt();
            int b = randomInt();
            int multiplication = a * b;
            String exercise = " Задание: " + a + " * " + b + " = ?";
            if (!(check.contains(multiplication))) {
                questions.add(i, exercise);
                check.add(multiplication);
                i++;
            }
        }
        System.out.println();
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i));
        }

//        Задание 3.3
        Passport.addPassport(new Passport("23131321", "Малахов", "Игорь",
                "Петрович", "12.02.1977"));
        System.out.println(Passport.getPassport());

        System.out.println(Passport.findThePassport("23131321"));

    }

    public static int randomInt() {
        //        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min); from 2 to 9
        int a = (int) Math.floor(Math.random() * (9 - 2 + 1) + 2);
        return a;
    }
}
