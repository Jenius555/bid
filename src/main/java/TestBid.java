import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.BidQueues;
import service.ReadFileThread;


public class TestBid {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestBid.class);
    private static final long DELAY = 60000;

    public static void main(String[] args) {

        BidQueues queues = new BidQueues();

        while (!Thread.currentThread().isInterrupted()) {
            ReadFileThread readFileThread = new ReadFileThread(queues);
            readFileThread.start();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                LOGGER.error("Error read or parse file: {}", e.getMessage(), e);
            }
        }
    }
}
