
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/27 10:29
 * @since 1.0.0
 */


public class Test1 {
    private static final Logger logger= LoggerFactory.getLogger(Test1.class);
    public static void main(String[] args) {


        MDC.put("session","bbbbbbb");
        new Thread(()->{
            String session = MDC.get("session");
            logger.info("new Thread:{}",session);

        }).start();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        logger.info("MAIN1");

        MDC.put("session","ccccccc");
        logger.info("MAIN2");

        pool.execute(()->{
            String session1 = MDC.get("session1");
            System.out.println(session1);

            logger.info("thredpool threadId:{}",Thread.currentThread().getId());

        });

        pool.shutdown();
    }
}
