package graphql.example.repository;

import graphql.example.constraints.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class ProductRepository {
    public Product queryProduct(String id) {
        return new Product(id);
    }

    public List<Product> retrieveProducts(int page, int size) {
        return IntStream.range(0, size).mapToObj(x -> String.format("%s-%s", page, x))
                .map(Product::new).collect(Collectors.toList());
    }
}
