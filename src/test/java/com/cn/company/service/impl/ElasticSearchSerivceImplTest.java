package com.cn.company.service.impl;

import com.cn.company.service.ElasticSearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}