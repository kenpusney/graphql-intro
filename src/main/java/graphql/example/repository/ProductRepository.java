package graphql.example.repository;

import graphql.example.constraints.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    public Product queryProduct(String id) {
        return new Product(id);
    }
}
