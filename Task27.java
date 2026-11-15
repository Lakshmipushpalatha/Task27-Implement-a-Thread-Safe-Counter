import java.util.concurrent.atomic.AtomicInteger;

public class Task27 {

    static class UnsafeCounter {
        private int count = 0;

        public void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    static class SafeCounter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public synchronized int getCount() {
            return count;
        }
    }

    static class AtomicCounter {
        private AtomicInteger count = new AtomicInteger(0);

        public void increment() {
            count.incrementAndGet();
        }

        public int getCount() {
            return count.get();
        }
    }

    static void testCounter(String name, Runnable task,
                            int numberOfThreads,
                            int incrementsPerThread) {

        Thread[] threads = new Thread[numberOfThreads];

        long startTime = System.nanoTime();

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted!");
                return;
            }
        }

        long endTime = System.nanoTime();

        System.out.println(name + " execution time: "
                + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {

        int numberOfThreads = 8;
        int incrementsPerThread = 500000;

        UnsafeCounter unsafe = new UnsafeCounter();
        SafeCounter safe = new SafeCounter();
        AtomicCounter atomic = new AtomicCounter();

        System.out.println("THREAD-SAFE COUNTER DEMONSTRATION");
        System.out.println("----------------------------------");

        testCounter("Unsafe Counter", () -> {
            for (int i = 0; i < incrementsPerThread; i++) {
                unsafe.increment();
            }
        }, numberOfThreads, incrementsPerThread);

        testCounter("Synchronized Counter", () -> {
            for (int i = 0; i < incrementsPerThread; i++) {
                safe.increment();
            }
        }, numberOfThreads, incrementsPerThread);


        testCounter("Atomic Counter", () -> {
            for (int i = 0; i < incrementsPerThread; i++) {
                atomic.increment();
            }
        }, numberOfThreads, incrementsPerThread);

        int expected = numberOfThreads * incrementsPerThread;

        System.out.println("\nEXPECTED COUNT: " + expected);

        System.out.println("Unsafe Counter Result: "
                + unsafe.getCount());

        System.out.println("Synchronized Counter Result: "
                + safe.getCount());

        System.out.println("Atomic Counter Result: "
                + atomic.getCount());

        System.out.println("\nDEMONSTRATION COMPLETED!");
    }
}
