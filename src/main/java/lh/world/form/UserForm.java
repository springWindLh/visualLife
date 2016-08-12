package lh.world.form;

import lh.world.domain.User;
import lh.world.form.support.BaseForm;

/**
 * Created by lh on 2016/8/11.
 */
public class UserForm extends BaseForm {
    private String name;
    private String password;
    private String mobile;
    private String avatar;
    private String introduce;

    public UserForm() {
    }

    public UserForm(User user) {
        this.setId(user.getId());
        this.setName(user.getName());
        this.setPassword(user.getPassword());
        this.setMobile(user.getMobile());
        this.setAvatar(user.getAvatar());
        this.setIntroduce(user.getIntroduce());
    }

    public User asUser(){
        User user = new User();
        if (this.getId() != null) {
            user.setId(this.getId());
        }
        user.setName(this.getName());
        user.setPassword(this.getPassword());
        user.setMobile(this.getMobile());
        // TODO: 2016/8/11 需要一个默认头像地址
        user.setAvatar(this.getAvatar());
        user.setIntroduce(this.getIntroduce());
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
