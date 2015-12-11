package ua.org.oa.podkopayv.zmarket3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.oa.podkopayv.zmarket3.model.Category;
import ua.org.oa.podkopayv.zmarket3.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Category> getAll() {
        return categoryService.getAll();
    }

}
