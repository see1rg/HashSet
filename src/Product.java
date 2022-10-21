import java.util.HashSet;
import java.util.Set;

public class Product {
    private String type;
    private double price;
    private double weight;

    private static Set<Product> bucket = new HashSet<>();

    public Product(String type, double price, double weight) {
        this.type = type;
        this.price = price;
        this.weight = weight;
    }

    public static Set<Product> getBucket() {
        return bucket;
    }

    public static void addBucket(Product type) throws Exception {
        if (type.getType() == null || type.getPrice() == 0 || type.getWeight() == 0) {
            throw new Exception("Заполните карточку товара полностью.");
        }
        if (!bucket.contains(type)) {
            bucket.add(type);
        } else {
            throw new Exception("Продукт " + type + " уже есть в корзине.");
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (Double.compare(product.getWeight(), getWeight()) != 0) return false;

        return (getType().equals(product.getType()));
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getType().hashCode();
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

