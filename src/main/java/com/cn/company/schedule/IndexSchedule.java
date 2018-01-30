package com.cn.company.schedule;

import com.cn.company.service.ElasticSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * IndexSechdule class
 *
 * @author bingyu wu
 * @Date: 2018/1/14
 * @Time: 下午4:02
 */
@Component
@EnableAutoConfiguration
public class IndexSchedule {
    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(IndexSchedule.class);

    @Autowired
    private ElasticSearchService elasticSearchService;

    @Scheduled(fixedDelay = 60*1000)
    public void indexSchedule(){

        elasticSearchService.cleanPostDataAndThreadDataBySearchServer();
        elasticSearchService.sendPostDataToElasticSearchServer();
        elasticSearchService.sendThreadDataToElasticSearchSever();
    }

}
