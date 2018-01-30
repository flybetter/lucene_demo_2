package com.cn.company.dao;

import com.cn.company.dao.jpa.PostDao;
import com.cn.company.domain.Post;
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

    @Test
    public void testWithPage() throws Exception {
       Page<Post> posts  =postDao.findAll(new PageRequest(1,20));
       logger.info("totalPages "+posts.getTotalPages());
       posts.forEach(e ->logger.info(e.toString()));

    }


    @Test
    public void testDefaultJpaSql() throws Exception {

        Long dateline=postDao.findDateline();
        logger.info("dateline:"+dateline);
        PageRequest pageRequest=new PageRequest(0,20);
        Page<Post> pages=postDao.findByDatelineGreaterThanAndVisibleIs(dateline,1,pageRequest);
//        pages.forEach(e->logger.info(e.toString()));
        logger.info(Integer.valueOf(pages.getSize()).toString());
        logger.info("totalPages:"+pages.getTotalPages()+" totalElements"+pages.getTotalElements()+"" +
                " numbers"+pages.getNumber());
        logger.info("next page");
        logger.info(Boolean.valueOf(pages.hasNext()).toString());
        logger.info(pages.nextPageable().toString());
        Page<Post> page2=postDao.findByDatelineGreaterThanAndVisibleIs(dateline,1,pages.nextPageable());
//        page2.forEach(e1->logger.info(e1.toString()));
        logger.info(Integer.valueOf(page2.getSize()).toString());
        logger.info("totalPages:"+page2.getTotalPages()+" totalElements"+page2.getTotalElements()+"" +
                " numbers"+page2.getNumber());
    }
}