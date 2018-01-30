package com.cn.company.dao.jpa;

import com.cn.company.domain.Thread;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * ThreadDao class
 *
 * @author bingyu wu
 * @Date: 2018/1/14
 * @Time: 上午12:53
 */
public interface ThreadDao extends JpaRepository<Thread, Integer> {


    Page<Thread> findByDatelineGreaterThanAndVisibleIs(long dateline, int visible, Pageable pageable);


    /*********************old logic business************************/

    /**
     * get up to 5000 data through greater than or equals threadid and greater than dateline
     *
     * @param threadid
     * @param dateline
     * @return
     */
    @Query(value = "select threadid,postusername,title,forumid from thread where threadid>=?1 and visible='1' and dateline>?2  order by threadid asc limit 5000", nativeQuery = true)
    List<Thread> findByThreadidGreaterThanEqualAndDatelineGreaterThan(int threadid, int dateline);


    /**
     * get the one top data through greater than dateline
     *
     * @param dateline
     * @return threadid
     */
    @Query(value = "select threadid from thread where dateline >?1 and visible =1 order by dateline desc limit 1", nativeQuery = true)
    Integer findTopByDatelineGreater(int dateline);

    /**
     * get the one bottom data through greater than datelines
     *
     * @param dateline
     * @return
     */
    @Query(value = "select threadid from thread where dateline >?1 and visible=1 order by dateline asc limit 1 ", nativeQuery = true)
    Integer findBottomByDatelineGreater(int dateline);

}
