package graphql.example.relay;

public class PageRequest {
    public PageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    private final int page;
    private final int size;

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }



}
