package com.cn.company.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DemoController class
 *
 * @author bingyu wu
 * @Date: 2018/1/12
 * @Time: 下午3:44
 */

@Controller
public class BBSController {
    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(BBSController.class);

    @ApiOperation(value="用于建立thread表和post表索引文件",notes = "用于建立thread表和post表索引文件")
    @RequestMapping(value = "/indexBuild",method = RequestMethod.GET)
    @ResponseBody
    public String indexBuild(){

        return null;
    }

    @ApiOperation(value="用于常规的查询",notes = "用于常规的查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="d",value="判断是哪张表 1 是post表 其它是thread表",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name="ps",value="ps指的是页面内容大小 默认是10",required =false,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name="pi",value="pi指的是第几页 默认是1",required =false ,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name="title",value="文章标题",required =false ,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name="pagetext",value="文章内容",required =false ,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name="forumid",value="讨论会的id",required =false ,dataType = "Integer"),
    })
    @RequestMapping(value ="/q",method=RequestMethod.GET)
    @ResponseBody
    public String q(){

        return null;
    }

    @ApiOperation(value="对所有字段的模糊查询",notes = "对所有字段的模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="d",value="判断是哪张表 1 是post表 其它是thread表",required = true,dataType = "Integer"),
    })
    @RequestMapping(value ="/getAllFieds",method=RequestMethod.GET)
    @ResponseBody
    public String getAllFieds(){

        return null;
    }


}
