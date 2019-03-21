package graphql.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.example.constraints.Cart;
import graphql.example.constraints.Customer;
import graphql.example.constraints.Order;
import graphql.example.repository.CartRepository;
import graphql.example.repository.CustomerRepository;
import graphql.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;


    public Cart addCartItem(String customerName, String productId) {
        return cartRepository.addProductIntoCart(
                customerRepository.queryCustomer(customerName),
                productId);
    }

    public Cart clearCart(String customerName) {
        return cartRepository.clearCart(customerRepository.queryCustomer(customerName));
    }

    public Order createOrder(String customerName) {
        Customer customer = customerRepository.queryCustomer(customerName);
        return orderRepository.createOrder(customer, cartRepository.queryCart(customer));
    }
}
