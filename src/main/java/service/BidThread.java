package service;

import model.Bid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BidThread extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(BidThread.class);

    private Bid bid;

    public BidThread(Bid bid) {
        this.bid = bid;
    }

    public void run() {
        LOGGER.debug("Thread running for {}", bid.getId());
    }
}
