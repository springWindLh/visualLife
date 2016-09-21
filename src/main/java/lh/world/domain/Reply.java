package lh.world.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lh.world.domain.support.CanLogicDelDomain;

import javax.persistence.*;

/**
 * Created by lh on 2016/9/14.
 */
@Entity
@Table(name = "reply")
public class Reply extends CanLogicDelDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content", length = 500)
    private String content;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    @JSONField(serialize = false)
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @Column(name = "vote")
    private Integer vote = 0;

    @ManyToOne
    @JoinColumn(name = "accepter_id")
    private User accepter;

    public Reply() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getAccepter() {
        return accepter;
    }

    public void setAccepter(User accepter) {
        this.accepter = accepter;
    }

    public Integer getVote() {
        return vote;
    }

    public void setVote(Integer vote) {
        this.vote = vote;
    }
}
