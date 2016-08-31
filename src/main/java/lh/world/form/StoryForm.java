package lh.world.form;

import lh.world.domain.Story;
import lh.world.form.support.BaseForm;

import java.time.LocalDateTime;

/**
 * Created by lh on 2016/8/31.
 */
public class StoryForm extends BaseForm {
    private String picture;
    private String description;

    public StoryForm() {
    }

    public StoryForm(Story story) {
        this.setId(story.getId());
        this.setPicture(story.getPicture());
        this.setDescription(story.getDescription());
    }

    public Story asStory() {
        Story story = new Story();
        if (this.getId() != null) {
            story.setId(this.getId());
            story.setUpdatedTime(LocalDateTime.now());
        }
        story.setPicture(this.getPicture());
        story.setDescription(this.getDescription());
        return story;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
