package lh.world.query.support;

/**
 * Created by lh on 2016/4/19.
 */
public class Query {
    private int page;
    private int size;

    public Query() {
        this(0, 10);
    }

    public Query(int page, int size) {
        if (page < 0 || size < 0) throw new IllegalArgumentException("index or size must be natural number");
        this.page = page;
        this.size = size;
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

}
