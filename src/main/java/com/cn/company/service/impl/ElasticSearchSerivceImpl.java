package com.cn.company.service.impl;

import com.cn.company.dao.elasticsearch.PostElasticSearchDao;
import com.cn.company.dao.elasticsearch.ThreadElasticSearchDao;
import com.cn.company.dao.jpa.PostDao;
import com.cn.company.dao.jpa.ThreadDao;
import com.cn.company.domain.Post;
import com.cn.company.domain.Thread;
import com.cn.company.service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ElasticSearchSerivce class
 *
 * @author bingyu wu
 *         Date: 2018/1/29
 *         Time: 下午1:58
 */
@Service("ElasticSearchService")
public class ElasticSearchSerivceImpl implements ElasticSearchService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private PostElasticSearchDao postElasticSearchDao;


    @Autowired
    private ThreadDao threadDao;

    @Autowired
    private ThreadElasticSearchDao threadElasticSearchDao;

    @Override
    public void sendPostDataToElasticSearchServer() {
        Long dateline = postDao.findDateline();
        Page<Post> pages = null;
        do {
            Pageable nextPageable = pages == null ? new PageRequest(0, 5000) : pages.nextPageable();
            pages = postDao.findByDatelineGreaterThanAndVisibleIs(dateline, 1, nextPageable);
            postElasticSearchDao.save(pages);
        } while (pages.hasNext());

    }

    @Override
    public void sendThreadDataToElasticSearchSever() {
        long dateline = postDao.findDateline();
        Page<Thread> pages = null;
        do {
            Pageable nextPageable = pages == null ? new PageRequest(0, 5000) : pages.nextPageable();
            pages=threadDao.findByDatelineGreaterThanAndVisibleIs(dateline,1,nextPageable);
            threadElasticSearchDao.save(pages);
        } while (pages.hasNext());
    }

    @Override
    public void cleanPostDataAndThreadDataBySearchServer() {
        threadElasticSearchDao.deleteAll();
        postElasticSearchDao.deleteAll();
    }
}
