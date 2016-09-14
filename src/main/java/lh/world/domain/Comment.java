package lh.world.domain;

import lh.world.domain.support.CanLogicDelDomain;

import javax.persistence.*;

/**
 * Created by lh on 2016/9/14.
 */
@Entity
@Table(name = "comment")
public class Comment extends CanLogicDelDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "target_id")
    private Long targetId;

    @Column(name = "target_type")
    @Enumerated(value = EnumType.STRING)
    private TargetType targetType;

    @Column(name = "content",length = 500)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Comment() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public enum TargetType{
        ARTICLE("文章"),
        STORY("故事"),
        SUGGESTION("意见");

        private String value;

        private TargetType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
