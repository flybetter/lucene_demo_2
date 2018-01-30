package com.cn.company.service;

import org.springframework.data.domain.Page;
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


    Page<T> customizedElasticsearchReposity();
}