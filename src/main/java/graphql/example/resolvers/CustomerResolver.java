package graphql.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.example.constraints.Cart;
import graphql.example.constraints.Customer;
import graphql.example.constraints.Order;
import graphql.example.repository.CartRepository;
import graphql.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Component
public class CustomerResolver implements GraphQLResolver<Customer> {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;


    public Cart cart(Customer customer) {
        return cartRepository.queryCart(customer);
    }

    public List<Order> orders(Customer customer, List<String> filter) {
        return orderRepository.query(customer, Optional.ofNullable(filter).orElse(emptyList()));
    }
}
