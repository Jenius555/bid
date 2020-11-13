import service.BidQueues;
import service.ReadFileThread;


public class TestBid {
    public static void main(String[] args) {

        BidQueues queues = new BidQueues();

        while (!Thread.currentThread().isInterrupted()) {
            ReadFileThread readFileThread = new ReadFileThread(queues);
            readFileThread.start();
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
