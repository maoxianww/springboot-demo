package com.example.redis;

import com.example.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
@Slf4j
class SpringbootRedisApplicationTests {
    @Resource
    RedisUtil redisUtil;
    @Resource
    RedisTemplate redisTemplate;

    private static final String JINTAI = "jintai";
    private static final String HUIZE = "huize";
    private static final String TEST = "test";

    @Test
    void contextLoads() {
    }

    @Test
    public void desensitizerTest() {
        // 1 获取所有的key
        Set<String> keys = redisTemplate.keys("*");
        log.debug("keys size = {}", keys.size());
        // 2 脱敏数据
        for (String key : keys) {
            Map<Object, Object> hmget = redisUtil.hmget(key);
            for (Map.Entry<Object, Object> entry : hmget.entrySet()) {
                System.out.println("Key = " + entry.getKey() + " Value = " + entry.getValue());
                if (entry.getValue() instanceof List) {
                    List list = (List) entry.getValue();
                    for (Object o : list) {
                        log.debug("o.value={}", o);
//                        StringUtils.isNumeric(0)
                    }
                }
            }
        }

        //3 rename key
//        renameKey(oldKeysSet);
    }

    @Test
    public void getKeyTest() {
        String jintaiKey = "jintai:cockpit:zbk_drqdbf";
        Map<Object, Object> map = redisUtil.hmget(jintaiKey);
        System.out.println("map = " + map);
    }


    private void renameKey(Set<String> oldKeysSet) {
        int count = 0;
        for (String oldKey : oldKeysSet) {
            if (!oldKeysSet.contains(JINTAI)) {
                count++;
                log.debug("第{}个key跳过rename操作,key={}", count, oldKey);
                continue;
            }
            String newKey = oldKey.replaceAll(JINTAI, HUIZE);
            redisUtil.rename(oldKey, newKey);
            count++;
            log.debug("第{}个key rename操作完成, old key = {} --> new key = {}", count, oldKey, newKey);
        }
    }

}
