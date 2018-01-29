package com.cn.company.dao;

import com.cn.company.dao.jpa.ThreadDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * ThreadDaoTest class
 *
 * @author bingyu wu
 * @Date: 2018/1/14
 * @Time: 上午9:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadDaoTest {
    
    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(ThreadDaoTest.class);

    @Autowired
    private ThreadDao threadDao;

    @Test
    public void findByThreadidGreaterThanEqualAndDatelineGreaterThan() throws Exception {
        threadDao.findByThreadidGreaterThanEqualAndDatelineGreaterThan(300796,1096766704).forEach(e->logger.info(e.toString()));
    }

    @Test
    public void findTopByDatelineGreater() throws Exception {
        logger.info(threadDao.findTopByDatelineGreater(1096766704).toString());

    }

    @Test
    public void findBottomByDatelineGreateer() throws Exception {
        logger.info(threadDao.findBottomByDatelineGreater(1096766704).toString());
    }



}