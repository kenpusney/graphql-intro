package graphql.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.example.constraints.Customer;
import graphql.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private CustomerRepository customerRepository;

    String message() {
        return "Hello world!";
    }

    Customer customer(String name) {
        return customerRepository.queryCustomer(name);
    }
}
