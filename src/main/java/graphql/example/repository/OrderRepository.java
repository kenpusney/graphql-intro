package graphql.example.repository;

import graphql.example.constraints.Cart;
import graphql.example.constraints.Customer;
import graphql.example.constraints.Order;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    private Map<String, List<Order>> orders = new HashMap<>();

    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(Customer customer, Cart cart) {

        Order order = new Order(UUID.randomUUID().toString(),
                cart.getProducts());

        orders.putIfAbsent(customer.getName(), new ArrayList<>());

        orders.get(customer.getName()).add(order);

        return order;
    }

    public List<Order> query(Customer customer, List<String> filter) {
        return orders.getOrDefault(customer.getName(), Collections.emptyList())
                .stream().filter(order -> filter.isEmpty() || filter.contains(order.getId()))
                .collect(Collectors.toList());
    }
}
