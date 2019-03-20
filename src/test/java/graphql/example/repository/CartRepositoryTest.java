package graphql.example.repository;

import com.google.common.collect.ImmutableList;
import graphql.example.constraints.Cart;
import graphql.example.constraints.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CartRepositoryTest {

    private static final String CUSTOMER = "CUSTOMER";
    private static final String PRODUCT = "PRODUCT";
    private CartRepository repository = new CartRepository();


    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer();
        customer.setName(CUSTOMER);
    }

    @Test
    public void shouldReturnEmptyCartIfNoProductAdded() {

        Cart cart = repository.queryCart(customer);

        assertTrue(cart.getProducts().isEmpty());
    }

    @Test
    public void shouldReturnAddedProductsIfCartContainsProducts() {
        repository.addProductIntoCart(customer, PRODUCT);

        Cart cart = repository.queryCart(customer);

        assertThat(cart.getProducts(), is(ImmutableList.of(PRODUCT)));
    }

    @Test
    public void shouldReturnAddedProduct() {

        Cart cart = repository.addProductIntoCart(customer, PRODUCT);

        assertThat(cart.getProducts(), is(ImmutableList.of(PRODUCT)));
    }
}