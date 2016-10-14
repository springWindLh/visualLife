package lh.world.query;


import lh.world.query.support.Query;

/**
 * Created by lh on 2016/8/26.
 */
public class ArticleQuery extends Query {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
