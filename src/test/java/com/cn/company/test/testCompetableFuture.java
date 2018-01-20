package com.cn.company.test;

import com.cn.company.dao.PostDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CompletableFuture;

/**
 * testCompetableFuture class
 *
 * @author bingyu wu
 *         Date: 2018/1/18
 *         Time: 下午1:33
 */
@RunWith(SpringRunner.class)
public class testCompetableFuture {

    @Autowired
    private PostDao postDao;

    /** logger */
    private static final Logger logger = LoggerFactory.getLogger(testCompetableFuture.class);
    @Test
    public void future() throws Exception {
        logger.info("test begin");
        CompletableFuture<String> completableFuture=new CompletableFuture();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //模拟执行耗时任务
                System.out.println("task doing...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //告诉completableFuture任务已经完成
                completableFuture.complete("result");
            }
        }).start();
        //获取任务结果，如果没有完成会一直阻塞等待
        String result=completableFuture.get();
        System.out.println("计算结果:"+result);
    }

//    @Test
//    /**
//     * 条件查询时动态组装条件
//     */
//    private Specification<Post> where(
//            final String corg,final String name,final String type,final String date,final String checker){
//        return new Specification<Post>() {
//            @Override
//            public Predicate toPredicate(Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                List<Predicate> predicates = new ArrayList<Predicate>();
//                Path path=root.get("aaa");
//
//                //机构
//                if(corg!=null&&!corg.equals("")){
//                    List<String> orgIds = postDao.findByName("%"+corg+"%");
//                    if(orgIds.size()>0&&orgIds.size()<1000)
//                        predicates.add(root.<String>get("confirmOrgNo").in(orgIds));//confirmOrgNo
//                }
//                //名字
//                if(name!=null&&!name.equals("")){
//                    List<String> userIds = postDao.findByName(name);
//                    if(userIds.size()>0&&userIds.size()<1000)//如果太多就不管了这个条件了
//                        predicates.add(root.<String>get("hrUserName").in(userIds));
//                }
//                //类型
//                if(type!=null&&!type.equals(""))
//                    predicates.add(cb.equal(root.<String>get("hrUpdateType"),type));
//                //日期
//                if(date!=null&&!date.equals("")){
//                    //处理时间
//                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//                    Date startDate;
//                    Date endDate;
//                    try {
//                        startDate = format.parse(date);
//                    } catch (ParseException e) {
//                        startDate = new Date(946656000000L);//2000 01 01
//                    }
//                    endDate = startDate;
//                    Calendar calendar = Calendar.getInstance() ;
//                    calendar.setTime(endDate);
//                    calendar.add(Calendar.DATE, 1);
//                    endDate = calendar.getTime();
//                    calendar = null;
//                    predicates.add(cb.between(root.<Date>get("insDate"),startDate,endDate));
//                }
//                //审核人
//                if(checker!=null&&!checker.equals("")){
//                    List<String> userIds = postDao.findByName(checker);
//                    if(userIds.size()>0&&userIds.size()<1000)//如果太多就不管了这个条件了
//                        predicates.add(root.<String>get("confirmUserId").in(userIds));
//                }
//                return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
//            }
//        };
//    }
}
