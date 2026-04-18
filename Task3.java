import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {

    // FIX: Use AtomicInteger for thread-safe increments
    private AtomicInteger processedCount = new AtomicInteger(0);

    public void process(List<StatementRecord> records) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (StatementRecord record : records) {
            executor.submit(() -> {
                processRecord(record);
                processedCount.incrementAndGet(); // FIX
            });
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }

    public int getProcessedCount() {
        return processedCount.get(); // FIX
    }

    void processRecord(StatementRecord r) {}
}

class StatementRecord {}
