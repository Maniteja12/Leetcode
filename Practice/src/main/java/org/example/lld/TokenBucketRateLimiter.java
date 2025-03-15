package org.example.lld;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucketRateLimiter {
    private final int maxRequests;
    private final long timeWindow;
    private final AtomicInteger tokens;
    private final AtomicLong lastRefill;

    public TokenBucketRateLimiter(int maxRequests, long timeWindow, TimeUnit timeUnit) {
        this.maxRequests = maxRequests;
        this.timeWindow = timeUnit.toMillis(timeWindow);
        this.tokens = new AtomicInteger(maxRequests);
        this.lastRefill = new AtomicLong(System.currentTimeMillis());
    }

    public boolean allowRequest() {
        long current_time = System.currentTimeMillis();
        if (current_time - lastRefill.get() > timeWindow) {
            refillTokens();
        }
        if (tokens.get() > 0) {
            tokens.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refillTokens() {
        long current_time = System.currentTimeMillis();
        long refill_amount = (current_time - lastRefill.get()) / timeWindow * maxRequests;
        tokens.addAndGet((int) refill_amount);
        lastRefill.set(current_time);
    }

    public static void main(String[] args) {
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(12, 3, TimeUnit.SECONDS);
        for (int i = 0; i < 15; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("Request allowed");
            } else {
                System.out.println("Request blocked");
            }
        }
    }
}
