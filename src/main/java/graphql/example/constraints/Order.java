package graphql.example.constraints;

import java.util.List;

public class Order {
    String id;
    List<String> productIds;

    public Order(String id, List<String> products) {
        this.id = id;
        this.productIds = products;
    }


    public String getId() {
        return id;
    }

    public List<String> getProductIds() {
        return productIds;
    }
}
