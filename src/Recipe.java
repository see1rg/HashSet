import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Recipe<T extends Product> {
    private double sumOfTheRecipe;
    private String nameOfTheRecipe;
    private static Map<Product, Integer> setOfProducts;
    private static final Set<Recipe> productSet = new HashSet<>();

    public Recipe(String nameOfTheRecipe, Map<Product, Integer> setOfProducts) {
        Recipe.setOfProducts = new HashMap<>();
        double sumOfTheRecipe1 = 0;
        for (Map.Entry<Product, Integer> productIntegerEntry : setOfProducts.entrySet()) {
            int amount;
            if (productIntegerEntry.getValue() == 0 || productIntegerEntry.getValue() < 0) {
                amount = 1;
            } else {
                amount = productIntegerEntry.getValue();
            }
            sumOfTheRecipe1 += (productIntegerEntry.getKey().getPrice()) * amount;
        }
        this.sumOfTheRecipe = sumOfTheRecipe1;
        this.nameOfTheRecipe = nameOfTheRecipe;
    }

    public static void addProductSet(Recipe recipe) throws Exception {
        for (Recipe recipe1 : productSet) {
            if (recipe1.getNameOfTheRecipe().equals(recipe.getNameOfTheRecipe())) {
                throw new Exception("Попытка добавить рецепт с названием, которое уже существует");
            }
        }
        productSet.add(recipe);
    }

    public static Map<Product, Integer> getSetOfProducts() {
        return setOfProducts;
    }

    public static void setSetOfProducts(Map<Product, Integer> setOfProducts) {
        Recipe.setOfProducts = setOfProducts;
    }

    public double getSumOfTheRecipe() {
        return sumOfTheRecipe;
    }

    public String getNameOfTheRecipe() {
        return nameOfTheRecipe;
    }

    public static Set<Recipe> getProductSet() {
        return productSet;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe<?> recipe)) return false;

        if (Double.compare(recipe.getSumOfTheRecipe(), getSumOfTheRecipe()) != 0) return false;
        return getNameOfTheRecipe().equals(recipe.getNameOfTheRecipe());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getSumOfTheRecipe());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getNameOfTheRecipe().hashCode();
        return result;
    }
}
