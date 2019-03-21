package graphql.example.relay;


import graphql.relay.*;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Base64.getEncoder;

public class PaginatedData<T> implements PageInfo, Iterable<T> {

    private final Page<T> page;
    private final long totalCount;

    public PaginatedData(Page<T> page) {
        this.page = page;
        this.totalCount = page.getTotalElements();
    }

    @Override
    public ConnectionCursor getStartCursor() {
        return createCursor(0);
    }

    @Override
    public ConnectionCursor getEndCursor() {
        return createCursor(page.getContent().size() - 1);
    }

    @Override
    public boolean isHasPreviousPage() {
        return page.hasPrevious();
    }

    @Override
    public boolean isHasNextPage() {
        return page.hasNext();
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return page.getContent().iterator();
    }


    public List<Edge<T>> toEdges() {
        List<T> content = page.getContent();
        return IntStream.range(0, content.size())
                .mapToObj(index -> {
                    return new DefaultEdge<>(content.get(index),
                            createCursor(index));
                })
                .collect(Collectors.toList());
    }

    public Connection<T> toConnection() {
        return new DefaultConnection<>(toEdges(),
                new DefaultPageInfo(getStartCursor(),
                        getEndCursor(),
                        isHasPreviousPage(),
                        isHasNextPage()));
    }

    private DefaultConnectionCursor createCursor(long index) {
        return new DefaultConnectionCursor(Optional.of(page.getPage() * page.getSize() + index)
                .map(String::valueOf)
                .map(String::getBytes)
                .map(getEncoder()::encodeToString)
                .orElse(""));
    }
}
