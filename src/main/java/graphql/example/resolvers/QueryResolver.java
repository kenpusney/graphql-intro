package graphql.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.example.constraints.Customer;
import graphql.example.constraints.Product;
import graphql.example.relay.Page;
import graphql.example.relay.PageRequest;
import graphql.example.relay.PaginatedData;
import graphql.example.repository.CustomerRepository;
import graphql.example.repository.ProductRepository;
import graphql.relay.Connection;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    String message() {
        return "Hello world!";
    }

    Customer customer(String name) {
        return customerRepository.queryCustomer(name);
    }

    Connection<Product> products(Integer first, String after, DataFetchingEnvironment env) {
        PageRequest request = Page.request(first, after);

        List<Product> products = productRepository.retrieveProducts(request.getPage(), request.getSize());

        return new PaginatedData<>(new Page<>(request.getPage(), request.getSize(), products, 65536))
                .toConnection();
    }
}
