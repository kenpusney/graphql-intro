package graphql.example.resolvers;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class QueryResolverTest {


    private final QueryResolver resolver = new QueryResolver();

    @Test
    public void shouldGetMessageSuccessfully() {

        assertThat(resolver.message(), is("Hello world!"));
    }
}