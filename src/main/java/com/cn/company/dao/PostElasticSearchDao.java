package com.cn.company.dao;

import com.cn.company.domain.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * PostElasticSearchDao class
 *
 * @author bingyu wu
 *         Date: 2018/1/28
 *         Time: 上午11:01
 */
public interface PostElasticSearchDao extends ElasticsearchRepository<Post,Integer> {

}
