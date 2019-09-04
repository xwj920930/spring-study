package com.xwj.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @Description spring cache
 * @Author yuki
 * @Date 2018/8/7 10:11
 * @Version 1.0
 **/
@Service("userServiceBean")
public class NewCacheUserService {
    @Autowired
    CacheManager cacheManager;
    public NewCacheUserService() {
        System.err.println("constructor...");
    }
    @PostConstruct
    public void init(){
        System.err.println("init...");
        Cache cache=cacheManager.getCache("users");
        cache.put("xwj",new CacheUser("xwj"));
    }
    @Cacheable(value = "users")
    public CacheUser getUserById(String userId){
        System.err.println("get ..."+userId);
        return  getFromDB(userId);
    }

    private CacheUser getFromDB(String userId){
        System.err.println("get from db ..."+userId);
        return new CacheUser(userId);
    }
}
