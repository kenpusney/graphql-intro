package graphql.example.resolvers;

import graphql.example.constraints.Customer;
import graphql.example.repository.CartRepository;
import graphql.example.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MutationResolverTest {
    private static final String CUSTOMER = "CUSTOMER";
    private static final String PRODUCT = "PRODUCT";
    @InjectMocks
    private MutationResolver resolver;

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CartRepository cartRepository;

    @Test
    public void shouldAddProductSuccessfully() {
        when(customerRepository.queryCustomer(CUSTOMER)).thenReturn(new Customer());

        resolver.addCartItem(CUSTOMER, PRODUCT);

        verify(customerRepository).queryCustomer(CUSTOMER);
        verify(cartRepository).addProductIntoCart(any(), eq(PRODUCT));
    }
}