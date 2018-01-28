package com.cn.company.dao;

import com.cn.company.domain.Thread;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * ThreadElasticSearchDao class
 *
 * @author bingyu wu
 *         Date: 2018/1/28
 *         Time: 上午11:06
 */
public interface ThreadElasticSearchDao extends ElasticsearchRepository<Thread,Integer> {

}
