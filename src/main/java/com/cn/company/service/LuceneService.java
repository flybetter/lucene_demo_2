package com.cn.company.service;

import org.springframework.stereotype.Service;

/**
 * LuceneService class
 *
 * @author bingyu wu
 * @Date: 2018/1/14
 * @Time: 下午4:56
 */
@Service
public interface LuceneService {
    /**
     * update the index of two tables
     * @return
     */
    String indexBuild();
}
