package com.cn.company.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Scheduled(fixedDelay = 60*1000)
    public void indexSchedule(){
        logger.info("看看是不是可以定时打印");
    }

}
