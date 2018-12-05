package com.github.smallAttr.controller;

import com.github.smallAttr.search.ChineseSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Author: chenGang
 * Date: 2018/12/4 10:17 AM
 */
@Controller
public class IndexController {

    @Autowired
    private ChineseSearch chineseSearch;


    @GetMapping("/lucene/test")
    public String test(Model model) throws Exception {
        // 索引所在的目录
        String indexDir = "/Users/chengang/workspace/lucene-search/index";
        // 要查询的字符
        String q = "南京文化";
        List<String> list = chineseSearch.search(indexDir, q);
        model.addAttribute("list", list);
        return "result";
    }
}
