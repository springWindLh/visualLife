package lh.world.form;

import lh.world.domain.Comment;
import lh.world.form.support.BaseForm;

import java.util.Date;

/**
 * Created by lh on 2016/9/18.
 */
public class CommentForm extends BaseForm {
    private Long targetId;
    private String targetType;
    private String content;

    public CommentForm() {
    }

    public Comment asComment() {
        Comment comment = new Comment();
        if (this.getId() != null) {
            comment.setId(this.getId());
            comment.setUpdatedTime(new Date());
        }
        comment.setContent(this.getContent());
        comment.setTargetId(this.getTargetId());
        if (this.getTargetType() != null) {
            comment.setTargetType(Comment.TargetType.valueOf(this.getTargetType()));
        }
        return comment;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
