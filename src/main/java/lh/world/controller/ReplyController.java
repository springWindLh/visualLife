package lh.world.controller;

import lh.world.controller.support.AjaxResponse;
import lh.world.controller.support.BaseController;
import lh.world.domain.Reply;
import lh.world.form.ReplyForm;
import lh.world.query.support.Query;
import lh.world.service.ReplyService;
import lh.world.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by lh on 2016/9/18.
 */
@Controller
@RequestMapping("/reply")
public class ReplyController extends BaseController {
    @Autowired
    ReplyService replyService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResponse list(Query query, Long commentId) {
        Page<Reply> page = replyService.listByCommentId(commentId, false, query);
        return AjaxResponse.ok().data(page);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse add(@RequestBody @Valid ReplyForm form, BindingResult result) {
        if (result.hasErrors()) {
            return getErrorInfo(result);
        }
        Reply reply = form.asReply();
        reply.setSender(getCurrentUser());
        try {
            reply = replyService.save(reply, form.getCommentId(), form.getAccepterId());
            return AjaxResponse.ok().msg("发表成功").data(reply);
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse remove(@PathVariable Long id) {
        try {
            replyService.remove(id);
            return AjaxResponse.ok().msg("删除成功");
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

    @RequestMapping(value = "/vote/{id}", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse vote(@PathVariable Long id) {
        Optional<Reply> replyOptional = replyService.findById(id);
        if (!replyOptional.isPresent()) {
            return getAjaxResourceNotFound();
        }
        Reply reply = replyOptional.get();
        reply.setVote(reply.getVote() + 1);
        try {
            reply = replyService.save(reply);
            return AjaxResponse.ok().msg("点赞成功").data(reply);
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }
}
