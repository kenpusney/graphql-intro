package graphql.example.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;


@Component
public class QueryResolver implements GraphQLQueryResolver {

    String message() {
        return "Hello world!";
    }
}
