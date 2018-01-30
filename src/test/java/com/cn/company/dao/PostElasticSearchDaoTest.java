package com.cn.company.dao;

import com.cn.company.dao.elasticsearch.PostElasticSearchDao;
import com.cn.company.dao.jpa.PostDao;
import com.cn.company.domain.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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


    @Autowired
    private PostDao postDao;

    @Test
    public void testDao() throws Exception {
        Post post =new Post();
        post.setPostid(1);
        post.setPagetext("something is real different");
        post.setThreadid(5);
        post.setUsername("big name style");
        postElasticSearchDao.save(post);
    }

    @Test
    public void savePostList() throws Exception {
        Post post =new Post();
        post.setPostid(1);
        post.setPagetext("something is real different");
        post.setThreadid(5);
        post.setUsername("big name style");
        Post post2 =new Post();
        post.setPostid(2);
        post.setPagetext("something2 is real different");
        post.setThreadid(6);
        post.setUsername("big name2 style");

        List<Post> posts=new ArrayList<>();
        posts.add(post);
        posts.add(post2);
        postElasticSearchDao.save(posts);
    }

    @Test
    public void testCriticalElasticsearch() throws Exception {



    }
}