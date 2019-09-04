package com.xwj.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author yuki
 * @Date 2018/8/7 20:51
 * @Version 1.0
 **/
@Service("initUserService")
public class InitUserService {
    private Map<Integer,CacheUser> users=new HashMap<>();
    {
        users.put(1,new CacheUser("1"));
        users.put(2,new CacheUser("2"));
    }
    @Autowired
    CacheManager cacheManager;
    @PostConstruct
    public void setup(){
        Cache cache=cacheManager.getCache("users");
        for (Integer key : users.keySet()) {
            cache.put(key,users.get(key));
        }
    }
    @Cacheable("users")
    public CacheUser getUser(int id){
        return users.get(id);
    }
}
