package com.cn.company.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PostDaoTest class
 *
 * @author bingyu wu
 * @Date: 2018/1/14
 * @Time: 下午12:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostDaoTest {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PostDaoTest.class);

    @Autowired
    public PostDao postDao;

    @Test
    public void findByPostIdGreaterThanAndDatelineGreater() throws Exception {
        postDao.findByPostIdGreaterThanAndDatelineGreater(158364, 1096645829).forEach(e -> logger.info(e.toString()));
    }

    @Test
    public void findTopByPostId() throws Exception {
        logger.info(postDao.findTopByDateline(1096645829).toString());

    }

    @Test
    public void findBottomByPostId() throws Exception {
        logger.info(postDao.findBottomByDateline(1096645829).toString());
    }


    @Test
    public void findDateline() throws Exception {
        logger.info(postDao.findDateline().toString());

    }
}