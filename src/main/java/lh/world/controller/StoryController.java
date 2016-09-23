package lh.world.controller;

import lh.world.controller.support.AjaxResponse;
import lh.world.controller.support.BaseController;
import lh.world.domain.Story;
import lh.world.form.StoryForm;
import lh.world.query.support.Query;
import lh.world.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by lh on 2016/8/31.
 */
@Controller
@RequestMapping("/story")
public class StoryController extends BaseController {
    @Autowired
    StoryService storyService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Query query, Model model) {
        Page<Story> page = storyService.listAll(query);
        model.addAttribute("page", page);
        return "/story/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("form", new StoryForm());
        return "/story/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse add(@RequestBody @Valid StoryForm form, BindingResult result) {
        if (result.hasErrors()) {
            return getErrorInfo(result);
        }
        Story story = form.asStory();
        story.setUser(getCurrentUser());
        try {
            storyService.save(story);
            return AjaxResponse.ok().msg("发表成功");
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable Long id, Model model) {
        Optional<Story> storyOptional = storyService.findById(id);
        if (!storyOptional.isPresent()) {
            return getResourceNotFound();
        }
        model.addAttribute("form", storyOptional.get());
        return "/story/detail";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable Long id, Model model) {
        Optional<Story> storyOptional = storyService.findById(id);
        if (!storyOptional.isPresent()) {
            return getResourceNotFound();
        }
        model.addAttribute("form", new StoryForm(storyOptional.get()));
        return "/story/form";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse update(@RequestBody @Valid StoryForm form, BindingResult result) {
        if (result.hasErrors()) {
            return getErrorInfo(result);
        }
        Optional<Story> storyOptional = storyService.findById(form.getId());
        if (!storyOptional.isPresent()) {
            return getAjaxResourceNotFound();
        }
        Story story = form.asStory();
        story.setUser(storyOptional.get().getUser());
        try {
            storyService.save(story);
            return AjaxResponse.ok().msg("更新成功").jumpUrl("/story/list");
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String userList(Query query, Model model) {
        Page<Story> page = storyService.listByUser(getCurrentUser(), query, false);
        model.addAttribute("page", page);
        return "/story/userList";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse remove(@PathVariable Long id) {
        try {
            storyService.remove(id);
            return AjaxResponse.ok().msg("删除成功");
        } catch (Exception e) {
            return AjaxResponse.fail().msg(e.getMessage());
        }
    }
}
