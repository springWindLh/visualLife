package lh.world.controller;

import com.google.common.base.Strings;
import lh.world.controller.support.AjaxResponse;
import lh.world.controller.support.BaseController;
import lh.world.domain.Comment;
import lh.world.form.CommentForm;
import lh.world.query.support.Query;
import lh.world.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by lh on 2016/9/18.
 */
@Controller
@RequestMapping("/comment")
public class CommentController extends BaseController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse list(Query query, String targetType, Long targetId) {
        Comment.TargetType type = null;
        if (!Strings.isNullOrEmpty(targetType)) {
            type = Comment.TargetType.valueOf(targetType);
        }
        Page<Comment> page = commentService.listByTargetTypeAndTargetId(type, targetId, false, query);
        return AjaxResponse.ok().data(page);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse add(@RequestBody @Valid CommentForm form, BindingResult result) {
        if (result.hasErrors()) {
            return getErrorInfo(result);
        }
        Comment comment = form.asComment();
        comment.setUser(getCurrentUser());
        try {
            comment = commentService.save(comment);
            return AjaxResponse.ok().msg("发表成功").data(comment);
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse remove(@PathVariable Long id) {
        try {
            commentService.remove(id);
            return AjaxResponse.ok().msg("删除成功");
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }
}
