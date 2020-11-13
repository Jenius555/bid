package service;

import model.Bid;
import model.BidWrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadFileThread extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFileThread.class);

    private BidQueues queues;

    public ReadFileThread(BidQueues queues) {
        this.queues = queues;
    }

    public void run() {

        BidWrap[] bids = BidFileReader.readFile();

        if (bids == null) {
            return;
        }

        for (BidWrap bidWrap : bids) {
            Bid bid = bidWrap.getBid();
            if (queues.add(bid)) {
                LOGGER.info("Added to queue: {}", bid);
            }
        }
    }
}
