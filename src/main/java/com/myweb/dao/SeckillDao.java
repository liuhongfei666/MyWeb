package com.myweb.dao;

import com.myweb.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Liu on 2017-05-09.
 */
public interface SeckillDao {
    //减库存
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    //根据Id查询秒杀对象
    Seckill queryById(long seckillId);

    //根据偏移量查询秒杀列表
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
