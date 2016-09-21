package lh.world.domain;

import lh.world.domain.support.CanLogicDelDomain;

import javax.persistence.*;

/**
 * Created by lh on 2016/8/8.
 */
@Entity
@Table(name = "article")
public class Article extends CanLogicDelDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "content")
    private String content;
    @Column(name = "cover_img")
    private String coverImg;
    @Column(name = "summarize")
    private String summarize;
    @Column(name = "vote")
    private Integer vote = 0;
    @Column(name = "weight")
    private Integer weight = 0;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Article() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
