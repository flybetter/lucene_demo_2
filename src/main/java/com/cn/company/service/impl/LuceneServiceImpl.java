package com.cn.company.service.impl;

import com.cn.company.service.LuceneService;

/**
 * LuceneServiceImpl class
 *
 * @author bingyu wu
 * @Date: 2018/1/14
 * @Time: 下午5:00
 */
public class LuceneServiceImpl implements LuceneService {

    public static int index_status=0;

    @Override
    public String indexBuild() {

        String result;

        if(index_status==0){
            index_status=1;
            index_status=0;
            result="ok";
        }else{
            result="busy";
        }
        return result;
    }
}
