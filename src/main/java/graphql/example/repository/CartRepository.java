package graphql.example.repository;

import graphql.example.constraints.Cart;
import graphql.example.constraints.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CartRepository {
    private Map<String, Cart> carts = new HashMap<>();

    public Cart queryCart(Customer customer) {
        return carts.getOrDefault(customer.getName(), new Cart());
    }

    public Cart addProductIntoCart(Customer customer, String productId) {
        carts.putIfAbsent(customer.getName(), new Cart());

        Cart cart = carts.get(customer.getName());
        cart.getProducts().add(productId);

        return cart;
    }

    public Cart clearCart(Customer customer) {
        Cart newCart = new Cart();
        carts.put(customer.getName(), newCart);

        return newCart;
    }
}
