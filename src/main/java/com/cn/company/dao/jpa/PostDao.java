package com.cn.company.dao.jpa;

import com.cn.company.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * PostDao class
 *
 * @author bingyu wu
 * @Date: 2018/1/14
 * @Time: 上午11:13
 */
public interface PostDao extends JpaRepository<Post, Integer> {


    /**
     * use the dateline and pageable to select data, the jpa default paging function
     * @param dateline
     * @param pageable
     * @return
     */
     Page<Post> findByDatelineGreaterThanAndVisibleIs(Long dateline,Integer visible, Pageable pageable);




    /************************************old business logic************************************************/

    /**
     * get up to 5000 data through greater than or equal postid and greater than dateline
     *
     * @param postid
     * @param dateline
     * @return
     */
    @Query(value = "select postid,pagetext,username,threadid from post where postid >=?1 and visible=1 and dateline>?2 order by postid asc limit 5000", nativeQuery = true)
    List<Post> findByPostIdGreaterThanAndDatelineGreater(int postid, int dateline);


    /**
     * get one top data through greater than dateline
     * @param dateline
     * @return
     */
    @Query(value = "select postid from post where dateline >?1 and visible=1 order by dateline desc limit 1", nativeQuery = true)
    Integer findTopByDateline(int dateline);


    /**
     * get one bottom data through greater than dateline
     * @param dateline
     * @return
     */
    @Query(value = "select postid from post where dateline >?1 and visible =1 order by dateline asc limit 1", nativeQuery = true)
    Integer findBottomByDateline(int dateline);


    /**
     * get the dateline in DB
     * @return
     */
    @Query(value = "select unix_timestamp()-9999905811200", nativeQuery = true)
    Long findDateline();


}
