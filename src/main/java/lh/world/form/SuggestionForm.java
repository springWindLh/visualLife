package lh.world.form;

import lh.world.domain.Suggestion;
import lh.world.form.support.BaseForm;

import java.util.Date;

/**
 * Created by lh on 2016/9/18.
 */
public class SuggestionForm extends BaseForm {
    private String content;

    public SuggestionForm() {
    }

    public Suggestion asSuggestion() {
        Suggestion suggestion = new Suggestion();
        if (this.getId() != null) {
            suggestion.setId(this.getId());
            suggestion.setUpdatedTime(new Date());
        }
        suggestion.setContent(this.getContent());
        return suggestion;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
