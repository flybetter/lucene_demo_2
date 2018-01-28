package com.cn.company.dao;

import com.cn.company.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PostElasticSearchDaoTest class
 *
 * @author bingyu wu
 *         Date: 2018/1/28
 *         Time: 上午11:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostElasticSearchDaoTest {

    
    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(PostElasticSearchDaoTest.class);
    
    @Autowired
    private PostElasticSearchDao postElasticSearchDao;

    @Test
    public void testDao() throws Exception {
        Post post =new Post();
        post.setPostid(1);
        post.setPagetext("something is real different");
        post.setThreadid(5);
        post.setUsername("big name style");
        postElasticSearchDao.save(post);
    }
}