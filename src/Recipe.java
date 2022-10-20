import java.util.HashSet;
import java.util.Set;

public class Recipe<T extends Product> {
    private double sumOfTheRecipe;
    private String nameOfTheRecipe;
    private T product;
    private T product1;
    private T product2;
    private static Set<Product> lotsOfProducts ;
    private static Set<Recipe> productSet = new HashSet<>();


    public Recipe(String nameOfTheRecipe, Set<Product>lotsOfProducts) {
        this.lotsOfProducts = new HashSet<>();
        this.sumOfTheRecipe = product.getPrice();
        this.nameOfTheRecipe = nameOfTheRecipe;
    }

    public Recipe(String nameOfTheRecipe, T product, T product1) {
        this.product = product;
        this.product1 = product1;
        this.sumOfTheRecipe = product.getPrice() + product1.getPrice();
        this.nameOfTheRecipe = nameOfTheRecipe;
    }

    public Recipe(String nameOfTheRecipe, T product, T product1, T product2) {
        this.product = product;
        this.product1 = product1;
        this.product2 = product2;
        this.sumOfTheRecipe = product.getPrice() + product1.getPrice() + product2.getPrice();
        this.nameOfTheRecipe = nameOfTheRecipe;
    }

//    public static void addlotsOfProducts(Product product) throws Exception {
//        lotsOfProducts.add(product);
//    }
    public static void addProductSet(Recipe recipe) throws Exception {
        for (Recipe recipe1 : productSet) {
            if (recipe1.getNameOfTheRecipe().equals(recipe.getNameOfTheRecipe())) {
                throw new Exception("Попытка добавить рецепт с названием, которое уже существует");
            }
        }
        productSet.add(recipe);
    }

    public  Set<Product> getLotsOfProducts() {
        return lotsOfProducts;
    }

    public static void setLotsOfProducts(Set<Product> lotsOfProducts) {
        Recipe.lotsOfProducts = lotsOfProducts;
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

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getSumOfTheRecipe());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getNameOfTheRecipe() != null ? getNameOfTheRecipe().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "sumOfTheRecipe=" + sumOfTheRecipe +
                ", nameOfTheRecipe='" + nameOfTheRecipe + '\'' +
                ", product=" + product +
                ", product1=" + product1 +
                ", product2=" + product2 +
                '}';
    }
}
