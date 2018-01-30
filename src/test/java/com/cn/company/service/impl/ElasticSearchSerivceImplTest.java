package com.cn.company.service.impl;

import com.cn.company.dao.elasticsearch.PostElasticSearchDao;
import com.cn.company.dao.jpa.PostDao;
import com.cn.company.domain.Post;
import com.cn.company.service.ElasticSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ElasticSearchSerivceImplTest class
 *
 * @author bingyu wu
 *         Date: 2018/1/29
 *         Time: 下午2:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchSerivceImplTest {
    @Autowired
    private ElasticSearchService elasticSearchService;

    @Autowired
    private PostDao postDao;

    @Autowired
    private PostElasticSearchDao postElasticSearchDao;
    
    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchSerivceImplTest.class);
    @Test
    public void sendPostDataToElasticSearchServer() throws Exception {
        elasticSearchService.sendPostDataToElasticSearchServer();

    }

    @Test
    public void sendThreadDataToElasticSearchSever() throws Exception {

    }

    @Test
    public void cleanAllData() throws Exception {
        elasticSearchService.cleanPostDataAndThreadDataBySearchServer();
    }

    @Test
    public void testElasticsearchCustomizedSearch() throws Exception {
        String pageText="收入";
        Page<Post> pages=elasticSearchService.customizedPostElasticsearchReposty( new PageRequest(1,20),pageText);
        pages.forEach(e->logger.info(e.toString()));
        logger.info("total Pages:"+pages.getTotalElements()+" numbers "+pages.getNumber()+" size:"+pages.getSize()+" " +
                "length:"+pages.getContent().size());
    }

    @Test
    public void test() throws Exception {

        postElasticSearchDao.deleteAll();

        elasticSearchService.test().forEach(e->logger.info(e.toString()));


    }

    @Test
    public void deletePostElasticsearch() throws Exception {

//        postElasticSearchDao.deleteAll();

        Post aa=new Post();
        aa.setUsername("haha");
        aa.setPagetext("干什么");
        postElasticSearchDao.save(aa);


        elasticSearchService.test().forEach(e->logger.info(e.toString()));

    }
}