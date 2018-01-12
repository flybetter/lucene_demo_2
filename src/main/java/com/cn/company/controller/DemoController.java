package com.cn.company.controller;

import com.cn.company.dao.ArticleDao;
import com.cn.company.domain.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * DemoController class
 *
 * @author bingyu wu
 * @Date: 2018/1/12
 * @Time: 下午3:44
 */
@RequestMapping("/demo")
@Controller
public class DemoController {
    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    public ArticleDao articleDao;

    @RequestMapping("/demo")
    @ResponseBody
    public List<Article> demo(){
        return articleDao.findByContentLike("%Lucene%");

    }
}
