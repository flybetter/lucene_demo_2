package com.cn.company.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ElasticSearchService class
 *
 * @author bingyu wu
 *         Date: 2018/1/29
 *         Time: 下午1:58
 */
@Service
public interface ElasticSearchService<T> {

    /**
     *  send the mysql post data to elasticsearch server
     */
    void sendPostDataToElasticSearchServer();

    /**
     * send the mysql thread data to elasticsearch server
     */
    void sendThreadDataToElasticSearchSever();

    /**
     *  clean the data in the elasticsearch server
     */
    void cleanPostDataAndThreadDataBySearchServer();

    /**
     *
     * @param pageable
     * @param pagetext
     * @return
     */
    Page<T> customizedPostElasticsearchReposty(Pageable pageable, String pagetext);

    /**
     *
     * @param pageable
     * @param title
     * @param pagetext
     * @param formid
     * @return
     */
    Page<Thread> customizedThreadlasticsearchReposity(Pageable pageable, String title,String pagetext,String formid);


    Iterable<T> test();
}
