package lh.world.web.controller;

import lh.world.web.controller.support.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lh on 2016/9/18.
 */
@Controller
@RequestMapping("/suggestion")
public class SuggestionController extends BaseController {
//    @Autowired
//    SuggestionService suggestionService;
//
//    @RequestMapping(value = "/list/page", method = RequestMethod.GET)
//    public String listPage(){
//        return "/suggestion/list";
//    }
//
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @ResponseBody
//    public AjaxResponse list(Query query) {
//        Page<Suggestion> page = suggestionService.listAll(query);
//        return AjaxResponse.ok().data(page);
//    }
//
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @ResponseBody
//    public AjaxResponse add(@RequestBody @Valid SuggestionForm form, BindingResult result) {
//        if (result.hasErrors()) {
//            return getErrorInfo(result);
//        }
//        Suggestion suggestion = form.asSuggestion();
//        suggestion.setUser(getCurrentUser());
//        try {
//            suggestionService.save(suggestion);
//            return AjaxResponse.ok().msg("发表成功");
//        } catch (Exception e) {
//            return AjaxResponse.fail().msg(e.getMessage());
//        }
//    }
//
//    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
//    @ResponseBody
//    public AjaxResponse remove(@PathVariable Long id) {
//        try {
//            suggestionService.remove(id);
//            return AjaxResponse.ok().msg("删除成功");
//        } catch (Exception e) {
//            return AjaxResponse.fail().msg(e.getMessage());
//        }
//    }
}
