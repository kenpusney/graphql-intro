package graphql.example.repository;

import graphql.example.constraints.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    public Customer queryCustomer(String name) {
        return new Customer(name);
    }
}
