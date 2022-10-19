import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Product.addBucket(new Product("молоко", 150, 1));
        Product.addBucket(new Product("слива", 300, 2));
        Product.addBucket(new Product("яблоко", 220, 3));
        Product.addBucket(new Product("масло", 630, 4));
        Product.addBucket(new Product("хлеб", 140, 6));
        Product.addBucket(new Product("мясо", 980, 8));

        Recipes.addProductSet(new Recipes(123, "Парацетомолл"));
        Recipes.addProductSet(new Recipes(21.3123, "Суп"));
        Recipes.addProductSet(new Recipes(555, "Парцетомолл"));
        Recipes.addProductSet(new Recipes(123, "Парацетоолл"));

//        System.out.println( meat.equals(bread));
//        sugar.setPrice(27.3);
//        sugar.setType("сахар");
//        Product.addBucket(sugar);
//        Product.addBucket(apple);
        System.out.println(Product.getBucket());
        System.out.println(Recipes.getProductSet());

//        Задание 2.2

        ArrayList<Integer> list = new ArrayList<>();
        int capacity = 20;
        for (int i = 0; i < capacity; i++) {
            int random_int = (int) Math.floor(Math.random() * (1000 - 1));
            list.add(random_int);
        }
        System.out.print(list + ", " + "\n");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i = 0;
            }

        }
        System.out.print(list + ", ");

        //        Задание 3.2
        ArrayList<String> questions = new ArrayList<>();
        Set<Integer> check = new HashSet<>();
        for (int i = 0; i < 15; ) {
            int a = randomInt();
            int b = randomInt();
            int multiplication = a * b;
            String primer = " Задание: " + a + " * " + b + " = ?";
            if (!(check.contains(multiplication))) {
                questions.add(i, primer);
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

        System.out.println(Passport.findThePassport("2313131"));

    }

    public static int randomInt() {
        //        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min); from 2 to 9
        int a = (int) Math.floor(Math.random() * (9 - 2 + 1) + 2);
        return a;
    }
}
