package com.cn.company.dao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ArticleDaoTest class
 *
 * @author bingyu wu
 * @Date: 2018/1/12
 * @Time: 下午2:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleDaoTest {
    
    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(ArticleDaoTest.class);

    @Autowired
    private ArticleDao articleDao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test(){
        Assert.assertEquals(16,articleDao.findAll().size());
        System.out.println(articleDao.findOne(5).toString());
        System.out.println(articleDao.findByTitle("Lucene").toString());
        logger.info("###");
        logger.error("****");
        System.out.println(articleDao.findByContentLike("%Lucene%").toString());
    }

    @After
    public void tearDown() throws Exception {

    }

}