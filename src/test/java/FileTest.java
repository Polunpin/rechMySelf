import com.Application;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * @author LYP
 * @date 2021/12/21 2:20 PM
 */
@Slf4j
@SpringBootTest(classes = Application.class)
public class FileTest {

    private static final String LOCK_SUCCESS = "OK";

    /**
     * 尝试获取分布式锁
     *
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {
        String result;
        try (Jedis jedis = new Jedis()) {
            //这里的jedis自己去实现一下
            result = jedis.set(lockKey, requestId, SetParams.setParams().nx().px(expireTime));
        }
        return LOCK_SUCCESS.equals(result);
    }

    //执行redis
    private String doRedis() {
        String s = UUID.randomUUID().toString();
        boolean flag = tryGetDistributedLock("sendMail_20200101", s, 1000 * 20);
        String msg;
        if (flag) {
            msg = "你获取到锁了可以去操作业务!";
        } else {
            msg = "别人获取到锁了,你就不用操作了!!!!";
        }
        return msg;
    }

    //每分钟执行一次
    static final String cron1 = "0 */1 * * * ?";

    @Test
    @Scheduled(cron = cron1)
    public void testRedis1() {
        String msg = doRedis();
        System.out.println("msg1 :" + msg);
    }

    @Test
    @Scheduled(cron = cron1)
    public void testRedis2() {
        String msg = doRedis();
        System.out.println("msg 2:" + msg);
    }

    @Test
    @Scheduled(cron = cron1)
    public void testRedis3() {
        String msg = doRedis();
        System.out.println("msg 3:" + msg);
    }

    //@Test
    //public void testRedis4() {
    //    int[] array = {6, 8, 9, 26, 27};
    //    //for (int lIdx = 0; ArrayUtils.contains(array, lIdx); ++lIdx) {
    //    //    log.info("---2-----------------------------{}", lIdx);
    //    //}
    //    for (int i = 0; i < 36; i++) {
    //        if (ArrayUtils.contains(array, i)) {
    //            log.info("---2-----------------------------{}", i);
    //        }
    //    }
    //}

}
