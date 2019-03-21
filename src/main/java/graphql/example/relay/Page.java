package graphql.example.relay;

import java.util.List;
import java.util.Optional;

import static java.util.Base64.getDecoder;

public class Page<T> {
    private int page;
    private int size;
    private List<T> content;
    private long totalElements;

    public Page(int page, int size, List<T> content, long totalElements) {
        this.page = page;
        this.size = size;
        this.content = content;
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) getTotalElements() / (double) getSize());
    }


    public boolean hasPrevious() {
        return page > 0;
    }

    public boolean hasNext() {
        return page + 1 < getTotalPages();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }


    public static PageRequest request(Integer first, String after) {
        int size = Optional.ofNullable(first).orElse(10);
        int afterNum = Optional.ofNullable(after)
                .map(getDecoder()::decode)
                .map(String::new)
                .map(Integer::parseInt)
                .orElse(0);

        int page = ((afterNum + 1) / size);

        return new PageRequest(page, size);
    }
}
