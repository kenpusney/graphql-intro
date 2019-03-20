package graphql.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.example.constraints.Cart;
import graphql.example.constraints.Customer;
import graphql.example.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerResolver implements GraphQLResolver<Customer> {

    @Autowired
    private CartRepository cartRepository;


    public Cart cart(Customer customer) {
        return cartRepository.queryCart(customer);
    }
}
