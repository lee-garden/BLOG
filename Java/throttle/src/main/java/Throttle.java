import com.google.common.util.concurrent.RateLimiter;

public class Throttle {
    private static int count = 1;
    private static RateLimiter rateLimiter;
    public static void main(String[] args) {
        rateLimiter = RateLimiter.create(2);

        long start = System.currentTimeMillis();

        while(true) {
            if (System.currentTimeMillis() - start > 4990) break;
            throttleMethod();
        }
    }

    public static void throttleMethod() {
        if (rateLimiter.tryAcquire()) {
            System.out.println(count++);
        }
    }
}
