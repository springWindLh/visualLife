package lh.world.form;

import lh.world.domain.Reply;
import lh.world.form.support.BaseForm;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created by lh on 2016/9/18.
 */
public class ReplyForm extends BaseForm {
    @NotBlank(message = "{reply.content.notBlank}")
    @Length(message = "{reply.content.length}", max = 500)
    private String content;
    private Long commentId;
    private Long accepterId;

    public ReplyForm() {
    }

    public Reply asReply() {
        Reply reply = new Reply();
        if (this.getId() != null) {
            reply.setId(this.getId());
            reply.setUpdatedTime(new Date());
        }
        reply.setContent(this.getContent());
        return reply;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getAccepterId() {
        return accepterId;
    }

    public void setAccepterId(Long accepterId) {
        this.accepterId = accepterId;
    }
}
