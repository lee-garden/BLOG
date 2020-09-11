import java.util.Objects;

public class Toy {
    String name;
    int price;

    public Toy(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return price == toy.price &&
                Objects.equals(name, toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
