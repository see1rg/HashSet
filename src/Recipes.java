import java.util.HashSet;
import java.util.Set;

public class Recipes {
    private double sumOfTheRecipe;
    private String nameOfTheRecipe;
    private static Set<Recipes> productSet = new HashSet<>();

    public Recipes(double sumOfTheRecipe, String nameOfTheRecipe) {
        this.sumOfTheRecipe = sumOfTheRecipe;
        this.nameOfTheRecipe = nameOfTheRecipe;
    }

    public static void addProductSet(Recipes recipes) throws Exception {
        for (Recipes recipes1 : productSet) {
            if (recipes1.getNameOfTheRecipe().equals(recipes.getNameOfTheRecipe())) {
                throw new Exception("Попытка добавить рецепт с названием, которое уже существует");
            }
        }
        productSet.add(recipes);
    }

    public double getSumOfTheRecipe() {
        return sumOfTheRecipe;
    }

    public String getNameOfTheRecipe() {
        return nameOfTheRecipe;
    }

    public static Set<Recipes> getProductSet() {
        return productSet;
    }

//      return (o instanceof Fee) && ((Fee)o.getName()).equals(this.getName());


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipes recipes)) return false;

        if (Double.compare(recipes.getSumOfTheRecipe(), getSumOfTheRecipe()) != 0) return false;
        return getNameOfTheRecipe() != null ? getNameOfTheRecipe().equals(recipes.getNameOfTheRecipe()) : recipes.getNameOfTheRecipe() == null;
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
        return "Recipes{" +
                "sumOfTheRecipe=" + sumOfTheRecipe +
                ", nameOfTheRecipe='" + nameOfTheRecipe + '\'' +
                '}';
    }
}
