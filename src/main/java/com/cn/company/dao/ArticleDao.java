package com.cn.company.dao;

import com.cn.company.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * AritcleRepository class
 *
 * @author bingyu wu
 * @Date: 2018/1/12
 * @Time: 下午1:56
 */
public interface ArticleDao extends JpaRepository<Article,Integer> {

    /**
     *  get the article by title's name
     * @param title
     * @return
     */
    List<Article> findByTitle(String title);


    /**
     * get the article by content fuzzy query
     * @param content
     * @return
     */
//    @Query(value = "select u from t_article u where u.content like '%?1%'",nativeQuery = true)
    List<Article> findByContentLike(String content);








}
