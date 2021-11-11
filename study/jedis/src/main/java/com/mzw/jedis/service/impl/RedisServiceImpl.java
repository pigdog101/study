package com.mzw.jedis.service.impl;

import com.mzw.jedis.service.RedisService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @PACKAGE_NAME: com.mzw.jedis.service
 * @AUTHOR: mzw
 * @DATE: 2021/9/1
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private RedissonClient redissonClient;

    private static final String REDIS_LOCK = "mzwLock";

    @Override
    public void getGoods() {
        String value = UUID.randomUUID().toString();

        RLock lock = redissonClient.getLock(REDIS_LOCK);
        lock.lock();
        try {
            //防止服务器宕机 （获得锁 自己写）
//            Boolean flag = redisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value,5, TimeUnit.SECONDS);
//            if (!flag){
//                System.out.println("抢锁失败，抢购商品失败");
//                return;
//            }
            Integer good = (Integer) redisTemplate.opsForValue().get("k1");
            Integer goodNumber = good;
            if (goodNumber>0) {
                System.out.println(Thread.currentThread().getName() + "\t" + "购买成功" + "商品剩余数量" + (goodNumber - 1));
                redisTemplate.opsForValue().set("k1", goodNumber - 1);
            }else{
                System.out.println("商品没货了");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //加个判断只能删掉自己的锁（操作非原子）自己写
//            if (redisTemplate.opsForValue().get(REDIS_LOCK).toString().equalsIgnoreCase(value)) {
//                //防止抛异常时没有释放锁
//                redisTemplate.delete(REDIS_LOCK);
//            }
            lock.unlock();
        }

    }
}
