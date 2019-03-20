package graphql.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.example.constraints.Cart;
import graphql.example.repository.CartRepository;
import graphql.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;


    public Cart addCartItem(String customerName, String productId) {
        return cartRepository.addProductIntoCart(
                customerRepository.queryCustomer(customerName),
                productId);
    }
}
