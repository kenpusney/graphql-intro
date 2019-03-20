package graphql.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.example.constraints.Cart;
import graphql.example.constraints.Product;
import graphql.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartResolver implements GraphQLResolver<Cart> {

    @Autowired
    private ProductRepository productRepository;

    List<Product> inCartProducts(Cart cart) {
        return cart.getProducts().stream().map(productRepository::queryProduct)
                .collect(Collectors.toList());
    }
}
