package graphql.example.constraints;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<String> products = new ArrayList<>();

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
