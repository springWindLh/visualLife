package lh.world.form;

import lh.world.domain.Article;
import lh.world.form.support.BaseForm;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created by lh on 2016/8/11.
 */
public class ArticleForm extends BaseForm {
    @NotBlank(message = "{article.title.notBlank}")
    @Length(message = "{article.title.length}", max = 20)
    private String title;

    @NotBlank(message = "{article.content.notBlank}")
    private String content;

    @NotBlank(message = "{article.coverImg.notBlank}")
    private String coverImg;

    @Length(message = "{article.summarize.length}", max = 200)
    private String summarize;
    private Integer vote;
    private Integer weight;

    public ArticleForm() {
    }

    public ArticleForm(Article article) {
        this.setId(article.getId());
        this.setTitle(article.getTitle());
        this.setContent(article.getContent());
        this.setCoverImg(article.getCoverImg());
        this.setSummarize(article.getSummarize());
        this.setVote(article.getVote());
        this.setWeight(article.getWeight());
    }

    public Article asArticle() {
        Article article = new Article();
        if (this.getId() != null) {
            article.setId(this.getId());
            article.setUpdatedTime(new Date());
        }
        article.setTitle(this.getTitle());
        article.setContent(this.getContent());
        article.setCoverImg(this.getCoverImg());
        article.setSummarize(this.getSummarize());
        int vote = this.getVote() == null ? 0 : this.getVote();
        article.setVote(vote);
        article.setWeight(this.getWeight());
        return article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
