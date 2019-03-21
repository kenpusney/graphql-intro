package graphql.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.example.constraints.Order;
import graphql.example.constraints.Product;
import graphql.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderResolver implements GraphQLResolver<Order> {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> products(Order order) {
        return order.getProductIds().stream().map(productRepository::queryProduct)
                .collect(Collectors.toList());
    }
}
