package com.want.redis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.want.redis.mapper.RedisUserMapper;
import com.want.redis.model.RedisUser;

/**
 * 缓存就在这层工作
 * @Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
 * @CachePut，指定key，将更新的结果同步到redis中
 * @CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
 */
@Service
@CacheConfig(cacheNames = "users")
public class UserService {
    @Autowired
    private RedisUserMapper redisUserMapper;

    @Cacheable(key ="#p0")
    public RedisUser selectUser(String id){
        System.out.println("select");
        return redisUserMapper.findById(id);
    }

    @CachePut(key = "#p0")
    public void updataById(RedisUser user){
        System.out.println("update");
        redisUserMapper.updateById(user);
    }
    
    @CachePut(key = "#p0")
    public void addUser(RedisUser user){
        System.out.println("update");
        redisUserMapper.addUser(user.getName(),user.getAge()+"");
    }

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key ="#p0",allEntries=true)
    public void deleteById(String id){
        System.out.println("delete");
        redisUserMapper.deleteById(id);
    }
}