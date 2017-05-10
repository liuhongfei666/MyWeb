package com.test;

import com.myweb.dao.SeckillDao;
import com.myweb.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Liu on 2017-05-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class SeckillDaoTest {


    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        Date killTIme = new Date();
        int updateCount = seckillDao.reduceNumber(1000L, killTIme);
        System.out.println(updateCount);
        //结果第一次执行为1 后面为0
    }

    @Test
    public void queryById() throws Exception {
        long id = 1001;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        //运行结果
        /** 500元秒杀ipad2*／
         ／**  Seckill{seckillId=1001, name='500元秒杀ipad2',number=200, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Sun Nov 27 10:44:30 CST 2016}*/
    }

    @Test
    public void queryAll() throws Exception {
        //java没有保存形参的记录，queryAll(int offeset,int limit)->queryAll(arg0,arg1),通过@param注解来解决

        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }
}
