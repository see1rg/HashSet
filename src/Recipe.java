import java.util.HashSet;
import java.util.Set;

public class Recipe<T extends Product> {
    private double sumOfTheRecipe;
    private String nameOfTheRecipe;
    private static Set<Product> setOfProducts;
    private static final Set<Recipe> productSet = new HashSet<>();


    public Recipe(String nameOfTheRecipe, Set<Product> setOfProducts) {
        Recipe.setOfProducts = new HashSet<>();
        double sumOfTheRecipe1 = 0;
        for (Product product : setOfProducts) {
            sumOfTheRecipe1 += product.getPrice();
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


    public static Set<Product> getSetOfProducts() {
        return setOfProducts;
    }

    public static void setSetOfProducts(Set<Product> setOfProducts) {
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
        if (!(o instanceof Recipe recipe)) return false;

        if (Double.compare(recipe.getSumOfTheRecipe(), getSumOfTheRecipe()) != 0) return false;
        return getNameOfTheRecipe() != null ? getNameOfTheRecipe().equals(recipe.getNameOfTheRecipe()) : recipe.getNameOfTheRecipe() == null;
    }


}
