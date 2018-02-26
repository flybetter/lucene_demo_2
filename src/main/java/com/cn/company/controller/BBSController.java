package com.cn.company.controller;

import com.cn.company.service.ElasticSearchService;
import com.google.gson.Gson;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

/**
 * DemoController class
 *
 * @author bingyu wu
 * @Date: 2018/1/12
 * @Time: 下午3:44
 */

@Controller
public class BBSController {
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BBSController.class);

    @Autowired
    private ElasticSearchService elasticSearchService;

    @ApiOperation(value = "用于建立thread表和post表索引文件", notes = "用于建立thread表和post表索引文件")
    @RequestMapping(value = "/indexBuild", method = RequestMethod.GET)
    @ResponseBody
    public String indexBuild() {
        Long startTime = System.currentTimeMillis();
        logger.info("start time:" + startTime);
        elasticSearchService.cleanPostDataAndThreadDataBySearchServer();
        logger.info("clean  time:" + (System.currentTimeMillis() - startTime));
        elasticSearchService.sendPostDataToElasticSearchServer();
        elasticSearchService.sendThreadDataToElasticSearchSever();
        Long endTime = System.currentTimeMillis();
        Long costTime = endTime - startTime;
        logger.info("end time:" + endTime + " cost time:" + costTime);
        return null;
    }

    @ApiOperation(value = "用于常规的查询", notes = "用于常规的查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "d", value = "判断是哪张表 1 是post表 其它是thread表", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "ps", value = "ps指的是页面内容大小 默认是10", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pi", value = "pi指的是第几页 默认是1", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "title", value = "文章标题", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pagetext", value = "文章内容", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "forumid", value = "讨论会的id", dataType = "String"),
    })
    @RequestMapping(value = "/q", method = RequestMethod.GET)
    @ResponseBody
    public String q(@NotNull Integer d, @RequestParam(defaultValue = "20") Integer ps, @RequestParam(defaultValue = "0") Integer pi, String title, String pagetext, String forumid) {

        PageRequest pageRequest = new PageRequest(pi, ps);
        Page<?> pages;

        if (d.equals(1)) {
            pages = elasticSearchService.customizedPostElasticsearchReposty(pageRequest, pagetext);
        } else {
            pages = elasticSearchService.customizedThreadElasticsearchReposity(pageRequest, title, forumid);
        }
        Gson gson = new Gson();
        return gson.toJson(pages.getContent());
    }

    @ApiOperation(value = "对所有字段的模糊查询", notes = "对所有字段的模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "d", value = "判断是哪张表 1 是post表 其它是thread表", required = true, dataType = "String"),
    })
    @RequestMapping(value = "/getAllFieds", method = RequestMethod.GET)
    @ResponseBody
    public String getAllFieds() {

        return null;
    }


}
