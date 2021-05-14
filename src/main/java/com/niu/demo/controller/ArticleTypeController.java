package com.niu.demo.controller;

import com.niu.demo.entity.ArticleType;
import com.niu.demo.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleTypeController {
    @Autowired
    private ArticleTypeService articleTypeService;

    @GetMapping("/addArticleType")
    public String addArticleType() {
        return "addArticleType";
    }

    @PostMapping("/addArticleType")
    @ResponseBody
    public ArticleType addArticleType(ArticleType articleType) {
        articleTypeService.add(articleType);
        return articleType;
    }

    @GetMapping("/getArticleTypes")
    public String getArticleTypes(Model model) {
        List<ArticleType> articleTypeList = articleTypeService.list();
        model.addAttribute("articleTypeList", articleTypeList);
        return "/getArticleTypes";
    }

    @GetMapping("/deleteArticleType")
    public String deleteArticleType(Model model, @RequestParam("articleTypeId") int articleTypeId) {
        articleTypeService.deleteByArticleTypeId(articleTypeId);
        List<ArticleType> articleTypeList = articleTypeService.list();
        model.addAttribute("articleTypeList", articleTypeList);
        return "/getArticleTypes";
    }

    @GetMapping("/modifyArticleType")
    public String modifyArticleType(Model model, @RequestParam("articleTypeId") int articleTypeId) {
        ArticleType articleType = articleTypeService.findByArticleTypeId(articleTypeId);
        model.addAttribute(articleType);
        return "/modifyArticleType";
    }

    @PostMapping("/modifyArticleType")
    @ResponseBody
    public ArticleType modifyArticleType(int articleTypeId, String articleTypeName, String articleTypeStatus) {
        return articleTypeService.modify(articleTypeId,articleTypeName,articleTypeStatus);
    }


    @GetMapping("/getArticleTypesJson")
    @ResponseBody
    public List<ArticleType> getArticleTypesJson() {
        return articleTypeService.list();
    }
}
