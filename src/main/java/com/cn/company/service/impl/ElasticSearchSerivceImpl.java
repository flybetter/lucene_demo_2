package com.cn.company.service.impl;

import com.cn.company.dao.elasticsearch.PostElasticSearchDao;
import com.cn.company.dao.elasticsearch.ThreadElasticSearchDao;
import com.cn.company.dao.jpa.PostDao;
import com.cn.company.dao.jpa.ThreadDao;
import com.cn.company.domain.Post;
import com.cn.company.domain.Thread;
import com.cn.company.service.ElasticSearchService;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * ElasticSearchSerivce class
 *
 * @author bingyu wu
 *         Date: 2018/1/29
 *         Time: 下午1:58
 */
@Service("ElasticSearchService")
public class ElasticSearchSerivceImpl<T> implements ElasticSearchService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private PostElasticSearchDao postElasticSearchDao;


    @Autowired
    private ThreadDao threadDao;

    @Autowired
    private ThreadElasticSearchDao threadElasticSearchDao;


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

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


    @Override
    public Page<T> customizedPostElasticsearchReposty (Pageable pageable, String pagetext) {
        BoolQueryBuilder boolQueryBuilder=boolQuery();

        if(StringUtils.isNotEmpty(pagetext)){
            boolQueryBuilder.must(matchPhraseQuery("pagetext",pagetext));
        }
        SearchQuery searchQuery=new NativeSearchQueryBuilder().
                withQuery(boolQueryBuilder).build().setPageable(pageable);
        Page<Post> pages=elasticsearchTemplate.queryForPage(searchQuery,Post.class);
        return (Page<T>) pages;
    }

    @Override
    public Page<java.lang.Thread> customizedThreadlasticsearchReposity(Pageable pageable, String title, String formid) {

        BoolQueryBuilder boolQueryBuilder=boolQuery();

        if(StringUtils.isNotEmpty(title)){
            boolQueryBuilder.must(matchPhraseQuery("titile",title));
        }

        if(StringUtils.isNotEmpty(formid)){

//            boolQueryBuilder.must(termsQuery("formid",formid.split(",")))
        }


        return null;
    }


    @Override
    public Iterable<Post> test() {
        Iterable<Post> pages= postElasticSearchDao.findAll();
        return pages;
    }
}
