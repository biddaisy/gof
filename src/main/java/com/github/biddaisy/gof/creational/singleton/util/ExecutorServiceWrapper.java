package com.github.biddaisy.gof.creational.singleton.util;

import com.github.biddaisy.gof.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * A Java-25-friendly wrapper that allows using ExecutorService
 * inside a try-with-resources block.
 *
 * This wrapper:
 *   - Implements AutoCloseable
 *   - Calls shutdown() automatically
 *   - Awaits termination
 *   - Forces shutdownNow() if needed
 *
 * This is the correct, modern way to satisfy static analysis tools
 * that require resources to be closed deterministically.
 */
public final class ExecutorServiceWrapper implements AutoCloseable {

    private final ExecutorService executor;
    private final long timeout;
    private final TimeUnit unit;

    public ExecutorServiceWrapper(ExecutorService executor,
                                  long timeout,
                                  TimeUnit unit) {
        this.executor = executor;
        this.timeout = timeout;
        this.unit = unit;
    }

    public ExecutorService get() {
        return executor;
    }

    @Override
    public void close() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(timeout, unit)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Logger.error("interrupted", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
